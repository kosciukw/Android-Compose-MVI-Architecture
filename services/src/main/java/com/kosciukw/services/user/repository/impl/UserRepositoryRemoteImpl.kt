package com.kosciukw.services.user.repository.impl

import com.kosciukw.services.user.repository.UserRepository
import com.kosciukw.services.user.model.LoginWithPasswordRequest
import javax.inject.Inject

class UserRepositoryRemoteImpl @Inject constructor(
    private val mockUserRepository: UserRepository
) : UserRepository {

    override suspend fun loginDeviceByPassword(
        request: LoginWithPasswordRequest
    ) = mockUserRepository.loginDeviceByPassword(request)
}