abstract class Transport {
    abstract val name: String
    abstract val speed: Int
    var x: Int = 0

    fun move(dt: Int) {
        x += dt * speed
    }
    fun returnLocation() {
        println("$x km from start")
    }
}

class Car: Transport() {
    override val name = "Car"
    override val speed = 60
}

class Bus: Transport() {
    override val name = "Bus"
    override val speed = 40
}

class Train: Transport() {
    override val name = "Train"
    override val speed = 80

}
class Plain: Transport() {
    override val name = "Plain"
    override val speed = 500

}

fun main() {
    println("Print name of the transport (Car, Bus, Train, Plain)")
    val name = readln()

    val transport: Transport?
    when(name) {
        "Car" -> transport = Car()
        "Bus" -> transport = Bus()
        "Train" -> transport = Train()
        "Plain" -> transport = Plain()
        else -> {
            print("Uncorrect name")
            transport = null
        }
        }

    if (transport != null) {
        println("Print passed time (hours)")
        var dt = readln()
        try {
            transport.run {
                move(dt.toInt())
                returnLocation()
            }
        }
        catch (e: Exception) {
            print("Not a number")
        }
    }


}
