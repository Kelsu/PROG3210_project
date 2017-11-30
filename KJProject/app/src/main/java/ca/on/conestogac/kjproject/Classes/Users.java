package ca.on.conestogac.kjproject.Classes;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


/**
 * Created by Kelsey on 11/30/17.
 */

@Entity
public class Users {
    @PrimaryKey
    public final int userID;
    public String username;
    public String password;


    public Users(int userID, String username, String password){
        this.userID = userID;
        this.username = username;
        this.password = password;
    }
}