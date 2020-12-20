package lab.chevalier.temperaturemonitor.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BaseResponse(
    @Json(name = "channel")
    val channel: Channel,
    @Json(name = "feeds")
    val feeds: List<Feed>
)