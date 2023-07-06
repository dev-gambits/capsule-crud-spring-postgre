package cl.sideralti.capsulespringpostgre.entity;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "codigo_barra_producto")
    private Integer codigoBarra;

    @Column(name = "descripcion_producto")
    private String descripcionProducto;

    public Producto() {
    }

    public Producto(Long id, String nombreProducto, Integer codigoBarra, String descripcionProducto) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.codigoBarra = codigoBarra;
        this.descripcionProducto = descripcionProducto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(Integer codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }
}
