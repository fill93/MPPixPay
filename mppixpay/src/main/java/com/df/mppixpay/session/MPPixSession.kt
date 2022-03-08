package com.df.mppixpay.session

import com.df.mppixpay.callback.MpPixCallback
import com.df.mppixpay.data.model.MPItem

internal object MPPixSession {
    lateinit var tokenMP: String
    lateinit var mpItem: MPItem
    var idPayment: String = ""
    lateinit var mpPixCallback: MpPixCallback
}