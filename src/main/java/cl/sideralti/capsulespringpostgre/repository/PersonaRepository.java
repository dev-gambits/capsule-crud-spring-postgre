package cl.sideralti.capsulespringpostgre.repository;

import cl.sideralti.capsulespringpostgre.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
