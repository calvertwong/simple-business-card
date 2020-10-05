package com.calvertanddev.aa.login

import androidx.viewbinding.ViewBinding
import com.calvertanddev.aa.core.coreUi.SbcBaseFragment

abstract class LoginBaseFragment<BindingType : ViewBinding> : SbcBaseFragment() {

    private var _binding: BindingType? = null
    val binding: BindingType get() = _binding!!

    fun setBinding(bindingType: BindingType?) {
        _binding = bindingType
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}