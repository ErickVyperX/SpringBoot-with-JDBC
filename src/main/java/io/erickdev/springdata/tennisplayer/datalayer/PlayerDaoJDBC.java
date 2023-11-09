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

    @Autowired
    public PlayerDaoJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Player> selectAllPlayers() {
        return jdbcTemplate.query(SQL_SELECT, new BeanPropertyRowMapper<>(Player.class));
    }
}
