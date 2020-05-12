package model

class Carne(cantidad:Int?, descripcion:String) :Categoria(cantidad , descripcion ), IActionable{
    var unidadMedida:String = "kls"
    var list:MutableList<String> = mutableListOf("Carne de pollo ","Carne de pescado", "Carne Bovina")
    init {
        listarIngredientes(list)
    }
}