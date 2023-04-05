package com.example.myapplication

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainrecyclerview)

        val list = List(100) {
            "Position ${it + 1}"
        }

        findViewById<RecyclerView>(R.id.list).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ListAdapter(list)
        }

        /*
        val  product = Product("Petits pois et carottes","Cassegrain","3083680085304",Nutriscore.A,"https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg","400 g (280 g net égoutté)", listOf("France, Japon, Suisse"),listOf("Petits pois 66%, eau, garniture 2,8% (salade, oignon grelot), sucre, sel, arôme naturel"),listOf("Aucune"),listOf("Aucun"))

        findViewById<TextView>(R.id.name).setText(product.name)
        findViewById<TextView>(R.id.brand).setText(product.brand)
        findViewById<TextView>(R.id.barcode).applyBoldText("Code-barres",product.barcode)
        findViewById<TextView>(R.id.quantity).applyBoldText("Quantité",product.quantity)
        findViewById<TextView>(R.id.saleCountry).applyBoldText("Vendu en",product.saleCountryList.joinToString(", " ))
        findViewById<TextView>(R.id.ingrediant).applyBoldText("Ingrédients",product.ingrediantList.joinToString(", " ))
        findViewById<ImageView>(R.id.nutriscore).setImageResource(resources.getIdentifier(
            "nutriscore_${product.nutriscore.letter.lowercase()}",
            "drawable",
            packageName,
        ))
        findViewById<TextView>(R.id.allergens).applyBoldText("Substances allergènes",product.allergensList.joinToString(", " ))
        findViewById<TextView>(R.id.additives).applyBoldText("Additifs",product.additivesList.joinToString(", " ))

        Glide.with(this).load(product.imageUrl)
            .into(findViewById(R.id.placeholderImage))

    }

    fun TextView.applyBoldText(prefix: String, value: String) {
        val text = "$prefix : $value"
        val builder = SpannableStringBuilder(text)
        builder.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(":") + 1, 0)
        setText(builder)
    }
    */
    }

}

    class ListAdapter(private val listOfPositions: List<String>) : RecyclerView.Adapter<PositionViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PositionViewHolder {
            return PositionViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.cell_item, parent, false)
            )
        }

        override fun onBindViewHolder(holder: PositionViewHolder, position: Int) {
            holder.updateCell(listOfPositions[position])
        }

        override fun getItemCount(): Int {
            return listOfPositions.size
        }

    }

    class PositionViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        private val text : TextView = v.findViewById(R.id.item_text)

        fun updateCell(position: String) {
            text.text = position
        }
    }


data class Product (
    val name: String,
    val brand: String,
    val barcode: String,
    val nutriscore: Nutriscore,
    val imageUrl: String,
    val quantity: String,
    val saleCountryList: List<String>,
    val ingrediantList: List<String>,
    val allergensList: List<String>,
    val additivesList: List<String>
)

enum class Nutriscore(val letter:String){
    A("A"),B("B"),C("C"),D("D"),E("E")
}