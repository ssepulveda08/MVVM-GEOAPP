package com.ssepulveda.geoapp.injection

import com.ssepulveda.geoapp.network.module.NetworkModule
import com.ssepulveda.geoapp.viewModels.ArtistListViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    fun inject(postListViewModel: ArtistListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}
