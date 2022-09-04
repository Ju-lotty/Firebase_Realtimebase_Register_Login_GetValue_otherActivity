package com.project.logintest.entity

data class UserEntity (
    val id: String,
    val pw: String,
    val nickname: String
)
{
    constructor() : this("","", "")
}