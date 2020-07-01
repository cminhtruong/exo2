package app.el_even.com.exo1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class ListViewModel : ViewModel() {

    private val _resultApi = MutableLiveData<String>()
    val resultApi: LiveData<String>
        get() = _resultApi

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init {
        getResult()
    }

    private fun getResult() {
        viewModelScope.launch {
            val getGithubRepoAsync = GithubApi.retrofitService.getAllGithubRepo()
            try {
                _resultApi.value = getGithubRepoAsync.execute().body()
            } catch (e: Exception) {
                // TODO
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

}