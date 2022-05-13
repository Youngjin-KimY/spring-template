package com.example.demo.service

import com.example.demo.dao.TestAEntity
import com.example.demo.dao.TestBEntity
import com.example.demo.exception.InvalidInputException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
class TestService(
    val testAEntityService: TestAEntityService,
    val testBEntityService: TestBEntityService
)
{
    @Transactional(value="transactionManager", propagation = Propagation.REQUIRED)
    fun transactionalGrandFather(age : Int) {
        transactionalFather(age)
        transactionalUncle(age)
    }

    @Transactional(value="transationManager", propagation = Propagation.SUPPORTS)
    protected fun transactionalFather(age : Int) {
        val testAEntity = TestAEntity(0,"yj_F_A",age)
        val testBEntity = TestBEntity(0, "yj_F_B", age)

        testAEntityService.add(testAEntity)
        testBEntityService.add(testBEntity)
    }

    @Transactional(value="transactionManager", propagation = Propagation.REQUIRED)
    protected fun transactionalUncle(age : Int) {
        val testANewEntity = TestAEntity(0, "yj_U_A",age)
        testAEntityService.add(testANewEntity)
        throw InvalidInputException("hi")
    }

}