package model

class Verdura (cantidad:Int , descripcion:String):Categoria(cantidad , descripcion ), IActionable{
    var unidadMedida:String = "Uds"
    var list:MutableList<String> = mutableListOf("Tomate", "Brocoli", "Rabano", "Zanahoria","Vaina", "Acelga")
    init {
        listarIngredientes(list)
    }
}