package cn.carveknife.carveknifewanandroid.ui.home

import cn.carveknife.carveknifewanandroid.data.entity.HomeEntity
import cn.carveknife.carveknifewanandroid.http.HttpManager
import cn.carveknife.carveknifewanandroid.http.asyncSubscribe

/**
 * description :
 * created time: 2020/12/10 11:50
 * created by: cuibenguang
 */
class HomeDataRepository constructor(private val httpManager: HttpManager) : HomeRepository {
    override fun getArticleData(pageSize: Int) {
        httpManager.wanApi.getArticles(pageSize)
            .asyncSubscribe({
                val data: Article? = it.data
                val data1 = data?.data
                it.errorCode
                it.errorMsg
            }, {

            })
    }

}