package com.example.tukitakirt.ui.user
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.tukitakirt.data.user.UserProfile
import com.example.tukitakirt.databinding.ItemUserBinding

//CS 41
class UserAdapter (private val  listener: Listener):  //cs44
    ListAdapter<UserProfile,UserAdapter.UserViewHolder>(Comparator){


    //Cs 44-1
    interface  Listener{
        fun profileClicked(userId:String)

    }

    class UserViewHolder(val itemUserBinding: ItemUserBinding) : RecyclerView.ViewHolder(itemUserBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {


        return  UserViewHolder( ItemUserBinding.inflate (LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

              getItem(position).let {
                  holder.itemUserBinding.apply {
                      userNameTv.text=it.name
                      userEmailTv.text=it.email
                      userBioTv.text =it.about
                      //profileImage.load(it.image)

                  }

                  //Cs-44.2
                  holder.itemUserBinding.profileBtn.setOnClickListener{_ ->   //this symbol protect to error

                      listener.profileClicked(it.userId!!)

                  }

              }
        }




    //2 id compare

    companion object{
        val Comparator=object : DiffUtil.ItemCallback<UserProfile>(){
            override fun areItemsTheSame(oldItem: UserProfile, newItem: UserProfile): Boolean {
                return oldItem==newItem
            }

            override fun areContentsTheSame(oldItem: UserProfile, newItem: UserProfile): Boolean {

                return  oldItem.userId==newItem.userId

            }


        }



    }


}