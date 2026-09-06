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
    @Json(name = "property1") val property1: String,
    @Json(name = "property2") val property2: String,
    @Json(name = "description") val description: String
) : Parcelable