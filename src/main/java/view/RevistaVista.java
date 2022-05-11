package view;

import model.entity.Revista;

import java.time.LocalDate;

public class RevistaVista {
    Teclado teclado = new Teclado();

    //Metodo que crea una revista
    public Revista datosRevista() {
        Revista revista = new Revista();
        revista.setIsbn(teclado.pideString("ISBN: "));
        revista.setTitulo(teclado.pideString("Titulo: "));
        revista.setEditorial(teclado.pideString("Editorial: "));
        revista.setFechaPublicacion(fechaPublicacion());
        revista.setTipo(teclado.pideString("Tipo: "));
        revista.setLongitudImpresion(teclado.pideInt("Longitud de impresion: "));

        return revista;
    }

    //Metodo que crea una fecha
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
                mensaje("Fecha invalida");
            }

        } while (!valido);

        return LocalDate.of(año, mes, dia);
    }

    //Metodo que muestra una revista
    public void muestraRevista(Revista revista) {
        mensaje(revista.toString());
    }

    //Metodo que muestra un mensaje
    public void mensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
