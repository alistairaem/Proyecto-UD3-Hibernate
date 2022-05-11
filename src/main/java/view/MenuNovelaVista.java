package view;

public class MenuNovelaVista {
    //Muestra el menu novela
    public void muestraMenuNovelas() {
        muestraMensaje("1. Nueva novela");
        muestraMensaje("2. Eliminar novela");
        muestraMensaje("3. Modificar novela");
        muestraMensaje("4. Mostrar novelas");
        muestraMensaje("5. Volver");
    }

    //Muestra menu modificar novela
    public void muestraMenuModificarNovela() {
        muestraMensaje("1. Modificar isbn");
        muestraMensaje("2. Modificar titulo");
        muestraMensaje("3. Modificar autor");
        muestraMensaje("4. Modificar editorial");
        muestraMensaje("5. Modificar tema");
        muestraMensaje("6. Modificar subgenero");
        muestraMensaje("7. Modificar fecha de publicacion");
        muestraMensaje("8. Modificar numero de paginas");
        muestraMensaje("9. Modificar novela completa");
        muestraMensaje("10. Volver");
    }

    //Muestra menu mostrar novela
    public void muestraMenuMostrarNovela() {
        muestraMensaje("1. Mostrar todas las novelas");
        muestraMensaje("2. Mostrar novelas por titulo");
        muestraMensaje("3. Mostrar novela por isbn");
        muestraMensaje("4. Mostrar todas las novelas de un autor");
        muestraMensaje("5. Mostrar todas las novelas de un tema");
        muestraMensaje("6. Mostrar todas las novelas de un subgenero");
        muestraMensaje("7. Mostrar todas las novelas de una editorial");
        muestraMensaje("8. Mostrar novela por año de publicacion");
        muestraMensaje("9. Volver");
    }

    //Muestra mensajes
    public void muestraMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
