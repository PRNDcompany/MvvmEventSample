package kr.co.prnd.mvvmeventsample.step2

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class Step2ViewModel @Inject constructor() : ViewModel() {

    private val _showToastEvent = MutableSingleLiveData<String>()
    val showToastEvent: SingleLiveData<String> = _showToastEvent

    fun showToast() {
        _showToastEvent.setValue("토스트")
    }

}
