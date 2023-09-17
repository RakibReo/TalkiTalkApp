package com.example.tukitakirt.services.user

import com.example.tukitakirt.data.register.RequestUserRegister
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DatabaseReference


//cs23

interface UserService {

    //cs23
    suspend fun createUser(request: RequestUserRegister): Task<Void>

    //CS32
suspend fun getUserById(userId: String): DatabaseReference

//CS 37

  suspend fun getUserAllUser(): DatabaseReference

}