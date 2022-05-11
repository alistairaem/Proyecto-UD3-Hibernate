package controller;

import model.dao.MangaDAO;
import model.entity.Manga;
import view.MangaVista;
import view.MenuMangaVista;
import view.Teclado;

import java.time.LocalDate;
import java.util.ArrayList;

public class MangaControlador {
    private Teclado teclado = new Teclado();
    private MangaVista mangaVista = new MangaVista();
    private MenuMangaVista menumangaVista = new MenuMangaVista();
    private MangaDAO mangaDAO = new MangaDAO();

    //Crea manga
    public void creaManga() {
        Manga manga = mangaVista.datosManga();
        mangaDAO.create(manga);
    }

    public Manga nuevoManga() {
        Manga manga = mangaVista.datosManga();
        mangaDAO.create(manga);
        return manga;
    }

    //Muestra todos los manga
    public void listaMangas() {
        ArrayList<Manga> lista = (ArrayList<Manga>) mangaDAO.find();
        if (lista.size() > 0) {
            for (Manga manga : lista) {
                mangaVista.muestraManga(manga);
            }
        } else {
            mangaVista.muestraMensaje("No hay novelas registradas");
        }
    }

    //Muestra manga por id
    public void muestraMangaPorId() {
        int id = teclado.pideInt("Introduce el id del manga: ");
        Manga manga = mangaDAO.findById(id);
        if (manga != null) {
            mangaVista.muestraManga(manga);
        } else {
            mangaVista.muestraMensaje("No existe el manga");
        }
    }

    //Busca un manga por id
    public Manga buscaMangaPorId(int id) {
        Manga manga = mangaDAO.findById(id);
        if (manga != null) {
            return manga;
        } else {
            return null;
        }
    }

    //Muestra manga por titulo
    public void muestraMangaPorTitulo() {
        String titulo = teclado.pideString("Introduce el titulo del manga: ");
        Manga manga = mangaDAO.findByTitulo(titulo);
        if (manga != null) {
            mangaVista.muestraManga(manga);
        } else {
            mangaVista.muestraMensaje("No existe el manga");
        }
    }

    //Muestra manga por ISBN
    public void muestraMangaPorISBN() {
        String isbn = teclado.pideString("Introduce el ISBN del manga: ");
        Manga manga = mangaDAO.findByIsbn(isbn);
        if (manga != null) {
            mangaVista.muestraManga(manga);
        } else {
            mangaVista.muestraMensaje("No existe el manga");
        }
    }

    //Muestra mangas por autor
    public void muestraMangaPorAutor() {
        String autor = teclado.pideString("Introduce el autor del manga: ");
        ArrayList<Manga> lista = (ArrayList<Manga>) mangaDAO.findByAutor(autor);
        if (lista.size() > 0) {
            for (Manga manga : lista) {
                mangaVista.muestraManga(manga);
            }
        } else {
            mangaVista.muestraMensaje("No existe el manga");
        }
    }

    //Muestra mangas por demografia
    public void muestraMangaPorDemografia() {
        String demografia = teclado.pideString("Introduce la demografia del manga: ");
        ArrayList<Manga> lista = (ArrayList<Manga>) mangaDAO.findByDemografia(demografia);
        if (lista.size() > 0) {
            for (Manga manga : lista) {
                mangaVista.muestraManga(manga);
            }
        } else {
            mangaVista.muestraMensaje("No existe el manga");
        }
    }

    //Muestra mangas por genero
    public void muestraMangaPorGenero() {
        String genero = teclado.pideString("Introduce el genero del manga: ");
        ArrayList<Manga> lista = (ArrayList<Manga>) mangaDAO.findByGenero(genero);
        if (lista.size() > 0) {
            for (Manga manga : lista) {
                mangaVista.muestraManga(manga);
            }
        } else {
            mangaVista.muestraMensaje("No existe el manga");
        }
    }

    //Muestra mangas por editorial
    public void muestraMangaPorEditorial() {
        String editorial = teclado.pideString("Introduce la editorial del manga: ");
        ArrayList<Manga> lista = (ArrayList<Manga>) mangaDAO.findByEditorial(editorial);
        if (lista.size() > 0) {
            for (Manga manga : lista) {
                mangaVista.muestraManga(manga);
            }
        } else {
            mangaVista.muestraMensaje("No existe el manga");
        }
    }

    //Muestra los mangas de un año
    public void muestraMangaPorAño() {
        int año = teclado.pideInt("Introduce el año del manga: ");
        ArrayList<Manga> lista = (ArrayList<Manga>) mangaDAO.findAllAño(año);
        if (lista.size() > 0) {
            for (Manga manga : lista) {
                mangaVista.muestraManga(manga);
                mangaVista.muestraMensaje("----------------------------------------------------");
            }
        } else {
            mangaVista.muestraMensaje("No existe el manga");
        }
    }

    //Muestra los mangas a color
    public void muestraMangaColor() {
        ArrayList<Manga> lista = (ArrayList<Manga>) mangaDAO.findAllColor();
        if (lista.size() > 0) {
            for (Manga manga : lista) {
                mangaVista.muestraManga(manga);
            }
        } else {
            mangaVista.muestraMensaje("No existe el manga");
        }
    }

    //Muestra los mangas en blanco y negro
    public void muestraMangaBlancoNegro() {
        ArrayList<Manga> lista = (ArrayList<Manga>) mangaDAO.findAllBlancoNegro();
        if (lista.size() > 0) {
            for (Manga manga : lista) {
                mangaVista.muestraManga(manga);
            }
        } else {
            mangaVista.muestraMensaje("No existe el manga");
        }
    }

