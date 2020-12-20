package lab.chevalier.temperaturemonitor.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Channel(
    @Json(name = "created_at")
    val createdAt: String,
    @Json(name = "field1")
    val field1: String,
    @Json(name = "field2")
    val field2: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "last_entry_id")
    val lastEntryId: Int,
    @Json(name = "latitude")
    val latitude: String,
    @Json(name = "longitude")
    val longitude: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "updated_at")
    val updatedAt: String
)