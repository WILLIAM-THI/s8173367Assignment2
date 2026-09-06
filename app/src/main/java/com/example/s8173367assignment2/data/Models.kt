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
    // Check field for correct entity property1
    @Json(name = "title") val titleField: String? = null,
    @Json(name = "name") val nameField: String? = null,

    // Check field for correct entity property2
    @Json(name = "year") val yearField: String? = null,
    @Json(name = "genre") val genreField: String? = null,
    @Json(name = "director") val directorField: String? = null,

    // Description
    @Json(name = "description") val description: String
) : Parcelable {

    // Cleans up the fields
    val property1: String
        get() = titleField ?: nameField ?: "Movie Title"

    val property2: String
        get() = yearField ?: genreField ?: directorField ?: "Movie Detail"
}