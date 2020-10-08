package com.naridsara.myapplication_test

import android.content.Context
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun EditText.getContents()= this.text.toString().trim()

fun Context.toast(message : String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
fun ImageView.setImageCircle(url: String?, @DrawableRes placeholder: Int = R.drawable.ic_launcher_background) {
    Glide.with(this)
            .load(url)
            .apply(RequestOptions.placeholderOf(placeholder))
            //.circleCrop()
            .into(this)
}
