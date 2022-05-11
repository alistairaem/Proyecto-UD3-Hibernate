package view;

import model.entity.Manga;

import java.time.LocalDate;

public class MangaVista {
    Teclado teclado = new Teclado();
    MenuMangaVista menuMangaVista = new MenuMangaVista();

    //Metodo para añadir los datos del manga
    public Manga datosManga() {
        Manga manga = new Manga();
        manga.setIsbn(teclado.pideString("Ingrese el ISBN: "));
        manga.setTitulo(teclado.pideString("Ingrese el titulo: "));
        manga.setAutor(teclado.pideString("Ingrese el autor: "));
        manga.setEditorial(teclado.pideString("Ingrese la editorial: "));
        manga.setDemografia(teclado.pideString("Ingrese la demografia: "));
        manga.setGenero(teclado.pideString("Ingrese el genero: "));
        manga.setFechaPublicacion(fechaPublicacion());
        manga.setColor(color());
        manga.setLongitudImpresion(teclado.pideInt("Ingrese el numero de paginas: "));
        return manga;
    }

    //Metodo para elegir la fecha de publicacion
    public LocalDate fechaPublicacion() {
        boolean valido = false;
        int año = 1;
        int mes = 1;
        int dia = 1;
        do {
            año = teclado.pideInt("Ingrese el año de publicacion: ");
            mes = teclado.pideInt("Ingrese el mes de publicacion: ");
            dia = teclado.pideInt("Ingrese el dia de publicacion: ");
            if ((mes > 0 && mes < 13) && (dia > 0 && dia < 32)) {
                valido = true;
            } else {
                menuMangaVista.muestraMensaje("Fecha invalida");
            }
        } while (!valido);
        return LocalDate.of(año, mes, dia);
    }

    //Metodo para elegir el color
    public boolean color() {
        boolean acolor = false;
        boolean valido = false;
        do {
            String color = teclado.pideString("El manga está a color? (s/n): ");
            if (color.equals("s")) {
                acolor = true;
                valido = true;
            } else if (color.equals("n")) {
                acolor = false;
                valido = true;
            } else {
                menuMangaVista.muestraMensaje("Opción invalida");
            }
        } while (!valido);
        return acolor;
    }

    public void muestraManga(Manga manga) {
        menuMangaVista.muestraMensaje(manga.toString());
    }

    public void muestraMensaje(String mensaje) {
        menuMangaVista.muestraMensaje(mensaje);
    }


}
