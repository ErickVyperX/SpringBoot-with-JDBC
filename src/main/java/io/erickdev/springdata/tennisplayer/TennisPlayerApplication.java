package io.erickdev.springdata.tennisplayer;

import io.erickdev.springdata.tennisplayer.businesslayer.PlayerService;
import io.erickdev.springdata.tennisplayer.datalayer.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;

@SpringBootApplication
public class TennisPlayerApplication implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final PlayerService playerServiceJDBC;

    public static void main(String[] args) {
        SpringApplication.run(TennisPlayerApplication.class, args);
    }

    public TennisPlayerApplication(PlayerService playerServiceJDBC) {
        this.playerServiceJDBC = playerServiceJDBC;
    }

    @Override
    public void run(String... args) {
        logger.info("Player all data: {}", playerServiceJDBC.listPlayers());
        logger.info("Find player by ID: {}", playerServiceJDBC.showPlayer(3));
        logger.info("Insertion result: {}", playerServiceJDBC.addPlayer(new Player(4, "Thiem", "Austria", LocalDate.now(), 17)));
        logger.info("Updating result: {}", playerServiceJDBC.updatePlayer(new Player(4, "Thiem", "Austria", LocalDate.now(), 18)));
        logger.info("Deleting result: {}", playerServiceJDBC.deletePlayer(4));
        logger.info("Creating result: {}", playerServiceJDBC.createTournamentTable());
    }
}
