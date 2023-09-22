package com.example.tukitakirt.data.user


//CS-20
data class UserProfile(var userId: String="",
                       var createdAt: Long?=null,
                       var updatedAt: Long?=null,
                       var image: String="",
                       var name: String="",
                       var email: String="",
                       var about: String="",
                       var token :String="",
                       var mobile: String?=null

)
