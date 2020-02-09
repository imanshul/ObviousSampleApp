package com.anshulthakur.obvioussampleapp.model

import java.io.Serializable

/*
*Created By Anshul Thakur on 2/9/2020.
*/
data class NasaPictureData(
    val copyright: String?,
    val date: String,
    val explanation: String,
    val hdurl: String,
    val media_type: String,
    val service_version: String,
    val title: String,
    val url: String
):Serializable
