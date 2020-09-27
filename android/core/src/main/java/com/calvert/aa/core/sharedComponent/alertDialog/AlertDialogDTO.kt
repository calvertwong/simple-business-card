package com.calvert.aa.core.sharedComponent.alertDialog

import android.content.DialogInterface

data class AlertDialogDTO(
    val title: String? = null,
    val message: String? = null,
    val positiveButtonText: String? = null,
    val positiveAction: DialogInterface.OnClickListener? = null,
    val negativeButtonText: String? = null,
    val negativeAction: DialogInterface.OnClickListener? = null,
    val neutralButtonText: String? = null,
    val neutralAction: DialogInterface.OnClickListener? = null
)