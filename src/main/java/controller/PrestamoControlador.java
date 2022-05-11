package controller;

import model.dao.PrestamoDAO;
import model.entity.Cliente;
import model.entity.Libro;
import model.entity.Prestamo;
import view.PrestamoVista;
import view.Teclado;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrestamoControlador {
    PrestamoDAO prestamoDAO = new PrestamoDAO();
    PrestamoVista prestamoVista = new PrestamoVista();

    NovelaControlador novelaControlador = new NovelaControlador();

    MangaControlador mangaControlador = new MangaControlador();

    RevistaControlador revistaControlador = new RevistaControlador();
    Teclado teclado = new Teclado();
    ClienteControlador clienteControlador = new ClienteControlador();
    boolean valido = false;

    //Metodo para crear un prestamo
    public void crearPrestamo() {
        Prestamo prestamo = prestamoVista.datosPrestamo();
        prestamo.setDevuelto(false);
        prestamo.setFechaInicio(LocalDate.now());
        prestamo.setFechaFin(LocalDate.now().plusDays(15));
        prestamo.setCliente(añadirCliente());
        valido = false;
        prestamoDAO.create(prestamo);
        int numLibros = 0;
        do {
            numLibros = teclado.pideInt("¿Cuántos libros desea agregar? (minimo 1) ");
        }
        while (numLibros <= 0);
        for (int i = 0; i < numLibros; i++) {
            Libro l = añadirLibro();
            prestamo.setlLibros(l);
            l.setPrestamo(prestamo);
        }
        prestamoDAO.update(prestamo);
    }

    //Metodo para añadir un cliente a un prestamo
    public Cliente añadirCliente() {
        Cliente cliente;
        String existe = teclado.pideString("¿El cliente está dado de alta? (S/N) ").toUpperCase();
        do {
            switch (existe) {
                case "S":
                    cliente = clienteControlador.buscaClientePorId();
                    if (cliente == null) {
                        prestamoVista.muestraMensaje("El cliente no existe, ingresa correctamente el id o crea uno nuevo: ");
                        valido = false;
                    } else {
                        valido = true;
                    }
                    break;
                case "N":
                    cliente = clienteControlador.nuevoCliente();
                    valido = true;
                    break;
                default:
                    prestamoVista.muestraMensaje("Opción no válida");
                    cliente = null;
            }
        } while (!valido);
        valido = false;
        return cliente;
    }

    //Metodo para añadir un libro a un prestamo
    public Libro añadirLibro() {
        Libro libro;
        String existe = teclado.pideString("¿El libro está dado de alta? (S/N) ").toUpperCase();
        do {
            switch (existe) {
                case "S":
                    int id = teclado.pideInt("Ingresa el id del libro: ");
                    libro = novelaControlador.buscaNovelaId(id);
                    if (libro == null) {
                        libro = mangaControlador.buscaMangaPorId(id);
                        if (libro == null) {
                            libro = revistaControlador.buscarRevistaPorId(id);
                            if (libro == null) {
                                prestamoVista.muestraMensaje("El libro no existe, ingresa correctamente el id o crea uno nuevo");
                                valido = false;
                            } else {
                                valido = true;
                            }
                        } else {
                            valido = true;
                        }
                    } else {
                        valido = true;
                    }
                    break;
                case "N":
                    do {
                        String tipo = teclado.pideString("¿Es un libro de novela, manga o revista? ").toUpperCase();
                        switch (tipo) {
                            case "NOVELA":
                                libro = novelaControlador.nuevaNovela();
                                valido = true;
                                break;
                            case "MANGA":
                                libro = mangaControlador.nuevoManga();
                                valido = true;
                                break;
                            case "REVISTA":
                                libro = revistaControlador.nuevaRevista();
                                valido = true;
                                break;
                            default:
                                prestamoVista.muestraMensaje("Opción no válida");
                        }
                        break;
                    } while (!valido);
                default:
                    prestamoVista.muestraMensaje("Opción no válida");
                    libro = null;
            }
        } while (!valido);
        valido = false;
        return libro;
    }

    //Metodo para mostrar todos los prestamos
    public void mostrarPrestamos() {
        ArrayList<Prestamo> prestamos = (ArrayList<Prestamo>) prestamoDAO.find();
        if (prestamos.size() > 0) {
            for (Prestamo prestamo : prestamos) {
                prestamoVista.muestraMensaje(prestamo.toString());
            }
        } else {
            prestamoVista.muestraMensaje("No hay prestamos registrados");
        }
    }

    //Metodo para mostrar los prestamos de un cliente
    public void mostrarPrestamosCliente() {
        int id = teclado.pideInt("Ingresa el id del cliente: ");
        ArrayList<Prestamo> prestamos = (ArrayList<Prestamo>) prestamoDAO.findByCliente(id);
        if (prestamos.size() > 0) {
            for (Prestamo prestamo : prestamos) {
                prestamoVista.muestraMensaje(prestamo.toString());
            }
        } else {
            prestamoVista.muestraMensaje("No hay prestamos registrados");
        }
    }

    //Metodo para obtener los prestamos de un cliente sin devolver
    public void mostrarPrestamosClienteNoDevuelto() {
        int id = teclado.pideInt("Ingresa el id del cliente: ");
        ArrayList<Prestamo> prestamos = (ArrayList<Prestamo>) prestamoDAO.findByClienteSinDevolver(id);
        if (prestamos.size() > 0) {
            for (Prestamo prestamo : prestamos) {
                prestamoVista.muestraMensaje(prestamo.toString());
            }
        } else {
            prestamoVista.muestraMensaje("No hay prestamos registrados");
        }
    }

    //Metodo para mostrar los prestamos que finalizan hoy
    public void mostrarPrestamosHoy() {
        ArrayList<Prestamo> prestamos = (ArrayList<Prestamo>) prestamoDAO.findPrestamosDevolverHoy();
        if (prestamos.size() > 0) {
            for (Prestamo prestamo : prestamos) {
                prestamoVista.mustraPrestamo(prestamo);
            }
        } else {
            prestamoVista.muestraMensaje("No hay prestamos para hoy");
        }
    }

    //Metodo para mostrar los prestamos que finalizan en una semana
    public void mostrarPrestamosSemana() {
        ArrayList<Prestamo> prestamos = (ArrayList<Prestamo>) prestamoDAO.findPrestamosDevolverSemana();
        if (prestamos.size() > 0) {
            for (Prestamo prestamo : prestamos) {
                prestamoVista.mustraPrestamo(prestamo);
            }
        } else {
            prestamoVista.muestraMensaje("No hay prestamos para la semana");
        }
    }

    //Metodo para finalizar un prestamo
    public void finalizarPrestamo() {
        int id = teclado.pideInt("Ingresa el id del prestamo: ");
        Prestamo prestamo = prestamoDAO.findById(id);
        if (prestamo != null) {
            if (prestamo.getDevuelto() == false) {
                prestamo.setDevuelto(true);
                prestamo.setFechaDevolucion(LocalDate.now());
                prestamoDAO.finalizarPrestamo(prestamo);
            } else {
                prestamoVista.muestraMensaje("El prestamo ya fue finalizado: ");
            }
        } else {
            prestamoVista.muestraMensaje("No existe el prestamo");
        }
    }

    //Metodo para modifcar la fecha de devolucion de un prestamo
    public void modificarFechaDevolucion() {
        int id = teclado.pideInt("Ingresa el id del prestamo: ");
        Prestamo prestamo = prestamoDAO.findById(id);
        if (prestamo != null) {
            LocalDate fecha = prestamoVista.fechaPer("Ingresa la nueva fecha de devolucion: ");
            prestamo.setFechaFin(fecha);
            prestamoDAO.modificarFechaDevolucion(prestamo);
        } else {
            prestamoVista.muestraMensaje("No existe el prestamo");
        }
    }

    //Metodo para modificar un prestamo completo
    public void modificarPrestamo() {
        int id = teclado.pideInt("Ingresa el id del prestamo: ");
        Prestamo prestamo = prestamoDAO.findById(id);
        if (prestamo != null) {
            prestamoVista.muestraMensaje("Introduce los datos del prestamo: ");
            Prestamo prestamoNuevo = prestamoVista.datosPrestamo();
            prestamo.setCliente(prestamoNuevo.getCliente());

            prestamoNuevo.setFechaFin(prestamoVista.fechaPer("Ingresa la nueva fecha de devolucion: "));
            prestamoDAO.update(prestamo);

        } else {
            prestamoVista.muestraMensaje("No existe el prestamo");
        }
    }

    //Mostrar todos los prestamos de un libro
    public void mostrarPrestamosLibro() {
        int id = teclado.pideInt("Ingresa el id del libro: ");
        Libro libro;
        List<Prestamo> prestamos;

        if (mangaControlador.buscaMangaPorId(id) != null) {
            libro = mangaControlador.buscaMangaPorId(id);
        } else if (novelaControlador.buscaNovelaId(id) != null) {
            libro = novelaControlador.buscaNovelaId(id);
        } else if (revistaControlador.buscarRevistaPorId(id) != null) {
            libro = revistaControlador.buscarRevistaPorId(id);
        } else {
            libro = null;
            prestamoVista.muestraMensaje("No existe el libro");
        }
        if (libro != null) {
            if (libro.getlPrestamos() != null) {
                prestamos = libro.getlPrestamos();
                for (Prestamo prestamo : prestamos) {
                    prestamoVista.mustraPrestamo(prestamo);
                }
            }
        } else {
            prestamoVista.muestraMensaje("El libro no tiene prestamos");
        }
    }

    //Metodo para mostrar los libros de un prestamo
    public void mostrarLibrosPrestamo() {
        int id = teclado.pideInt("Ingresa el id del prestamo: ");
        Prestamo prestamo = prestamoDAO.findById(id);
        if (prestamo != null) {
            if (prestamo.getlLibros() != null) {
                List<Libro> libros = prestamo.getlLibros();
                for (Libro libro : libros) {
                    prestamoVista.muestraMensaje(libro.toString());
                }
            }
        }
    }

    //Metodo para mostrar todos los prestamos sin devolver
    public void mostrarPrestamosSinDevolver() {
        List<Prestamo> prestamos = prestamoDAO.findPrestamosSinDevolver();
        for (Prestamo prestamo : prestamos) {
            prestamoVista.mustraPrestamo(prestamo);
        }
    }
}
