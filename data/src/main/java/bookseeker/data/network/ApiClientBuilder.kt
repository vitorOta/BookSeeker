package bookseeker.data.network

import bookseeker.data.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.ConnectionSpec
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object ApiClientBuilder {
    private val baseClient = OkHttpClient()
    private val defaultUrl = "https://itunes.apple.com/"
    private val gsonDefault = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create()

    inline fun <reified S> createServiceApi(
        baseUrl: String = defaultUrl,
        gson: Gson = gsonDefault,
        vararg interceptors: Interceptor
    ): S {
        val builder = baseClient.newBuilder()

        //Http logging
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingInterceptor)
        }

        interceptors.forEach { builder.addInterceptor(it) }
        //endregion

        val client = builder
            .connectionSpecs(listOf(ConnectionSpec.COMPATIBLE_TLS))
            .build()

        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(S::class.java)
    }
}