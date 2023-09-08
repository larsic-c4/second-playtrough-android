package rs.ac.bg.etf.pmu.al200730d.secondplaytrough.data;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public interface DatabaseModule {

    @Provides
    static AccountDao provideAccountDao(@ApplicationContext Context context) {
        return GamesDatabase.getDatabase(context).accountDao();
    }
    @Provides
    static GameDao provideGameDao(@ApplicationContext Context context) {
        return GamesDatabase.getDatabase(context).gameDao();
    }
}
