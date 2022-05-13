package com.example.demo.dao

import javax.persistence.*

@Entity
@Table(name = "test_b")
class TestBEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id : Long,
    @Column(nullable = false)
    val name : String,
    @Column(nullable = true)
    val age : Int
    ) :  BaseEntity()