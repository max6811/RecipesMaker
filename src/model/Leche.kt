package model

class Leche(cantidad:Int?, descripcion:String) :Categoria(cantidad , descripcion ), IActionable{
    var unidadMedida:String = ""
    var list:MutableList<String> = mutableListOf("Leche deslactosada","Leche lactosa", "Leche de soya")
    init {
        listarIngredientes(list)
    }
}