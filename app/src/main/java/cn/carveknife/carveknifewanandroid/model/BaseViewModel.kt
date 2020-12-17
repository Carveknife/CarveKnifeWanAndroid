package cn.carveknife.carveknifewanandroid.model

import androidx.lifecycle.ViewModel
import cn.carveknife.carveknifewanandroid.http.respository.BaseRepository

/**
 * description :
 * created time: 2020/11/19 16:51
 * created by: cuibenguang
 */
open abstract class BaseViewModel<T> constructor(private val respository: BaseRepository<T>) :
    ViewModel() {
    abstract fun initLoad();
}