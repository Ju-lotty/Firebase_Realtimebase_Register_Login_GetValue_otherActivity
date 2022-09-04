package com.project.logintest.entity

data class OwnerEntity (
    val id: String,
    val pw: String,
    val nickname: String
)
{
    constructor() : this("","", "")
}