package com.df.mppixpay.session

import com.df.mppixpay.data.model.MPItem
import com.df.mppixpay.responses.CreatePayResponse
import com.df.mppixpay.responses.VerifyPayResponse

internal object MPPixSession {
    lateinit var tokenMP: String
    lateinit var mpItem: MPItem
    var idPayment: String = ""
    lateinit var genratePayCallback: (payResponse: CreatePayResponse) -> Unit
    lateinit var verifyPayCallback: (verifyPayResponse: VerifyPayResponse) -> Unit
    lateinit var errorPay: (error: String) -> Unit
}