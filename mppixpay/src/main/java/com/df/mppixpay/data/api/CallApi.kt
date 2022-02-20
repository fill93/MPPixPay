package com.df.mppixpay.data.api

import com.df.mppixpay.data.model.MPItem
import com.df.mppixpay.responses.CreatePayResponse
import com.df.mppixpay.responses.VerifyPayResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface CallApi {

    @POST("v1/payments")
    fun postCreatePayID(
        @Header("Content-Type")             headerContentType: String = "application/json",
        @Header("Accept")                   headerAccept: String = "application/json",
        @Header("Authorization")            headerAuthorization: String,
        @Body                               body: MPItem
    ) : Deferred<CreatePayResponse>

    @GET("v1/payments/{idPay}")
    fun getVerifyPixPayByID(
        @Header("Content-Type")             headerContentType: String = "application/json",
        @Header("Accept")                   headerAccept: String = "application/json",
        @Header("Authorization")            headerAuthorization: String,
        @Path("idPay")                      idPayment: String
    ) : Deferred<VerifyPayResponse>

}