package io.erickdev.springdata.tennisplayer;

import io.erickdev.springdata.tennisplayer.datalayer.Player;
import io.erickdev.springdata.tennisplayer.datalayer.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootApplication
public class TennisPlayerApplication implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    PlayerRepository playerRepository;
    Player player;

    @Autowired
    public TennisPlayerApplication(PlayerRepository playerRepository, Player player) {
        this.playerRepository = playerRepository;
        this.player = player;
    }

    public static void main(String[] args) {
        SpringApplication.run(TennisPlayerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("\n\n>> Inserting Player: {}\n", playerRepository.insertPlayer(
                new Player("Djokovic", "Serbia", Date.valueOf("1987-05-22").toLocalDate(), 81)));

        logger.info("\n\n>> Inserting Player: {}\n", playerRepository.insertPlayer(
                new Player("Monfils", "France", Date.valueOf("1986-09-01").toLocalDate(), 10)));
        logger.info("\n\n>> Finding Player: {}\n", playerRepository.selectById(2));
        logger.info("\n\n>> Inserting Player: {}\n", playerRepository.insertPlayer(
                new Player("Thiem", "Austria", new Date(System.currentTimeMillis()).toLocalDate(), 17)));
        logger.info("\n\n>> Updating Player: {}\n", playerRepository.updatePlayer(
                new Player(3, "Thiem", "Austria", new Date(System.currentTimeMillis()).toLocalDate(), 27)));
        playerRepository.deletePlayer(3);
        logger.info("\n\n>> Listing Players: {}\n", playerRepository.selectAllPlayers());
    }
}
