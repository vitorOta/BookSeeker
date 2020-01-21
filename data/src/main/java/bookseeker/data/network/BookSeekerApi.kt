package bookseeker.data.network

import bookseeker.domain.book.Book
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BookSeekerApi {
    @GET("search?entity=ibook")
    suspend fun searchBooks(@Query("term") searchTerm: String): Response<List<Book>>
}