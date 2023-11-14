package io.erickdev.springdata.tennisplayer;

import io.erickdev.springdata.tennisplayer.datalayer.PatientSpringDataRepository;
import io.erickdev.springdata.tennisplayer.datalayer.Player;
import io.erickdev.springdata.tennisplayer.datalayer.PlayerRepository;
import io.erickdev.springdata.tennisplayer.datalayer.PlayerSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Date;

@SpringBootApplication
public class TennisPlayerApplication implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    PlayerRepository playerRepository;
    PlayerSpringDataRepository playerSpringDataRepository;
    Player player;
    PatientSpringDataRepository patientSpringDataRepository;

    @Autowired
    public TennisPlayerApplication(PlayerRepository playerRepository, Player player,
                                   PlayerSpringDataRepository playerSpringDataRepository,
                                   PatientSpringDataRepository patientSpringDataRepository) {
        this.playerRepository = playerRepository;
        this.player = player;
        this.playerSpringDataRepository = playerSpringDataRepository;
        this.patientSpringDataRepository = patientSpringDataRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TennisPlayerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        logger.info("\n\n>> Inserting Player: {}\n", playerRepository.insertPlayer(
//                new Player("Djokovic", "Serbia", Date.valueOf("1987-05-22").toLocalDate(), 81)));
//
//        logger.info("\n\n>> Inserting Player: {}\n", playerRepository.insertPlayer(
//                new Player("Monfils", "France", Date.valueOf("1986-09-01").toLocalDate(), 10)));
//        logger.info("\n\n>> Finding Player: {}\n", playerRepository.selectById(2));
//        logger.info("\n\n>> Inserting Player: {}\n", playerRepository.insertPlayer(
//                new Player("Thiem", "Austria", new Date(System.currentTimeMillis()).toLocalDate(), 17)));
//        logger.info("\n\n>> Updating Player: {}\n", playerRepository.updatePlayer(
//                new Player(3, "Thiem", "Austria", new Date(System.currentTimeMillis()).toLocalDate(), 27)));
//        playerRepository.deletePlayer(3);
//        logger.info("\n\n>> Listing Players: {}\n", playerRepository.selectAllPlayers());
//        //SPRING DATA JPA
//        logger.info("\n\n>> Inserting Player: {}\n", playerSpringDataRepository.save(
//                new Player("Ronaldo", "Portugal", new Date(System.currentTimeMillis()).toLocalDate(), 36)));
//        logger.info("\n\n>> Updating Player: {}\n", playerSpringDataRepository.save(
//                new Player(4, "Ronaldo", "Portugal", Date.valueOf("1985-02-05").toLocalDate(), 38)));
//        logger.info("\n\n>> Finding Player: {}\n", playerSpringDataRepository.findById(4));
//        logger.info("\n\n>> Finding All Players: {}\n", playerSpringDataRepository.findAll());
//        playerSpringDataRepository.deleteById(4);
//        logger.info("\n\n>> Finding By Nationality: {}\n", playerSpringDataRepository.findByNationality("France"));
        logger.info("\n\n>> Finding All Patients: {}\n", patientSpringDataRepository.findAll());
    }
}
