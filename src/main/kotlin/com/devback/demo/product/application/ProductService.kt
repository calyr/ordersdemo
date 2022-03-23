package com.devback.demo.product.application

import com.devback.demo.product.application.`in`.IProductRepository
import com.devback.demo.product.application.`in`.IProductService
import com.devback.demo.product.domain.Product
import org.springframework.stereotype.Service

@Service
class ProductService(private val repository: IProductRepository): IProductService {
    override fun addProduct(product: Product): Product {
       return repository.addProduct(product)
    }

    override fun deleteProduct(product: Product) {
        repository.deleteProduct(product)
    }

    override fun getList(): ArrayList<Product> {
        return repository.getList()
    }

}