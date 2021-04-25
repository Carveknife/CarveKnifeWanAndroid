package cn.carveknife.carveknifewanandroid.http

import cn.carveknife.carveknifewanandroid.ui.home.Article
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * description :
 * created time: 2020/12/10 14:23
 * created by: cuibenguang
 */
interface WanApi {
    /**
     * 首页文章列表
     */
    @GET("article/list/{pageNo}/json")
    suspend fun getArticles(@Path("pageNo") pageNo: Int): HttPResponse<Article>

}