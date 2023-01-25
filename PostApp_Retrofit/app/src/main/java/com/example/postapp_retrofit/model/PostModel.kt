package com.omer.retrofitapp.model

import com.google.gson.annotations.SerializedName

data class PostModel(
    @SerializedName("postImage")
    val postImage: String,
    @SerializedName("userImage")
    val userImage: String,
    @SerializedName("postStatement")
    val postStatement: String,
    @SerializedName("userName")
    val userName: String


)