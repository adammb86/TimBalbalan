package com.example.adammb.timbalbalan.TeamList

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Team (val teamName:String?, val teamLogo: Int?, val teamInfo: String?): Parcelable