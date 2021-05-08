package cn.carveknife.carveknifewanandroid.ui.home

import cn.carveknife.carveknifewanandroid.data.CraveKnifeNetRequestException

/**
 * description :
 * created time: 2021/5/8 16:41
 * created by: cuibenguang
 */
interface NetResponseCallback<T> {
    fun loadSuccess(t: T?)
    fun loadError(craveKnifeNetRequestException: CraveKnifeNetRequestException)
}