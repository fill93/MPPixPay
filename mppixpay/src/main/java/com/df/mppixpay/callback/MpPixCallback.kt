package com.df.mppixpay.callback

import com.df.mppixpay.responses.CreatePayResponse
import com.df.mppixpay.responses.VerifyPayResponse

interface MpPixCallback {
    /*
    genratePayCallback: (response: CreatePayResponse) -> Unit,
    verifyPayCallback: (response: VerifyPayResponse) -> Unit,
    errorPay: (error: String) -> Unit
    */

    fun createPayCallback(response: CreatePayResponse)

    fun verifyPayCallback(response: VerifyPayResponse)

    fun errorPayCallback(response: String)
}