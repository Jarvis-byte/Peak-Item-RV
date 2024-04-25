package com.example.peekrv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.peekrv.Data.Genre
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    private val eventChannel = MutableSharedFlow<Event>()
    val eventsFlow: SharedFlow<Event> = eventChannel.asSharedFlow()


    fun openShow(genre: Genre?) {
        viewModelScope.launch {
            eventChannel.emit(Event.OpenShow(genre))
        }
    }


    sealed class Event {
        data class OpenShow(val genre: Genre?) : Event()
    }
}

