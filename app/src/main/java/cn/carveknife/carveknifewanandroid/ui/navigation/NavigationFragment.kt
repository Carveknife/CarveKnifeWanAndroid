package cn.carveknife.carveknifewanandroid.ui.navigation

import android.view.LayoutInflater
import cn.carveknife.carveknifewanandroid.base.LazyBaseFragment
import cn.carveknife.carveknifewanandroid.databinding.ActivityMainBinding
import cn.carveknife.carveknifewanandroid.databinding.FragmentNavigationBinding

/**
 * description :
 * created time: 2020/11/23 17:36
 * created by: cuibenguang
 */
class NavigationFragment:LazyBaseFragment<FragmentNavigationBinding>() {
    override fun lazyInit() {
    }

    override fun initView() {
        mViewBinding = FragmentNavigationBinding.inflate(LayoutInflater.from(activity))
    }
}