/*
Nested классы или вложенные классы - это классы объявленные внутри некоторого внешнего класса.
Это делается главным образом для улучшения читаемости кода, так как вложенный класс используется только для
работы в внешним классом в котором он размещен.
Вложенный класс не имеет доступа к членам внешнего класса, однако имеет доступ к статичным членам класса.
Инстанс вложенного класса создается без создания инстанса внешнего класса (кроме случаев когда вложенный класс
объявлен как private, тогда создать инстанс вложенного класса можно только из функции внутри внешнего класса)
 */

/*
Создадим класс компьютер, привязываем к нему companion object в которых объявлены переменные, с помощью которых
будут инициализироваться id как внешнего класса, так и вложенного.
 */
class Computer(val brend: String) {
    companion object {
        var pcCounter: Int = 0
        var hddCounter: Int = 0
    }

    val id = pcCounter++

    init {
        println("Computer is created. Brend: $brend, Id: $id")
    }

    fun getInfo() {
        println("This computer id: $id")
    }

    fun installHDD(hdd:HardDrive){
        TODO("запилить ченить что показать, что nested class нужен только работы с внешним классом" )
    }

    class HardDrive(val volume: Int) {
        val id = hddCounter++

        init {
            println("HDD is created. Volume: $volume, Id: $id")
        }
    }
    /*
    Теперь добавим еще один private вложенный класс и добавим функцию во внешний класс, чтобы работать с вложенным
     */
    private class Ram(val volume: Int){
        init {
            println("Ram is created. Volume: $volume")
        }
    }
    // Обратим внимание, что я не могу указать класс Ram как возвращаемый тип, потому что класс приватный и доступный только внутри
    // я объявляю внутри внешнего класса private переменную, куда положу инстанс класса Ram из функции, и тогда смогу получить к нему доступ извне
    private var ram:Ram?=null
    fun createRam(volume: Int){
        ram= Ram(volume)
    }
    fun getRam(){
        println("Outer class fun: ${ram?.volume}")
    }
}
