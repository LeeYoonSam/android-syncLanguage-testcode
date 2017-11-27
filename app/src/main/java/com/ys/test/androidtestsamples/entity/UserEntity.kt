package com.ys.test.androidtestsamples.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by Albert-IM on 27/11/2017.
 */
class UserEntity {

    @SerializedName("id")
    var userId: Int = 0

    @SerializedName("cover_url")
    val coverUrl: String? = null

    @SerializedName("full_name")
    var fullname: String? = null

    @SerializedName("description")
    val description: String? = null

    @SerializedName("followers")
    val followers: Int = 0

    @SerializedName("email")
    val email: String? = null
}