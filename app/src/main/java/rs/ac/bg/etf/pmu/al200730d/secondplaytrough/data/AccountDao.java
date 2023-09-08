package rs.ac.bg.etf.pmu.al200730d.secondplaytrough.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface AccountDao {

    @Insert
    long insert(Account account);

    @Query("SELECT * FROM account WHERE username = :username")
    Account findByUsername(String username);

    @Query("SELECT * FROM account WHERE username = :username AND password = :passwordHash")
    Account findByCredentials(String username, String passwordHash);

}
