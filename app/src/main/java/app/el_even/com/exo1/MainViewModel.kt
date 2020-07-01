package app.el_even.com.exo1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author el_even
 * @version 1.0
 * @since 27/06/2020
 */
class MainViewModel : ViewModel() {

    private val _isButtonClicked = MutableLiveData<Boolean>()
    val isButtonClicked: LiveData<Boolean> = _isButtonClicked

    init {
        _isButtonClicked.value = false
    }

    fun navigateToListGithub() {
        _isButtonClicked.value = true
    }

    fun navigateToListGithubDone() {
        _isButtonClicked.value = false
    }

}