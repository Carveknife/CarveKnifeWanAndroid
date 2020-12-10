package cn.carveknife.carveknifewanandroid.http

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * description :
 * created time: 2020/12/10 14:12
 * created by: cuibenguang
 */
fun <T> Observable<T>.async(): Observable<T> {
    return this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.asyncSubscribe(onNext: (T) -> Unit, onError: (Throwable) -> Unit) {
    this.async()
        .subscribe(object : RxHttpObserver<T>() {
            override fun onNext(it: T) {
                super.onNext(it)
                onNext(it)
            }

            override fun onError(e: Throwable) {
                super.onError(e)
                onError(e)
            }
        })
}