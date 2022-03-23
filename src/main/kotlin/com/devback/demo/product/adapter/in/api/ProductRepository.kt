package com.devback.demo.product.adapter.`in`.api

import com.devback.demo.product.application.`in`.IProductRepository
import com.devback.demo.product.domain.Product
import org.springframework.stereotype.Repository
import java.util.*
import kotlin.collections.ArrayList

@Repository
class ProductRepository: IProductRepository {

    val data = ArrayList<Product>()
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