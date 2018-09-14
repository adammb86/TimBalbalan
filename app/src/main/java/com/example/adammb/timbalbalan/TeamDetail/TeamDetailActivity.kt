package com.example.adammb.timbalbalan.TeamDetail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.adammb.timbalbalan.R
import com.example.adammb.timbalbalan.TeamList.Team
import kotlinx.android.synthetic.main.abc_activity_chooser_view.view.*
import org.jetbrains.anko.*

class TeamDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)

        initData()
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

    class TeamDetailActivity : AnkoContext<TeamDetailActivity>{
        override fun createView(ui: AnkoContext<TeamDetailActivity>) = with(ui) {
            verticalLayout(){
                padding = dip(16)

                imageView(){
                    setImageResource()
                }
            }
        }
    }
}
