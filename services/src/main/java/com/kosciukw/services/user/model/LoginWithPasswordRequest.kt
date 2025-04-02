package com.kosciukw.services.user.model

import pl.kosciukw.petsify.shared.utils.empty

data class LoginWithPasswordRequest(
    val email: String,
    val password: String
) {
    override fun toString() = String.empty()
}