    //Muestra todos los mangas
    public void muestraMangaLista(ArrayList<Manga> lista) {
        if (lista.size() > 0) {
            for (Manga manga : lista) {
                mangaVista.muestraManga(manga);
            }
        } else {
            mangaVista.muestraMensaje("No existe el manga");
        }
    }


    //Actualiza un manga completo
    public void actualizaManga() {
        Manga manga = mangaDAO.findById(teclado.pideInt("Ingrese el id del manga a modificar: "));
        if (manga != null) {
            mangaVista.muestraMensaje("Introduce los datos del cliente a modificar: ");
            Manga mangaNuevo = mangaVista.datosManga();
            manga.setIsbn(mangaNuevo.getIsbn());
            manga.setTitulo(mangaNuevo.getTitulo());
            manga.setAutor(mangaNuevo.getAutor());
            manga.setColor(mangaNuevo.isColor());
            manga.setLongitudImpresion(mangaNuevo.getLongitudImpresion());
            manga.setEditorial(mangaNuevo.getEditorial());
            manga.setGenero(mangaNuevo.getGenero());
            manga.setTitulo(mangaNuevo.getTitulo());
            manga.setFechaPublicacion(mangaNuevo.getFechaPublicacion());
            mangaDAO.update(manga);
        } else {
            mangaVista.muestraMensaje("No existe la novela con el id ingresado");
        }
    }

    //Actualiza ISBN de un manga
    public void actualizaISBN() {
        Manga manga = mangaDAO.findById(teclado.pideInt("Ingrese el id del manga a modificar: "));
        if (manga != null) {
            String isbn = teclado.pideString("Introduce el nuevo ISBN: ");
            mangaDAO.updateIsbn(manga, isbn);
        } else {
            mangaVista.muestraMensaje("No existe la novela con el id ingresado");
        }
    }

    //Actualiza titulo de un manga
    public void actualizaTitulo() {
        Manga manga = mangaDAO.findById(teclado.pideInt("Ingrese el id del manga a modificar: "));
        if (manga != null) {
            String titulo = teclado.pideString("Introduce el nuevo titulo: ");
            mangaDAO.updateTitulo(manga, titulo);
        } else {
            mangaVista.muestraMensaje("No existe la novela con el id ingresado");
        }
    }

    //Actualiza autor de un manga
    public void actualizaAutor() {
        Manga manga = mangaDAO.findById(teclado.pideInt("Ingrese el id del manga a modificar: "));
        if (manga != null) {
            String autor = teclado.pideString("Introduce el nuevo autor: ");
            mangaDAO.updateAutor(manga, autor);
        } else {
            mangaVista.muestraMensaje("No existe la novela con el id ingresado");
        }
    }

    //Actualiza demografia de un manga
    public void actualizaDemografia() {
        Manga manga = mangaDAO.findById(teclado.pideInt("Ingrese el id del manga a modificar: "));
        if (manga != null) {
            String demografia = teclado.pideString("Introduce la nueva demografia: ");
            mangaDAO.updateDemografia(manga, demografia);
        } else {
            mangaVista.muestraMensaje("No existe la novela con el id ingresado");
        }
    }

    //Actualiza genero de un manga
    public void actualizaGenero() {
        Manga manga = mangaDAO.findById(teclado.pideInt("Ingrese el id del manga a modificar: "));
        if (manga != null) {
            String genero = teclado.pideString("Introduce el nuevo genero: ");
            mangaDAO.updateGenero(manga, genero);
        } else {
            mangaVista.muestraMensaje("No existe la novela con el id ingresado");
        }
    }

    //Actualiza la editorial de un manga
    public void actualizaEditorial() {
        Manga manga = mangaDAO.findById(teclado.pideInt("Ingrese el id del manga a modificar: "));
        if (manga != null) {
            String editorial = teclado.pideString("Introduce la nueva editorial: ");
            mangaDAO.updateEditorial(manga, editorial);
        } else {
            mangaVista.muestraMensaje("No existe la novela con el id ingresado");
        }
    }

    //Actualiza el color de un manga
    public void actualizaColor() {
        Manga manga = mangaDAO.findById(teclado.pideInt("Ingrese el id del manga a modificar: "));
        if (manga != null) {
            Boolean color = mangaVista.color();
            mangaDAO.updateColor(manga, color);
        } else {
            mangaVista.muestraMensaje("No existe la novela con el id ingresado");
        }
    }

    //Actualiza las paginas de un manga
    public void actualizaPaginas() {
        Manga manga = mangaDAO.findById(teclado.pideInt("Ingrese el id del manga a modificar: "));
        if (manga != null) {
            Integer paginas = teclado.pideInt("Introduce las nuevas paginas: ");
            mangaDAO.updatePaginas(manga, paginas);
        } else {
            mangaVista.muestraMensaje("No existe la novela con el id ingresado");
        }
    }

    //Actualiza la fecha de publicacion de un manga
    public void actualizaFechaPublicacion() {
        Manga manga = mangaDAO.findById(teclado.pideInt("Ingrese el id del manga a modificar: "));
        if (manga != null) {
            LocalDate fechaPublicacion = mangaVista.fechaPublicacion();
            mangaDAO.updateFecha(manga, fechaPublicacion);
        } else {
            mangaVista.muestraMensaje("No existe la novela con el id ingresado");
        }
    }

    //Elimina manga
    public void eliminaManga() {
        Manga manga = mangaDAO.findById(teclado.pideInt("Ingrese el id del manga a eliminar: "));
        if (manga != null) {
            mangaDAO.delete(manga);
        } else {
            mangaVista.muestraMensaje("No existe la novela con el id ingresado");
        }
    }
}
