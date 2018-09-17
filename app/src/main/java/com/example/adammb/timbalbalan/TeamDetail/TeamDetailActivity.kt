package com.example.adammb.timbalbalan.TeamDetail

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.adammb.timbalbalan.TeamList.Team
import org.jetbrains.anko.*

class TeamDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val team = intent.extras.getParcelable<Team>("team")

        TeamDetailActivityUI(team).setContentView(this)
    }

    class TeamDetailActivityUI(val team: Team) : AnkoComponent<TeamDetailActivity> {
        override fun createView(ui: AnkoContext<TeamDetailActivity>) = with(ui) {
            verticalLayout {
                padding = dip(16)
                gravity = Gravity.CENTER_HORIZONTAL

                imageView {
                    Glide.with(context)
                            .load(team.teamLogo)
                            .apply(RequestOptions().override(100, 100))
                            .into(this)
                }.lparams(width = matchParent, height = dip(100)) {
                    verticalMargin = dip(8)
                }

                textView(team.teamName) {
                    textSize = sp(12).toFloat()
                    textColor = Color.BLACK
                    gravity = Gravity.CENTER_HORIZONTAL
                }

                scrollView {
                    textView(team.teamInfo) {
                        textSize = sp(8).toFloat()
                    }.lparams {
                        verticalMargin = dip(16)
                    }
                }.lparams(width = matchParent, height = wrapContent)
            }
        }
    }
}

