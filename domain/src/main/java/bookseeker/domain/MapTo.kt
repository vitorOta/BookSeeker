package bookseeker.domain

interface MapTo<Model> {
    fun transform(): Model
}

fun <Model> List<MapTo<Model>>.transform() = this.map { it.transform() }