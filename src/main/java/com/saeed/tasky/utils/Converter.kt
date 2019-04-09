package com.saeed.tasky.utils

class Converter<T> {

    fun objectToMutableSet(obj: T): MutableSet<T> {
        val list: MutableSet<T> = HashSet()
        list.add(obj)
        return list
    }
}