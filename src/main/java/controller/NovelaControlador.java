package controller;


import model.dao.NovelaDAO;
import model.entity.Novela;
import view.MenuNovelaVista;
import view.NovelaVista;
import view.Teclado;

import java.time.LocalDate;
import java.util.ArrayList;

public class NovelaControlador {
    private Teclado teclado = new Teclado();
    private NovelaVista novelaVista = new NovelaVista();
    private MenuNovelaVista menuNovelaVista = new MenuNovelaVista();
    private NovelaDAO novelaDAO = new NovelaDAO();

    public void creaNovela() {
        Novela novela = novelaVista.datosNovela();
        novelaDAO.create(novela);
    }

    public Novela nuevaNovela() {
        Novela novela = novelaVista.datosNovela();
        novelaDAO.create(novela);
        return novela;
    }

    //Muestra todas las novelas
    public void listaNovelas() {
        ArrayList<Novela> lista = (ArrayList<Novela>) novelaDAO.find();
        if (lista.size() > 0) {
            for (Novela novela : lista) {
                novelaVista.muestraNovela(novela);
            }
        } else {
            novelaVista.muestraMensaje("No hay novelas registradas");
        }
    }

    //Muestra una novela por id
    public void muestraNovelaId(int id) {
        Novela novela = novelaDAO.findById(id);
        if (novela != null) {
            novelaVista.muestraNovela(novela);
        } else {
            novelaVista.muestraMensaje("No existe la novela");
        }
    }

    //Busca una novela por id
    public Novela buscaNovelaId(int id) {
        Novela novela = novelaDAO.findById(id);
        if (novela != null) {
            return novela;
        } else {
            return null;
        }
    }

    //Muestra una novela por titulo
    public void muestraNovelaTitulo(String titulo) {
        Novela novela = novelaDAO.findByTitulo(titulo);
        if (novela != null) {
            novelaVista.muestraNovela(novela);
        } else {
            novelaVista.muestraMensaje("No hay novelas registradas con ese titulo");
        }
    }

    //Muestra una novela por ISBN
    public void muestraNovelaISBN(String isbn) {
        Novela novela = novelaDAO.findByISBN(isbn);
        if (novela != null) {
            novelaVista.muestraNovela(novela);
        } else {
            novelaVista.muestraMensaje("No hay novelas registradas con ese ISBN");
        }
    }

    //Muestra todas las novelas del autor
    public void listaNovelasAutor(String autor) {
        ArrayList<Novela> lista = (ArrayList<Novela>) novelaDAO.findByAutor(autor);
        if (lista.size() > 0) {
            for (Novela novela : lista) {
                novelaVista.muestraNovela(novela);
            }
        } else {
            novelaVista.muestraMensaje("No hay novelas registradas de ese autor");
        }
    }

    //Muestra todas las novelas de un tema
    public void listaNovelasTema(String tema) {
        ArrayList<Novela> lista = (ArrayList<Novela>) novelaDAO.findByTema(tema);
        if (lista.size() > 0) {
            for (Novela novela : lista) {
                novelaVista.muestraNovela(novela);
            }
        } else {
            novelaVista.muestraMensaje("No hay novelas registradas de ese tema");
        }
    }

    //Muestra todas las novelas de un subgenero
    public void listaNovelasSubgenero(String subgenero) {
        ArrayList<Novela> lista = (ArrayList<Novela>) novelaDAO.findBySubgenero(subgenero);
        if (lista.size() > 0) {
            for (Novela novela : lista) {
                novelaVista.muestraNovela(novela);
            }
        } else {
            novelaVista.muestraMensaje("No hay novelas registradas de ese subgenero");
        }
    }

    //Muestra todas las novelas de una editorial
    public void listaNovelasEditorial(String editorial) {
        ArrayList<Novela> lista = (ArrayList<Novela>) novelaDAO.findByEditorial(editorial);
        if (lista.size() > 0) {
            for (Novela novela : lista) {
                novelaVista.muestraNovela(novela);
            }
        } else {
            novelaVista.muestraMensaje("No hay novelas registradas de esa editorial");
        }
    }

    //Muestra todas las novelas de un año
    public void listaNovelasAnio(int año) {
        ArrayList<Novela> lista = (ArrayList<Novela>) novelaDAO.findByAño(año);
        if (lista.size() > 0) {
            for (Novela novela : lista) {
                novelaVista.muestraNovela(novela);
            }
        } else {
            novelaVista.muestraMensaje("No hay novelas registradas de ese año");
        }
    }

