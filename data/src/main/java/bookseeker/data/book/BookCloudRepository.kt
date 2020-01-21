package bookseeker.data.book

import bookseeker.data.network.BookSeekerApi
import bookseeker.domain.book.Book
import bookseeker.domain.book.repository.BookRepository

class BookCloudRepository(private val api: BookSeekerApi) : BookRepository {
    override suspend fun search(term: String): List<Book> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}