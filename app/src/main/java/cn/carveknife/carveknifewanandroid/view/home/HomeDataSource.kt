package cn.carveknife.carveknifewanandroid.view.home

import cn.carveknife.carveknifewanandroid.data.entity.HomeEntity
import cn.carveknife.carveknifewanandroid.http.HttpManager
import cn.carveknife.carveknifewanandroid.http.datastore.DataSource

/**
 * description :
 * created time: 2020/12/11 11:16
 * created by: cuibenguang
 */
class HomeDataSource constructor(private val httpManager: HttpManager) : DataSource<HomeEntity> {
    override fun requestDatas(): HomeEntity {
        return HomeEntity("")
    }

}