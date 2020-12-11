package cn.carveknife.carveknifewanandroid.model

import androidx.lifecycle.Transformations
import cn.carveknife.carveknifewanandroid.data.entity.HomeEntity
import cn.carveknife.carveknifewanandroid.respository.HomeRepository

/**
 * description :
 * created time: 2020/12/10 11:49
 * created by: cuibenguang
 */
class HomeViewModel(respository: HomeRepository) : BaseViewModel<HomeEntity>(respository) {
    val result = respository.
}