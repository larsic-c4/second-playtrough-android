package rs.ac.bg.etf.pmu.al200730d.secondplaytrough.data;

import java.util.List;

import javax.inject.Inject;

public class AppRepository {
    
    GameDao gameDao;
    AccountDao accountDao;

    @Inject
    public AppRepository(GameDao gameDao, AccountDao accountDao) {
        this.gameDao = gameDao;
        this.accountDao = accountDao;
    }

    public long insert(Account account) {
        return accountDao.insert(account);
    }

    public Account findByUsername(String username) {
        return accountDao.findByUsername(username);
    }

    public Account findByCredentials(String username, String password) {
        String passwordHash = GamesDatabase.generateSHA256Hash(password);
        return accountDao.findByCredentials(username, passwordHash);
    }

    public List<Game> getByAccountIdOrderByPlayerName(long accountId) {
        return gameDao.getByAccountIdOrderByPlayerName(accountId);
    }

}
