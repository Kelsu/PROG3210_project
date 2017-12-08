package ca.on.conestogac.kjproject.Classes;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by Kelsey on 12/07/17.
 */

@Entity(tableName = "habits",
        foreignKeys = {
                @ForeignKey(
                        entity = Files.class,
                        parentColumns = "fileID",
                        childColumns = "fileID",
                        onDelete = ForeignKey.CASCADE
                )},
        indices = { @Index(value = "fileID")})
public class Habits {

    @PrimaryKey(autoGenerate = true)
    public long habitID;
    public long fileID;
    public String habit;

    //@Ignore
    //public Date date;

    public Habits(long fileID, String habit) {
        this.fileID = fileID;
        this.habit = habit;
        //this.date = new Date(System.currentTimeMillis());
    }
}
