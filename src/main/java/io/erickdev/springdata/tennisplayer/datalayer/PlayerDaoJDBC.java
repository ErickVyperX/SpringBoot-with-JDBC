package io.erickdev.springdata.tennisplayer.datalayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Qualifier("JdbcImplementation")
public class PlayerDaoJDBC implements PlayerDAO{
    private final JdbcTemplate jdbcTemplate;
    private static final String SQL_SELECT = "SELECT * FROM PLAYER";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM PLAYER WHERE ID = ?";
    private static final String SQL_SELECT_BY_NATIONALITY = "SELECT * FROM PLAYER WHERE NATIONALITY = ?";
    private static final String SQL_INSERT = "INSERT INTO PLAYER VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE PLAYER SET NAME = ?, NATIONALITY = ?, BIRTH_DATE = ?, TITLES = ? WHERE ID = ?";
    private static final String SQL_DELETE = "DELETE FROM PLAYER WHERE ID = ?";
    private static final String SQL_CREATE= "CREATE TABLE TOURNAMENT (ID INTEGER, NAME VARCHAR(50), LOCATION VARCHAR(50), PRIMARY KEY (ID))";


    @Autowired
    public PlayerDaoJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Player> selectAllPlayers() {
        return jdbcTemplate.query(SQL_SELECT, new BeanPropertyRowMapper<>(Player.class));
    }

    @Override
    public Player selectPlayerById(int id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, new BeanPropertyRowMapper<>(Player.class), id);
    }

    @Override
    public int insertPlayer(Player player) {
        return jdbcTemplate.update(SQL_INSERT, player.getId(), player.getName(), player.getNationality(), player.getBirth_date(), player.getTitles());
    }

    @Override
    public int updatePlayer(Player player) {
        return jdbcTemplate.update(SQL_UPDATE, player.getName(), player.getNationality(), player.getBirth_date(), player.getTitles(), player.getId());
    }

    @Override
    public int deletePlayer(int id) {
        return jdbcTemplate.update(SQL_DELETE, id);
    }

    @Override
    public void createTable() {
        jdbcTemplate.execute(SQL_CREATE);
    }

    public List<Player> selectPlayersByNationality(String nationality) {
        return jdbcTemplate.query(SQL_SELECT_BY_NATIONALITY, new PlayerMapper(), nationality);
    }

    private static final class PlayerMapper implements RowMapper<Player> {
        @Override
        public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
            Player player = new Player();
            player.setId(rs.getInt("id"));
            player.setName(rs.getString("name"));
            player.setNationality(rs.getString("nationality"));
            player.setBirth_date(rs.getDate("birth_date").toLocalDate());
            player.setTitles(rs.getInt("titles"));
            return player;
        }
    }
}