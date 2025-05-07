package com.kosciukw.services.data.user.service.user.error.impl

import com.kosciukw.services.data.user.repository.error.model.UserDomainError
import com.kosciukw.services.data.user.service.user.error.UserDomainToAppErrorMapper
import pl.kosciukw.petsify.shared.error.AppError
import pl.kosciukw.petsify.shared.error.DomainError

class UserDomainToAppErrorMapperImpl : UserDomainToAppErrorMapper {

    override fun map(error: DomainError) = when (error) {
        is UserDomainError -> mapUserDomainError(error)
        else -> AppError.TechnicalError.Unknown(message = error.message)
    }

    private fun mapUserDomainError(error: DomainError) = when (error) {
//        is UserDomainError.UnknownError,
        is UserDomainError.ValidationError, -> AppError.InfoError(
//            description = context.getString(R.string.GeneralErrorDialog_MessageLabel_Text),
            description = "Unknown or Validation Error",
            message = error.message
        )
        else -> AppError.InfoError(
            description = error.message,
            message = "Oops, something went wrong..."
        )
    }
}