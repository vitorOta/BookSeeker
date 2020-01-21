package bookseeker.data.network

import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken

internal const val apiDateFormat = "yyyy-MM-dd'T'HH:mm:ss"
val gsonDefault = GsonBuilder()
    .setDateFormat(apiDateFormat)
    .create()

fun Any.toJson(): String {
    return gsonDefault.toJson(this)
}

@Throws(JsonSyntaxException::class)
inline fun <reified T> fromJson(json: String): T {
    return gsonDefault.fromJson(json, object : TypeToken<T>() {}.type)
}