package model

class Fruta(cantidad:Int, descripcion:String):Categoria(cantidad, descripcion), IActionable {
    var unidadMedida:String = "Uds"
    var list:MutableList<String> = mutableListOf("Fresa", "Platano", "Uvas", "Manzana","Naranja", "Pera", "Cereza")
    init {
        listarIngredientes(list)
    }
}