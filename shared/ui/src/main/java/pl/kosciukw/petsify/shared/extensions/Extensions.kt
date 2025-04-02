package pl.kosciukw.petsify.shared.extensions

import androidx.compose.runtime.MutableState
import java.util.LinkedList

fun <T> MutableState<LinkedList<T>>.appendToMessageQueue(item: T) {
    value.add(item)
    value = LinkedList(value)
}

fun <T> MutableState<LinkedList<T>>.removeHeadMessage() {
    if (value.isNotEmpty()) {
        value.remove()
        value = LinkedList(value)
    }
}