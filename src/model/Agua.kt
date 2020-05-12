package model

class Agua(cantidad:Int?, descripcion:String): Categoria(cantidad ,descripcion), IActionable{
    var unidadMedida:String = ""
    var list:MutableList<String> = mutableListOf("Agua Normal","Agua Dulce", "Agua Salada")
    init {
         listarIngredientes(list)
    }
}