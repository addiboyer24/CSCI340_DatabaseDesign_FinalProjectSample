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
        return null;
    }

    @Override
    public int update(String id, AttractionHistory attractionHistory) {
        return 0;
    }

    @Override
    public boolean delete(String id) {
        return false;
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
