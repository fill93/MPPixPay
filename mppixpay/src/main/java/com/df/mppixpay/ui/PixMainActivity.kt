package com.df.mppixpay.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.df.mppixpay.R
import com.df.mppixpay.session.MPPixSession
import org.koin.androidx.viewmodel.ext.android.viewModel

class PixMainActivity : AppCompatActivity() {

    private val viewModel: PixMainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pix_main)

        setObservers()

        if (intent.hasExtra("KEY")) {
            if (intent.getStringExtra("KEY") == "CREATE_PAY") {
                viewModel.postCreatePixPay(MPPixSession.mpItem)
            } else {
                viewModel.verifyPixPay(MPPixSession.idPayment)
            }
        }
    }

    private fun setObservers() {
        viewModel.successCreatePayMLD.observe(this) {
            MPPixSession.mpPixCallback.createPayCallback(it)
            finish()
        }
        viewModel.successVerifyPayMLD.observe(this) {
            MPPixSession.mpPixCallback.verifyPayCallback(it)
            finish()
        }
        viewModel.errorMLD.observe(this) {
            MPPixSession.mpPixCallback.errorPayCallback(it.message.toString())
            finish()
        }
    }
}