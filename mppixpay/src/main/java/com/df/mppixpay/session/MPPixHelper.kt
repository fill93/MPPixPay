package com.df.mppixpay.session

import android.app.Activity
import android.content.Intent
import com.df.mppixpay.ui.PixMainActivity
import com.df.mppixpay.data.model.MPItem
import com.df.mppixpay.responses.CreatePayResponse
import com.df.mppixpay.responses.VerifyPayResponse

class MPPixHelper {

    fun initMPPix (
        activity: Activity,
        tokenMP: String,
        mpItem: MPItem,
        genratePayCallback: (response: CreatePayResponse) -> Unit,
        verifyPayCallback: (response: VerifyPayResponse) -> Unit,
        errorPay: (error: String) -> Unit
    ) {
        MPPixSession.tokenMP = tokenMP
        MPPixSession.mpItem = mpItem
        MPPixSession.genratePayCallback = genratePayCallback
        MPPixSession.verifyPayCallback = verifyPayCallback
        MPPixSession.errorPay = errorPay

        activity.startActivity(Intent(activity, PixMainActivity::class.java))
    }

    fun verifyMPPixPay (activity: Activity, idPayment: String) {
        MPPixSession.idPayment = idPayment
        activity.startActivity(Intent(activity, PixMainActivity::class.java))
    }

}