package com.kosciukw.services.user.repository

import com.kosciukw.services.user.model.LoginWithPasswordRequest
import com.kosciukw.services.user.model.UserDomainModel
import pl.kosciukw.petsify.shared.result.ResultOrFailure

interface UserRepository {

    suspend fun loginDeviceByPassword(request: LoginWithPasswordRequest): ResultOrFailure<UserDomainModel, Throwable>
}