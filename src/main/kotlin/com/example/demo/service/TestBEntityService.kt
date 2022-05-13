package com.example.demo.service

import com.example.demo.dao.TestBEntity
import com.example.demo.repository.TestBRepository
import org.springframework.stereotype.Service

@Service
class TestBEntityService(
    val repository: TestBRepository
)
{
    fun getTestBEntity(id : Long) : TestBEntity {
        return repository.getById(id)
    }

    fun add(entity: TestBEntity) {
//        throw InvalidInputException("not right")
        repository.save(entity)
    }

    fun modify(entity: TestBEntity) {
        repository.save(entity)
    }
}