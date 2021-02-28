package pt.andre.domain.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import pt.andre.domain.model.Result

abstract class FlowUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {
    operator fun invoke(parameters: P): Flow<Result<R>> {
        return execute(parameters)
            .map { Result.Success(it) }
            .catch { e -> Result.Error(Exception(e)) }
            .flowOn(coroutineDispatcher)
    }

    protected abstract fun execute(parameters: P): Flow<R>
}