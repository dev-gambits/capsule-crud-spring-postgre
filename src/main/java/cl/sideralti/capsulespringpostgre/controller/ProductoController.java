package cl.sideralti.capsulespringpostgre.controller;

import cl.sideralti.capsulespringpostgre.entity.Persona;
import cl.sideralti.capsulespringpostgre.entity.Producto;
import cl.sideralti.capsulespringpostgre.service.PersonaService;
import cl.sideralti.capsulespringpostgre.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping("/guardar")
    private ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto) {
        Producto temporal = productoService.createProducto(producto);
        try {
            return ResponseEntity.created(new URI("/api/producto" + temporal.getId())).body(temporal);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/lista")
    private ResponseEntity<List< Producto>> listarTodasLosProductos() {
        return ResponseEntity.ok(productoService.getAllProducto());
    }

    @DeleteMapping("/eliminar")
    private ResponseEntity<Void> eliminarProductos(@RequestBody Producto producto) {
        productoService.deleteProducto(producto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Optional<Producto>> buscarPorIdProductos(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productoService.findByIdProducto(id));
    }
}
