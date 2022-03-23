package com.devback.demo.product.adapter.`in`.api

import com.devback.demo.product.application.`in`.IProductRepository
import com.devback.demo.product.domain.Product
import org.springframework.stereotype.Repository

@Repository
class ProductRepository: IProductRepository {

    val data = ArrayList<Product>()
    override fun getList(): ArrayList<Product> = data

    override fun addProduct(product: Product) : Product {
        data.add(product)
        return product
    }

    override fun deleteProduct(product: Product) {
        data.remove(product)
    }
}