package cn.carveknife.carveknifewanandroid.ui.home

import cn.carveknife.carveknifewanandroid.base.paging.BaseDataSourceFactory
import cn.carveknife.carveknifewanandroid.base.paging.BaseItemKeyedDataSource
import cn.carveknife.carveknifewanandroid.data.entity.HomeEntity
import cn.carveknife.carveknifewanandroid.http.HttpManager

/**
 * description :
 * created time: 2020/12/11 16:26
 * created by: cuibenguang
 */
class HomeDataSourceFactory constructor(private val httpManager: HttpManager) :
    BaseDataSourceFactory<HomeEntity>() {
    override fun createDataStore(): BaseItemKeyedDataSource<HomeEntity> {
        return HomeDataSource(httpManager)
    }
}