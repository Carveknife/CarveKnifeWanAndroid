package cn.carveknife.carveknifewanandroid.model

import androidx.lifecycle.ViewModel
import cn.carveknife.carveknifewanandroid.respository.BaseRepository

/**
 * description :
 * created time: 2020/11/19 16:51
 * created by: cuibenguang
 */
open class BaseViewModel<T>(respository: BaseRepository<T>) : ViewModel() {

}