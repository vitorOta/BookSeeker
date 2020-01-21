package bookseeker.domain.book

import java.util.*

data class Book(
    val artworkUrl60: String,
    val artworkUrl100: String,
    val artistViewUrl: String,
    val trackCensoredName: String,
    val fileSizeBytes: Long,
    val trackViewUrl: String,
    val trackId: Long,
    val trackName: String,
    val formattedPrice: String,
    val currency: String,
    val kind: String,
    val releaseDate: Date,
    val description: String,
    val artistId: Long,
    val artistName: String,
    val genres: List<String>,
    val price: Double
)