package rs.ac.bg.etf.pmu.al200730d.secondplaytrough.data;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(indices = {@Index("id"), @Index(value = "username", unique = true)})
public class Account {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String username;
    private String password;
    private String image;

    public Account(long id, String username, String password, String image) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
