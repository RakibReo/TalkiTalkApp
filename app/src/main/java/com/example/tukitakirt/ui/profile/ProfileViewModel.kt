package com.example.tukitakirt.ui.profile

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tukitakirt.data.user.UserProfile
import com.example.tukitakirt.repositories.UserRepo
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.core.Context
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//CS-35

@HiltViewModel
class ProfileViewModel @Inject constructor(private val userRepo: UserRepo) : ViewModel() {


    // Get user single who sign in
    private var _resposne = MutableLiveData<UserProfile>()
    val responseUserProfile: LiveData<UserProfile> = _resposne


    fun getUserById(userId: String) {


        viewModelScope.launch {

            userRepo.getUserById(userId).addValueEventListener(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {

                    val value = snapshot.getValue(UserProfile::class.java)

                    value?.let {

                        _resposne.postValue(it)
                    }


                }

                override fun onCancelled(error: DatabaseError) {
                    Log.w("TAG", "Failed to read value.", error.toException())
                }

            })


        }


    }

    //CS-40

    private var _resposneAllUser = MutableLiveData<List<UserProfile>>()
    val responseAllUserProfile: LiveData<List <UserProfile>> = _resposneAllUser

    fun getAllUser() {

        val userList= mutableListOf<UserProfile>()

        viewModelScope.launch {

            userRepo.getAllUser().addValueEventListener(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {

                    userList.clear()

                    snapshot.children.forEach{ dataSnapshot ->

                        val value = dataSnapshot.getValue(UserProfile::class.java)

                        value?.let {

                            userList.add(it)




                        }


                    }

                    _resposneAllUser.postValue(userList)



                }

                override fun onCancelled(error: DatabaseError) {
                Log.w("TAG", "Failed to read value.", error.toException())
                }

            })


        }


    }




}