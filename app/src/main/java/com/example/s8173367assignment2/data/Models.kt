package com.example.s8173367assignment2.data

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

// Login Request
@JsonClass(generateAdapter = true)
data class LoginRequest(
    @Json(name = "username") val username: String,
    @Json(name = "password") val password: String
)

// Login Response
@JsonClass(generateAdapter = true)
data class LoginResponse(
    @Json(name = "keypass") val keypass: String
)

// Dashboard Response
@JsonClass (generateAdapter = true)
data class DashboardResponse(
    @Json(name = "entities") val entities: List<Entity>,
    @Json(name = "entityTotal") val entityTotal: Int
)

// Entity Item
@JsonClass(generateAdapter = true)
@Parcelize
data class Entity(
    // We check for any possible key the server might be using for the movie name/title
    @Json(name = "title") val titleField: String? = null,
    @Json(name = "name") val nameField: String? = null,

    // We check for any possible key the server might use for the secondary detail
    @Json(name = "year") val yearField: String? = null,
    @Json(name = "genre") val genreField: String? = null,
    @Json(name = "director") val directorField: String? = null,

    // Description remains mandatory as requested by your prompt assignment sheet
    @Json(name = "description") val description: String
) : Parcelable {

    // Cleans up the fields so your EntityAdapter layout views read them perfectly
    val property1: String
        get() = titleField ?: nameField ?: "Movie Title"

    val property2: String
        get() = yearField ?: genreField ?: directorField ?: "Movie Detail"
}