package model

abstract class Ingrediente(var cantidad: Int?, var descripcion: String) {
    override fun toString(): String {
        return "\nCantidad:  $cantidad \nDescripcion: $descripcion"
    }

}