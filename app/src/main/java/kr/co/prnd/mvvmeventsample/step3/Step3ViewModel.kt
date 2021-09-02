package kr.co.prnd.mvvmeventsample.step3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Step3ViewModel @Inject constructor() : ViewModel() {

    private val _showToastEvent = MutableSharedFlow<String>()
    val showToastEvent = _showToastEvent.asSharedFlow()

    private val _aaaEvent = MutableSharedFlow<String>()
    val aaaEvent = _aaaEvent.asSharedFlow()

    private val _bbbEvent = MutableSharedFlow<Int>()
    val bbbEvent = _bbbEvent.asSharedFlow()

    fun showToast() {
        viewModelScope.launch {
            _showToastEvent.emit("토스트")
        }
    }

    fun aaa() {
        viewModelScope.launch {
            _aaaEvent.emit("aaa")
        }
    }

    fun bbb() {
        viewModelScope.launch {
            _bbbEvent.emit(36)
        }
    }
}
