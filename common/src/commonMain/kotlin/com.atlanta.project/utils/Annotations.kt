package com.atlanta.project.utils

import kotlin.RequiresOptIn.Level.WARNING
import kotlin.annotation.AnnotationTarget.*
import kotlin.annotation.AnnotationRetention.BINARY

@Retention(BINARY)
@RequiresOptIn(level = WARNING)
@Target(CLASS, PROPERTY, FUNCTION)
annotation class AtlantaExperimental

