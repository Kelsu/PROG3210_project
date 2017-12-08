package ca.on.conestogac.kjproject.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import ca.on.conestogac.kjproject.Classes.Files;

/**
 * Created by Kelsey on 12/05/17.
 */

@Dao
public interface FilesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addFile(Files files);

    @Query("select * from files")
    public List<Files> getAllFiles();

    @Query("select * from files where fileID = :fileID")
    public Files getFiles(long fileID);

    @Query("select * from files where userID = :userID")
    public List<Files> selectFiles(int userID);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateFiles(Files files);

    @Query("delete from files")
    void removeAllFiles();
}
