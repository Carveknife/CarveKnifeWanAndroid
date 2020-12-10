package cn.carveknife.carveknifewanandroid.http


/**
 * Author: cuibg
 */
data class HttpResponse<T>(
    var data: T?,
    var errorCode: Int,
    var errorMsg: String?
)
