package cn.carveknife.carveknifewanandroid.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * description :
 * created time: 2021/5/8 16:07
 * created by: cuibenguang
 */
open class BaseViewModel : ViewModel() {
    protected val mCraveKnifeNetRequestException by lazy {
        MutableLiveData<CraveKnifeNetRequestException>()
    }
}