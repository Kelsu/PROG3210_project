package ca.on.conestogac.kjproject.Classes;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Kelsey on 12/04/17.
 */
@Entity(tableName = "files",
        foreignKeys = {
                @ForeignKey(
                        entity = Users.class,
                        parentColumns = "userID",
                        childColumns = "userID",
                        onDelete = ForeignKey.CASCADE
                )},
        indices = { @Index(value = "userID")})

public class Files {

    @PrimaryKey(autoGenerate = true)
    public long fileID;
    public int userID;
    public String name;

    public Files(int userID, String name) {
        this.userID = userID;
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
