package cn.carveknife.carveknifewanandroid.http

import android.provider.MediaStore
import cn.carveknife.carveknifewanandroid.data.entity.HomeEntity
import cn.carveknife.carveknifewanandroid.ui.home.Article
import cn.carveknife.carveknifewanandroid.ui.wechat.Chapter
import io.reactivex.Observable
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
    fun getArticles(@Path("pageNo") pageNo: Int): Observable<HttpResponse<Article>>

    /**
     * 公众号列表
     */
    @GET("wxarticle/chapters/json")
    fun getWXChapters(): Observable<HttpResponse<List<Chapter>>>
}