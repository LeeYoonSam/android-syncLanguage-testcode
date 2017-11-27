package com.ys.test.androidtestsamples.io

import com.google.gson.Gson

/**
 * Created by Albert-IM on 27/11/2017.
 */
class Serializer {

    val gson = Gson()

    fun serialize(obj: Any, clazz: Class<*>): String {
        return gson.toJson(obj, clazz)
    }

    fun <T> deserialize(json: String, clazz: Class<T>): T {
        return gson.fromJson(json, clazz)
    }

}