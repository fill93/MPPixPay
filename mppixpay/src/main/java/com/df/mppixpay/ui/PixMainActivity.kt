package com.df.mppixpay.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.df.mppixpay.R
import com.df.mppixpay.session.MPPixSession

class PixMainActivity : AppCompatActivity() {

    private lateinit var viewModel: PixMainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pix_main)

        viewModel = ViewModelProvider(this)[PixMainViewModel::class.java]

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