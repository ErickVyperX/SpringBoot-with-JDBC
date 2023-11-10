package io.erickdev.springdata.tennisplayer.datalayer;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlayerDAO {
    List<Player> selectAllPlayers();
    Player selectPlayerById(int id);
}
