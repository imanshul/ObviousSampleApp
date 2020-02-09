package com.anshulthakur.obvioussampleapp.extensions

import android.content.Context
import android.widget.Toast

/*
*Created By Anshul Thakur on 2/9/2020.
*/

fun showMessage(context: Context, msg:String){
    Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
}