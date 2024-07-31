abstract class Food(val name: String, val price: Double) {
    abstract fun cook(): String
}

class Burger(name: String, price: Double) : Food(name, price) {
    override fun cook(): String {
        return "Preparando la " + super.name + "."
    }
}

class Pizza(name: String, price: Double) : Food(name, price) {
    override fun cook(): String {
        return "Haciendo la " + super.name + "."
    }
}

interface Dessert {
    fun eat(): String
}

class IceCream(name: String, price: Double) : Food(name, price), Dessert {
    override fun cook(): String {
        return "Sirviendo el " + super.name + "."
    }

    override fun eat(): String {
        return "Comiendo el " + super.name + "."
    }
}

abstract class Drink(name: String, price: Double) : Food(name, price) {
    abstract fun pour(): String
}

class Juice(name: String, price: Double) : Drink(name, price) {
    override fun pour(): String {
        return "Sirviendo el " + super.name + "."
    }

    override fun cook(): String {
        return "Haciendo el " + super.name + "."
    }
}

fun Food.discountedPrice(discountPercentage: Double): Double {
    return price * (1 - discountPercentage / 100)
}

fun main() {
    val burger = Burger("Quesoburguesa", 5.99)
    val pizza = Pizza("Pizza de peperoni", 8.99)
    val iceCream = IceCream("Helado de Vainilla", 3.99)
    val juice = Juice("Jugo de naranja", 2.99)

    println(burger.cook())
    println(pizza.cook())
    println(iceCream.cook())
    println(iceCream.eat())
    println(juice.cook())
    println(juice.pour())

    val discount = 10.0
    println("Precio con descuento de la hamburguesa: ${burger.discountedPrice(discount)}")
}