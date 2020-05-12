import model.*
import java.util.*

var nombreReceta:String = ""
var recetas:MutableList<Receta> = mutableListOf()
var ingredienteList: MutableList<Ingrediente> = mutableListOf()

fun main(args:Array<String>){
    menuPrincipal()
}
fun menuPrincipal(){
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
            3 -> {
                println("Regresa Pronto")
                break@stopLoop
            }
            else -> {
                println("Debe ingresar una de las opciones")
                continue@stopLoop
            }
        }
    }while (response?.toInt() != 3)
}
fun repicesMaker(){
    if (recetas.size > 0){
        println("Ingrese el nombre de la receta nueva")
        nombreReceta = readLine().toString()
        for (receta in recetas){
            if (receta.nombreReceta.toLowerCase() === nombreReceta.toLowerCase()){
                println("La receta con el nombre ya existe. Ingrese otro nombre")
                optionToRepiceMaker()
            }else{
                optionToRepiceMaker()
            }
        }
    }else{
        if (nombreReceta === "") {
            println("Ingrese el nombre de la receta")
            nombreReceta = readLine().toString()
            optionToRepiceMaker()
        }else{
            optionToRepiceMaker()
        }
    }

}
fun optionToRepiceMaker(){
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
        0. Terminar Cereta
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
            0 -> {
                recetas.add(Receta(nombreReceta, ingredienteList))//recetas cuando se termina
                menuPrincipal()
            }
            else -> println("debe seleccionar una de las opciones")
        }
    }while (selected != 0)
}
fun viewRepices(){
    do {
        println("Mis recetas")
        for ((index, item) in recetas.withIndex()){
            println("${index+1}. ${item.nombreReceta}")
        }
        println("0. Volver al Menu Principal")
        val selected = readLine()?.toInt()
        println("tamanio recetas : ${recetas.size}")
        if (selected in 1..recetas.size){
            printReceta(selected!!)
        }else if (selected == 0){
            menuPrincipal()
        }else{
            println("debe seleccionar un numero de las opciones")
        }
    }while (selected != 0)
}
fun printReceta(selected: Int){
    println("======   ${recetas.get(selected-1).nombreReceta}   ======")
    println("Nro. \t  Nombre Ingrediente \t Cantidad \t Unidad de Medida")
    for ((index, item) in recetas[selected-1].listIngrediente.withIndex()){
        println("${index+1} \t\t ${item.nombre} \t\t ${item.cantidad} \t\t ${item.unidadMedida}\n")
    }
}
fun addAgua(){
    stopAgua@ do {
        val agua = Agua(0,"")
        println("0. Terminar receta")
        val selected:Int? = readLine()?.toInt()
        when(selected){
            1->{
                addAguaToIngredientes(agua, selected)
                optionToRepiceMaker()
                break@stopAgua
            }
            2->{
                addAguaToIngredientes(agua,selected)
                optionToRepiceMaker()
                break@stopAgua
            }
            3->{
                addAguaToIngredientes(agua,selected)
                optionToRepiceMaker()
                break@stopAgua
            }
            0-> println("Regrese pronto")
            else -> println("Debe seleccionar un numero de las opciones")

        }
    }while (selected != 0)
}
fun addAguaToIngredientes(agua: Agua, selected:Int){
    println("Introduce una cantidad")
    val cantidad:Int? = readLine()?.toInt()
    agua.cantidad = cantidad
    agua.descripcion = agua.list.get(selected-1)
    agua.unidadMedida = "Lts"
    val ingrediente = Ingrediente(cantidad!!,agua.list.get(selected-1),agua.unidadMedida)
    ingredienteList.add(ingrediente)
    //recetas.add(Receta(nombreReceta, ingredienteList))//recetas cuando se termina
    println("Se agrego $cantidad lts ${agua.list.get(selected - 1)}  :)")
}
fun addLeche(){
    stopLeche@ do {
        val leche = Leche(0,"")
        println("0. Terminar receta")
        val selected:Int? = readLine()?.toInt()

        if (selected in 1..leche.list.size){
            addLecheToIngredientes(leche, selected!!)
            optionToRepiceMaker()
            break@stopLeche
        }else if(selected == 0){
            println("Regrese pronto")
        }else{
            println("Debe seleccionar un numero de las opciones")
        }
    }while (selected != 0)
}
fun addLecheToIngredientes(leche:Leche, selected: Int){
    println("Introduce una cantidad")
    val cantidad:Int? = readLine()?.toInt()
    leche.cantidad = cantidad
    leche.descripcion = leche.list.get(selected-1)
    leche.unidadMedida = "Lts"
    val ingrediente = Ingrediente(cantidad!!,leche.list.get(selected-1),leche.unidadMedida)
    ingredienteList.add(ingrediente)
    //recetas.add(Receta(nombreReceta, ingredienteList))//recetas cuando se termina
    println("Se agrego $cantidad lts ${leche.list.get(selected - 1)}  :)")
}
fun addCarne(){
    do {
        val carne = Carne(0,"")
        println("0. Terminar receta")
        val selected:Int? = readLine()?.toInt()
        if (selected in 1..carne.list.size){
            addCarneToIngredientes(carne, selected!!)
            optionToRepiceMaker()
        }else if(selected == 0){
            println("Regrese pronto")
        }else{
            println("Debe seleccionar un numero de las opciones")
        }
    }while (selected != 0)
}
fun addCarneToIngredientes(carne:Carne, selected: Int){
    println("Introduce una cantidad")
    val cantidad:Int? = readLine()?.toInt()
    carne.cantidad = cantidad
    carne.descripcion = carne.list.get(selected-1)
    carne.unidadMedida = "Kls"
    val ingrediente = Ingrediente(cantidad!!,carne.list.get(selected-1),carne.unidadMedida)
    ingredienteList.add(ingrediente)
    //recetas.add(Receta(nombreReceta, ingredienteList))//recetas cuando se termina
    println("Se agrego $cantidad lts ${carne.list.get(selected - 1)}  :)")
}
fun addVerdura(){
    do {
        val verdura = Verdura(0,"")
        println("0. Terminar receta")
        val selected:Int? = readLine()?.toInt()
        if (selected in 1..verdura.list.size){
            addVerduraToIngredientes(verdura, selected!!)
            optionToRepiceMaker()
        }else if(selected == 0){
            println("Regrese pronto")
        }else{
            println("Debe seleccionar un numero de las opciones")
        }
    }while (selected != 0)
}
fun addVerduraToIngredientes(verdura: Verdura, selected: Int){
    println("Introduce una cantidad")
    val cantidad:Int? = readLine()?.toInt()
    verdura.cantidad = cantidad
    verdura.descripcion = verdura.list.get(selected-1)
    verdura.unidadMedida = "Uds"
    val ingrediente = Ingrediente(cantidad!!,verdura.list.get(selected-1),verdura.unidadMedida)
    ingredienteList.add(ingrediente)
    //recetas.add(Receta(nombreReceta, ingredienteList))//recetas cuando se termina
    println("Se agrego $cantidad lts ${verdura.list.get(selected - 1)}  :)")
}

