package bookseeker.domain.di

import bookseeker.domain.book.usecase.SearchBooksUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModule {
    fun getModules(): Array<Module> = arrayOf(
        useCaseModule
    )
}

private val useCaseModule = module {
    factory { SearchBooksUseCase(repo = get()) }
}