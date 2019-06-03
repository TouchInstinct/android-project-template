package ru.touchin.template.model

import com.bluelinelabs.logansquare.annotation.JsonEnum
import com.bluelinelabs.logansquare.annotation.JsonNumberValue

@JsonEnum
enum class TemplateApiError {

    @JsonNumberValue(-1)
    INVALID_PARAMETERS,

    @JsonNumberValue(0)
    VALID_RESPONSE

}
