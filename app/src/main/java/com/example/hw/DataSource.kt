package com.example.hw

class DataSource(size: Int) {
    private var list: MutableList<Int> = mutableListOf<Int>()

    init {
        for (i in 0..size) {
            list.add(i)
        }
    }

    fun get(index: Int): Int {
        return list[index]
    }

    fun add(): Int {
        list.add(list.size)
        return list.size - 1
    }

    fun size(): Int {
        return list.size
    }

}
