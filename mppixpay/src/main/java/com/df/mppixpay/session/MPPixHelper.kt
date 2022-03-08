package com.df.mppixpay.session

import android.app.Activity
import android.content.Intent
import com.df.mppixpay.callback.MpPixCallback
import com.df.mppixpay.ui.PixMainActivity
import com.df.mppixpay.data.model.MPItem
import com.df.mppixpay.responses.CreatePayResponse
import com.df.mppixpay.responses.VerifyPayResponse

class MPPixHelper {

    fun initMPPix (tokenMP: String, mpItem: MPItem, mpPixCallback: MpPixCallback) {
        MPPixSession.tokenMP = tokenMP
        MPPixSession.mpItem = mpItem
        MPPixSession.mpPixCallback = mpPixCallback
    }

    fun createMPPixPay(activity: Activity) {
        activity.startActivity(Intent(activity, PixMainActivity::class.java).apply {
            putExtra("KEY","CREATE_PAY")
        })
    }

    fun verifyMPPixPay (activity: Activity, idPayment: String) {
        MPPixSession.idPayment = idPayment
        activity.startActivity(Intent(activity, PixMainActivity::class.java).apply {
            putExtra("KEY","VERIFY_PAY")
        })
    }

}