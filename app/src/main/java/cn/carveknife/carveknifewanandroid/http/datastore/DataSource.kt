package cn.carveknife.carveknifewanandroid.http.datastore

/**
 * description :
 * created time: 2020/12/10 17:41
 * created by: cuibenguang
 */
interface DataSource<T> {
    fun requestDatas():T
}