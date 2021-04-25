package cn.carveknife.carveknifewanandroid.ui.home

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


/**
 * description :
 * created time: 2021/3/3 10:16
 * created by: cuibenguang
 */
@JsonClass(generateAdapter = true)
data class Article(
    @Json(name = "curPage")
    val curPage: Int? = 0,
    @Json(name = "datas")
    val datas: List<Data>? = listOf(),
    @Json(name = "offset")
    val offset: Int? = 0,
    @Json(name = "over")
    val over: Boolean? = false,
    @Json(name = "pageCount")
    val pageCount: Int? = 0,
    @Json(name = "size")
    val size: Int? = 0,
    @Json(name = "total")
    val total: Int? = 0
)

@JsonClass(generateAdapter = true)
data class Data(
    @Json(name = "apkLink")
    val apkLink: String? = "",
    @Json(name = "audit")
    val audit: Int? = 0,
    @Json(name = "author")
    val author: String? = "",
    @Json(name = "canEdit")
    val canEdit: Boolean? = false,
    @Json(name = "chapterId")
    val chapterId: Int? = 0,
    @Json(name = "chapterName")
    val chapterName: String? = "",
    @Json(name = "collect")
    val collect: Boolean? = false,
    @Json(name = "courseId")
    val courseId: Int? = 0,
    @Json(name = "desc")
    val desc: String? = "",
    @Json(name = "descMd")
    val descMd: String? = "",
    @Json(name = "envelopePic")
    val envelopePic: String? = "",
    @Json(name = "fresh")
    val fresh: Boolean? = false,
    @Json(name = "host")
    val host: String? = "",
    @Json(name = "id")
    val id: Int? = 0,
    @Json(name = "link")
    val link: String? = "",
    @Json(name = "niceDate")
    val niceDate: String? = "",
    @Json(name = "niceShareDate")
    val niceShareDate: String? = "",
    @Json(name = "origin")
    val origin: String? = "",
    @Json(name = "prefix")
    val prefix: String? = "",
    @Json(name = "projectLink")
    val projectLink: String? = "",
    @Json(name = "publishTime")
    val publishTime: Long? = 0,
    @Json(name = "realSuperChapterId")
    val realSuperChapterId: Int? = 0,
    @Json(name = "selfVisible")
    val selfVisible: Int? = 0,
    @Json(name = "shareDate")
    val shareDate: Long? = 0,
    @Json(name = "shareUser")
    val shareUser: String? = "",
    @Json(name = "superChapterId")
    val superChapterId: Int? = 0,
    @Json(name = "superChapterName")
    val superChapterName: String? = "",
    @Json(name = "tags")
    val tags: List<Tag>? = listOf(),
    @Json(name = "title")
    val title: String? = "",
    @Json(name = "type")
    val type: Int? = 0,
    @Json(name = "userId")
    val userId: Int? = 0,
    @Json(name = "visible")
    val visible: Int? = 0,
    @Json(name = "zan")
    val zan: Int? = 0
)

@JsonClass(generateAdapter = true)
data class Tag(
    @Json(name = "name")
    val name: String? = "",
    @Json(name = "url")
    val url: String? = ""
)