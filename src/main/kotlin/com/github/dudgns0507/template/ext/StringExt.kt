package com.github.dudgns0507.template.ext

fun String.lowerWithUnderBar(): String {
    return this.split("(?=[A-Z])".toRegex())
        .joinToString("_") { it.decapitalize() }
        .replaceFirst("_", "")
}

fun String.replaceAll(oldValue: String, newValue: String?): String {
    return this.replace(oldValue, newValue ?: "")
}

fun String.replaceAllIfNotNull(oldValue: String, newValue: String?): String {
    return if (newValue != null) {
        this.replaceAll(oldValue, newValue)
    } else {
        this
    }
}