package com.kosciukw.services.data.user.repository.error.model

import pl.kosciukw.petsify.shared.error.DomainError
import pl.kosciukw.petsify.shared.utils.empty

//TODO
sealed class UserDomainError(message: String) : DomainError(message = HEADER + message) {

    class ApiRequestFailed(message: String) : UserDomainError(message = message)

//    class UserNotVerified(message: String) : UserDomainError(message = message)

    class CannotFindUser(message: String) : UserDomainError(message = message)

    class ValidationError(message: String) : UserDomainError(message)

    class InvalidOtpCode(message: String) : UserDomainError(message)

    class InvalidOtpCodeLimitReached(message: String) : UserDomainError(message)

    object AddingUserFailed : UserDomainError(message = "Adding user failed")

//    object AutomaticPairingFailed : UserDomainError(message = "Automatic pairing failed")

    object BiometryAuthFailed : UserDomainError(message = "Biometry auth failed")

    object UserLocked : UserDomainError(message = "User is locked")

    class UnknownError(message: String) : UserDomainError(message)

    override fun toString() = String.empty()


    companion object {
        private const val HEADER = "UserDomainError : "
    }
}