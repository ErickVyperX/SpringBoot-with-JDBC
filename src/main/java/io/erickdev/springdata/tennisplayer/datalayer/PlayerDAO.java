package io.erickdev.springdata.tennisplayer.datalayer;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlayerDAO {
    List<Player> selectAllPlayers();
    List<Player> selectPlayersByNationality(String nationality);
    Player selectPlayerById(int id);
    int insertPlayer(Player player);
    int updatePlayer(Player player);
    int deletePlayer(int id);
    void createTable();
}
