package ca.on.conestogac.kjproject.Database;

import android.content.Context;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import ca.on.conestogac.kjproject.Classes.Habits;
import ca.on.conestogac.kjproject.Classes.Users;
import ca.on.conestogac.kjproject.Classes.Files;

import ca.on.conestogac.kjproject.DAO.HabitsDao;
import ca.on.conestogac.kjproject.DAO.UsersDao;
import ca.on.conestogac.kjproject.DAO.FilesDAO;

/**
 * Created by Kelsey on 12/01/17.
 */
@Database(entities = {Users.class, Files.class, Habits.class,
}, version = 19, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

        private static AppDatabase INSTANCE;

        public abstract UsersDao usersDao();
        public abstract FilesDAO filesDao();
        public abstract HabitsDao habitsDao();

        public static AppDatabase getDatabase(Context context) {
            if (INSTANCE == null) {
                INSTANCE =
                        Room.databaseBuilder(context, AppDatabase.class, "usersdatabase")
//Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                                // To simplify the exercise, allow queries on the main thread.
                                // Don't do this on a real app!
                                .allowMainThreadQueries()
                                // recreate the database if necessary
                                .fallbackToDestructiveMigration()
                                .build();
            }
            return INSTANCE;
        }

        public static void destroyInstance() {
            INSTANCE = null;
        }
}
