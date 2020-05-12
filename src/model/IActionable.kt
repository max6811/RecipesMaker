package model

interface IActionable {
    fun setCantidad(cantidad: Int):Int{
        return cantidad
    }
    fun <T> listarIngredientes(list: MutableList<T>){
        for ((index, item) in list.withIndex()){
            println("${index+1}. ${item.toString()}")
        }
    }
}