package ru.touchin.template.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.touchin.template.persistence.entities.UserEntity

@Database(version = 1, entities = [UserEntity::class], exportSchema = false)
abstract class Database : RoomDatabase()
