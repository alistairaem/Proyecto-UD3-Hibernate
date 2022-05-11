package view;

import model.entity.Prestamo;

import java.time.LocalDate;

public class PrestamoVista {
    Teclado teclado = new Teclado();

    //Metodo para pedir los datos del prestamo
    public Prestamo datosPrestamo() {
        Prestamo prestamo = new Prestamo();
        return prestamo;
    }

    //Metodo para añadir una fecha predeterminada
    public LocalDate fecha() {
        LocalDate fecha = LocalDate.now();
        return fecha;
    }

    //Metodo para añadir una fecha personalizada
    public LocalDate fechaPer(String mensaje) {
        muestraMensaje(mensaje);
        int dia = teclado.pideInt("Dia: ");
        int mes = teclado.pideInt("Mes: ");
        int año = teclado.pideInt("Año: ");
        LocalDate fecha = LocalDate.of(año, mes, dia);
        return fecha;
    }


    //Metodo para mostrar un mensaje
    public void muestraMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mustraPrestamo(Prestamo prestamo) {
        System.out.println(prestamo.toString());
    }
}
