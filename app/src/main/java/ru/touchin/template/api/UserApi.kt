package ru.touchin.template.api

import com.touchin.template.api.BaseResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("user/session/create")
    fun getSession(@Body body: Body): Single<BaseResponse<String>>

}
