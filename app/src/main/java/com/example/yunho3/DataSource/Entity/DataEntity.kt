package com.example.yunho3.DataSource.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val Data : String
)
