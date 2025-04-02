package com.kosciukw.services.user.repository.impl

import com.kosciukw.services.user.repository.UserRepository
import com.kosciukw.services.user.model.LoginWithPasswordRequest
import com.kosciukw.services.user.model.UserDomainModel
import kotlinx.coroutines.delay
import pl.kosciukw.petsify.shared.error.TechnicalError
import pl.kosciukw.petsify.shared.result.ResultOrFailure
import javax.inject.Inject

class UserRepositoryMockImpl @Inject constructor() : UserRepository {

    override suspend fun loginDeviceByPassword(
        request: LoginWithPasswordRequest
    ): ResultOrFailure<UserDomainModel, Throwable> {
        delay(1000)

        return if (request.email == "test@example.com" && request.password == "password123") {
            ResultOrFailure.Success(
                UserDomainModel(
                    userId = "mock_user_123",
                    email = request.email,
                    displayName = "Mock User",
                    profilePictureUrl = "https://example.com/mock-profile.png"
                )
            )
        } else {
            ResultOrFailure.Failure(TechnicalError("Invalid email or password"))
        }
    }
}