package controller;

import view.MenuRevistaVista;
import view.Teclado;

public class MenuRevistaControlador {

    private MenuRevistaVista menuRevistaVista = new MenuRevistaVista();

    private Teclado teclado = new Teclado();

    private RevistaControlador revistaControlador = new RevistaControlador();

    private boolean salir;


    public void controladorMenuRevistas() {
        do {
            menuRevistaVista.muestraMenuRevista();
            int opcion = teclado.pideInt("Elige una opción: ");
            switch (opcion) {
                // Opciones del menu revistas
                // Nueva revista
                case 1:
                    revistaControlador.crearRevista();
                    break;
                // Eliminar revista
                case 2:
                    revistaControlador.eliminarRevista();
                    break;
                // Modificar revista
                case 3:
                    controladorMenuModificarRevistas();
                    break;
                // Mostrar revistas
                case 4:
                    controladorMenuMostrarRevistas();
                    break;
                // volver
                case 5:
                    salir = true;
                    break;
                default:
                    menuRevistaVista.muestraMensaje("Opción incorrecta, inténtelo de nuevo");
                    break;
            }
        } while (!salir);
        salir = false;
    }

    public void controladorMenuModificarRevistas() {
        do {
            menuRevistaVista.muestraMenuModificarRevista();
            int opcion = teclado.pideInt("Elige una opción: ");
            switch (opcion) {
                // Opciones del menu modificar revistas
                // Modificar titulo
                case 1:
                    revistaControlador.actualizarTitulo();
                    break;
                // Modificar ISBN
                case 2:
                    revistaControlador.actualizarISBN();
                    break;
                // Modificar editorial
                case 3:
                    revistaControlador.actualizarEditorial();
                    break;
                // Modificar fecha de publicacion
                case 4:
                    revistaControlador.actualizarFechaPublicacion();
                    break;
                // Modificar tipo
                case 5:
                    revistaControlador.actualizarTipo();
                    break;
                // Modificar numero de paginas
                case 6:
                    revistaControlador.actualizarNumeroPaginas();
                    break;
                // Modificar revista completa
                case 7:
                    revistaControlador.actualizarRevista();
                    break;
                // volver
                case 8:
                    salir = true;
                    break;
                default:
                    menuRevistaVista.muestraMensaje("Opción incorrecta, inténtelo de nuevo");
                    break;
            }
        } while (!salir);
        salir = false;
    }

    public void controladorMenuMostrarRevistas() {
        do {
            menuRevistaVista.muestraMenuMostrarRevista();
            int opcion = teclado.pideInt("Elige una opción: ");
            switch (opcion) {
                // Opciones del menu mostrar revistas
                // Mostrar todas las revistas
                case 1:
                    revistaControlador.mostrarRevistas();
                    break;
                // Mostrar revista por titulo
                case 2:
                    revistaControlador.mostrarRevistaPorTitulo();
                    break;
                // Mostrar revista por ISBN
                case 3:
                    revistaControlador.mostrarRevistaPorISBN();
                    break;
                // Mostrar revistas por editorial
                case 4:
                    revistaControlador.mostrarRevistasPorEditorial();
                    break;
                // Mostrar revistas por año de publicacion
                case 5:
                    revistaControlador.mostrarRevistasPorAño();
                    break;
                // Mostrar revistas por tipo
                case 6:
                    revistaControlador.mostrarRevistasPorTipo();
                    break;
                //salir
                case 7:
                    salir = true;
                    break;
                default:
                    menuRevistaVista.muestraMensaje("Opción incorrecta, inténtelo de nuevo");
                    break;
            }
        } while (!salir);
        salir = false;
    }
}
