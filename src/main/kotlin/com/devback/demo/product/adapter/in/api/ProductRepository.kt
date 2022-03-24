package com.devback.demo.product.adapter.`in`.api

import com.devback.demo.order.application.port.out.error.ApiResponse
import com.devback.demo.order.application.port.out.error.NotFoundException
import com.devback.demo.product.application.`in`.IProductRepository
import com.devback.demo.product.domain.Product
import com.devback.demo.product.domain.ProductName
import org.springframework.stereotype.Repository
import java.math.BigDecimal
import java.util.*
import kotlin.collections.ArrayList

@Repository
class ProductRepository: IProductRepository {

    var data = arrayListOf(Product(ProductName("Producto1"), BigDecimal("10.30")),
        Product(ProductName("Producto2"), BigDecimal("20.30")))

    override fun getList(): ArrayList<Product> = data

    override fun addProduct(product: Product): Any {

        return if(product != null) {
            data.add(product)
            return product
            return ApiResponse(0, "The product created", result = product)
        } else {
            throw NotFoundException("Invalid product")
        }
    }

    override fun updateProduct(product: Product): Any? {
        val productOld = data.find { it.id == product.id }

        if(productOld != null) {
            val position = data.indexOf(productOld)
            data.set(position, product)
            return ApiResponse(0, "The product updated", result = product)
        } else {
            throw NotFoundException("The productId doesn't belong in the product list.")
        }
    }

    override fun deleteProduct(id: UUID): Any? {
        val product = data.find { it.id == id }
        return if(product != null) {
            data.remove(product)
            return ApiResponse(0, "The product deleted", result = product)
        } else {
            throw NotFoundException("The productId doesn't belong in the product list.")
        }
    }

    override fun findByName(name: String): Any {
        val order = data.filter { it.name.value.contains(name) }
        return ApiResponse(0, "Count result ${order.size}", result = order)
    }
}