package com.example.adammb.timbalbalan.TeamList

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.adammb.timbalbalan.R
import com.example.adammb.timbalbalan.RecyclerViewTeam
import com.example.adammb.timbalbalan.TeamDetail.TeamDetailActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {
    private var teams: MutableList<Team> = mutableListOf()

    companion object {
        val listTeamId = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initData()

        val adapter = RecyclerViewTeam(this, teams) { team ->
            startActivity<TeamDetailActivity>("team" to team)
        }

        MainActivityUI(adapter).setContentView(this)
    }

    class MainActivityUI(val recylerViewAdapter: RecyclerViewTeam) : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                recyclerView {
                    id = listTeamId
                    layoutManager = LinearLayoutManager(context)
                    adapter = recylerViewAdapter
                }.lparams(width = matchParent, height = matchParent)
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
