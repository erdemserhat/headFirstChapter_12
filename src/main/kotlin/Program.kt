fun main(args: Array<String>) {
    //Important Keywords;
    //minBy, maxBy, sumOf
    //filter, filterTo, filterNot, filterIsInstance
    //map,mapTo, mapNotNull
    //chain
    //forEach


    fun a() {
        // 1. `minBy` ve `maxBy`:
        val numbers = listOf(5, 10, 3, 8, 1)
        val minNumber = numbers.minByOrNull { it }
        val maxNumber = numbers.maxByOrNull { it }
        println("Minimum: $minNumber, Maximum: $maxNumber")
    }


    fun b() {
        // 2. `sumOf`:
        val numbers = listOf(5, 10, 3, 8, 1)
        val total = numbers.sumOf { it }
        println("Toplam: $total")
    }

    //  3. `filter`:
    fun c() {
        val numbers = listOf(5, 10, 3, 8, 1)
        val filteredNumbers = numbers.filter { it > 5 }
        println("Filtrelenmiş Sayılar: $filteredNumbers")
    }

    // 4. `filterTo`:
    fun d() {
        val numbers = listOf(5, 10, 3, 8, 1)
        val filteredNumbers = mutableListOf<Int>()
        numbers.filterTo(filteredNumbers) { it > 5 }
        println("Filtrelenmiş Sayılar: $filteredNumbers")
    }

    //5. `filterNot`:
    fun e() {
        val numbers = listOf(5, 10, 3, 8, 1)
        val filteredNumbers = numbers.filterNot { it > 5 }
        println("Filtrelenmemiş Sayılar: $filteredNumbers")
    }

    //6. `filterIsInstance`:
    fun f() {
        val mixedList: List<Any> = listOf(5, "Hello", 3.14, "World", 42)
        val filteredIntegers = mixedList.filterIsInstance<Int>()
        println("Filtrelenmiş Sayılar: $filteredIntegers")
    }

    fun g() {
        // 7. `map`:
        val numbers = listOf(5, 10, 3, 8, 1)
        val squaredNumbers = numbers.map { it * it }
        println("Kareleri: $squaredNumbers")
    }

    // 8. `mapTo`:
    fun h() {
        val numbers = listOf(5, 10, 3, 8, 1)
        val squaredNumbers = mutableListOf<Int>()
        numbers.mapTo(squaredNumbers) { it * it }
        println("Kareleri: $squaredNumbers")
    }

    // 9. `mapNotNull`:
    fun j() {
        val numbers = listOf(5, 10, 3, null, 8, 1, null)
        val nonNullNumbers = numbers.mapNotNull { it }
        println("Null Olmayan Sayılar: $nonNullNumbers")
    }

    // 10. `chain`: İşlevleri birleştirerek kullanır. Örneğin, `filter` ve `map` işlemlerini zincirleme olarak uygulayabilirsiniz.

    fun l() {
        //11. `forEach`:
        val numbers = listOf(5, 10, 3, 8, 1)
        numbers.forEach { println("Sayı: $it") }
    }

    // 12. `groupBy`:
    data class Person(val name: String, val age: Int)

    val people = listOf(Person("Alice", 25), Person("Bob", 30), Person("Charlie", 25))
    val groupedByAge = people.groupBy { it.age }
    println("Yaşa Göre Gruplanmış Kişiler: $groupedByAge")


    //Using minBy, maxBy and SumOf
    val myArray: List<Int> = listOf(1, 2, 3, 4)
    val myMinValue = myArray.minBy { it } //1
    val maxValue = myArray.maxBy({ it }) //4
    println(myArray.sumOf { it * 2 }) //20
    println(myArray.sumOf { it - 12 }) //-38
    println(maxValue)

    data class Car(
        val name: String,
        val price: Int,
        val doorNumber: Int
    )

    val myCarList: MutableList<Car> = mutableListOf(
        Car("Bugatti", 1500, 3),
        Car("Mercedes", 2000, 2),
        Car("Truck X", 1000, 1),
        Car("Tesla", 5000, 5),
    )

    println(myCarList.minBy { it.price }) //Car(name=Truck X, price=1000, doorNumber=1)

    //using filters

    println(myCarList.filter { car: Car -> car.price > 1000 })
    //[Car(name=Bugatti, price=1500, doorNumber=3),
    // Car(name=Mercedes, price=2000, doorNumber=2),
    // Car(name=Tesla, price=5000, doorNumber=5)]
    println(myCarList.filter { car: Car -> car.doorNumber > 16 }) //Empty

    println(myCarList.filterNot { car: Car -> car.name == "Bugatti" })
    //prin the car which its name atrribute is not "Bugatti"

    var myNewCarList: MutableList<Car>
    myNewCarList = mutableListOf(
        Car("Hundai", 100, 4)
    )

    println(myNewCarList)

    //originalCollection.filterTo (firstParam, {secondParam})
    //firstParam->the collection which you add filtered items
    //secondParam->the statement return true or false for filtering
    //originalCollection->the collection which you want to filter as a source


    myCarList.filterTo(myNewCarList) { car: Car -> car.price > 3000 }
    println(myNewCarList)

    //map,mapTo, mapNotNull


    println(myCarList.map { it.price * 2 })
    //[3000, 4000, 2000, 10000]
    //make an array of called collection with the specified lambda expression

    println(myCarList.map { it.name.length })
    //[7, 8, 7, 5]
    val myExList: ArrayList<Int> = arrayListOf()
    myCarList.mapTo(myExList) { car: Car -> car.price }
    println(myExList)
    //[1500, 2000, 1000, 5000]

    println((myCarList.filter { it.doorNumber > 2 }).map { it.price })
    //print the car's price, which has more than 2 doors.

    println(myCarList.filter { car: Car -> car.price > 1200 && car.doorNumber > 3 }.map { it.name })
    //[Tesla]

    val list: List<String?> = listOf("Mike", "Jra", null)

    println(list.mapNotNull { it?.length })
    //[4, 3]

    val mutableList: MutableList<Int> = mutableListOf(10, 20, 30, 40)

    mutableList.forEach { a: Int -> println(mutableList.indexOf(a)) }
    mutableList.forEach({ println(it) })


}

