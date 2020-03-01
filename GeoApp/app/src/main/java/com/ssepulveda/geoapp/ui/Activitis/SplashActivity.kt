package com.ssepulveda.geoapp.ui.Activitis

import android.animation.Animator
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.databinding.DataBindingUtil
import com.ssepulveda.geoapp.R
import com.ssepulveda.geoapp.base.BaseActivity
import com.ssepulveda.geoapp.databinding.ActivitySplashBinding


const val TIMER_END = 1000

class SplashActivity : BaseActivity(), Animator.AnimatorListener {

    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        addListenerView()
    }

    private fun addListenerView() {
        binding.animationView.addAnimatorListener(this)
        binding.animationView.repeatCount = 1
    }

    private fun endSplash(){
        Handler().postDelayed({
            onStartActivity(MainActivity::class.java, true)
        }, TIMER_END.toLong())
    }

    /**
     * Lottie Listener
     */

    override fun onAnimationRepeat(p0: Animator?) {
    }

    override fun onAnimationEnd(p0: Animator?) {
        binding.animationView.cancelAnimation()
        binding.nameDev.visibility = View.VISIBLE
        endSplash()
    }

    override fun onAnimationCancel(p0: Animator?) {
    }

    override fun onAnimationStart(p0: Animator?) {

    }

}