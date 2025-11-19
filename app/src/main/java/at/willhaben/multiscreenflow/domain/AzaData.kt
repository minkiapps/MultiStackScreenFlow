package at.willhaben.multiscreenflow.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AzaData(val title : String, val description : String) : Parcelable