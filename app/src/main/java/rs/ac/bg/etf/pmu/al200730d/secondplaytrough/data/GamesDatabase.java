package rs.ac.bg.etf.pmu.al200730d.secondplaytrough.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@TypeConverters(value = {DateConverter.class})
@Database(entities = {Account.class, Game.class}, version = 1, exportSchema = false)
public abstract class GamesDatabase extends RoomDatabase {
    public abstract AccountDao accountDao();

    public abstract GameDao gameDao();

    static private GamesDatabase instance = null;

    static public GamesDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (GamesDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            GamesDatabase.class, "mucenik.db").allowMainThreadQueries().build();
                }
            }
        }
        return instance;
    }

    public static String generateSHA256Hash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            BigInteger hashInt = new BigInteger(1, hashBytes);
            return hashInt.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
