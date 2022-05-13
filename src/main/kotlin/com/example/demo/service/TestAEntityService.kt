package com.example.demo.service

import com.example.demo.dao.TestAEntity
import com.example.demo.repository.TestARepository
import org.springframework.stereotype.Service

@Service
class TestAEntityService(
    val repository: TestARepository
)
{
    fun getTestAEntity(id : Long) : TestAEntity {
        return repository.getById(id)
    }

    fun add(entity: TestAEntity) {
//        throw InvalidInputException("not right")
        repository.save(entity)
    }

    fun modify(entity: TestAEntity) {
        repository.save(entity)
    }
}