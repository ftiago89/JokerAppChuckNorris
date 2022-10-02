package com.felipe.jokerapp.model

import com.google.gson.annotations.SerializedName

data class Joke(
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("icon_url") val iconUrl: String,
    @SerializedName("id") val id: String,
    @SerializedName("updated_at") val updatedAt: String,
    @SerializedName("value") val value: String
) {
}