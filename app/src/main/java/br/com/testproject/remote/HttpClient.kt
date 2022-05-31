package br.com.testproject.remote

import br.com.testproject.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit


class HttpClient {
    private lateinit var okHttpClient: OkHttpClient
    private companion object {
        private const val CACHE_OF_10_MB: Long = 10 * 1024 * 1024
    }

    fun <T> create(
        restApiClass: Class<T>,
        baseUrl: String? = null,
    ): T {

        var okHttp = createOkHttp()

        return Retrofit.Builder()
            .baseUrl(baseUrl ?: "https://the-one-api.dev/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp)
            .build()
            .create(restApiClass)
    }


    private fun createOkHttp(
        timeOut: Long = 10L,
    ): OkHttpClient {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val okHttpBuilder = OkHttpClient.Builder()
            .connectTimeout(timeOut, TimeUnit.SECONDS)
            .readTimeout(timeOut, TimeUnit.SECONDS)
            .writeTimeout(timeOut, TimeUnit.SECONDS)
            .addInterceptor(object : Interceptor {
                @Throws(IOException::class)
                override fun intercept(chain: Interceptor.Chain): Response {
                    val request: Request = chain.request().newBuilder().addHeader("Authorization", BuildConfig.API_KEY).build()
                    return chain.proceed(request)
                }
            })
            .addInterceptor(logging)

        okHttpClient = okHttpBuilder.build()

        return okHttpClient
    }

}