package cn.carveknife.carveknifewanandroid.http

import cn.carveknife.carveknifewanandroid.R
import com.blankj.utilcode.util.NetworkUtils
import com.blankj.utilcode.util.Utils
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

abstract class RxHttpObserver<T> : Observer<T> {

    override fun onSubscribe(d: Disposable) {
        if (!NetworkUtils.isConnected()) {
            onError(RuntimeException(Utils.getApp().getString(R.string.network_error)))
        }
    }

    override fun onError(e: Throwable) {

    }

    override fun onNext(it: T) {

    }

    override fun onComplete() {
    }
}
