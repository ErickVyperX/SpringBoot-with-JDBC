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

    public Player showPlayer(int id) {
        return playerDAO.selectPlayerById(id);
    }

    public String addPlayer(Player player) {
        return playerDAO.insertPlayer(player) == 1 ? "Player added successfully" : "Player not added";
    }

    public String updatePlayer(Player player) {
        return playerDAO.updatePlayer(player) == 1 ? "Player updated successfully" : "Player not updated";
    }

    public String deletePlayer(int id) {
        return playerDAO.deletePlayer(id) == 1 ? "Player deleted successfully" : "Player not deleted";
    }

    public String createTournamentTable() {
        playerDAO.createTable();
        return "Table created successfully";
    }
}
