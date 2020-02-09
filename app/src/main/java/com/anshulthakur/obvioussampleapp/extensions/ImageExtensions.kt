package com.anshulthakur.obvioussampleapp.extensions

import android.content.Context
import android.widget.ImageView
import com.anshulthakur.obvioussampleapp.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/*
*Created By Anshul Thakur on 2/9/2020.
*/

fun ImageView.loadImageFromUrl(context: Context, url:String){
    val requestOptions = RequestOptions()
        .centerCrop()
        .placeholder(R.drawable.placeholder)
        .error(R.drawable.failed_to_load)
    Glide.with(context).load(url).apply(requestOptions).into(this)
}