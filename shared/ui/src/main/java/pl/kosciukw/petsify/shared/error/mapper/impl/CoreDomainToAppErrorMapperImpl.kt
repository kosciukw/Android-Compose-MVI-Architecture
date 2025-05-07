package pl.kosciukw.petsify.shared.error.mapper.impl

import pl.kosciukw.petsify.shared.error.AppError
import pl.kosciukw.petsify.shared.error.CoreDomainError
import pl.kosciukw.petsify.shared.error.DomainError
import pl.kosciukw.petsify.shared.error.mapper.CoreDomainToAppErrorMapper

class CoreDomainToAppErrorMapperImpl(
//    private val context: Context
) : CoreDomainToAppErrorMapper {

    override fun map(error: DomainError) = when (error) {
        is CoreDomainError -> mapCoreDomainError(error)
        else -> AppError.TechnicalError.Unknown(message = error.message)
    }

    private fun mapCoreDomainError(error: CoreDomainError) = when (error) {
        is CoreDomainError.NoInternetConnection -> AppError.InfoError(
            description = error.message,//context.getString(R.string.ConnectionLostDialog_MessageLabel_Text),
            message = "No internet exception"
        )

        is CoreDomainError.NoSession -> AppError.TechnicalError.SessionExpired(
            message = error.message
        )

        else -> AppError.TechnicalError.Unknown(message = error.message)
    }
}