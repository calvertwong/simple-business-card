package com.calvert.aa.core.coreUi

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.calvert.aa.core.coreUtil.errorHandler.SbcErrorHandler
import com.calvert.aa.core.logger.SbcTimber
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

abstract class SbcBaseFragment : Fragment() {
    val timber: SbcTimber = get(named("provideTimber"))

    val errorHandler: SbcErrorHandler by inject(named("provideSbcErrorHandler"))

    fun navigateTo(actionId: Int) {
        findNavController().navigate(actionId)
    }
}