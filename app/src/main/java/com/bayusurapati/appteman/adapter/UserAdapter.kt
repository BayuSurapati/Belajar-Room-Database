package com.bayusurapati.appteman.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bayusurapati.appteman.R
import com.bayusurapati.appteman.data.entiy.User
import kotlinx.android.synthetic.main.row_user.view.*

class UserAdapter(var list: List<User>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        var fullName: TextView
        var email: TextView
        var kelamin: TextView
        var telepon: TextView
        var alamat: TextView
        init{
            fullName = view.full_name
            email = view.email
            kelamin = view.kelamin
            telepon = view.telepon
            alamat = view.alamat
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fullName.text = list[position].fullName
        holder.email.text = list[position].email
        holder.kelamin.text = list[position].kelamin
        holder.telepon.text = list[position].telp
        holder.alamat.text = list[position].alamat
    }

    override fun getItemCount(): Int {
        return list.size
    }
}