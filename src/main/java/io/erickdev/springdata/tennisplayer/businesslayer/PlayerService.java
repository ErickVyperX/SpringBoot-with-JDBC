package io.erickdev.springdata.tennisplayer.businesslayer;

import io.erickdev.springdata.tennisplayer.datalayer.Player;
import io.erickdev.springdata.tennisplayer.datalayer.PlayerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlayerService {
    private final PlayerDAO playerDAO;

    @Autowired
    public PlayerService(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public List<Player> listPlayers() {
        //Add Business Logic - Treatment player data list
        return playerDAO.selectAllPlayers();
    }
}
