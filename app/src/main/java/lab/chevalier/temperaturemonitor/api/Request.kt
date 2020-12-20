package lab.chevalier.temperaturemonitor.api

import kotlinx.coroutines.Deferred
import lab.chevalier.temperaturemonitor.model.BaseResponse
import retrofit2.Response
import retrofit2.http.GET

interface Request {
    @GET("channels/1265106/feeds.json?api_key=FAV16DC137MEX2I5")
    fun getDataAsync(): Deferred<Response<BaseResponse>>
}