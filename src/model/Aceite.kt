package model

class Aceite (cantidad:Int?, descripcion:String):Categoria(cantidad , descripcion ), IActionable{
    var unidadMedida:String = "Lts"
    var list:MutableList<String> = mutableListOf("Aceite coco","Aceite de Oliva", "Agua Girazol")
    init {
        listarIngredientes(list)
    }
}