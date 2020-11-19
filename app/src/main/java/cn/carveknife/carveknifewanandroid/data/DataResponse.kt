package cn.carveknife.carveknifewanandroid.data

import com.google.gson.annotations.SerializedName

/**
 * description :
 * created time: 2020/11/19 16:54
 * created by: cuibenguang
 */
data class DataResponse<T>(
    @SerializedName("data")
    val data: T?,
    @SerializedName("status")
    val status: Int,
    @SerializedName("error_code")
    val errorCode: String,
    @SerializedName("error")
    val error: String,
    @SerializedName("code")
    val code: String
) {
}