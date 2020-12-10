package cn.carveknife.carveknifewanandroid.http

/**
 * description :
 * created time: 2020/12/10 14:23
 * created by: cuibenguang
 */
object HttpConstant {
    const val BASE_URL = "https://www.wanandroid.com/"
    const val NETWORK_TIME: Long = 60
    const val CACHE_FILE_NAME = "CraveKnifeWanAndroid"
    const val MAX_CACHE_SIZE: Long = 50

    const val SAVE_USER_LOGIN_KEY = "user/login"
    const val SAVE_USER_REGISTER_KEY = "user/register"

    val LOGIN_REQUIRED_URLS = arrayOf("lg/collect", "lg/uncollect", "lg/todo")

    const val COOKIE_HEADER_RESPONSE = "set-cookie"
    const val COOKIE_HEADER_REQUEST = "Cookie"

    fun encodeCookie(cookies: List<String>): String {
        val sb = StringBuilder()
        val set = HashSet<String>()
        cookies
            .map { cookie ->
                cookie.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            }
            .forEach {
                it.filterNot { set.contains(it) }.forEach { set.add(it) }
            }
        val ite = set.iterator()
        while (ite.hasNext()) {
            val cookie = ite.next()
            sb.append(cookie).append(";")
        }
        val last = sb.lastIndexOf(";")
        if (sb.length - 1 == last) {
            sb.deleteCharAt(last)
        }
        return sb.toString()
    }

    fun saveCookie(url: String?, host: String?, cookies: String) {
        url ?: return
        host ?: return
    }
}