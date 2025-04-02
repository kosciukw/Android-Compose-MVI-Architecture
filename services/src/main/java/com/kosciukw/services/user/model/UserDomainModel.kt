package com.kosciukw.services.user.model

import pl.kosciukw.petsify.shared.utils.empty

data class UserDomainModel(
    val userId: String,
    val email: String,
    val displayName: String? = null,
    val profilePictureUrl: String? = null
) {
    override fun toString() = String.empty()
}