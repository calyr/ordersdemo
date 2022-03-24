package com.devback.demo.product.adapter.`in`.api

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

    override fun addProduct(product: Product) : Product {
        data.add(product)
        return product
    }

    override fun updateProduct(product: Product): Product? {
        val productOld = data.find { it.id == product.id }
        val position = data.indexOf(productOld)
        data.set(position, product)
        return product
    }

    override fun deleteProduct(id: UUID) : Product? {
        val product = data.find { it.id == id }
        data.remove(product)
        return product
    }
}