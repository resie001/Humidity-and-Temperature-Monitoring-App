package lab.chevalier.temperaturemonitor.api

import kotlinx.coroutines.Deferred
import lab.chevalier.temperaturemonitor.model.BaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Request {
    @GET("channels/1265106/feeds.json")
    fun getDataAsync(@Query("api_key") apiKey: String): Deferred<Response<BaseResponse>>
}