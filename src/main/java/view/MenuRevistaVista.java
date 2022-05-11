package view;

public class MenuRevistaVista {

    //Muestra el menu de revistas
    public void muestraMenuRevista() {
        muestraMensaje("1. Nueva revista");
        muestraMensaje("2. Eliminar revista");
        muestraMensaje("3. Modificar revista");
        muestraMensaje("4. Mostrar revistas");
        muestraMensaje("5. Volver");
    }

    //Muestra el menu modificar revista
    public void muestraMenuModificarRevista() {
        muestraMensaje("1. Modificar titulo");
        muestraMensaje("2. Modificar ISBN");
        muestraMensaje("3. Modificar editorial");
        muestraMensaje("4. Modificar fecha de publicacion");
        muestraMensaje("5. Modificar tipo");
        muestraMensaje("6. Modificar numero de paginas");
        muestraMensaje("7. Modificar revista completa");
        muestraMensaje("8. Volver");
    }

    //Muestra el menu mostrar revista
    public void muestraMenuMostrarRevista() {
        muestraMensaje("1. Mostrar todas las revistas");
        muestraMensaje("2. Mostrar revista por titulo");
        muestraMensaje("3. Mostrar revista por ISBN");
        muestraMensaje("4. Mostrar revistas por editorial");
        muestraMensaje("5. Mostrar revistas por fecha de publicacion");
        muestraMensaje("6. Mostrar revistas por tipo");
        muestraMensaje("7. Volver");
    }

    public void muestraMensaje(String mensaje) {
        System.out.println(mensaje);
    }


}
