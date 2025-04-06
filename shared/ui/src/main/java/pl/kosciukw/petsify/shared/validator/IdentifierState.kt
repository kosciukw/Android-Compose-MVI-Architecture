package pl.kosciukw.petsify.shared.validator

sealed class IdentifierState {
    
    object Empty : IdentifierState()
    
    class Valid(
        val validIdentifier: Identifier
    ) : IdentifierState()
    
    object Invalid : IdentifierState()
}