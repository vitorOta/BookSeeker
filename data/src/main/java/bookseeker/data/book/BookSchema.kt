package bookseeker.data.book

import bookseeker.domain.MapTo
import bookseeker.domain.book.Book
import com.google.gson.annotations.SerializedName
import java.util.*

data class BookSchema(
    @SerializedName("artworkUrl60")
    val artworkUrl60: String,

    @SerializedName("artworkUrl100")
    val artworkUrl100: String,

    @SerializedName("artistViewUrl")
    val artistViewUrl: String,

    @SerializedName("trackCensoredName")
    val trackCensoredName: String,

    @SerializedName("fileSizeBytes")
    val fileSizeBytes: Long,

    @SerializedName("trackViewUrl")
    val trackViewUrl: String,

    @SerializedName("trackId")
    val trackId: Long,

    @SerializedName("trackName")
    val trackName: String,

    @SerializedName("formattedPrice")
    val formattedPrice: String,

    @SerializedName("currency")
    val currency: String,

    @SerializedName("kind")
    val kind: String,

    @SerializedName("releaseDate")
    val releaseDate: Date,

    @SerializedName("description")
    val description: String,

    @SerializedName("artistId")
    val artistId: Long,

    @SerializedName("artistName")
    val artistName: String,

    @SerializedName("genres")
    val genres: List<String>,

    @SerializedName("price")
    val price: Double
) : MapTo<Book> {
    override fun transform() = Book(
        artworkUrl60 = artworkUrl60,
        artworkUrl100 = artworkUrl100,
        artistViewUrl = artistViewUrl,
        trackCensoredName = trackCensoredName,
        fileSizeBytes = fileSizeBytes,
        trackViewUrl = trackViewUrl,
        trackId = trackId,
        trackName = trackName,
        formattedPrice = formattedPrice,
        currency = currency,
        kind = kind,
        releaseDate = releaseDate,
        description = description,
        artistId = artistId,
        artistName = artistName,
        genres = genres,
        price = price
    )
}