package model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;
    private String nombre;

    private String apellido;
    private String dni;
    @Embedded
    private Direccion direccion;
    private int edad;

    @OneToMany(mappedBy = "cliente")
    private List<Prestamo> lPrestamos;

    public Cliente() {
        lPrestamos = new ArrayList<Prestamo>();
    }


    public Cliente(int idCliente, String nombre, String apellido, String dni, Direccion direccion, int edad) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.edad = edad;
        lPrestamos = new ArrayList<Prestamo>();
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPrestamo(Prestamo prestamo) {
        lPrestamos.add(prestamo);
    }

    public List<Prestamo> getlPrestamos() {
        return lPrestamos;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", direccion=" + direccion.toString() +
                ", edad=" + edad +
                '}';
    }
}
