package ru.touchin.mvitest.network.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import ru.touchin.mvitest.network.interceptor.ExceptionsInterceptor
import ru.touchin.template.core_network.BuildConfig
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        private const val TIMEOUT = 30L
    }

    @Singleton
    @Provides
    fun providePublicClient(exceptionsInterceptor: ExceptionsInterceptor): OkHttpClient =
            buildPublicClient(exceptionsInterceptor)

    @Singleton
    @Provides
    fun provideMoshi() = buildMoshi()

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient, moshi: Moshi) = buildRetrofitInstance(client, moshi)

    private fun buildMoshi() = Moshi.Builder()
            .build()

    private fun buildRetrofitInstance(client: OkHttpClient, moshi: Moshi): Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    private fun buildPublicClient(exceptionsInterceptor: ExceptionsInterceptor): OkHttpClient = OkHttpClient.Builder()
            .apply {
                connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                readTimeout(TIMEOUT, TimeUnit.SECONDS)
                writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                addInterceptor(exceptionsInterceptor)
                if (BuildConfig.DEBUG) {
                    addNetworkInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
                }
            }.build()

}
