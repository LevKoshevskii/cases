package com.example.cases.service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired

internal class WordSpellServiceImplTest {
    private val wordSpellService =  WordSpellServiceImpl()

    @Test
    fun spell() {
        Assertions.assertEquals(listOf("Лев","Льва","Льву","Льва","Львом","Льве"),wordSpellService.spell("Лев"))
    }
}