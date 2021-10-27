package com.example.cases.service

import org.springframework.stereotype.Service
import ru.morpher.ws3.*
import ru.morpher.ws3.russian.*

@Service
class WordSpellServiceImpl: WordSpellService{

    constructor()
    override fun spell(word: String): List<String> {

        val result:MutableList<String> = ArrayList()
        val client: Client = ClientBuilder().useToken("d1f0dc47-1ef0-47f3-8448-1c815753dfbf").build()

        val declensionResult: DeclensionResult = client.russian().declension(word)

        result.add(declensionResult.nominative)
        result.add(declensionResult.genitive)
        result.add(declensionResult.dative)
        result.add(declensionResult.accusative)
        result.add(declensionResult.instrumental)
        result.add(declensionResult.prepositional)

        return result
    }
}