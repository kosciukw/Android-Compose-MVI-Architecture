package com.kosciukw.services.data.user.service

import com.kosciukw.services.data.user.model.api.response.AccessTokenApiModel
import com.kosciukw.services.data.user.model.domain.PairByPasswordDomainModel
import com.kosciukw.services.data.user.model.domain.UserDomainModel
import pl.kosciukw.petsify.shared.result.ResultOrFailure

interface UserService {

//    suspend fun loginDeviceByPassword(request: PairByPasswordDomainModel): ResultOrFailure<UserDomainModel, Throwable>
    suspend fun loginDeviceByPassword(request: PairByPasswordDomainModel): AccessTokenApiModel
}