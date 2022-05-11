package view;

public class MenuPrestamoVista {

    public void menuPrestamo() {
        mensaje("1. Nuevo prestamo");
        mensaje("2. Devolver prestamo");
        mensaje("3. Modificar prestamo");
        mensaje("4. Mostrar prestamos");
        mensaje("5. Salir");
    }

    public void prestamoModificar() {
        mensaje("1. Modificar fecha de devolucion");
        mensaje("2. Modificar prestamo completo");
        mensaje("3. Volver");
    }

    public void prestamoMostrar() {
        mensaje("1. Mostrar prestamos que vencen hoy");
        mensaje("2. Mostrar prestamos que vencen esta semana");
        mensaje("3. Mostrar prestamos sin devolver de un cliente");
        mensaje("4. Mostrar todos los prestamos de un cliente");
        mensaje("5. Mostrar todos los prestamos");
        mensaje("6. Mostrar todos los prestamos sin devolver");
        mensaje("7. Mostrar todos los prestamos de un libro");
        mensaje("8. Mostrar todos los libros de un prestamo");
        mensaje("9. Volver");
    }

    //Metodo para mostrar mensajes
    public void mensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
