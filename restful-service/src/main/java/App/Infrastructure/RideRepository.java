package App.Infrastructure;

import App.Domain.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RideRepository implements IRideRepository {

    private JdbcTemplate databaseConnection;
    @Override
    public void setDatabaseConnection(JdbcTemplate databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
    @Override
    public Ride create(Ride ride) {
        String sql = "INSERT INTO UNIVERSITY.RIDE VALUES ('" + ride.getAttractionName() + "', '" + ride.getRiderEmail() + "', '" + ride.getBoardingTime() + "');";
        this.databaseConnection.execute(sql);
        return ride;
    }

    @Override
    public int update(String id, Ride rider) {
        return 0;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Ride> get(String id) {
        return null;
    }

    @Override
    public List<Ride> get() {
        return null;
    }
}
