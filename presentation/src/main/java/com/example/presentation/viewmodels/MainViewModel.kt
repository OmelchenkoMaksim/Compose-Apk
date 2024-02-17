package com.example.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.NetworkStatusHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val networkStatusHelper: NetworkStatusHelper
) : ViewModel() {

    val showSnackbar: MutableStateFlow<Boolean> = MutableStateFlow(true)

    init {
        observeNetworkStatus()
    }

    private fun observeNetworkStatus() {
        viewModelScope.launch {
            networkStatusHelper.observeNetworkStatus().collect { isAvailable ->
                showSnackbar.value = !isAvailable
            }
        }
    }
}
