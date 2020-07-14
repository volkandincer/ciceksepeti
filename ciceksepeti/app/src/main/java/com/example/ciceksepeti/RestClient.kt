package com.example.ciceksepeti

import android.os.Build
import com.boyner.morhipomarketsdk.network.TLSSocketFactory
import com.example.ciceksepeti.response.ApiError
import com.example.ciceksepeti.response.ApiResult
import com.example.ciceksepeti.service.ProductListService
import okhttp3.OkHttpClient
import okhttp3.TlsVersion
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.net.ssl.SSLContext

internal object RestClient {

    private var BASE_URL: String = "https://api.ciceksepeti.com/v1/"

    private var retrofitBFF: Retrofit? = null

    lateinit var productListService: ProductListService
        private set

    private val httpClientBuilder = OkHttpClient.Builder().enableTls12()


    fun initialize() {

        productListService = getClient().create(ProductListService::class.java)

    }

    private fun getClient(): Retrofit {
        if (retrofitBFF == null)
            retrofitBFF =
                Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                    GsonConverterFactory.create())
                    .client(httpClientBuilder.build()).build()


        return retrofitBFF as Retrofit
    }


    private fun OkHttpClient.Builder.enableTls12() = apply {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP_MR1) {
            try {
                val sslContext = SSLContext.getInstance(TlsVersion.TLS_1_2.javaName)
                sslContext.init(null, arrayOf(TLSSocketFactory.trustManager), null)

                sslSocketFactory(TLSSocketFactory(), TLSSocketFactory.trustManager)
            } catch (ignored: Exception) {
            }
        }

    }

    @Suppress("UNCHECKED_CAST")
    fun <A> getResult(call: Call<A>, callback: (ApiResult<A>) -> Unit) {
        call.enqueue(object : Callback<A> {
            override fun onFailure(call: Call<A>, t: Throwable) {

                callback(
                    ApiResult(
                        null,
                        if (t is ApiError) t.error else null
                    )
                )
            }

            override fun onResponse(call: Call<A>, response: Response<A>) {
                when (response.code()) {
                    200 -> callback(
                        ApiResult(
                            response.body() as A,
                            null
                        )
                    )
                    else -> callback(
                        ApiResult(
                            null,
                            null
                        )
                    )
                }
            }
        })
    }
}