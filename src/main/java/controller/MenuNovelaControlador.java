package controller;

import view.MenuNovelaVista;
import view.Teclado;

public class MenuNovelaControlador {
    private MenuNovelaVista menuNovelaVista = new MenuNovelaVista();
    private NovelaControlador novelaControlador = new NovelaControlador();
    private Teclado teclado = new Teclado();
    boolean salir = false;

    public void controladorMenuNovelas() {
        do {
            menuNovelaVista.muestraMenuNovelas();
            int opcion = teclado.pideInt("Elige una opción: ");
            switch (opcion) {
                // Opciones del menu novelas
                // Nueva novela
                case 1:
                    novelaControlador.creaNovela();
                    break;
                // Eliminar novela
                case 2:
                    novelaControlador.eliminaNovela(teclado.pideInt("Introduce el id: "));
                    break;
                // Modificar novela
                case 3:
                    controladorMenuModificarNovela();
                    break;
                // Mostrar novelas
                case 4:
                    controladorMenuMostrarNovela();
                    break;
                // volver
                case 5:
                    salir = true;
                    break;
                default:
                    menuNovelaVista.muestraMensaje("Opción incorrecta, inténtelo de nuevo");
                    break;
            }
        } while (!salir);
        salir = false;
    }

    public void controladorMenuMostrarNovela() {
        menuNovelaVista.muestraMenuMostrarNovela();
        int opcion = teclado.pideInt("Elige una opción: ");
        switch (opcion) {
            // Opciones del menu mostrar novela
            // Mostrar todas las novelas
            case 1:
                novelaControlador.listaNovelas();
                break;
            // Mostrar novela por titulo
            case 2:
                novelaControlador.muestraNovelaTitulo(teclado.pideString("Introduce el autor: "));
                break;
            // Mostrar novela por ISBN
            case 3:
                novelaControlador.muestraNovelaISBN(teclado.pideString("Introduce el ISBN: "));
                break;
            // Mostrar novelas por autor
            case 4:
                novelaControlador.listaNovelasAutor(teclado.pideString("Introduce el autor: "));
                break;
            // Mostrar novelas por tema
            case 5:
                novelaControlador.listaNovelasTema(teclado.pideString("Introduce el tema: "));
                break;
            // Mostrar novelas por subgenero
            case 6:
                novelaControlador.listaNovelasSubgenero(teclado.pideString("Introduce el subgenero: "));
                break;
            // Mostrar novelas por editorial
            case 7:
                novelaControlador.listaNovelasEditorial(teclado.pideString("Introduce el editorial: "));
                break;
            // Mostrar novelas por año
            case 8:
                novelaControlador.listaNovelasAnio(teclado.pideInt("Introduce el año: "));
                break;
            // volver
            case 9:
                salir = true;
                break;
            default:
                menuNovelaVista.muestraMensaje("Opción incorrecta, inténtelo de nuevo");
                break;
        }
    }

    public void controladorMenuModificarNovela() {
        menuNovelaVista.muestraMenuModificarNovela();
        int opcion = teclado.pideInt("Elige una opción: ");
        switch (opcion) {
            // Opciones del menu modificar novela
            // Modificar isbn
            case 1:
                novelaControlador.actualizaISBN();
                break;
            // Modificar titulo
            case 2:
                novelaControlador.actualizaTitulo();
                break;
            // Modificar autor
            case 3:
                novelaControlador.actualizaAutor();
                break;
            // Modificar editorial
            case 4:
                novelaControlador.actualizaEditorial();
                break;
            // Modificar tema
            case 5:
                novelaControlador.actualizaTema();
                break;
            // Modificar subgenero
            case 6:
                novelaControlador.actualizaSubgenero();
                break;
            // Modificar fecha de publicacion
            case 7:
                novelaControlador.actualizaFecha();
                break;
            // Modificar numero de paginas
            case 8:
                novelaControlador.actualizaNumPaginas();
                break;
            // Modificar novela completa
            case 9:
                novelaControlador.actualizaNovela();
                break;
            // volver
            case 10:
                salir = true;
                break;
        }
    }
}
