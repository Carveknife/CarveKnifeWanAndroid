package cn.carveknife.carveknifewanandroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import cn.carveknife.carveknifewanandroid.base.BaseActivity
import cn.carveknife.carveknifewanandroid.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    companion object {
        public fun getCallingIntent(context: Context):Intent {
            return Intent(context,MainActivity::class.java)
        }
    }

    override fun initViewBinding() {
        mViewBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
    }
}