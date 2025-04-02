package com.kosciukw.services.user.service

import com.kosciukw.services.user.model.LoginWithPasswordRequest
import com.kosciukw.services.user.model.UserDomainModel
import com.kosciukw.services.user.repository.UserRepository
import pl.kosciukw.petsify.shared.error.DomainError
import pl.kosciukw.petsify.shared.result.ResultOrFailure
import javax.inject.Inject

class UserServiceImpl @Inject constructor(
    private val userRepository: UserRepository
) : UserService {

    override suspend fun loginDeviceByPassword(
        request: LoginWithPasswordRequest
    ) = userRepository.loginDeviceByPassword(request)
}