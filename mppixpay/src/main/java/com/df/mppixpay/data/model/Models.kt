package com.df.mppixpay.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MPItem (
    @Json(name = "transaction_amount")
    val transactionAmount: Double,
    @Json(name = "description")
    val description: String,
    @Json(name = "payment_method_id")
    val paymentMethodId: String = "pix",
    @Json(name = "payer")
    val payer: MPPayer
): Parcelable

@Parcelize
data class MPPayer (
    @Json(name = "email")
    val email: String,
    @Json(name = "first_name")
    val firtName: String,
    @Json(name = "last_name")
    val lastName: String
): Parcelable