package cl.sideralti.capsulespringpostgre.service;

import cl.sideralti.capsulespringpostgre.entity.Persona;
import cl.sideralti.capsulespringpostgre.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public Persona create(Persona persona) {
        return personaRepository.save(persona);
    }

    public List<Persona> getAllPersona() {
        return personaRepository.findAll();
    }

    public void deletePersona(Persona persona) {
        personaRepository.delete(persona);
    }

    public Optional<Persona> findByIdPersona(Long id) {
        return personaRepository.findById(id);
    }
}
