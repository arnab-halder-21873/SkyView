package com.rocketman.storeroom.entity.DbObject;

import lombok.*;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor
@Table(name="users")
public class UserObject {

    @Getter(AccessLevel.NONE)
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    @NonNull
    @Getter(AccessLevel.MODULE)
    private String userName;
    @Column(name = "email", nullable = false)
    @NonNull
    @Getter(AccessLevel.MODULE)
    private String emailID;
    @Column(name = "password", nullable = false)
    @NonNull
    @Getter(AccessLevel.MODULE)
    private char[] hashedPassword;
    @Column(name = "primaryLoc")
    private String primaryLocation;
    @Column(name = "CurrentLoc")
    private String currentLocation;
    @Column(name = "currentLocFlag")
    private boolean curLocSameAsPrimLoc;

    public UserObject(@NonNull String userName, @NonNull String emailID, @NonNull char[] hashedPassword, String primaryLocation, boolean curLocSameAsPrimLoc) {
        this.userName = userName;
        //TODO whenever the emailID will be stored it will be encrypted
        this.emailID = emailID;
        //TODO whenever the password is stored it will be hashed with salt
        //Proposed solution: when password is to be changed, drop old user and create new with new UserID
        this.hashedPassword = hashedPassword;
        this.primaryLocation = primaryLocation;
        this.curLocSameAsPrimLoc = curLocSameAsPrimLoc;
    }

    @Override
    public String toString() {
        return "UserObject{" +
                "userID=" + id +
                ", userName='" + userName + '\'' +
                ", primaryLocation='" + primaryLocation + '\'' +
                ", currentLocation='" + currentLocation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserObject that = (UserObject) o;
        return id == that.id && userName.equals(that.userName) && emailID.equals(that.emailID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName);
    }
}
