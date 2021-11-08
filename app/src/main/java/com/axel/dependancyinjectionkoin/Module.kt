package com.axel.dependancyinjectionkoin

import org.koin.dsl.module

val appModule = module {
    single { Course() }
    factory { Friend() }
    factory { Student(get(),get()) }
}