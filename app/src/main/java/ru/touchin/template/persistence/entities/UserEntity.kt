package ru.touchin.template.persistence.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(

        @PrimaryKey
        val uid: String = "",

        @ColumnInfo(name = "session_id")
        var sessionId: String?

)
