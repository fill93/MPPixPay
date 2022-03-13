package com.df.mppixpay.data.repository

import com.df.mppixpay.data.api.ApiService
import com.df.mppixpay.data.model.MPItem
import com.df.mppixpay.session.MPPixSession

class PixMainREPO : PixMainIMPL {

    override suspend fun postCreatePixPay(mpItem: MPItem) =
        ApiService.callApi.postCreatePayID(
            headerAuthorization = "Bearer ${MPPixSession.tokenMP}",
            body = mpItem
        ).await()

    override suspend fun verifyPixPay(idPayment: String) =
        ApiService.callApi.getVerifyPixPayByID(
            headerAuthorization = "Bearer ${MPPixSession.tokenMP}",
            idPayment = idPayment
        ).await()


}