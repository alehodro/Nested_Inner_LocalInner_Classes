/*
Класс можно запилить даже в функцию другого класса, такой класс называется внутренний локальный класс (inner local class).
Класс видит свойства внутри метода, метод видит свойства внешнего класса. В примере ниже, функция lightOn()
внутреннего класса  использует свойство внешнего класса, а чтобы менять это свойство и соотвесмтвенно менять
функцию внутреннего класса, я добавил функцию для изменения во внешний класс
 */


class Lamp {
    var defaultBulbCapacity = 100
    fun on() {
        class Bulb(val capacity: Int) {
            fun lightOn() {
                println("Lamp is shining with $capacity WW")
            }
        }

        val bulb = Bulb(defaultBulbCapacity)
        bulb.lightOn()
    }

    fun changeBulbCapacity(capacity: Int) {
        defaultBulbCapacity = capacity
    }
}