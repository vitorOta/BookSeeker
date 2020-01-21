package bookseeker.domain.book.repository

import bookseeker.domain.book.Book

interface BookRepository {
    suspend fun search(term: String): List<Book>
}