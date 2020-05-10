import com.sun.tools.javac.Main
import model.*
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

var receta:MutableList<Fruta> = ArrayList()

fun main(args:Array<String>){

    val options: String = """
        :: Bienvenido a Recipe Maker ::
        
        Selecciona la opcion deseada
        1. Hacer una receta
        2. Ver mis recetas
        3. Salir
    """.trimIndent()
    stopLoop@ do {
        println(options)
        val response: String? = readLine()
        repit@ when( response?.toInt()){
            1 -> {
                    repicesMaker()
                    break@stopLoop
                }
            2 -> {
                    viewRepices()
                    break@stopLoop
                }
            3 -> println("Regresa Pronto")
            else -> println("Debe ingresar una de las opciones")

        }
    }while (response?.toInt() != 3)
}

fun repicesMaker(){
    stopCategoria@do {
        val options: String = """
        Hacer receta
        Selecciona por categoria el ingrediente que buscas
        1. Agua
        2. Leche
        3. Carne
        4. Verduras
        5. Frutas
        6. Cereal
        7. Huevos
        8. Aceites
        0. Salir
    """.trimIndent()
        println(options)
        val selected:Int? = readLine()?.toInt()
        when(selected){
            1 -> {
                addAgua()
                break@stopCategoria
            }
            2 -> {
                addLeche()
                break@stopCategoria
            }
            3 -> {
                addCarne()
                break@stopCategoria
            }
            4 -> {
                addVerdura()
                break@stopCategoria
            }
            5 -> {
                addFruta()
                break@stopCategoria
            }
            6 -> {
                addCereal()
                break@stopCategoria
            }
            7 -> {
                addHuevo()
                break@stopCategoria
            }
            8 -> {
                addAceite()
                break@stopCategoria
            }
            0 -> println("Regresa Pronto")
            else -> println("debe seleccionar una de las opciones")
        }
    }while (selected != 0)
}
fun viewRepices(){
    val title: String = "Ver mis recetas"
    println(title)
}
fun addAgua(){
    println("Introduce una cantidad en Litros")
    val cantidad:Int? = readLine()?.toInt()
    val agua = Agua(cantidad, "Agua")
    println("Cantidad de Agua que se agredo: $cantidad")
}

fun addLeche(){
    println("Introduce una cantidad en Litros")
    val cantidad:Int? = readLine()?.toInt()
    val leche = Leche(cantidad, "Leche")
    println("Cantidad de Leche que se agredo: $cantidad")
}
fun addCarne(){
    println("Introduce una cantidad en kilos")
    val cantidad:Int? = readLine()?.toInt()
    val carne = Carne(cantidad, "Carne")
    println("Cantidad de Carne que se agredo: $cantidad")
}
fun addVerdura(){
    val listVerduras: Array<String> = arrayOf("Tomate", "Brocoli", "Rabano", "Zanahoria","Vaina", "Acelga")

    stopVerdura@ do {
        for ((index , item) in listVerduras.withIndex()){
            println("${index+1}. $item")
        }
        println("0. Salir")
        val selected:Int? = readLine()?.toInt()
        when(selected){
            1->{
                val verdura = Verdura(selected,listVerduras.get(selected-1))
                
                break@stopVerdura
            }
            2->{
                val verdura = Verdura(selected,listVerduras.get(selected-1))
                break@stopVerdura
            }
            3->{
                val verdura = Verdura(selected,listVerduras.get(selected-1))
                break@stopVerdura
            }
            4->{
                val verdura = Verdura(selected,listVerduras.get(selected-1))
                break@stopVerdura
            }
            5->{
                val verdura = Verdura(selected,listVerduras.get(selected-1))
                break@stopVerdura
            }
            6->{
                val verdura = Verdura(selected,listVerduras.get(selected-1))
                break@stopVerdura
            }
            6->{
                val verdura = Verdura(selected,listVerduras.get(selected-1))
                break@stopVerdura
            }
            0-> println("Regrese pronto")
            else -> println("Debe seleccionar un numero de las opciones")

        }
    }while (selected != 0)
}
fun addFruta(){
    val list: Array<String> = arrayOf("Fresa", "Platano", "Uvas", "Manzana","Naranja", "Pera", "Cereza")

    stopFruta@ do {
        for ((index , item) in list.withIndex()){
            println("${index+1}. $item")
        }
        println("0. Salir")
        val selected:Int? = readLine()?.toInt()
        when(selected){
            1->{
                val fruta = Fruta(selected,list.get(selected-1))
                receta.add(fruta)
                break@stopFruta
            }
            2->{
                val fruta = Fruta(selected,list.get(selected-1))
                break@stopFruta
            }
            3->{
                val fruta = Fruta(selected,list.get(selected-1))
                break@stopFruta
            }
            4->{
                val fruta = Fruta(selected,list.get(selected-1))
                break@stopFruta
            }
            5->{
                val fruta = Fruta(selected,list.get(selected-1))
                break@stopFruta
            }
            6->{
                val fruta = Fruta(selected,list.get(selected-1))
                break@stopFruta
            }
            6->{
                val fruta = Fruta(selected,list.get(selected-1))
                break@stopFruta
            }
            0-> println("Regrese pronto")
            else -> println("Debe seleccionar un numero de las opciones")

        }
    }while (selected != 0)
}
fun addCereal(){
    val listCereal: Array<String> = arrayOf("Avena", "Trigo", "Arroz", "Maiz")

    stopCereal@ do {
        println("0. Salir")
        for ((index , item) in listCereal.withIndex()){
            println("${index+1}. $item")
        }
        val selected:Int? = readLine()?.toInt()
        when(selected){
            1->{
                val cereal = Cereal(selected,listCereal.get(selected-1))
                break@stopCereal
            }
            2->{
                val cereal = Cereal(selected,listCereal.get(selected-1))
                break@stopCereal
            }
            3->{
                val cereal = Cereal(selected,listCereal.get(selected-1))
                break@stopCereal
            }
            4->{
                val cereal = Cereal(selected,listCereal.get(selected-1))
                break@stopCereal
            }
            0-> println("Regrese pronto")
            else -> println("Debe seleccionar un numero de las opciones")

        }
    }while (selected != 0)
}
fun addHuevo(){
    println("Introduce una cantidad")
    val cantidad:Int? = readLine()?.toInt()
    val huevo = Huevo(cantidad, "Huevo")
    println("Cantidade de Huevo que se agrego: $cantidad ")
}
fun addAceite(){
    println("Introduce una cantidad en Litros")
    val cantidad:Int? = readLine()?.toInt()
    val aceite = Aceite(cantidad, "Aceite")
    println("Cantidad de Aceite que se agredo: $cantidad")
}