/*
Внутренние классы или inner классы, объявляются внутри внешнего класса и могут быть инициализированы только вместе
с инстансом внешнего класса (вместе, а не через функцию внешнего класса как было с приватным вложенным классом).
Внутренний класс имеет полный доступ к свойствам и функциям внешнего класса (в отличие от вложенного класса)
 */

class Smartphone(val brend:String){
    companion object{
        var counter=0
    }
    val id = counter++
    init {
        println("Smartphone is created. Brend: $brend, Id: $id")
    }
    inner class Screen{
        // Обратим внимание что у inner класса есть доступ к свойствам внешнего класса
        init {
            println("Screen is created from smartphone instance with brend: $brend, Id: $id")
        }
    }
}