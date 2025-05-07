package com.kosciukw.services.data.user.repository

import com.kosciukw.services.data.user.model.api.response.AccessTokenApiModel
import com.kosciukw.services.data.user.model.domain.PairByPasswordDomainModel
import com.kosciukw.services.data.user.model.domain.UserDomainModel
import pl.kosciukw.petsify.shared.result.ResultOrFailure

interface UserRepository {

    suspend fun pairDeviceByPassword(request: PairByPasswordDomainModel): AccessTokenApiModel
}