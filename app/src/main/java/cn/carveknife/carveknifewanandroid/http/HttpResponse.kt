package cn.carveknife.carveknifewanandroid.http


/**
 * Author: Sbingo666
 * Date:   2019/4/4
 */
data class HttpResponse<T>(
    var data: T?,
    var errorCode: Int,
    var errorMsg: String?
)
