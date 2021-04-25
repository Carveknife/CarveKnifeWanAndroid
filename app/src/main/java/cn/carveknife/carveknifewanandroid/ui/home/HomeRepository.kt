package cn.carveknife.carveknifewanandroid.ui.home

/**
 * description :
 * created time: 2021/3/3 10:20
 * created by: cuibenguang
 */
interface HomeRepository {
    suspend fun getArticleData(pageSize: Int): Article
}