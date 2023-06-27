package com.example.cases.service

interface WordSpellService {

    fun spell(word: String): List<String>
}