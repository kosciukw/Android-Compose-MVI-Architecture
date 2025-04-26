package com.kosciukw.services.data.user.api.controller

import com.kosciukw.services.data.user.model.api.response.AccessTokenApiModel
import com.kosciukw.services.data.user.model.domain.PairByPasswordDomainModel

interface UserApiController {

    suspend fun pairByPassword(
        pairByPasswordDomainModel: PairByPasswordDomainModel
    ): AccessTokenApiModel
}