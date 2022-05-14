package com.amirhusseinsoori.domain.entity

import java.util.*


data class TodoModel(
    val id: Long? = null,
    val title: String? = null,
    val description: String? = null,
    val date: String? = Calendar.getInstance().time.toString()
)





