package pl.kosciukw.petsify.shared.error

sealed class AppError(override val message: String) : Throwable(message) {

    class InfoError(
        val uiMessage: String,
        technicalMessage: String
    ) : AppError(message = technicalMessage)

    sealed class TechnicalError(
        message: String
    ) : AppError(message = HEADER + message) {

        class Unknown(message: String) : TechnicalError(message = message)

        class UserIsLocked(message: String) : TechnicalError(message = message)

        class SessionExpired(message: String) : TechnicalError(message = message)

        companion object {
            private const val HEADER = "TechnicalError : "
        }
    }
}