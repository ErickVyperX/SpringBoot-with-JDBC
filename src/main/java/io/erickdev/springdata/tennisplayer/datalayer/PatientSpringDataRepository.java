package io.erickdev.springdata.tennisplayer.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientSpringDataRepository extends JpaRepository<Paciente, Integer> {

}
