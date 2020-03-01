package com.ssepulveda.geoapp.viewModels

import androidx.lifecycle.MutableLiveData
import com.ssepulveda.geoapp.base.BaseViewModel
import com.ssepulveda.geoapp.network.models.Artist

class PostViewModel: BaseViewModel() {
    private val postTitle = MutableLiveData<String>()
    private val postImg = MutableLiveData<String>()

    fun bind(article: Artist){
        postTitle.value = article.name
        postImg.value = article.image.firstOrNull()?.img ?: ""
    }

    fun getPostTitle():MutableLiveData<String>{
        return postTitle
    }

    fun getPostImg():MutableLiveData<String>{
        return postImg
    }
}