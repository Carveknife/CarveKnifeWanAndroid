package cn.carveknife.carveknifewanandroid.http

import cn.carveknife.carveknifewanandroid.BuildConfig
import cn.carveknife.carveknifewanandroid.http.interceptor.CacheInterceptor
import cn.carveknife.carveknifewanandroid.http.interceptor.CookieInterceptor
import cn.carveknife.carveknifewanandroid.http.interceptor.HeaderInterceptor
import cn.carveknife.carveknifewanandroid.http.interceptor.LoggingInterceptor
import com.blankj.utilcode.util.Utils
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

class HttpManager private constructor() {

    companion object {
        @Volatile
        private var instance: HttpManager? = null

        fun getInstance(): HttpManager {
            return instance ?: synchronized(this) {
                instance ?: HttpManager().also { instance = it }
            }
        }
    }

    internal val wanApi: WanApi by lazy {
        create(HttpConstant.BASE_URL, WanApi::class.java)
    }

    private fun <T> create(baseUrl: String, c: Class<T>): T {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(provideOKHttpClient())
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(c)
    }

    private class MyLog : LoggingInterceptor.Logger {
        override fun log(message: String) {
        }
    }

    private fun provideOKHttpClient(): OkHttpClient {
        val loggingInterceptor = LoggingInterceptor(MyLog())
        loggingInterceptor.level =
            if (BuildConfig.DEBUG) LoggingInterceptor.Level.BODY else LoggingInterceptor.Level.NONE
        val cache = Cache(
            File(Utils.getApp().cacheDir, HttpConstant.CACHE_FILE_NAME),
            HttpConstant.MAX_CACHE_SIZE
        )
        val builder = OkHttpClient.Builder()
            .connectTimeout(HttpConstant.NETWORK_TIME, TimeUnit.SECONDS)
            .readTimeout(HttpConstant.NETWORK_TIME, TimeUnit.SECONDS)
            .writeTimeout(HttpConstant.NETWORK_TIME, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(HeaderInterceptor())
            .addInterceptor(CacheInterceptor())
            .addInterceptor(CookieInterceptor())
            .addInterceptor(loggingInterceptor)
            .cache(cache)
        return builder.build()
    }
}
