package view;

public class MenuVista {

    //Muestra el menu principal
    public void muestraMenuPrincipal() {
        muestraMensaje("1. Libros");
        muestraMensaje("2. Clientes");
        muestraMensaje("3. Prestamos");
        muestraMensaje("4. Salir");
    }

    //Muestra el menu libros
    public void muestraMenuLibros() {
        muestraMensaje("1. Mostrar todos libros");
        muestraMensaje("2. Novelas");
        muestraMensaje("3. Manga");
        muestraMensaje("4. Revistas");
        muestraMensaje("5. Volver");
    }


    //Muestra el menu prestamos
    public void muestraMenuPrestamos() {
        muestraMensaje("1. Nuevo prestamo");
        muestraMensaje("2. Eliminar prestamo");
        muestraMensaje("3. Modificar prestamo");
        muestraMensaje("4. Mostrar prestamos");
        muestraMensaje("5. Volver");

    }

    //Muestra los mensajes del menu
    public void muestraMensaje(String mensaje) {
        System.out.println(mensaje);
    }


}
