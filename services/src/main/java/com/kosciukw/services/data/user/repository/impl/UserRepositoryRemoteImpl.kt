package com.kosciukw.services.data.user.repository.impl

import com.kosciukw.services.data.user.api.controller.UserApiController
import com.kosciukw.services.data.user.mapper.UserApiToDomainErrorMapper
import com.kosciukw.services.data.user.model.api.response.AccessTokenApiModel
import com.kosciukw.services.data.user.repository.UserRepository
import com.kosciukw.services.data.user.model.domain.PairByPasswordDomainModel
import pl.kosciukw.petsify.shared.callback.mapResult
import pl.kosciukw.petsify.shared.callback.suspendCallbackWithData
import pl.kosciukw.petsify.shared.network.NetworkStateProvider
import pl.kosciukw.petsify.shared.network.networkRequest
import pl.kosciukw.petsify.shared.result.ResultOrFailure
import javax.inject.Inject

class UserRepositoryRemoteImpl @Inject constructor(
    private val networkStateProvider: NetworkStateProvider,
    private val errorMapper: UserApiToDomainErrorMapper,
    private val userApiController: UserApiController
) : UserRepository {

    override suspend fun pairDeviceByPassword(
        request: PairByPasswordDomainModel
    ) = mapResult(errorMapper = errorMapper) {
        userApiController.pairByPassword(request)
    }

//    override suspend fun pairDeviceByPassword(
//        request: PairByPasswordDomainModel
//    ): ResultOrFailure<UserDomainModel, Throwable> {
//        return mapResult(errorMapper = errorMapper) {
//            networkRequest(networkStateProvider) {
//                userApiController.pairByPassword(
//                    pairByPasswordDomainModel = request
//                )
//            }
//        }
//    }

//    override suspend fun pairDeviceByPassword(
//        request: PairByPasswordDomainModel
//    ): ResultOrFailure<UserDomainModel, Throwable> {
//        return runCatching {
//            suspendCallbackWithData(errorMapper = errorMapper) { success, failure ->
//                networkRequest(networkStateProvider) {
//                    if (request.email == "test@example.com" && request.password == "password123") {
//                        success(
//                            UserDomainModel(
//                                userId = "mock_user_123",
//                                email = request.email,
//                                displayName = "Mock User",
//                                profilePictureUrl = "https://example.com/mock-profile.png"
//                            )
//                        )
//                    } else {
//                        failure(TechnicalError("Invalid email or password"))
//                    }
//                }
//            }
//        }.fold(
//            onSuccess = { ResultOrFailure.Success(it) },
//            onFailure = { ResultOrFailure.Failure(it) }
//        )
}