package cn.carveknife.carveknifewanandroid.view.splash

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import cn.carveknife.carveknifewanandroid.R
import cn.carveknife.carveknifewanandroid.base.BaseActivity
import cn.carveknife.carveknifewanandroid.databinding.ActivitySplashBinding
import cn.carveknife.carveknifewanandroid.module.Router
import io.reactivex.Observable

class SplashActivity : BaseActivity<ActivitySplashBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView();
        initReback();
    }

    private fun initReback() {
        if (!isTaskRoot()) {
            if (intent.hasCategory(Intent.CATEGORY_LAUNCHER)
                && TextUtils.equals(intent.action, Intent.ACTION_MAIN)
            ) {
                finish()
                return
            }
        }
    }

    override fun initViewBinding() {
        mViewBinding = ActivitySplashBinding.inflate(LayoutInflater.from(this))
    }

    private fun initView() {
        val ivLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_up_to_down)
        ivLoadAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                mViewBinding.ivIcon.clearAnimation()
            }

            override fun onAnimationStart(animation: Animation?) {
            }

        })
        mViewBinding.ivIcon.startAnimation(ivLoadAnimation)

        val tvLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_down_to_up)
        tvLoadAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                mViewBinding.tvCarveKnife.clearAnimation()
                Router.routeToMain(getContext())
                finish()
            }

            override fun onAnimationStart(animation: Animation?) {
            }

        })
        mViewBinding.tvCarveKnife.startAnimation(tvLoadAnimation)
    }
}