package database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1, exportSchema = true)
abstract class ContactAppDatabase: RoomDatabase(){
    abstract fun getDao(): ContactDao
}
