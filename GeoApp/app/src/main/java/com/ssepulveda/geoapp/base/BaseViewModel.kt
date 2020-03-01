package com.ssepulveda.geoapp.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ssepulveda.geoapp.injection.DaggerViewModelInjector
import com.ssepulveda.geoapp.injection.ViewModelInjector
import com.ssepulveda.geoapp.network.module.NetworkModule
import com.ssepulveda.geoapp.viewModels.ArtistListViewModel
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel(){

    lateinit var subscription: Disposable

    val loadingVisibility: MutableLiveData<Boolean> = MutableLiveData()

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is ArtistListViewModel -> injector.inject(this)
        }
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    fun showLoading(){
        loadingVisibility.postValue(true)
    }

    fun hideLoading(){
        loadingVisibility.postValue(false)
    }
}