package com.ssepulveda.geoapp.viewModels

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.ssepulveda.geoapp.base.BaseViewModel
import com.ssepulveda.geoapp.network.Api.ArtistApi
import com.ssepulveda.geoapp.network.models.Artist
import com.ssepulveda.geoapp.ui.adapters.ArtistListAdapter
import com.ssepulveda.geoapp.utils.API_KEY
import com.ssepulveda.geoapp.utils.JSON
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ArtistListViewModel : BaseViewModel() {

    val errorMessage: MutableLiveData<String> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadPosts() }
    val postListAdapter: ArtistListAdapter = ArtistListAdapter()

    @Inject
    lateinit var postApi: ArtistApi

    init {
        loadPosts()
    }

    private fun loadPosts() {
        subscription = postApi.getPosts(API_KEY, JSON)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePostListStart() }
            .doOnTerminate { onRetrievePostListFinish() }
            .filter { !it.topartists.artist.isNullOrEmpty() }
            .subscribe(
                { result -> onRetrievePostListSuccess(result.topartists.artist) },
                { onRetrievePostListError(it) }
            )
    }

    private fun onRetrievePostListStart() {
        showLoading()
        errorMessage.value = null
    }

    private fun onRetrievePostListFinish() {
        hideLoading()
    }

    private fun onRetrievePostListSuccess(artist: List<Artist>?) {
        artist?.let {
            postListAdapter.updatePostList(it)
            postListAdapter.notifyDataSetChanged()
        }
    }

    private fun onRetrievePostListError(it: Throwable) {
        errorMessage.value = it.message ?: "Error"
    }
}