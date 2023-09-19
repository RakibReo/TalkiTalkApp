package com.example.tukitakirt.ui.user
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.example.tukitakirt.base.BaseFragment
import com.example.tukitakirt.databinding.FragmentUserBinding
import com.example.tukitakirt.ui.profile.OthersProfileActivity
import com.example.tukitakirt.ui.profile.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint


//CS-28

@AndroidEntryPoint

class UserFragment : BaseFragment<FragmentUserBinding>(FragmentUserBinding::inflate),UserAdapter.Listener {   //Cs45

    //CS 42

    private val viewModel: ProfileViewModel by viewModels()
    private lateinit var  adapter: UserAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapter=UserAdapter(this)   //cs45

        viewModel.getAllUser()
        viewModel.responseAllUserProfile.observe(viewLifecycleOwner){


            Log.d("TAGT","DATA: {$it}")


         adapter.submitList(it)


            binding.userRCV.adapter=adapter

        }


    }


    //cs45
    override fun profileClicked(userId: String) {

        val intent = Intent(requireContext(),OthersProfileActivity::class.java)  //CS
         intent.putExtra(OthersProfileActivity.USER_KEY,userId)     //putextra work(pw)-1+pw3 ==this activity data go to OthersProfileActivity
       startActivity(intent)
    }


}