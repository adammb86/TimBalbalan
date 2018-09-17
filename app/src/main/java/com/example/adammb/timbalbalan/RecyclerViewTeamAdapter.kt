package com.example.adammb.timbalbalan

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.adammb.timbalbalan.TeamList.Team
import org.jetbrains.anko.*

class RecyclerViewTeamAdapter(private val context: Context,
                              private val teams: List<Team>,
                              private val listener: (Team) -> Unit)
    : RecyclerView.Adapter<RecyclerViewTeamAdapter.ViewHolder>() {

    companion object {
        val logoTeamId = 1
        val nameTeamId = 2
    }

    class RecyclerViewTeamUI : AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
            linearLayout {
                horizontalPadding = dip(16)
                verticalPadding = dip(8)

                imageView {
                    id = logoTeamId
                }.lparams(width = dip(50), height = dip(50))

                textView {
                    id = nameTeamId
                }.lparams {
                    gravity = Gravity.CENTER_VERTICAL
                    horizontalMargin = dip(16)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(RecyclerViewTeamUI().createView(AnkoContext.create(parent.context, parent)))

    override fun getItemCount(): Int = teams.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(teams[position], listener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewTeamName = itemView.findViewById<TextView>(RecyclerViewTeamAdapter.nameTeamId)
        val imageViewTeamLogo = itemView.findViewById<ImageView>(RecyclerViewTeamAdapter.logoTeamId)

        fun bindItem(team: Team, listener: (Team) -> Unit) {
            textViewTeamName.text = team.teamName
            Glide.with(itemView.context)
                    .load(team.teamLogo)
                    .apply(RequestOptions().override(100, 100))
                    .into(imageViewTeamLogo)

            itemView.setOnClickListener {
                listener(team)
            }
        }
    }
}