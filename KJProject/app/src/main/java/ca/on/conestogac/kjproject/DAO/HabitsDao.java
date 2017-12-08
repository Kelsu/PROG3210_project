package ca.on.conestogac.kjproject.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import ca.on.conestogac.kjproject.Classes.Habits;

/**
 * Created by Kelsey on 12/07/17.
 */

@Dao
public interface HabitsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addHabit(Habits habits);

    @Query("select * from habits")
    public List<Habits> getAllHabits();

    @Query("select * from habits where fileID = :fileID")
    public Habits getHabit(long fileID);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateHabit(Habits habits);

    @Query("delete from habits")
    void removeAllHabits();
}
