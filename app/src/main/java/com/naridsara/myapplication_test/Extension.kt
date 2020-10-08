package com.naridsara.myapplication_test

import android.content.Context
import android.widget.EditText
import android.widget.Toast

fun EditText.getContents()= this.text.toString().trim()

fun Context.toast(message : String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}