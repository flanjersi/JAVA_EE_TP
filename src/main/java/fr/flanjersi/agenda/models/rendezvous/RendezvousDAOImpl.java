package fr.flanjersi.agenda.models.rendezvous;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Implemented DAO of the "Rendezvous" Bean with JDBC
 */
@Transactional
@Repository
public class RendezvousDAOImpl implements RendezvousDAO {

    /**
     * JdbcTemplate to request database
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Class to transform a resultset line in "Rendezvous" Bean
     */
    private class RowMapperRendezvous implements RowMapper<Rendezvous> {

        @Override
        public Rendezvous mapRow(ResultSet resultSet, int i) throws SQLException {
            Rendezvous rendezvous = new Rendezvous();

            rendezvous.setId(resultSet.getInt("id"));
            rendezvous.setDuration(resultSet.getInt("duration"));
            rendezvous.setType(resultSet.getString("type_rendezvous"));
            rendezvous.setPlace(resultSet.getString("place"));

            List<String> listNames = new ArrayList<>();
            for(String str : resultSet.getString("names_people").split(";")){
                listNames.add(str);
            }

            rendezvous.setNames(listNames);

            return rendezvous;
        }
    }

    @Override
    public void create(Rendezvous rendezvous) {
        String rSQL = "INSERT INTO RENDEZVOUS (duration, names_people, place, type_rendezvous) VALUES (?, ?, ?, ?)";


        jdbcTemplate.update(
                rSQL,
                rendezvous.getDuration(),
                String.join(";", rendezvous.getNames()),
                rendezvous.getPlace(),
                rendezvous.getType()
        );
    }

    @Override
    public void update(Rendezvous rendezvous) {
        String rSQL = "UPDATE RENDEZVOUS " +
                "SET duration = ? " +
                "AND names_people = ? " +
                "AND place = ? " +
                "AND type_rendezvous = ? " +
                "WHERE id = ?";

        jdbcTemplate.update(
                rSQL,
                rendezvous.getDuration(),
                String.join(";", rendezvous.getNames()),
                rendezvous.getPlace(),
                rendezvous.getType(),
                rendezvous.getId()
        );
    }

    @Override
    public void delete(Rendezvous rendezvous) {
        String rSQL = "DELETE FROM RENDEZVOUS WHERE id = ?";

        jdbcTemplate.update(
                rSQL,
                rendezvous.getId()
        );
    }

    @Override
    public List<Rendezvous> findAllRendezvous() {
        String rSQL = "SELECT * FROM RENDEZVOUS";

        RowMapper<Rendezvous> rowMapper = new BeanPropertyRowMapper<>(Rendezvous.class);

        List<Rendezvous> rendezvousList = jdbcTemplate.query(rSQL, new RowMapperRendezvous());

        return rendezvousList;
    }

    @Override
    public List<Rendezvous> findRendezvousByTypes(String... types) {
        if(types.length == 0) return new ArrayList<>();

        String rSQL = "SELECT * FROM RENDEZVOUS WHERE type_rendezvous in (" + String.join(", ", types) + ") ";

        RowMapper<Rendezvous> rowMapper = new BeanPropertyRowMapper<>(Rendezvous.class);

        List<Rendezvous> rendezvousList = jdbcTemplate.query(rSQL, new RowMapperRendezvous());

        return rendezvousList;
    }


}
