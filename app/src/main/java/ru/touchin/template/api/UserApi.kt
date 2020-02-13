package ru.touchin.template.api

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("user/session/create")
    fun getSession(@Body body: Body): Single<String>

}
