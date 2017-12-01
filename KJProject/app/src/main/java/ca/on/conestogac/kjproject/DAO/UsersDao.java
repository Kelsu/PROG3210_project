package ca.on.conestogac.kjproject.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import ca.on.conestogac.kjproject.Classes.Users;

/**
 * Created by Kelsey on 12/01/17.
 */

@Dao
public interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addUser(Users users);

    @Query("select * from users")
    public List<Users> getAllUser();

    @Query("select * from users where userID = :userID")
    public List<Users> getUser(long userID);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateUser(Users users);

    @Query("delete from users")
    void removeAllUsers();
}
