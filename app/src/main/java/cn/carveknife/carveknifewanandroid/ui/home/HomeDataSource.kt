package cn.carveknife.carveknifewanandroid.ui.home

import cn.carveknife.carveknifewanandroid.base.paging.BaseItemKeyedDataSource
import cn.carveknife.carveknifewanandroid.data.entity.HomeEntity
import cn.carveknife.carveknifewanandroid.http.HttpManager

/**
 * description :
 * created time: 2020/12/11 11:16
 * created by: cuibenguang
 */
class HomeDataSource constructor(private val httpManager: HttpManager) :
    BaseItemKeyedDataSource<HomeEntity>() {
    override fun setKey(item: HomeEntity): Int {
        return item.id
    }

    override fun onLoadAfter(params: LoadParams<Int>, callback: LoadCallback<HomeEntity>) {
    }

    override fun onLoadIntial(params: LoadInitialParams<Int>, callback: LoadCallback<HomeEntity>) {
    }


}