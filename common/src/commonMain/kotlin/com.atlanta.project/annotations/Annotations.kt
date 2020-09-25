package com.atlanta.project.annotations

@Suppress("deprecation")
@Retention(value = AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.FUNCTION)
@Experimental(level = Experimental.Level.WARNING)
annotation class AtlantaExperimental

