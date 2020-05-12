package model

class Huevo(cantidad:Int?, descripcion:String) :Categoria(cantidad , descripcion ), IActionable{
    var unidadMedida:String = "Uds"
    var list:MutableList<String> = mutableListOf("Huevo de gallina","Huevo de codornis", "Huevo de pato")
    init {
        listarIngredientes(list)
    }
}