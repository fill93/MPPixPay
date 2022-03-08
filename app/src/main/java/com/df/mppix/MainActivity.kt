package com.df.mppix

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.df.mppixpay.callback.MpPixCallback
import com.df.mppixpay.data.model.MPItem
import com.df.mppixpay.data.model.MPPayer
import com.df.mppixpay.responses.CreatePayResponse
import com.df.mppixpay.responses.VerifyPayResponse
import com.df.mppixpay.session.MPPixHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MpPixCallback {

    private var pixCopiaCola = ""
    private var idPayment: String = ""
    private val mpPixHelper = MPPixHelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListenres()

        mpPixHelper.initMPPix (
            tokenMP = "APP_USR-5",
            mpItem = MPItem(
                0.12,
                "RIFA",
                "pix",
                MPPayer("filipepitel.fp@gmail.com", "FILIPE", "PIMENTEL")
            ),
            mpPixCallback = this
        )

        mpPixHelper.createMPPixPay(this)
    }

    private fun setListenres() {
        bt_pix_copia_cola.setOnClickListener {
            val clipboard: ClipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("",pixCopiaCola)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this,"Copiado!!!",Toast.LENGTH_LONG).show()
        }

        bt_pix_verify_pay.setOnClickListener {
            mpPixHelper.verifyMPPixPay (
                activity = this,
                idPayment = idPayment
            )
        }
    }

    override fun createPayCallback(response: CreatePayResponse) {
        val decodedString = Base64.decode(response.pointOfInteraction.transactioDataPayResponse.qrCodeBase64, Base64.DEFAULT)
        val decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
        qrcode_image.setImageBitmap(decodedByte)
        pixCopiaCola = response.pointOfInteraction.transactioDataPayResponse.qrCode
        idPayment = response.id
    }

    override fun verifyPayCallback(response: VerifyPayResponse) {
        Log.i("JKK", ":::: s ${response.status}")
    }

    override fun errorPayCallback(response: String) {
        Log.i("JKK", ":::: $response")
    }
}