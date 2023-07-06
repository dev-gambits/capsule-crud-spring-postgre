package cl.sideralti.capsulespringpostgre.service;

import cl.sideralti.capsulespringpostgre.entity.Producto;
import cl.sideralti.capsulespringpostgre.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public List<Producto> getAllProducto() {
        return productoRepository.findAll();
    }

    public void deleteProducto(Producto producto) {
        productoRepository.delete(producto);
    }

    public Optional<Producto> findByIdProducto(Long id) {
        return productoRepository.findById(id);
    }
}
