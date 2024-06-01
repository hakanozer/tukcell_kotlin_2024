package com.selincengiz.selin_cengiz_odev10.presentation.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.selincengiz.selin_cengiz_odev10.common.RegisterState
import com.selincengiz.selin_cengiz_odev10.common.Resource
import com.selincengiz.selin_cengiz_odev10.domain.usecase.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val registerUseCase: RegisterUseCase) : ViewModel() {

    private var _registerState = MutableStateFlow<RegisterState>(RegisterState.Entry)
    val registerState: StateFlow<RegisterState>
        get() = _registerState.asStateFlow()

    fun register(email: String?, password: String?, passwordConfirm: String?) {
        viewModelScope.launch {
            val result = registerUseCase.invoke(email, password, passwordConfirm)
            when (result) {
                is Resource.Success -> {
                    _registerState.value = RegisterState.Registered(result.data)
                }

                is Resource.Error -> {
                    _registerState.value = RegisterState.Error(result.throwable)
                }
            }
        }
    }
}