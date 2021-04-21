package cn.carveknife.carveknifewanandroid.ui.project

import android.view.LayoutInflater
import cn.carveknife.carveknifewanandroid.base.LazyBaseFragment
import cn.carveknife.carveknifewanandroid.databinding.FragmentProjectBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * description :
 * created time: 2020/11/23 17:36
 * created by: cuibenguang
 */
@AndroidEntryPoint
class ProjectFragment:LazyBaseFragment<FragmentProjectBinding>() {
    override fun initView() {
        mViewBinding = FragmentProjectBinding.inflate(LayoutInflater.from(activity))
    }

    override fun lazyInit() {
    }
}