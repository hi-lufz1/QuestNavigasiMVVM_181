package com.example.arsitekturmvvm.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.arsitekturmvvm.model.DataMahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel : ViewModel() {

    // Request
    private val _uiState = MutableStateFlow(DataMahasiswa())
    val uiState: StateFlow<DataMahasiswa> = _uiState.asStateFlow()

    fun saveDataMahasiswa(listDM: List<String>) {
        _uiState.update { dataMhs ->
            dataMhs.copy(
                nama = listDM[0],
                nim = listDM[1],
                alamat = listDM[2]
            )
        }
    }
}