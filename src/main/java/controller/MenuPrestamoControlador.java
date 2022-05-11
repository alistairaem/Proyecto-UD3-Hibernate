package controller;

import view.MenuPrestamoVista;
import view.Teclado;

public class MenuPrestamoControlador {

    MenuPrestamoVista menuPrestamoVista = new MenuPrestamoVista();

    PrestamoControlador prestamoControlador = new PrestamoControlador();

    Teclado teclado = new Teclado();

    boolean salir = false;

    int opcion = 0;

    public void menuControlador() {
        do {
            menuPrestamoVista.menuPrestamo();
            opcion = teclado.pideInt("Seleccione una opcion: ");
            switch (opcion) {
                //Nuevo prestamo
                case 1:
                    prestamoControlador.crearPrestamo();
                    break;
                //Devolver prestamo
                case 2:
                    prestamoControlador.finalizarPrestamo();
                    break;
                //Modificar prestamo
                case 3:
                    menuModificar();
                    break;
                // Mostrar prestamos
                case 4:
                    menuMostrar();
                    break;
                //Salir
                case 5:
                    salir = true;
                    break;
                default:
                    menuPrestamoVista.mensaje("Opcion no valida");
                    break;
            }
        } while (!salir);
        salir = false;
    }

    public void menuModificar() {
        do {
            menuPrestamoVista.prestamoModificar();
            opcion = teclado.pideInt("Seleccione una opcion: ");
            switch (opcion) {
                //Modificar fecha de devolucion
                case 1:
                    prestamoControlador.modificarFechaDevolucion();
                    break;
                //Modificar prestamo completo
                case 2:
                    prestamoControlador.modificarPrestamo();
                    break;
                //Salir
                case 3:
                    salir = true;
                    break;
                default:
                    menuPrestamoVista.mensaje("Opcion no valida");
                    break;
            }
        } while (!salir);
        salir = false;
    }

    public void menuMostrar() {
        do {
            menuPrestamoVista.prestamoMostrar();
            opcion = teclado.pideInt("Seleccione una opcion: ");
            switch (opcion) {
                //Mostrar prestamos que vencen hoy
                case 1:
                    prestamoControlador.mostrarPrestamosHoy();
                    break;
                //Mostrar prestamos que vencen esta semana
                case 2:
                    prestamoControlador.mostrarPrestamosSemana();
                    break;
                //Mostrar todos los prestamos sin devolver de un cliente
                case 3:
                    prestamoControlador.mostrarPrestamosClienteNoDevuelto();
                    break;
                //Mostrar todos los prestamos de un cliente
                case 4:
                    prestamoControlador.mostrarPrestamosCliente();
                    break;
                //Mostrar todos los prestamos
                case 5:
                    prestamoControlador.mostrarPrestamos();
                    break;
                    //Mostrar todos los prestamos sin devolver
                case 6:
                    prestamoControlador.mostrarPrestamosSinDevolver();
                    break;
                //Mostrar todos los prestamos de un libro
                case 7:
                    prestamoControlador.mostrarPrestamosLibro();
                    break;
                //Mostrar todos los libros de un prestamo
                case 8:
                    prestamoControlador.mostrarLibrosPrestamo();
                    break;
                //Salir
                case 9:
                    salir = true;
            }
        } while (!salir);
        salir = false;
    }

}
