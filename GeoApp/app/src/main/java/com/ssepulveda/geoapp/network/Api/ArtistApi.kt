package com.ssepulveda.geoapp.network.Api

import com.ssepulveda.geoapp.network.models.BaseOpartIsts
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ArtistApi {
    /**
     * Get the list of the pots from the API
     */
    @GET("?method=geo.gettopartists&country=spain")
    fun getPosts(@Query("api_key") api_key: String, @Query("format") format: String): Observable<BaseOpartIsts>
}