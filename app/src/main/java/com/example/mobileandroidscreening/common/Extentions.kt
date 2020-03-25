package com.example.mobileandroidscreening.common

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso

fun ViewGroup.inflate(layoutId:Int):View{
    return LayoutInflater.from(context).inflate(layoutId, this, false)
}

fun loadImage(img_url: String, imageView: ImageView) {
    Picasso.get().load(img_url).into(imageView)
}

fun Context.createToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}