package lab.chevalier.temperaturemonitor.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Feed(
    @Json(name = "created_at")
    val createdAt: String,
    @Json(name = "entry_id")
    val entryId: Int,
    @Json(name = "field1")
    val field1: String,
    @Json(name = "field2")
    val field2: String? = null
)