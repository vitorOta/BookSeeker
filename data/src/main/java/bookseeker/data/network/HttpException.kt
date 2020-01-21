package bookseeker.data.network

import bookseeker.data.network.exceptions.NetworkException

class HttpException(
    val httpStatusCode: Int,
    message: String? = null,
    cause: Throwable? = null
) : NetworkException(message, cause)