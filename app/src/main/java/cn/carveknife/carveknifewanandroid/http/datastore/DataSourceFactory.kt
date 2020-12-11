package cn.carveknife.carveknifewanandroid.http.datastore

/**
 * description :
 * created time: 2020/12/11 11:09
 * created by: cuibenguang
 */
interface DataSourceFactory<T> {
    fun createDatasouce(): DataSource<T>
}