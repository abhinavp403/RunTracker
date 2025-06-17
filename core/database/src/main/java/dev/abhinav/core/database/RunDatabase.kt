package dev.abhinav.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.abhinav.core.database.dao.RunDao
import dev.abhinav.core.database.entity.DeletedRunSyncEntity
import dev.abhinav.core.database.entity.RunEntity
import dev.abhinav.core.database.entity.RunPendingSyncEntity

@Database(
    entities = [
        RunEntity::class,
        RunPendingSyncEntity::class,
        DeletedRunSyncEntity::class
       ],
    version = 1,
)
abstract class RunDatabase : RoomDatabase() {

    abstract val runDao: RunDao
    abstract val runPendingSyncEntity: RunPendingSyncEntity
}