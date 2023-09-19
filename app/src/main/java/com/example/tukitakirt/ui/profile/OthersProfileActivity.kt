package com.example.tukitakirt.ui.profile
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import coil.load
import com.example.tukitakirt.databinding.ActivityOthersProfileBinding
import dagger.hilt.android.AndroidEntryPoint


//Cs-43
@AndroidEntryPoint
class OthersProfileActivity : AppCompatActivity() {


    //CS-46
    companion object{

        const val USER_KEY="user_key_id"     //pw-2


    }


    lateinit var binding: ActivityOthersProfileBinding
    private val viewModel: ProfileViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityOthersProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.getStringExtra(USER_KEY)?.let {      //CS-48  //pw-4   //instead of line 39

            viewModel.getUserById(it)

        }


//        val user = FirebaseAuth.getInstance().currentUser
//        user?.let {
//               viewModel.getUserById(it.uid)
//        }


        viewModel.responseUserProfile.observe(this) {

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