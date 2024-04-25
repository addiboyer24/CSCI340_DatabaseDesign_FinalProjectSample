package App.Infrastructure;

import App.Domain.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RiderRepository implements IRiderRepository {

    private JdbcTemplate databaseConnection;
    @Override
    public void setDatabaseConnection(JdbcTemplate databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
    @Override
    public Rider create(Rider rider) {
        return null;
    }

    @Override
    public int update(String id, Rider rider) {
        String sql = "UPDATE UNIVERSITY.RIDER SET tickets = " + rider.getTickets() + " WHERE email = '" + rider.getEmail() + "';";
        int rows = this.databaseConnection.update(sql);
        return rows;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Rider> get(String id) {
        String sql = "SELECT *, CASE WHEN DATEPART(d, DateOfBirth) = DATEPART(d, GETDATE()) THEN 1 ELSE 0 END AS IsBirthday, DATEDIFF(YEAR, dateOfBirth, GETDATE()) - \n" +
                "    CASE" +
                "        WHEN DATEADD(YY, DATEDIFF(YEAR, dateOfBirth, GETDATE()), dateOfBirth) > GETDATE() THEN 1\n" +
                "        ELSE 0" +
                "    END AS Age FROM UNIVERSITY.RIDER " +
                "WHERE Email = '" + id + "';";
        List<Rider> riders = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Rider.class));
        return riders;
    }

    @Override
    public List<Rider> get() {
        String sql = "SELECT *, CASE WHEN DATEPART(d, DateOfBirth) = DATEPART(d, GETDATE()) THEN 1 ELSE 0 END AS IsBirthday, DATEDIFF(YEAR, dateOfBirth, GETDATE()) - \n" +
                "    CASE" +
                "        WHEN DATEADD(YY, DATEDIFF(YEAR, dateOfBirth, GETDATE()), dateOfBirth) > GETDATE() THEN 1\n" +
                "        ELSE 0" +
                "    END AS Age FROM UNIVERSITY.RIDER;";
        List<Rider> riders = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Rider.class));
        return riders;
    }
}
