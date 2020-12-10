package cn.carveknife.carveknifewanandroid.http.interceptor

import cn.carveknife.carveknifewanandroid.http.HttpConstant
import okhttp3.Interceptor
import okhttp3.Response


class CookieInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        val requestUrl = request.url().toString()
        val host = request.url().host()
        if ((requestUrl.contains(HttpConstant.SAVE_USER_LOGIN_KEY)
                    || requestUrl.contains(HttpConstant.SAVE_USER_REGISTER_KEY))
            && response.headers(HttpConstant.COOKIE_HEADER_RESPONSE).isNotEmpty()
        ) {
            val cookies = response.headers(HttpConstant.COOKIE_HEADER_RESPONSE)
            val cookie = HttpConstant.encodeCookie(cookies)
            HttpConstant.saveCookie(requestUrl, host, cookie)
        }
        return response
    }
}