package io.erickdev.springdata.tennisplayer.datalayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Qualifier("JdbcImplementation")
public class PlayerDaoJDBC implements PlayerDAO{
    private final JdbcTemplate jdbcTemplate;
    private static final String SQL_SELECT = "SELECT * FROM PLAYER";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM PLAYER WHERE ID = ?";

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
}
