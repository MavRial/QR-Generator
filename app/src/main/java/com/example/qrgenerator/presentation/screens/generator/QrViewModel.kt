package com.example.qrgenerator.presentation.screens.generator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrgenerator.domain.model.QrDomain
import com.example.qrgenerator.domain.usecase.GetQrByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QrViewModel @Inject constructor(
    private val getQrByIdUseCase: GetQrByIdUseCase
): ViewModel() {

    private val _qrState = MutableStateFlow<QrDomain?>(null)
    val qrState: StateFlow<QrDomain?> = _qrState

    fun loadQr(id: String){
        viewModelScope.launch {
            _qrState.value = getQrByIdUseCase(id)
        }
    }
}