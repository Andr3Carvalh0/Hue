package pt.andre.domain.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import pt.andre.domain.model.Result
import java.lang.RuntimeException

abstract class CoroutineUseCase<in P, out R>(private val coroutineDispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(params: P): Result<R> {
        return try {
            withContext(coroutineDispatcher) {
                Result.Success(execute(params))
            }
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(params: P): R
}
