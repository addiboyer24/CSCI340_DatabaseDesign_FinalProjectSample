package App.Infrastructure;

import App.Domain.AttractionHistory;
import App.Domain.IAttractionHistoryRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AttractionHistoryRepository implements IAttractionHistoryRepository {
    private JdbcTemplate databaseConnection;

    @Override
    public AttractionHistory create(AttractionHistory attractionHistory) {
        String sql = "INSERT INTO UNIVERSITY.ATTRACTIONHISTORY\n" +
                "VALUES ('"
                + attractionHistory.getAttractionName() + "', '"
                + attractionHistory.getHistoryDate()  + "', '"
                + attractionHistory.getDescription() + "');";
        this.databaseConnection.execute(sql);
        return attractionHistory;
    }

    @Override
    public int update(String id, AttractionHistory attractionHistory) {
        return 0;
    }

    public int update(String attractionName, String historyDate, AttractionHistory attractionHistory){
        String sql = "UPDATE UNIVERSITY.ATTRACTIONHISTORY SET AttractionName = '" + attractionHistory.getAttractionName() + "',"
                + "HistoryDate = '" + attractionHistory.getHistoryDate() + "',"
                + "Description = '" + attractionHistory.getDescription() + "' " +
                "WHERE AttractionName = '" + attractionName + "' AND HistoryDate = '" + historyDate + "';";
        int rows = this.databaseConnection.update(sql);
        return rows;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    public boolean delete(String attractionName, String historyDate){
        String sql = "DELETE FROM UNIVERSITY.ATTRACTIONHISTORY" +
                " WHERE AttractionName = '" + attractionName + "' AND HistoryDate = '" + historyDate + "';";
        this.databaseConnection.execute(sql);
        return true;
    }

    @Override
    public List<AttractionHistory> get(String id) {
        String sql = "SELECT * FROM UNIVERSITY.ATTRACTIONHISTORY WHERE AttractionName = '" + id + "';";
        List<AttractionHistory> histories = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(AttractionHistory.class));
        return histories;
    }

    @Override
    public List<AttractionHistory> get() {
        String sql = "SELECT * FROM UNIVERSITY.ATTRACTIONHISTORY;";
        List<AttractionHistory> histories = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(AttractionHistory.class));
        return histories;
    }

    @Override
    public void setDatabaseConnection(JdbcTemplate databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
}
