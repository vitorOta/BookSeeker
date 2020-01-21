package com.vitorota.bookseeker.di

import bookseeker.data.di.DataModule
import bookseeker.domain.di.DomainModule
import org.koin.core.module.Module
import org.koin.dsl.module

object AppModule {
    fun getModules() = listOf<Module>(
        uiModule,
        *DataModule.getModules(),
        *DomainModule.getModules()
    )
}

private val uiModule = module {

}