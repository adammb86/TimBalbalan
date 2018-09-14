package com.example.adammb.timbalbalan.TeamList

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.adammb.timbalbalan.R
import com.example.adammb.timbalbalan.RecyclerViewTeam
import com.example.adammb.timbalbalan.TeamDetail.TeamDetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import kotlinx.android.synthetic.main.item_team.view.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {
    private var teams: MutableList<Team> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        team_list.layoutManager = LinearLayoutManager(this)
        team_list.adapter = RecyclerViewTeam(this, teams) {
            val toast = Toast.makeText(applicationContext, it.teamName, Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    class MainActivityUI : AnkoContext<MainActivity>{
        override fun createView(ui: AnkoContext<TeamDetailActivity.TeamDetailActivity>) = with(ui) {
            verticalLayout(){
                padding = dip(16)

                recyclerView(){

                }
            }
        }
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val info = resources.getStringArray(R.array.club_detail)
        teams.clear()

        for (i in name.indices) {
            teams.add(Team(name[i], image.getResourceId(i, 0), info[i]))
        }

        image.recycle()
    }

}
