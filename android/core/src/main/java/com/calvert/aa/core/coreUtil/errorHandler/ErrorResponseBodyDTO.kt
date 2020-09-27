package com.calvert.aa.core.coreUtil.errorHandler

data class ErrorResponseBodyDTO(
    val errorCode: String? = null,
    val errorTitle: String? = null,
    val errorMessage: String? = null,
    val errorHttpCode: String? = null
)