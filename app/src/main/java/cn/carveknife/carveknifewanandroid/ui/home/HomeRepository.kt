package cn.carveknife.carveknifewanandroid.ui.home

import cn.carveknife.carveknifewanandroid.base.paging.BaseDataSourceFactory
import cn.carveknife.carveknifewanandroid.base.paging.BasePagingRepository
import cn.carveknife.carveknifewanandroid.data.entity.HomeEntity
import cn.carveknife.carveknifewanandroid.http.HttpManager

/**
 * description :
 * created time: 2020/12/10 11:50
 * created by: cuibenguang
 */
class HomeRepository constructor(private val httpManager: HttpManager) :
    BasePagingRepository<HomeEntity>() {
    override fun createDataBaseFactory(): BaseDataSourceFactory<HomeEntity> {
        return HomeDataSourceFactory(httpManager)
    }

}