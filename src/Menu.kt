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
    do {
        println(options)
        val response: String? = readLine()
        repit@ when( response?.toInt()){
            1 -> println("Listos para hacer la receta, vamos!")
            2 -> println("Veamos las recetas")
            3 -> println("Vuelve pronto")
            else -> println("Debe ingresar una de las opciones")

        }
    }while (response?.toInt() != 3)
}