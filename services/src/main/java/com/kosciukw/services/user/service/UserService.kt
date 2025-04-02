package com.kosciukw.services.user.service

import com.kosciukw.services.user.model.LoginWithPasswordRequest
import com.kosciukw.services.user.model.UserDomainModel
import pl.kosciukw.petsify.shared.error.DomainError
import pl.kosciukw.petsify.shared.result.ResultOrFailure

interface UserService {

    suspend fun loginDeviceByPassword(request: LoginWithPasswordRequest): ResultOrFailure<UserDomainModel, Throwable>
}