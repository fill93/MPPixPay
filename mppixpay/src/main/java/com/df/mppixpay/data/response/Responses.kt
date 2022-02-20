package com.df.mppixpay.responses

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CreatePayResponse(
    @Json(name = "id")
    val id: String,
    /*@Json(name = "date_created")
    val dateCreated: String,
    @Json(name = "date_approved")
    val dateApproved: String,
    @Json(name = "date_of_expiration")
    val dateOfExpiration: String,
    @Json(name = "payment_method_id")
    val paymentMethodId: String,
    @Json(name = "payment_type_id")
    val paymentTypeId: String,*/
    @Json(name = "status")
    val status: String,
    @Json(name = "point_of_interaction")
    val pointOfInteraction: PointOfInteraction
): Parcelable

@Parcelize
data class PointOfInteraction(
    @Json(name = "transaction_data")
    val transactioDataPayResponse: TransactioDataPayResponse
): Parcelable

@Parcelize
data class TransactioDataPayResponse(
    @Json(name = "qr_code")
    val qrCode: String,
    @Json(name = "qr_code_base64")
    val qrCodeBase64: String
): Parcelable

@Parcelize
data class VerifyPayResponse(
    @Json(name = "status")
    val status: String,
    @Json(name = "status_detail")
    val statusDetail: String
): Parcelable