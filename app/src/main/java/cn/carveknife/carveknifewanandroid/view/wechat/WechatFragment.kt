package cn.carveknife.carveknifewanandroid.view.wechat

import android.view.LayoutInflater
import cn.carveknife.carveknifewanandroid.base.LazyBaseFragment
import cn.carveknife.carveknifewanandroid.databinding.FragmentWechatBinding

/**
 * description :
 * created time: 2020/11/23 17:36
 * created by: cuibenguang
 */
class WechatFragment:LazyBaseFragment<FragmentWechatBinding>() {
    override fun initView() {
        mViewBinding = FragmentWechatBinding.inflate(LayoutInflater.from(activity))
    }

    override fun lazyInit() {

    }
}