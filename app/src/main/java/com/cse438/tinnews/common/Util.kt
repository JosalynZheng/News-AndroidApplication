package com.cse438.tinnews.common

class Util {
    companion object {
        fun isStringEmpty(string: String?): Boolean {
            return string == null || string.isEmpty()
        }
    }
}