package pl.kosciukw.petsify.shared.error

open class DomainError(override val message: String) : Throwable(message)

class TechnicalError(message: String) : DomainError(message = message)