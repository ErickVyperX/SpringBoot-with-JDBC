package io.erickdev.springdata.tennisplayer.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlayerSpringDataRepository extends JpaRepository<Player, Integer> {
    //No need implementation

    //Analyze method name and create a JPQL query automatically
    List<Player> findByNationality(String nationality);
}
