package controller;


import view.MenuMangaVista;
import view.Teclado;

public class MenuMangaControlador {
    private MenuMangaVista menuMangaVista = new MenuMangaVista();
    private MangaControlador mangaControlador = new MangaControlador();
    private Teclado teclado = new Teclado();
    boolean salir = false;

    //Controlador del menu principal
    public void menuMangaControlador() {
        salir = false;
        do {
            menuMangaVista.muestraMenuMangas();
            int opcion = teclado.pideInt("Introduce una opción: ");
            switch (opcion) {
                //Crear manga
                case 1:
                    mangaControlador.creaManga();
                    break;
                //Eliminar manga
                case 2:
                    mangaControlador.eliminaManga();
                    break;
                //Modificar manga
                case 3:
                    menuMangaModificar();
                    break;
                //Mostar todos los mangas
                case 4:
                    menuMangaMostar();
                    break;
                //Salir
                case 5:
                    salir = true;
                    break;
                default:
            }
        } while (!salir);
    }

    //Controlador modificar manga
    public void menuMangaModificar() {
        salir = false;
        do {
            menuMangaVista.muestraMenuModificarManga();
            int opcion = teclado.pideInt("Introduce una opción: ");
            switch (opcion) {
                //Modificar ISBN
                case 1:
                    mangaControlador.actualizaISBN();
                    break;
                //Modificar titulo
                case 2:
                    mangaControlador.actualizaTitulo();
                    break;
                //Modificar autor
                case 3:
                    mangaControlador.actualizaAutor();
                    break;
                //Modificar editorial
                case 4:
                    mangaControlador.actualizaEditorial();
                    break;
                //Modificar demografia
                case 5:
                    mangaControlador.actualizaDemografia();
                    break;
                //Modificar genero
                case 6:
                    mangaControlador.actualizaGenero();
                    break;
                //Modificar fecha de publicacion
                case 7:
                    mangaControlador.actualizaFechaPublicacion();
                    break;
                //Modificar numero de paginas
                case 8:
                    mangaControlador.actualizaPaginas();
                    break;
                //Modificar color
                case 9:
                    mangaControlador.actualizaColor();
                    break;
                //Modificar manga completo
                case 10:
                    mangaControlador.actualizaManga();
                    break;
                //Salir
                case 11:
                    salir = true;
                    break;
                default:
                    menuMangaVista.muestraMensaje("Opción incorrecta");
                    break;
            }
        } while (!salir);
    }

    public void menuMangaMostar() {
        salir = false;
        do {
            menuMangaVista.muestraMenuMostrarManga();
            int opcion = teclado.pideInt("Introduce una opción: ");
            switch (opcion) {
                //Mostar manga por ISBN
                case 1:
                    mangaControlador.muestraMangaPorISBN();
                    break;
                //Mostar manga por titulo
                case 2:
                    mangaControlador.muestraMangaPorTitulo();
                    break;
                //Mostar manga por autor
                case 3:
                    mangaControlador.muestraMangaPorAutor();
                    break;
                //Mostar manga por editorial
                case 4:
                    mangaControlador.muestraMangaPorEditorial();
                    break;
                //Mostar manga por demografia
                case 5:
                    mangaControlador.muestraMangaPorDemografia();
                    break;
                //Mostar manga por genero
                case 6:
                    mangaControlador.muestraMangaPorGenero();
                    break;
                //Mostar manga por año
                case 7:
                    mangaControlador.muestraMangaPorAño();
                    break;
                //Mostar mangas a color
                case 8:
                    mangaControlador.muestraMangaColor();
                    break;
                //Mostar mangas en blanco y negro
                case 9:
                    mangaControlador.muestraMangaBlancoNegro();
                    break;
                //Mostar todos los mangas
                case 10:
                    mangaControlador.listaMangas();
                    break;
                //Salir
                case 11:
                    salir = true;
                    break;
                default:
                    menuMangaVista.muestraMensaje("Opción incorrecta");
                    break;
            }
        } while (!salir);
    }
}
