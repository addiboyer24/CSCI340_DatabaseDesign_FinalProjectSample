package App.Infrastructure;

import App.Domain.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AttractionRepository implements IAttractionRepository {

    private JdbcTemplate databaseConnection;

    @Override
    public void setDatabaseConnection(JdbcTemplate databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
    @Override
    public Attraction create(Attraction attraction) {
        return null;
    }

    @Override
    public int update(String id, Attraction attraction) {
        return 0;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Attraction> get(String id) {
        String sql = "SELECT * FROM UNIVERSITY.ATTRACTION WHERE name = '" + id + "';";
        List<Attraction> attractions = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Attraction.class));
        for (Attraction attraction : attractions){
            sql = "SELECT * FROM UNIVERSITY.AGERESTRICTION AR\n" +
                    "INNER JOIN UNIVERSITY.RESTRICTION R\n" +
                    "ON AR.Id = R.Id\n" +
                    "WHERE R.AttractionName = '" + attraction.getName() + "';";
            List<AgeRestriction> ageRestrictions = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(AgeRestriction.class));
            attraction.setAgeRestrictions(ageRestrictions);

            sql = "SELECT * FROM UNIVERSITY.HEIGHTRESTRICTION HR\n" +
                    "INNER JOIN UNIVERSITY.RESTRICTION R\n" +
                    "ON HR.Id = R.Id\n" +
                    "WHERE R.AttractionName = '" + attraction.getName() + "';";

            List<HeightRestriction> heightRestrictions = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(HeightRestriction.class));
            attraction.setHeightRestrictions(heightRestrictions);
        }

        return attractions;
    }

    @Override
    public List<Attraction> get() {
        String sql = "SELECT * FROM UNIVERSITY.ATTRACTION;";
        List<Attraction> attractions = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Attraction.class));
        for (Attraction attraction : attractions){
            sql = "SELECT * FROM UNIVERSITY.AGERESTRICTION AR\n" +
                    "INNER JOIN UNIVERSITY.RESTRICTION R\n" +
                    "ON AR.Id = R.Id\n" +
            "WHERE R.AttractionName = '" + attraction.getName() + "';";
            List<AgeRestriction> ageRestrictions = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(AgeRestriction.class));
            attraction.setAgeRestrictions(ageRestrictions);

            sql = "SELECT * FROM UNIVERSITY.HEIGHTRESTRICTION HR\n" +
                    "INNER JOIN UNIVERSITY.RESTRICTION R\n" +
                    "ON HR.Id = R.Id\n" +
                    "WHERE R.AttractionName = '" + attraction.getName() + "';";

            List<HeightRestriction> heightRestrictions = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(HeightRestriction.class));
            attraction.setHeightRestrictions(heightRestrictions);
        }

        return attractions;
    }
}
