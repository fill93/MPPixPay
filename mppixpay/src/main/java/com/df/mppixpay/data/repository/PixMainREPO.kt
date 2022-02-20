package com.df.mppixpay.data.repository

import com.df.mppixpay.data.api.CallApi
import com.df.mppixpay.data.model.MPItem
import com.df.mppixpay.session.MPPixSession

class PixMainREPO(private val api: CallApi) : PixMainIMPL {

    override suspend fun postCreatePixPay(mpItem: MPItem) =
        api.postCreatePayID(
            headerAuthorization = "Bearer ${MPPixSession.tokenMP}",
            body = mpItem
        ).await()

    override suspend fun verifyPixPay(idPayment: String) =
        api.getVerifyPixPayByID(
            headerAuthorization = "Bearer ${MPPixSession.tokenMP}",
            idPayment = idPayment
        ).await()


}