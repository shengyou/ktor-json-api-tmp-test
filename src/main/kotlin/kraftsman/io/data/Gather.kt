package kraftsman.io.data

import kotlinx.serialization.Serializable

@Serializable
data class Gather(
    val id: String = "",
    val name: String,
    val introduction: String = "",
    val note: String = "",
    val startTime: Long = System.currentTimeMillis(),
    val endTime: Long = System.currentTimeMillis() + 2 * 60 * 60 * 1_000,
    val countLimitTime: Long = System.currentTimeMillis(),
    val place: Place,
    val peopleMinLimit: Long = 2,
    val peopleMaxLimit: Long = 22,
    val cityCode: Long = 0,
) {
    @Serializable
    class Place {
        var id: String = ""
        var name: String = ""
        var googleMap: String = ""
        var lat: Double = 0.0
        var lng: Double = 0.0
        var price: Long = 0
        var hasWoodWork: Boolean = false
    }
}
