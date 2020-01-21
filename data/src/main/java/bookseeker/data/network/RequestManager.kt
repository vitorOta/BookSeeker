package bookseeker.data.network

import bookseeker.data.network.exceptions.NetworkException
import retrofit2.Response
import java.io.IOException

internal object RequestManager {

    suspend fun <T> requestFromApi(request: suspend () -> Response<T>): T? {
        try {
            val response = request()
            if (response.isSuccessful) {
                return if (response.code() == 204)
                    null
                else
                    response.body()
            } else {
                val errorMessage = response.errorBody()?.string() ?: response.message()

                throw HttpException(response.code(), errorMessage)
            }
        } catch (e: Exception) {
            when (e) {
                is IOException -> throw NetworkException(cause = e)
                else -> throw e
            }
        }
    }
}