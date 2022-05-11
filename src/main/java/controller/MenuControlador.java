package controller;

import view.MenuVista;
import view.Teclado;

public class MenuControlador {
    private MenuVista menuVista = new MenuVista();
    private MenuClienteControlador menuClienteControlador = new MenuClienteControlador();
    private MenuNovelaControlador menuNovelaControlador = new MenuNovelaControlador();
    private MenuRevistaControlador menuRevistaControlador = new MenuRevistaControlador();
    private MenuMangaControlador menuMangaControlador = new MenuMangaControlador();

    private MenuPrestamoControlador menuPrestamoControlador = new MenuPrestamoControlador();
    private Teclado teclado = new Teclado();
    private boolean salir = false;


    public void controladorMenuPrincipal() {
        do {
            menuVista.muestraMenuPrincipal();
            int opcion = teclado.pideInt("Elige una opción: ");
            switch (opcion) {
                // Opciones del menu principal
                // Libros
                case 1:
                    controladorMenuLibros();
                    break;
                // Clientes
                case 2:
                    menuClienteControlador.controladorMenuClientes();
                    break;
                // Prestamos
                case 3:
                    menuPrestamoControlador.menuControlador();
                    break;
                // Salir
                case 4:
                    menuVista.muestraMensaje("Hasta pronto!");
                    salir = true;
                    break;
                default:
                    menuVista.muestraMensaje("Opción incorrecta, inténtelo de nuevo");
                    break;
            }
        } while (!salir);
    }

    public void controladorMenuLibros() {
        do {
            menuVista.muestraMenuLibros();
            int opcion = teclado.pideInt("Elige una opción: ");
            switch (opcion) {
                // Opciones del menu libros
                // Mostrar todos los libros
                case 1:
                    break;
                // Menu novelas
                case 2:
                    menuNovelaControlador.controladorMenuNovelas();
                    break;
                //Menu mangas
                case 3:
                    menuMangaControlador.menuMangaControlador();
                    break;
                // Menu revistas
                case 4:
                    menuRevistaControlador.controladorMenuRevistas();
                    break;
                // volver
                case 5:
                    salir = true;
                    break;
                default:
                    menuVista.muestraMensaje("Opción incorrecta, inténtelo de nuevo");
                    break;
            }
        } while (!salir);
        salir = false;
    }

}
