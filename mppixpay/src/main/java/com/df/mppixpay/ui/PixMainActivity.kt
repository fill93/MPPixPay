package com.df.mppixpay.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.df.mppixpay.R
import com.df.mppixpay.session.MPPixSession
import kotlinx.android.synthetic.main.activity_pix_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PixMainActivity : AppCompatActivity() {

    private val viewModel: PixMainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pix_main)

        setObservers()

        if (MPPixSession.idPayment.isBlank() || MPPixSession.idPayment.isEmpty()) {
            postCreatePixPay()
        } else {
            verifyPixPay()
        }

    }

    private fun postCreatePixPay() {
        Log.i("JKK", ":::: A")
        viewModel.postCreatePixPay(MPPixSession.mpItem)
    }

    private fun verifyPixPay() {
        Log.i("JKK", ":::: B")
        viewModel.verifyPixPay(MPPixSession.idPayment)
    }

    private fun setObservers() {
        viewModel.successCreatePayMLD.observe(this) {
            MPPixSession.genratePayCallback(it)
            finish()
        }
        viewModel.successVerifyPayMLD.observe(this) {
            MPPixSession.verifyPayCallback(it)
            finish()
        }
        /*viewModel.loadingMLD.observe(this) {
            progressBar.visibility = it
        }*/
        viewModel.errorMLD.observe(this) {
            MPPixSession.errorPay(it.message.toString())
            finish()
        }
    }
}