package kraftsman.io.plugins

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kraftsman.io.data.Gather
import kraftsman.io.data.Gather.*

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }

    routing {
        get("/json/kotlinx-serialization") {
            call.respond(mapOf("hello" to "world"))
        }

        get("/api/test") {
            val place = Place()
            val gathers = (1..10).map {
                Gather(
                    id = "Gather $it",
                    name = "Default",
                    cityCode = it.toLong(),
                    introduction = "intro",
                    place = place,
                    note = "note",
                    startTime = 0,
                    endTime = 0,
                    countLimitTime = 0,
                    peopleMinLimit = 2,
                    peopleMaxLimit = 33,
                )
            }
            call.respond(gathers)
        }
    }
}
