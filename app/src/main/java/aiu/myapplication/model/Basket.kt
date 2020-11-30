package aiu.myapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Basket(

    val id: Int,

    val title: String?,

    val price: String?,


)