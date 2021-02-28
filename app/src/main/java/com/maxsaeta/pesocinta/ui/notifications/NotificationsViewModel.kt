package com.maxsaeta.pesocinta.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Newlin Max Saeta \n Balanzas y Sistemas Embebidos"
    }
    val text: LiveData<String> = _text
}