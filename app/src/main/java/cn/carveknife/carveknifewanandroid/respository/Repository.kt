package cn.carveknife.carveknifewanandroid.respository

import cn.carveknife.carveknifewanandroid.http.datastore.DataSourceFactory

/**
 * description :
 * created time: 2020/12/10 17:34
 * created by: cuibenguang
 */
interface Repository<T> {
    fun createDataStoreFactory(): DataSourceFactory<T>
}