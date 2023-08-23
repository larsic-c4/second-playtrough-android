package rs.ac.bg.etf.pmu.al200730d.secondplaytrough.data;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface GameDao {
    @Insert
    long insert(Game playedGame);
}
