package com.example.composefun.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.composefun.data.FormState

class FormViewModel : ViewModel() {

    var formState by mutableStateOf(FormState())
        private set

    fun onNameChanged(value: String) {
        formState = formState.copy(name = value)
    }

    fun onEmailChange(value: String) {
        formState = formState.copy(email = value)
    }

    fun onPasswordChange(value: String) {
        formState = formState.copy(password = value)
    }

    fun confirmPasswordChange(value: String) {
        formState = formState.copy(confirmPassword = value)
    }

    fun validateAndSubmit() {
        val emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()

        formState = when {
            formState.name.isBlank() -> formState.copy(error = "Name cannot be empty")
            !formState.email.matches(emailRegex) -> formState.copy(error = "Invalid email")
            formState.password.length < 6 -> formState.copy(error = "Password too short")
            formState.confirmPassword != formState.password -> formState.copy(error = "Password don't match")
            else -> formState.copy(error = null, isSubmitted = true)
        }
    }

}