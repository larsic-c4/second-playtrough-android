package rs.ac.bg.etf.pmu.al200730d.secondplaytrough.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "game", foreignKeys = @ForeignKey(entity = Account.class,
        parentColumns = "id", childColumns = "account_id", onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE),
        indices = {@Index("account_id")})
public class Game {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "account_id")
    private long accountId;
    @ColumnInfo(name = "player_a_name")
    private String playerAName;
    @ColumnInfo(name = "player_b_name")
    private String playerBName;
    @ColumnInfo(name = "player_a_score")
    private int playerAScore;
    @ColumnInfo(name = "player_b_score")
    private int playerBScore;
    private Date date;

    public Game(long id, long accountId, String playerAName, String playerBName, int playerAScore, int playerBScore, Date date) {
        this.id = id;
        this.accountId = accountId;
        this.playerAName = playerAName;
        this.playerBName = playerBName;
        this.playerAScore = playerAScore;
        this.playerBScore = playerBScore;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getPlayerAName() {
        return playerAName;
    }

    public void setPlayerAName(String playerAName) {
        this.playerAName = playerAName;
    }

    public String getPlayerBName() {
        return playerBName;
    }

    public void setPlayerBName(String playerBName) {
        this.playerBName = playerBName;
    }

    public int getPlayerAScore() {
        return playerAScore;
    }

    public void setPlayerAScore(int playerAScore) {
        this.playerAScore = playerAScore;
    }

    public int getPlayerBScore() {
        return playerBScore;
    }

    public void setPlayerBScore(int playerBScore) {
        this.playerBScore = playerBScore;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
