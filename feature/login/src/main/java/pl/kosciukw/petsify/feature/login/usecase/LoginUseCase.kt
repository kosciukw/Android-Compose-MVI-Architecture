package pl.kosciukw.petsify.feature.login.usecase

import com.kosciukw.services.data.user.model.api.response.AccessTokenApiModel
import com.kosciukw.services.data.user.repository.UserRepository
import com.kosciukw.services.data.user.model.domain.PairByPasswordDomainModel

import kotlinx.coroutines.flow.*
import pl.kosciukw.petsify.shared.usecase.UseCase
import pl.kosciukw.petsify.shared.result.ResultOrFailure
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val userRepository: UserRepository
) : UseCase<ResultOrFailure<AccessTokenApiModel, Throwable>, LoginUseCase.Params>() {

    data class Params(
        val email: String,
        val password: String
    )

    override fun action(params: Params) = flow {
        // Emit the Loading state initially
        emit(ResultOrFailure.Loading)

        // Prepare the request for the userRepository
        val request = PairByPasswordDomainModel(
            email = params.email,
            password = params.password
        )

        // Use runCatching to safely call the suspending function and handle exceptions
        runCatching {
            // This is where the suspending function is called
            userRepository.pairDeviceByPassword(request)
        }.onSuccess { result ->
            // On success, emit the result as Success
            emit(ResultOrFailure.Success(result))
        }.onFailure { error ->
            // On failure, emit the error as Failure
            emit(ResultOrFailure.Failure(error))
        }
    }
}