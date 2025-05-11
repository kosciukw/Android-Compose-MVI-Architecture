package pl.kosciukw.petsify.feature.login.usecase

import com.kosciukw.services.data.user.model.api.response.AccessTokenApiModel
import com.kosciukw.services.data.user.model.domain.PairByPasswordDomainModel
import com.kosciukw.services.data.user.service.user.UserService
import kotlinx.coroutines.flow.*
import pl.kosciukw.petsify.shared.usecase.UseCase
import pl.kosciukw.petsify.shared.result.ResultOrFailure
import javax.inject.Inject

class PairDeviceUseCase @Inject constructor(
    private val userService: UserService
) : UseCase<ResultOrFailure<AccessTokenApiModel, Throwable>, PairDeviceUseCase.Params>() {

    data class Params(
        val email: String,
        val password: String
    )

    override fun action(params: Params) = flow {
        emit(ResultOrFailure.Loading)
        println("Emitting Loading...")

        val request = PairByPasswordDomainModel(
            email = params.email,
            password = params.password
        )

        runCatching {
            println("Calling pairDeviceByPassword...")
            userService.pairDeviceByPassword(request)
        }.onSuccess { result ->
            println("Emitting Success with result: $result")
            emit(ResultOrFailure.Success(result))
        }.onFailure { error ->
            println("Emitting Failure with error: ${error.message}")
            emit(ResultOrFailure.Failure(error))
        }
    }
}