package com.example.demo.controller

import com.example.demo.service.TestService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/demo")
class TestController (
    val testService : TestService
    )
{
    @GetMapping("/test/{age}")
    fun test(@PathVariable("age") age: Int) {
        testService.transactionalGrandFather(age)
    }
}