package me.zw.common

import java.util.*


class Searcher {
    var map: MutableMap<String, List<String>> = HashMap()
    fun search(keyword: String): List<String> {
        var results = map[keyword]
        if (results == null) {
            results = ArrayList()
        }
        return results
    }

    init {
        map["M"] = Arrays.asList("Macau", "Malaysia", "Maldives", "Mexico", "Myanmar", "Macedonia")
        map["Ma"] = Arrays.asList("Macau", "Malaysia", "Maldives", "Macedonia")
        map["Mal"] = Arrays.asList("Malaysia", "Maldives")
        map["Malay"] = Arrays.asList("Malaysia")
    }
}