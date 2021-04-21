package cn.carveknife.carveknifewanandroid.ui.wechat

import java.io.Serializable
import com.squareup.moshi.Json


/**
 * description :
 * created time: 2020/12/18 11:43
 * created by: cuibenguang
 */
data class Chapter(
    @Json(name = "data")
    val `data`: List<Data>? = listOf(),
    @Json(name = "errorCode")
    val errorCode: Int? = 0,
    @Json(name = "errorMsg")
    val errorMsg: String? = ""
)

data class Data(
    @Json(name = "children")
    val children: List<Any>? = listOf(),
    @Json(name = "courseId")
    val courseId: Int? = 0,
    @Json(name = "id")
    val id: Int? = 0,
    @Json(name = "name")
    val name: String? = "",
    @Json(name = "order")
    val order: Int? = 0,
    @Json(name = "parentChapterId")
    val parentChapterId: Int? = 0,
    @Json(name = "userControlSetTop")
    val userControlSetTop: Boolean? = false,
    @Json(name = "visible")
    val visible: Int? = 0
)