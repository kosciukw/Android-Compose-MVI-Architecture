package com.kosciukw.services.data.user.repository.impl

import com.kosciukw.services.data.user.model.api.response.AccessTokenApiModel
import com.kosciukw.services.data.user.repository.UserRepository
import com.kosciukw.services.data.user.model.domain.PairByPasswordDomainModel
import javax.inject.Inject

class UserRepositoryMockImpl @Inject constructor() : UserRepository {

    override suspend fun pairDeviceByPassword(
        request: PairByPasswordDomainModel
    ): AccessTokenApiModel {
        return AccessTokenApiModel(
            accessToken = "asfasfdg",
            refreshToken = "askfakso"
        )
    }
}