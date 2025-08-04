package com.example.composefun.data

data class FormState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val error: String? = null,
    val isSubmitted: Boolean = false
)
