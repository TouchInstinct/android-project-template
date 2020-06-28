package ru.touchin.template.network.models

import java.io.IOException

open class ServerException(val code: Int, message: String? = null) : IOException(message) {

    companion object {
        private val codeToErrorTypeMap = mapOf(
                1 to TemplateApiError.VALID_RESPONSE,
                2 to TemplateApiError.INVALID_PARAMETERS
        )

        fun getErrorTypeByCode(code: Int) = codeToErrorTypeMap[code]
    }

    fun getErrorType(): TemplateApiError? = codeToErrorTypeMap[code]

}
