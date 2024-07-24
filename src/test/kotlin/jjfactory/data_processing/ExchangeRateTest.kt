package jjfactory.data_processing

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.util.concurrent.CompletableFuture

class ExchangeRateTest {

    @Test
    fun test(){
        val result = CompletableFuture.supplyAsync {
            getProductInfoTwo()
        }

        Assertions.assertThat(result.get()).isEqualTo("hi")
    }

    @Test
    fun test2(){
        val result = CompletableFuture.supplyAsync {
            getProductInfoTwo()
        }

        var str = result.thenApply {
            "$it add"
        }

        Assertions.assertThat(str.get()).isEqualTo("hi add")
    }

    @Test
    fun test3(){
        val result1 = CompletableFuture.supplyAsync {
            getOrderInfo(100)
        }

        val result2 = CompletableFuture.supplyAsync {
            getOrderInfo(200)
        }

        val result3 = CompletableFuture.supplyAsync {
            getOrderInfo(300)
        }
    }

    fun getProductInfoTwo(): String {
        Thread.sleep(2000)

        return "hi"
    }

    fun getOrderInfo(price: Int): MutableList<OrderTmp> {
        Thread.sleep(1000)

        var list: MutableList<OrderTmp> = mutableListOf()

        for (i in 1.. 10){
            list.add(OrderTmp(
                price = price * i
            ))
        }

        return list
    }

    data class OrderTmp(
        val price: Int
    )
}
