package lab.chevalier.temperaturemonitor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import lab.chevalier.temperaturemonitor.api.ApiStatus
import lab.chevalier.temperaturemonitor.api.BaseApi
import lab.chevalier.temperaturemonitor.model.Feed

class MainViewModel : ViewModel() {

    private val apiKey = "FAV16DC137MEX2I5"
    private val api = BaseApi
    private val feeds = MutableLiveData<List<Feed>>()
    private val status = MutableLiveData<ApiStatus>()
    private val uiScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    init {
        this.uiScope.launch {
            getData()
        }
    }

    private suspend fun getData() {
        this.status.postValue(ApiStatus.LOADING)
        val response = api.request.getDataAsync(apiKey).await()
        if (response.isSuccessful) {
            this.feeds.postValue(response.body()?.feeds)
            this.status.postValue(ApiStatus.SUCCESS)
        } else {
            this.status.postValue(ApiStatus.FAILED)
        }
    }

    fun getFeeds(): LiveData<List<Feed>> = this.feeds
    fun getApiStatus(): LiveData<ApiStatus> = this.status
}