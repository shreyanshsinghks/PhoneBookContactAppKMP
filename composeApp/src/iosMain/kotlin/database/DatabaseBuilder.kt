package database
import androidx.room.Database
import androidx.room.RoomDatabase

fun getDatabaseBuilder(): AppDatabase {
    val dbFilePath = NSHomeDirectory() + "/my_room.db"
    return Room.databaseBuilder<AppDatabase>(
        name = dbFilePath,
        factory =  { AppDatabase::class.instantiateImpl() }
    ).setDriver(BundledSQLiteDriver()).build()
}