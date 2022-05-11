package view;

import model.entity.Cliente;

public class ClienteVista {
    private MenuVista menuVista = new MenuVista();
    private Teclado teclado = new Teclado();

    //Vista para solicitar los datos de un cliente
    //Los datos del telefono se solicitan en la vista del telefono y se agregan al cliente en el controlador del cliente
    public Cliente datosCliente() {
        Cliente cliente = new Cliente();
        cliente.setDni(teclado.pideString("DNI: "));
        cliente.setNombre(teclado.pideString("Nombre: "));
        cliente.setApellido(teclado.pideString("Apellido: "));
        cliente.setEdad(teclado.pideInt("Edad: "));
        return cliente;
    }

    //Vista para mostrar un cliente
    public void mostrarCliente(Cliente cliente) {
        System.out.println(cliente.toString());
    }

    //Solicita nombre al cliente
    public String nombreCliente() {
        return teclado.pideString("Nombre: ");
    }

    //Solicita apellido al cliente
    public String apellidoCliente() {
        return teclado.pideString("Apellido: ");
    }

    //Solicita dni al cliente
    public String dniCliente() {
        return teclado.pideString("DNI: ");
    }

    //Solicita edad al cliente
    public int edadCliente() {
        return teclado.pideInt("Edad: ");
    }
}
