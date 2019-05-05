package com.uhc.data.remote

data class ResponseWrap<T>(val results: List<T> = arrayListOf())