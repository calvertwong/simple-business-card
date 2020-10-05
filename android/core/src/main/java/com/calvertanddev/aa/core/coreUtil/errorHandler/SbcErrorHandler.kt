package com.calvertanddev.aa.core.coreUtil.errorHandler

import android.content.DialogInterface
import com.calvertanddev.aa.core.sharedComponent.alertDialog.AlertDialogDTO
import com.calvertanddev.aa.core.sharedComponent.alertDialog.SbcAlertDialog
import com.squareup.moshi.Moshi
import okhttp3.ResponseBody
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named

class SbcErrorHandler : KoinComponent {

    private val moshi: Moshi by inject(named("provideMoshi"))

    fun displayErrorDialog(
        title: String?,
        message: String?,
        positiveButtonText: String? = null,
        positiveAction: DialogInterface.OnClickListener? = null,
        negativeButtonText: String? = null,
        negativeAction: DialogInterface.OnClickListener? = null,
        neutralButtonText: String? = null,
        neutralAction: DialogInterface.OnClickListener? = null
    ): SbcAlertDialog {
        val alertDialog: SbcAlertDialog by inject(named("provideAlertDialog")) {
            parametersOf(
                AlertDialogDTO(
                    title = title,
                    message = message,
                    positiveButtonText = positiveButtonText,
                    positiveAction = positiveAction,
                    negativeButtonText = negativeButtonText,
                    negativeAction = negativeAction,
                    neutralButtonText = neutralButtonText,
                    neutralAction = neutralAction
                )
            )
        }
        return alertDialog
    }

    fun displayNetworkErrorDialog(): SbcAlertDialog {
        val alertDialog: SbcAlertDialog by inject(named("provideAlertDialog")) {
            parametersOf(
                AlertDialogDTO(
                    title = "Network Error",
                    message = "Sorry, unable to fetch your data.",
                    positiveButtonText = "Close",
                    positiveAction = { dialog, _ ->
                        dialog.dismiss()
                    }
                )
            )
        }
        return alertDialog
    }

    fun displayErrorDialogFromResponseBody(responseBody: ResponseBody?): SbcAlertDialog {
        val parsedResponse = responseBody?.let { parseErrorResponseBody(it) }
        val alertDialog: SbcAlertDialog by inject(named("provideAlertDialog")) {
            parametersOf(
                AlertDialogDTO(
                    title = parsedResponse?.errorTitle,
                    message = parsedResponse?.errorMessage,
                    positiveButtonText = "Close",
                    positiveAction = { dialog, _ ->
                        dialog.dismiss()
                    }
                )
            )
        }
        return alertDialog
    }

    private fun parseErrorResponseBody(responseBody: ResponseBody): ErrorResponseBodyDTO? {
        return moshi.adapter(ErrorResponseBodyDTO::class.java).fromJson(responseBody.string())?.run {
            ErrorResponseBodyDTO(
                errorCode = errorCode,
                errorTitle = errorTitle,
                errorMessage = errorMessage,
                errorHttpCode = errorHttpCode
            )
        }
    }
}

