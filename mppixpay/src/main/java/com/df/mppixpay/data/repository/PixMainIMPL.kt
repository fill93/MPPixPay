package com.df.mppixpay.data.repository

import com.df.mppixpay.data.model.MPItem
import com.df.mppixpay.responses.CreatePayResponse
import com.df.mppixpay.responses.VerifyPayResponse

interface PixMainIMPL {
    suspend fun postCreatePixPay(mpItem: MPItem) : CreatePayResponse
    suspend fun verifyPixPay(idPayment: String) : VerifyPayResponse
}