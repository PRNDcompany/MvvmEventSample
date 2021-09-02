package kr.co.prnd.mvvmeventsample.step6

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Step6ViewModel @Inject constructor() : ViewModel() {

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    fun showToast() {
        event(Event.ShowToast("토스트"))
    }

    fun aaa() {
        event(Event.Aaa("aaa"))
    }

    fun bbb() {
        event(Event.Bbb(36))
    }

    private fun event(event: Event) {
        viewModelScope.launch {
            _eventFlow.emit(event)
        }
    }

    sealed class Event {
        data class ShowToast(val text: String) : Event()
        data class Aaa(val value: String) : Event()
        data class Bbb(val value: Int) : Event()
    }
}
