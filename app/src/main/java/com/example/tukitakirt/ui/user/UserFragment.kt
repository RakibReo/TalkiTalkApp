package com.example.tukitakirt.ui.user
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tukitakirt.base.BaseFragment
import com.example.tukitakirt.databinding.FragmentUserBinding
import dagger.hilt.android.AndroidEntryPoint


//CS-28

@AndroidEntryPoint

class UserFragment : BaseFragment<FragmentUserBinding>(FragmentUserBinding::inflate) {

    //CS 42
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }



}