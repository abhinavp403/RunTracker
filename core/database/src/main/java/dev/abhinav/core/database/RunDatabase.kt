package dev.abhinav.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.abhinav.core.database.dao.RunDao
import dev.abhinav.core.database.entity.RunEntity

@Database(
    entities = [RunEntity::class],
    version = 1,
)
abstract class RunDatabase : RoomDatabase() {

    abstract fun runDao(): RunDao
}