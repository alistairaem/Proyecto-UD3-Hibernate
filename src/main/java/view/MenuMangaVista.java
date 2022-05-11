package view;

public class MenuMangaVista {

    //Menu principal Manga
    public void muestraMenuMangas() {
        muestraMensaje("1. Nuevo manga");
        muestraMensaje("2. Eliminar manga");
        muestraMensaje("3. Modificar manga");
        muestraMensaje("4. Mostrar mangas");
        muestraMensaje("5. Volver");
    }

    //Menu de modificar manga
    public void muestraMenuModificarManga() {
        muestraMensaje("1. Modificar isbn");
        muestraMensaje("2. Modificar titulo");
        muestraMensaje("3. Modificar autor");
        muestraMensaje("4. Modificar editorial");
        muestraMensaje("5. Modificar demografica");
        muestraMensaje("6. Modificar genero");
        muestraMensaje("7. Modificar fecha de publicacion");
        muestraMensaje("8. Modificar numero de paginas");
        muestraMensaje("9. Modificar color");
        muestraMensaje("10. Modificar manga completo");
        muestraMensaje("11. Volver");
    }

    //Menu para mostrar manga
    public void muestraMenuMostrarManga() {
        muestraMensaje("1. Mostrar manga por isbn");
        muestraMensaje("2. Mostrar manga por titulo");
        muestraMensaje("3. Mostrar mangas de un autor");
        muestraMensaje("4. Mostrar manga por editorial");
        muestraMensaje("5. Mostrar manga por demografica");
        muestraMensaje("6. Mostrar manga por genero");
        muestraMensaje("7. Mostrar manga por año");
        muestraMensaje("8. Mostrar manga por numero de paginas");
        muestraMensaje("9. Mostrar mangas a color");
        muestraMensaje("10. Mostrar todos los manga");
        muestraMensaje("11. Volver");
    }


    //Muestra mensajes
    public void muestraMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
