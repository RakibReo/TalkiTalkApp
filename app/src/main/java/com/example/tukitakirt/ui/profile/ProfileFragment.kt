package com.example.tukitakirt.ui.profile
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.tukitakirt.R
import com.example.tukitakirt.base.BaseFragment
import com.example.tukitakirt.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.AndroidEntryPoint


//CS-36

@AndroidEntryPoint

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    private val viewModel: ProfileViewModel by viewModels()
    lateinit var user: FirebaseUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

      user = FirebaseAuth.getInstance().currentUser!!
        user.let {
            viewModel.getUserById(it.uid)
        }


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val auth = FirebaseAuth.getInstance()


        binding. logoutBtn.setOnClickListener {


            auth.signOut()

            findNavController().navigate(R.id.loginFragment)


        }

        viewModel.responseUserProfile.observe(viewLifecycleOwner) {
    Log.i("TAG","Data{$it}")
            binding.apply {
                userName.text = it.name
                userEmail.text = it.email
                userAbout.text = it.about
                profileImage.load(it.image)
                coverImage.load(it.image)






            }


        }


    }






}