package database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import dao.BookDao;
import entity.BookInfo;


@Database(entities = {BookInfo.class},version = 1, exportSchema = false)
public abstract class BookDatabase extends RoomDatabase {
    public abstract BookDao bookDao();
}
