package app.el_even.com.exo1.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.el_even.com.exo1.api.GithubApi
import app.el_even.com.exo1.data.GithubRepo
import app.el_even.com.exo1.data.Result
import kotlinx.coroutines.*
import timber.log.Timber

class ListViewModel : ViewModel() {

    private val _resultApi = MutableLiveData<Result>()
    val resultApi: LiveData<Result>
        get() = _resultApi

    private val _githubRepos = MutableLiveData<List<GithubRepo>>()
    val githubRepos: LiveData<List<GithubRepo>>
        get() = _githubRepos

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init {
        getResult()
    }

    private fun getResult() {
        viewModelScope.launch {
            val getGithubRepoAsync =
                GithubApi.retrofitService.getAllGithubRepo() // Result: Request JSON Complete
            try {
                _resultApi.value = getGithubRepoAsync.await() // JSON complete in object Result
                Timber.d("Result ${_resultApi.value}")
                _githubRepos.value = _resultApi.value!!.githubRepos // JSON list
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