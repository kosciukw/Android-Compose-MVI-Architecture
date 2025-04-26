package com.kosciukw.services.data.user.api.controller.impl

import com.kosciukw.services.data.user.api.UserApi
import com.kosciukw.services.data.user.api.controller.UserApiController
import com.kosciukw.services.data.user.api.provider.UserUrlProvider
import com.kosciukw.services.data.user.error.mapper.UserExceptionMapper
import com.kosciukw.services.data.user.model.api.request.PairByPasswordRequest
import com.kosciukw.services.data.user.model.domain.PairByPasswordDomainModel

class UserApiControllerImpl(
    private val userApi: UserApi,
    private val userUrlProvider: UserUrlProvider,
    private val userExceptionMapper: UserExceptionMapper
) : UserApiController {

    override suspend fun pairByPassword(pairByPasswordDomainModel: PairByPasswordDomainModel) =
        userExceptionMapper.mapException {
            with(pairByPasswordDomainModel) {
                userApi.pairByPassword(
                    pairByPasswordRequest = PairByPasswordRequest(
                        email = email,
                        password = password
                    ),
                    url = userUrlProvider.getPairByPasswordUrl()
                )
            }
        }
}