package com.anshulthakur.obvioussampleapp.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

/*
*Created By Anshul Thakur on 2/9/2020.
*/
@SuppressLint("SimpleDateFormat")
object TimeUtils{

    const val APP_DEFAULT_TIME_FORMAT = "yyyy-MM-dd"

    fun getReadableTimeFromString(time:String):String{
        val defaultFormat = SimpleDateFormat(APP_DEFAULT_TIME_FORMAT,Locale.ENGLISH)
        val newFormat = SimpleDateFormat("dd MMM yyyy")
        val date = defaultFormat.parse(time)
        return newFormat.format(date)
    }

    fun getMillisFromStringDate(stringDate:String):Long{
        val defaultFormat = SimpleDateFormat(APP_DEFAULT_TIME_FORMAT,Locale.ENGLISH)
        return defaultFormat.parse(stringDate).time
    }
}