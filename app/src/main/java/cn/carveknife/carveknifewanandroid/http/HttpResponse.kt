package cn.carveknife.carveknifewanandroid.http

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


/**
 * Author: cuibg
 */
@JsonClass(generateAdapter = true)
data class HttPResponse<T>(
    @Json(name = "data")
    var data: T?,
    @Json(name = "errorCode")
    var errorCode: Int,
    @Json(name = "errorMsg")
    var errorMsg: String?
)
