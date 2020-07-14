package com.example.ciceksepeti.Base

import android.os.Build
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import java.text.NumberFormat
import java.util.*


@BindingAdapter("imageUrl")
fun setUrl(imageView: ImageView, imageUrl: String?) {
    Picasso.with(imageView.context).load(imageUrl.toString()).into(imageView)
}
@BindingAdapter("price")
fun setPrice(textView: TextView, price: Double?) {
    val p = price ?: 0.00
    val format = NumberFormat.getCurrencyInstance(Locale("tr", ""))
    val formatted = format.format(p)
    val result = if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.N_MR1) {
        formatted.substring(0, formatted.length - 1) + "TL"
    } else {
        val pre = if (p < 0) "-" else ""
        pre + formatted.substring(if (p >= 0) 1 else 2) + " TL"
    }
    textView.text = result
}

@BindingAdapter("sale")
fun setSale(textView: TextView, sale: Int?) {
    val result  = "%" + sale.toString()

    textView.text = result
}
@BindingAdapter("count")
fun setRatingCount(textView: TextView, count: Int?) {
    val result  =  "(" + count.toString() + ")"

    textView.text = result
}