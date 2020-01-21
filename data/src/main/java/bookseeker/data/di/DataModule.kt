package bookseeker.data.di

import bookseeker.data.book.BookCloudRepository
import bookseeker.data.network.ApiClientBuilder
import bookseeker.data.network.BookSeekerApi
import bookseeker.domain.book.repository.BookRepository
import org.koin.dsl.bind
import org.koin.dsl.module

object DataModule {
    fun getModules() = arrayOf(networkModule)
}

private val networkModule = module {
    single { ApiClientBuilder.createServiceApi<BookSeekerApi>() }

    factory { BookCloudRepository(api = get()) } bind BookRepository::class
}