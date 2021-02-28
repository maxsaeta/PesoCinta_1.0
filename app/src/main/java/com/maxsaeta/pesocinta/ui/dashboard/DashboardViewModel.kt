package com.maxsaeta.pesocinta.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import domain.Velocidad
import usecases.Speed

class DashboardViewModel : ViewModel() {
    private val speed = Speed()
    private val _text = MutableLiveData<String>().apply {
        value = "Calcule la velocidad de la banda transportadora"
    }
    val text: LiveData<String> = _text

    private val _velocidad = MutableLiveData<Float>()
    val velocidad: LiveData<Float> get() = _velocidad


    fun printSpeed():Float{
        return _velocidad.value.toString().toFloat()
    }

    fun setSpeed(veloc: Velocidad){
        _velocidad.value = speed.calcSpeed(veloc)
    }
}