package com.ssepulveda.geoapp.ui.Activitis

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.ssepulveda.geoapp.R
import com.ssepulveda.geoapp.base.BaseActivity
import com.ssepulveda.geoapp.databinding.ActivityMainBinding
import com.ssepulveda.geoapp.viewModels.ArtistListViewModel

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ArtistListViewModel

    private var errorSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)
        binding.postList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel = ViewModelProviders.of(this).get(ArtistListViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.errorMessage.observe(this, Observer { errorMessage -> if(errorMessage != null) showError(errorMessage) else hideError() })
        initView()
    }

    private fun initView(){
        binding.postList.adapter = viewModel.postListAdapter
    }

    private fun showError(message: String){
        errorSnackbar = Snackbar.make(binding.root, message, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError(){
        errorSnackbar?.dismiss()
    }

}
