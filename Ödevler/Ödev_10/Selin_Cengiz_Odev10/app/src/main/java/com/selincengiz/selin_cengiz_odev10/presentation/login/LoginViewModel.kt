package com.selincengiz.selin_cengiz_odev10.presentation.login


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.selincengiz.selin_cengiz_odev10.common.LoginState
import com.selincengiz.selin_cengiz_odev10.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.selincengiz.selin_cengiz_odev10.common.Resource
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {

    private var _loginState = MutableStateFlow<LoginState>(LoginState.Entry)
    val loginState: StateFlow<LoginState>
        get() = _loginState.asStateFlow()

    fun login(email: String?, password: String?) {
        viewModelScope.launch {
            val result = loginUseCase.invoke(email, password)
            when (result) {
                is Resource.Success -> {
                    _loginState.value = LoginState.Logined(result.data)
                }

                is Resource.Error -> {
                    _loginState.value = LoginState.Error(result.throwable)
                }
            }
        }
    }
}