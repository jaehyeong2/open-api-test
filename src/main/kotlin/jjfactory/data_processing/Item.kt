package jjfactory.data_processing

class Item(
    val id: Long? = null,
    var name: String,
    var price: Int
) {

    fun updatePrice(price: Int){
        this.price = price
    }
}