    //Actualizar una novela completa
    public void actualizaNovela() {
        Novela novela = novelaDAO.findById(teclado.pideInt("Ingrese el id de la novela a modificar: "));
        if (novela != null) {
            menuNovelaVista.muestraMensaje("Introduce los datos de la novela a modificar: ");
            Novela novelaNueva = novelaVista.datosNovela();
            novela.setTitulo(novelaNueva.getTitulo());
            novela.setAutor(novelaNueva.getAutor());
            novela.setTema(novelaNueva.getTema());
            novela.setSubgenero(novelaNueva.getSubgenero());
            novela.setEditorial(novelaNueva.getEditorial());
            novela.setFechaPublicacion(novelaNueva.getFechaPublicacion());
            novela.setIsbn(novelaNueva.getIsbn());
            novela.setLongitudImpresion(novelaNueva.getLongitudImpresion());
            novelaDAO.update(novela);
        } else {
            menuNovelaVista.muestraMensaje("No existe la novela con el id ingresado");
        }
    }

    //Actualiza ISBN de una novela
    public void actualizaISBN() {
        Novela novela = novelaDAO.findById(teclado.pideInt("Ingrese el id de la novela a modificar: "));
        if (novela != null) {
            String isbn = teclado.pideString("Ingrese el nuevo ISBN: ");
            novelaDAO.updateISBN(novela, isbn);
        } else {
            menuNovelaVista.muestraMensaje("No existe la novela con el id ingresado");
        }
    }

    //Actualiza titulo de una novela
    public void actualizaTitulo() {
        Novela novela = novelaDAO.findById(teclado.pideInt("Ingrese el id de la novela a modificar: "));
        if (novela != null) {
            String titulo = teclado.pideString("Ingrese el nuevo titulo: ");
            novelaDAO.updateTitulo(novela, titulo);
        } else {
            menuNovelaVista.muestraMensaje("No existe la novela con el id ingresado");
        }
    }

    //Actualiza autor de una novela
    public void actualizaAutor() {
        Novela novela = novelaDAO.findById(teclado.pideInt("Ingrese el id de la novela a modificar: "));
        if (novela != null) {
            String autor = teclado.pideString("Ingrese el nuevo autor: ");
            novelaDAO.updateAutor(novela, autor);
        } else {
            menuNovelaVista.muestraMensaje("No existe la novela con el id ingresado");
        }
    }

    //Actualiza tema de una novela
    public void actualizaTema() {
        Novela novela = novelaDAO.findById(teclado.pideInt("Ingrese el id de la novela a modificar: "));
        if (novela != null) {
            String tema = teclado.pideString("Ingrese el nuevo tema: ");
            novelaDAO.updateTema(novela, tema);
        } else {
            menuNovelaVista.muestraMensaje("No existe la novela con el id ingresado");
        }
    }

    //Actualiza subgenero de una novela
    public void actualizaSubgenero() {
        Novela novelaVieja = novelaDAO.findById(teclado.pideInt("Ingrese el id de la novela a modificar: "));
        if (novelaVieja != null) {
            String subgenero = teclado.pideString("Ingrese el nuevo subgenero: ");
            novelaDAO.updateSubgenero(novelaVieja, subgenero);
        } else {
            menuNovelaVista.muestraMensaje("No existe la novela con el id ingresado");
        }
    }

    //Actualiza editorial de una novela
    public void actualizaEditorial() {
        Novela novelaVieja = novelaDAO.findById(teclado.pideInt("Ingrese el id de la novela a modificar: "));
        if (novelaVieja != null) {
            String editorial = teclado.pideString("Ingrese el nuevo editorial: ");
            novelaDAO.updateEditorial(novelaVieja, editorial);
        } else {
            menuNovelaVista.muestraMensaje("No existe la novela con el id ingresado");
        }
    }

    //Actualiza numero de paginas de una novela
    public void actualizaNumPaginas() {
        Novela novela = novelaDAO.findById(teclado.pideInt("Ingrese el id de la novela a modificar: "));
        if (novela != null) {
            int numPaginas = teclado.pideInt("Ingrese el nuevo numero de paginas: ");
            novelaDAO.updatePaginas(novela, numPaginas);
        } else {
            menuNovelaVista.muestraMensaje("No existe la novela con el id ingresado");
        }
    }

    //Actualiza fecha de una novela
    public void actualizaFecha() {
        Novela novela = novelaDAO.findById(teclado.pideInt("Ingrese el id de la novela a modificar: "));
        if (novela != null) {
            LocalDate fecha = novelaVista.fechaPublicacion();
            novelaDAO.updateFecha(novela, fecha);
        } else {
            menuNovelaVista.muestraMensaje("No existe la novela con el id ingresado");
        }
    }

    //Elimina una novela
    public void eliminaNovela(int id) {
        Novela novela = novelaDAO.findById(id);
        if (novela != null) {
            novelaDAO.delete(novela);
            novelaVista.muestraMensaje("Novela eliminada");
        } else {
            novelaVista.muestraMensaje("No existe la novela");
        }
    }
}
