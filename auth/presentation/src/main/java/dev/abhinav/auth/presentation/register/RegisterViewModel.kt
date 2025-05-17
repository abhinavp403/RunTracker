package dev.abhinav.auth.presentation.register

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.abhinav.auth.domain.UserDataValidator
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@OptIn(ExperimentalFoundationApi::class)
class RegisterViewModel(
    private val userDataValidator: UserDataValidator
) : ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    init {
        snapshotFlow { state.email.text.toString() }
            .debounce(400)
            .distinctUntilChanged()
            .onEach { email ->
                state = state.copy(
                    isEmailValid = userDataValidator.isValidEmail(email.toString())
                )
            }
            .launchIn(viewModelScope)

        snapshotFlow { state.password.text.toString() }
            .debounce(400)
            .distinctUntilChanged()
            .onEach { password ->
                state = state.copy(
                    passwordValidationState = userDataValidator.validatePassword(password.toString())
                )
            }
            .launchIn(viewModelScope)
    }

    fun onAction(action: RegisterAction) {

    }
}