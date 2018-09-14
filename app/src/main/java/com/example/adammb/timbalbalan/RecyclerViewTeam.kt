package com.example.adammb.timbalbalan

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.adammb.timbalbalan.TeamList.Team
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_team.view.*

class RecyclerViewTeam(private val context: Context, private val teams: List<Team>, private val listener: (Team) -> Unit)
    : RecyclerView.Adapter<RecyclerViewTeam.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val imageLogoTeamId = 1
        val imageNameTeamId = 2

        ImageView(){

            id = imageLogoTeamId
        }

        <ImageView
        android:id = "@+id/team_logo"
        android:layout_width = "50dp"
        android:layout_height = "50dp"
        android:src = "@drawable/img_barca" />

        <TextView
        android:id = "@+id/team_name"
        android:layout_width = "wrap_content"
        android:layout_height = "wrap_content"
        android:layout_gravity = "center_vertical"
        android:layout_margin = "10dp"
        tools:text = "Barcelona FC" />
    }

    override fun getItemCount(): Int = teams.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(teams[position], listener)
    }

    class ViewHolder(containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        override val containerView: View?
            get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

        fun bindItem(teams: Team, listener: (Team) -> Unit) {
            itemView.team_name.text = teams.teamName
            Glide.with(itemView.context).load(teams.teamLogo).into(itemView.team_logo)

            itemView.setOnClickListener {
                listener(teams)
            }
        }
    }
}