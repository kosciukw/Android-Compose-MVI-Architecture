package com.kosciukw.services.data.user.service

import com.kosciukw.services.data.user.model.domain.PairByPasswordDomainModel
import com.kosciukw.services.data.user.repository.UserRepository
import javax.inject.Inject

class UserServiceImpl @Inject constructor(
    private val userRepository: UserRepository
) : UserService {

    override suspend fun loginDeviceByPassword(
        request: PairByPasswordDomainModel
    ) = userRepository.pairDeviceByPassword(request)
}