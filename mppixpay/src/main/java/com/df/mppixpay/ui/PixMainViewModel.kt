package com.df.mppixpay.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.df.mppixpay.data.repository.PixMainIMPL
import com.df.mppixpay.data.model.MPItem
import com.df.mppixpay.responses.CreatePayResponse
import com.df.mppixpay.responses.VerifyPayResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class PixMainViewModel(private val repository: PixMainIMPL): ViewModel() {

    val successCreatePayMLD by lazy { MutableLiveData<CreatePayResponse>() }
    val successVerifyPayMLD by lazy { MutableLiveData<VerifyPayResponse>() }
    //val loadingMLD by lazy { MutableLiveData<Int>() }
    val errorMLD by lazy { MutableLiveData<Throwable>() }

    fun postCreatePixPay(mpItem: MPItem) = launchSilent{
        try {
            //loadingMLD.postValue(View.VISIBLE)
            successCreatePayMLD.postValue(repository.postCreatePixPay(mpItem))
        } catch (e: Exception) {
            errorMLD.postValue(e)
        } finally {
            //loadingMLD.postValue(View.GONE)
        }
    }

    fun verifyPixPay(idPayment: String) = launchSilent {
        try {
            //loadingMLD.postValue(View.VISIBLE)
            successVerifyPayMLD.postValue(repository.verifyPixPay(idPayment))
        } catch (e: Exception) {
            errorMLD.postValue(e)
        } finally {
            //loadingMLD.postValue(View.GONE)
        }
    }

    private fun launchSilent (
        context: CoroutineContext = Dispatchers.IO,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit
    ) {
        CoroutineScope(context).launch (context, start, block)
    }
}