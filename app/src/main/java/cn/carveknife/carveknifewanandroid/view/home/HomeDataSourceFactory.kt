package cn.carveknife.carveknifewanandroid.view.home

import cn.carveknife.carveknifewanandroid.data.entity.HomeEntity
import cn.carveknife.carveknifewanandroid.http.HttpManager
import cn.carveknife.carveknifewanandroid.http.datastore.DataSource
import cn.carveknife.carveknifewanandroid.http.datastore.DataSourceFactory

/**
 * description :
 * created time: 2020/12/11 16:26
 * created by: cuibenguang
 */
class HomeDataSourceFactory constructor(private val httpManager: HttpManager) :
    DataSourceFactory<HomeEntity> {
    override fun createDatasouce(): DataSource<HomeEntity> {
        return HomeDataSource(httpManager)
    }

}