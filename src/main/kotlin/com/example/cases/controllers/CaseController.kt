package com.example.cases.controllers

import com.example.cases.service.WordSpellService
import com.example.cases.service.WordSpellServiceImpl
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/spell")
class CaseController {

    val wordSpellService: WordSpellService = WordSpellServiceImpl()

    @RequestMapping(
        value = ["/{word}"],
        method = [RequestMethod.GET],
        produces = [MediaType.APPLICATION_JSON_UTF8_VALUE]
    )
    fun speller(@PathVariable("word") word: String): List<String> {
        return wordSpellServiceqweqwe.spell(word)
    }
}