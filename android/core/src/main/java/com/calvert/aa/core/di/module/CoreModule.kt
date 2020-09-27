package com.calvert.aa.core.di.module

import com.calvert.aa.core.coreUtil.errorHandler.SbcErrorHandler
import com.calvert.aa.core.logger.SbcTimber
import com.calvert.aa.core.sharedComponent.alertDialog.AlertDialogDTO
import com.calvert.aa.core.sharedComponent.alertDialog.SbcAlertDialog
import com.squareup.moshi.Moshi
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

val coreModule = module {
    single(named("provideAppContext")) { androidContext() }

    single(named("provideMoshi")) { Moshi.Builder().build() }

    // 0 = private mode
    single(named("provideSharedPreferences")) {
        androidContext().getSharedPreferences("core_sp", 0)
    }

    factory(named("provideTimber")) { SbcTimber }

    factory(named("provideAlertDialog")) { (param: AlertDialogDTO) -> SbcAlertDialog(param) }

    factory(named("provideSbcErrorHandler")) { SbcErrorHandler() }
}