package com.maxsaeta.pesocinta.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import domain.Peso
import usecases.PesoTeorico

class HomeViewModel : ViewModel() {
    private val pesoTeorico = PesoTeorico()

    private val _pesoteorico = MutableLiveData<Float>()
    val pesoteorico: LiveData<Float> get() = _pesoteorico

    private val _pesoefectivo = MutableLiveData<Float>()
    val pesoefectivo: LiveData<Float> get() = _pesoefectivo

    fun setPesoTeorico(peso: Peso){
        _pesoteorico.value = pesoTeorico.calcPesoTeorico(peso)
        _pesoefectivo.value = pesoTeorico.calcPesoEfectivo(peso)
    }
}