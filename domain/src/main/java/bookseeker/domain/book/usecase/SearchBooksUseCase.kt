package bookseeker.domain.book.usecase

import bookseeker.domain.UseCase
import bookseeker.domain.book.Book
import bookseeker.domain.book.repository.BookRepository

class SearchBooksUseCase(private val repo: BookRepository) : UseCase<List<Book>, String> {
    override suspend fun execute(terms: String): List<Book> {
        return repo.search(terms)
    }

}