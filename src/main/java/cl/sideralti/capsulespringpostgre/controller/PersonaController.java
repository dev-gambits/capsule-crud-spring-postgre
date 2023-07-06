package cl.sideralti.capsulespringpostgre.controller;

import cl.sideralti.capsulespringpostgre.entity.Persona;
import cl.sideralti.capsulespringpostgre.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {
    private PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping("/guardar")
    private ResponseEntity<Persona>  guardar(@RequestBody Persona persona) {
        Persona temporal = personaService.create(persona);
        try {
            return ResponseEntity.created(new URI("/api/persona" + temporal.getId())).body(temporal);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/lista")
    private ResponseEntity<List< Persona>> listarTodasLasPersonas() {
        return ResponseEntity.ok(personaService.getAllPersona());
    }

    @DeleteMapping("/eliminar")
    private ResponseEntity<Void> eliminarPersonas(@RequestBody Persona persona) {
        personaService.deletePersona(persona);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Optional<Persona>> buscarPorIdPersonas(@PathVariable("id") Long id) {
        return ResponseEntity.ok(personaService.findByIdPersona(id));
    }

}
