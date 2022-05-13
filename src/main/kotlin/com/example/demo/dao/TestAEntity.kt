package com.example.demo.dao

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Table

@Entity
@Table(name = "test_a")
class TestAEntity(
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id : Long,
    @Column(nullable = false)
    val name : String,
    @Column(nullable = false)
    val age : Int,
) : BaseEntity()