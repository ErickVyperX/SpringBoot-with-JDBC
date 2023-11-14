package io.erickdev.springdata.tennisplayer.datalayer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PlayerRepository {
    @PersistenceContext
    EntityManager entityManager;
    public PlayerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Player insertPlayer(Player player) {
        return entityManager.merge(player);
    }

    public Player updatePlayer(Player player) {
        return entityManager.merge(player);
    }

    public Player selectById(int id) {
        return entityManager.find(Player.class, id);
    }

    public void deletePlayer(int id) {
        entityManager.remove(selectById(id));
    }
}