fun addFruta(){
    do {
        val fruta = Fruta(0,"")
        println("0. Terminar receta")
        val selected:Int? = readLine()?.toInt()
        if (selected in 1..fruta.list.size){
            addFrutaToIngredientes(fruta, selected!!)
            optionToRepiceMaker()
        }else if(selected == 0){
            println("Regrese pronto")
        }else{
            println("Debe seleccionar un numero de las opciones")
        }
    }while (selected != 0)
}
fun addFrutaToIngredientes(fruta: Fruta, selected: Int){
    println("Introduce una cantidad")
    val cantidad:Int? = readLine()?.toInt()
    fruta.cantidad = cantidad
    fruta.descripcion = fruta.list.get(selected-1)
    fruta.unidadMedida = "Uds"
    val ingrediente = Ingrediente(cantidad!!,fruta.list.get(selected-1),fruta.unidadMedida)
    ingredienteList.add(ingrediente)
    //recetas.add(Receta(nombreReceta, ingredienteList))//recetas cuando se termina
    println("Se agrego $cantidad lts ${fruta.list.get(selected - 1)}  :)")
}
fun addCereal(){
    do {
        val cereal = Cereal(0,"")
        println("0. Terminar receta")
        val selected:Int? = readLine()?.toInt()
        if (selected in 1..cereal.list.size){
            addCerealToIngredientes(cereal, selected!!)
            optionToRepiceMaker()
        }else if(selected == 0){
            println("Regrese pronto")
        }else{
            println("Debe seleccionar un numero de las opciones")
        }
    }while (selected != 0)
}
fun addCerealToIngredientes(cereal:Cereal, selected: Int){
    println("Introduce una cantidad")
    val cantidad:Int? = readLine()?.toInt()
    cereal.cantidad = cantidad
    cereal.descripcion = cereal.list.get(selected-1)
    cereal.unidadMedida = "Kls"
    val ingrediente = Ingrediente(cantidad!!,cereal.list.get(selected-1),cereal.unidadMedida)
    ingredienteList.add(ingrediente)
    //recetas.add(Receta(nombreReceta, ingredienteList))//recetas cuando se termina
    println("Se agrego $cantidad lts ${cereal.list.get(selected - 1)}  :)")
}
fun addHuevo(){
    do {
        val huevo = Huevo(0,"")
        println("0. Terminar receta")
        val selected:Int? = readLine()?.toInt()
        if (selected in 1..huevo.list.size){
            addHuevoToIngredientes(huevo, selected!!)
            optionToRepiceMaker()
        }else if(selected == 0){
            println("Regrese pronto")
        }else{
            println("Debe seleccionar un numero de las opciones")
        }
    }while (selected != 0)
}
fun addHuevoToIngredientes(huevo: Huevo, selected: Int){
    println("Introduce una cantidad")
    val cantidad:Int? = readLine()?.toInt()
    huevo.cantidad = cantidad
    huevo.descripcion = huevo.list.get(selected-1)
    huevo.unidadMedida = "Uds"
    val ingrediente = Ingrediente(cantidad!!,huevo.list.get(selected-1),huevo.unidadMedida)
    ingredienteList.add(ingrediente)
    //recetas.add(Receta(nombreReceta, ingredienteList))//recetas cuando se termina
    println("Se agrego $cantidad lts ${huevo.list.get(selected - 1)}  :)")
}
fun addAceite(){
    do {
        val aceite = Aceite(0,"")
        println("0. Terminar receta")
        val selected:Int? = readLine()?.toInt()
        if (selected in 1..aceite.list.size){
            addAceiteToIngredientes(aceite, selected!!)
            optionToRepiceMaker()
        }else if(selected == 0){
            println("Regrese pronto")
        }else{
            println("Debe seleccionar un numero de las opciones")
        }
    }while (selected != 0)
}
fun addAceiteToIngredientes(aceite: Aceite, selected: Int){
    println("Introduce una cantidad")
    val cantidad:Int? = readLine()?.toInt()
    aceite.cantidad = cantidad
    aceite.descripcion = aceite.list.get(selected-1)
    aceite.unidadMedida = "Lts"
    val ingrediente = Ingrediente(cantidad!!,aceite.list.get(selected-1),aceite.unidadMedida)
    ingredienteList.add(ingrediente)
    //recetas.add(Receta(nombreReceta, ingredienteList))//recetas cuando se termina
    println("Se agrego $cantidad lts ${aceite.list.get(selected - 1)}  :)")
}