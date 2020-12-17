package cn.carveknife.carveknifewanandroid.respository

import cn.carveknife.carveknifewanandroid.data.entity.HomeEntity
import cn.carveknife.carveknifewanandroid.http.HttpManager
import cn.carveknife.carveknifewanandroid.http.datastore.DataSourceFactory
import cn.carveknife.carveknifewanandroid.http.respository.BaseRepository
import cn.carveknife.carveknifewanandroid.view.home.HomeDataSourceFactory

/**
 * description :
 * created time: 2020/12/10 11:50
 * created by: cuibenguang
 */
class HomeRepository constructor(private val httpManager: HttpManager) :
    BaseRepository<HomeEntity>() {
    override fun createDataStoreFactory(): DataSourceFactory<HomeEntity> {
        return HomeDataSourceFactory(httpManager)
    }

    fun getDatas(): HomeEntity {
        return HomeEntity("")
    }
}