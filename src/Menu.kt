import com.sun.tools.javac.Main
import java.lang.NullPointerException

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
//                    println("Listos para hacer la receta, vamos!")
                    repicesMaker()
                    break@stopLoop
                }
            2 -> {
//                    println("Veamos las recetas")
                    viewRepices()
                    break@stopLoop
                }
            3 -> println("Vuelve pronto")
            else -> println("Debe ingresar una de las opciones")

        }
    }while (response?.toInt() != 3)
}

fun repicesMaker(){
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
    """.trimIndent()
    println(options)
}
fun viewRepices(){
    val title: String = "Ver mis recetas"
    println(title)
}