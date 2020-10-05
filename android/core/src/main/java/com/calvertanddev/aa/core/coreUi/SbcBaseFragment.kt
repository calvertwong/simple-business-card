package com.calvertanddev.aa.core.coreUi

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.calvertanddev.aa.core.coreUtil.errorHandler.SbcErrorHandler
import com.calvertanddev.aa.core.logger.SbcTimber
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

abstract class SbcBaseFragment : Fragment() {
    val timber: SbcTimber = get(named("provideTimber"))

    val errorHandler: SbcErrorHandler by inject(named("provideSbcErrorHandler"))

    fun navigateTo(actionId: Int, bundle: Bundle?) {
        findNavController().navigate(actionId, bundle)
    }
}