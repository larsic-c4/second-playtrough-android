package rs.ac.bg.etf.pmu.al200730d.secondplaytrough.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GameDao {
    @Insert
    long insert(Game playedGame);

    @Query("SELECT * FROM game WHERE account_id = :accountId ORDER BY player_a_name, player_b_name")
    List<Game> getByAccountIdOrderByPlayerName(long accountId);

}
