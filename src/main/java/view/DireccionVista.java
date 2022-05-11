package view;

import model.entity.Direccion;

public class DireccionVista {
    private Teclado teclado = new Teclado();


    // Metodo para pedir los datos de la direccion al usuario
    public Direccion datosDireccion() {
        try {
            Direccion direccion = new Direccion();
            direccion.setCalle(teclado.pideString("Ingrese la calle: "));
            direccion.setNumero(teclado.pideInt("Ingrese el numero: "));
            direccion.setPais(teclado.pideString("Ingrese el pais: "));
            direccion.setProvincia(teclado.pideString("Ingrese la provincia: "));
            direccion.setCiudad(teclado.pideString("Ingrese la ciudad: "));
            direccion.setCodigoPostal(teclado.pideInt("Ingrese el codigo postal: "));
            return direccion;

        } catch (Exception e) {
            System.out.println("Error al pedir los datos de la direccion" + e.getMessage());
            return null;
        }

    }

}
