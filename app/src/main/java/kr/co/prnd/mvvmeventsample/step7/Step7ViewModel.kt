package kr.co.prnd.mvvmeventsample.step7

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Step7ViewModel @Inject constructor() : ViewModel() {

    private val _eventChannel = Channel<Event>(Channel.BUFFERED)
    val eventFlow = _eventChannel.receiveAsFlow()

    fun showToast() = viewModelScope.launch {
        delay(2000)
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
            _eventChannel.send(event)
        }
    }

    sealed class Event {
        data class ShowToast(val text: String) : Event()
        data class Aaa(val value: String) : Event()
        data class Bbb(val value: Int) : Event()
    }
}
