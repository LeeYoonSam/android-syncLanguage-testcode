package com.ys.test.androidtestsamples.junit

/**
 * Created by Albert-IM on 23/11/2017.
 */
class AddingMachine {
    fun sum(a: String, b: String): String {
        var sumInt:Int = 0
        try {
            sumInt = a.toInt() + b.toInt()
        } catch ( e: NumberFormatException ) {
            e.printStackTrace()
        }

        return sumInt.toString()
    }
}