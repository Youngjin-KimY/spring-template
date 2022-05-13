package com.example.demo.repository

import com.example.demo.dao.TestBEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TestBRepository : JpaRepository<TestBEntity, Long>{

}