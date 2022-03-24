package com.devback.demo.product.application

import com.devback.demo.product.application.`in`.IProductRepository
import com.devback.demo.product.application.`in`.IProductService
import com.devback.demo.product.domain.Product
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
class ProductService(private val repository: IProductRepository): IProductService {
    override fun addProduct(product: Product): Any {
       return repository.addProduct(product)
    }

    override fun deleteProduct(id: UUID): Any? {
        return repository.deleteProduct(id)
    }

    override fun getList(): ArrayList<Product> {
        return repository.getList()
    }

    override fun updateProduct(product: Product): Any? {
        return repository.updateProduct(product)
    }

}