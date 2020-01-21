package com.vitorota.bookseeker.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bookseeker.data.network.HttpException
import bookseeker.data.network.exceptions.NetworkException
import com.vitorota.bookseeker.R
import com.vitorota.bookseeker.util.SingleLiveEvent
import com.vitorota.bookseeker.util.ViewModelString
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

open class BaseViewModel : ViewModel() {
    val showLoading by lazy { SingleLiveEvent<Void>() }
    val hideLoading by lazy { SingleLiveEvent<Void>() }
    val showError by lazy { SingleLiveEvent<ViewModelString>() }

    protected fun doAsyncWork(
        shouldShowLoading: Boolean = true,
        exceptionHandler: (Exception) -> Unit = ::handleException,
        work: suspend () -> Unit
    ) {
        viewModelScope.launch {
            doWork(shouldShowLoading, exceptionHandler, work)
        }
    }

    protected suspend fun <T> doAsyncWorkWithReturn(
        shouldShowLoading: Boolean = true,
        exceptionHandler: (Exception) -> Unit = ::handleException,
        work: suspend () -> T
    ): T? {
        return withContext(viewModelScope.coroutineContext) {
            doWork(shouldShowLoading, exceptionHandler, work)
        }
    }

    private suspend fun <T> doWork(
        shouldShowLoading: Boolean = true,
        exceptionHandler: (Exception) -> Unit,
        work: suspend () -> T
    ): T? {
        return try {
            if (shouldShowLoading) {
                showLoading.call()
            }
            work()
        } catch (e: Exception) {
            Timber.e(e)
            exceptionHandler(e)
            null
        } finally {
            if (shouldShowLoading) {
                hideLoading.call()
            }
        }
    }

    private fun handleException(e: Exception) {
        val errorMessage = when (e) {
            is NetworkException -> ViewModelString(R.string.error_network)
            is HttpException -> e.message?.let {
                if (it.isNotBlank()) ViewModelString(
                    it
                ) else null
            } ?: ViewModelString(R.string.error_http)
            else -> ViewModelString(R.string.error_default)
        }
        showError.call(errorMessage)
    }
}