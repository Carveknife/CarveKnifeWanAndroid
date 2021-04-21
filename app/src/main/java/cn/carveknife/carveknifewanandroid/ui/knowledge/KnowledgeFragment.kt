package cn.carveknife.carveknifewanandroid.ui.knowledge

import android.view.LayoutInflater
import cn.carveknife.carveknifewanandroid.base.LazyBaseFragment
import cn.carveknife.carveknifewanandroid.databinding.FragmentHomeBinding
import cn.carveknife.carveknifewanandroid.databinding.FragmentKnowledgeBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * description :
 * created time: 2020/11/23 17:36
 * created by: cuibenguang
 */
@AndroidEntryPoint
class KnowledgeFragment:LazyBaseFragment<FragmentKnowledgeBinding>() {
    override fun initView() {
        mViewBinding = FragmentKnowledgeBinding.inflate(LayoutInflater.from(activity))
    }

    override fun lazyInit() {

    }
}