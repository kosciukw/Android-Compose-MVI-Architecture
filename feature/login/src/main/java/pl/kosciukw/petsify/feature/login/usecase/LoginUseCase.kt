package pl.kosciukw.petsify.feature.login.usecase

import com.kosciukw.services.user.repository.UserRepository
import com.kosciukw.services.user.model.LoginWithPasswordRequest
import com.kosciukw.services.user.model.UserDomainModel

import kotlinx.coroutines.flow.*
import pl.kosciukw.petsify.shared.usecase.UseCase
import pl.kosciukw.petsify.shared.result.ResultOrFailure
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val userRepository: UserRepository
) : UseCase<ResultOrFailure<UserDomainModel, Throwable>, LoginUseCase.Params>() {

    data class Params(
        val email: String,
        val password: String
    )

    override fun action(params: Params) = flow {
        emit(ResultOrFailure.Loading)
        runCatching {
            val request = LoginWithPasswordRequest(
                email = params.email,
                password = params.password
            )

            val result = userRepository.loginDeviceByPassword(request)
            emit(result)
        }.getOrElse { error ->
            emit(ResultOrFailure.Failure(error))
        }
    }
}