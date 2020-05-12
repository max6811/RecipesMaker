package model

class Cereal(cantidad:Int, descripcion:String) : Categoria(cantidad, descripcion), IActionable{
    var unidadMedida:String = "Uds"
    var list:MutableList<String> = mutableListOf("Avena", "Trigo", "Arroz", "Maiz")
    init {
        listarIngredientes(list)
    }
}