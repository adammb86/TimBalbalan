package com.example.adammb.timbalbalan.TeamDetail

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import org.jetbrains.anko.*

class TeamDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val teamName: String = intent.extras.getString("teamName")
        val teamLogo = intent.extras.getInt("teamLogo")
        val teamInfo = intent.extras.getString("teamInfo")

        TeamDetailActivityUI(teamName, teamLogo, teamInfo).setContentView(this)
    }

    class TeamDetailActivityUI(val teamName: String, val teamLogo: Int, val teamInfo: String) :
            AnkoComponent<TeamDetailActivity> {
        override fun createView(ui: AnkoContext<TeamDetailActivity>) = with(ui) {
            verticalLayout {
                padding = dip(16)
                gravity = Gravity.CENTER_HORIZONTAL

                imageView {
                    imageResource = teamLogo
                }.lparams(width = matchParent, height = dip(100)) {
                    verticalMargin = dip(8)
                }

                textView(teamName) {
                    textSize = sp(12).toFloat()
                    textColor = Color.BLACK
                    gravity = Gravity.CENTER_HORIZONTAL
                }

                scrollView {


                    textView(teamInfo) {
                        textSize = sp(8).toFloat()
                    }.lparams {
                        verticalMargin = dip(16)
                    }
                }.lparams(width = matchParent, height = wrapContent)
            }
        }
    }
}
