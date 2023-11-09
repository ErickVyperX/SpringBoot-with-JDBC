package io.erickdev.springdata.tennisplayer;

import io.erickdev.springdata.tennisplayer.businesslayer.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
    }
}
