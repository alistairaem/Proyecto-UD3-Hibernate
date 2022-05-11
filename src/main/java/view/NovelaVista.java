package view;

import model.entity.Novela;

import java.time.LocalDate;

public class NovelaVista {
    Teclado teclado = new Teclado();
    MenuNovelaVista menuNovelaVista = new MenuNovelaVista();

    public Novela datosNovela() {
        Novela novela = new Novela();
        novela.setIsbn(teclado.pideString("Ingrese el ISBN: "));
        novela.setTitulo(teclado.pideString("Ingrese el titulo: "));
        novela.setAutor(teclado.pideString("Ingrese el autor: "));
        novela.setEditorial(teclado.pideString("Ingrese la editorial: "));
        novela.setTema(teclado.pideString("Ingrese el tema: "));
        novela.setSubgenero(teclado.pideString("Ingrese el subgenero: "));
        novela.setFechaPublicacion(fechaPublicacion());
        novela.setLongitudImpresion(teclado.pideInt("Ingrese el numero de paginas: "));
        return novela;
    }

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
                menuNovelaVista.muestraMensaje("Fecha invalida");
            }

        } while (!valido);

        return LocalDate.of(año, mes, dia);
    }

    public void muestraNovela(Novela novela) {
        menuNovelaVista.muestraMensaje(novela.toString());
    }

    public void muestraMensaje(String mensaje) {
        menuNovelaVista.muestraMensaje(mensaje);
    }
}
