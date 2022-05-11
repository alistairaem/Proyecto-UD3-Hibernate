package controller;

import view.MenuClienteVista;
import view.Teclado;

public class MenuClienteControlador {
    private MenuClienteVista menuClienteVista = new MenuClienteVista();
    private ClienteControlador clienteControlador = new ClienteControlador();
    private Teclado teclado = new Teclado();
    boolean salir = false;


    public MenuClienteControlador() {

    }

    // Metodo que muestra el menu principal del cliente
    public void controladorMenuClientes() {
        do {
            menuClienteVista.muestraMenuClientes();
            int opcion = teclado.pideInt("Elige una opción: ");
            switch (opcion) {
                // Opciones del menu clientes
                // Nuevo cliente
                case 1:
                    clienteControlador.creaCliente();
                    break;
                // Eliminar cliente
                case 2:
                    clienteControlador.eliminaCliente();
                    break;
                // Abre menu para modificar cliente
                case 3:
                    controladorMenuModificarCliente();
                    break;
                // Mostrar todos los clientes
                case 4:
                    clienteControlador.listaClientes();
                    break;
                // buscar cliente por id
                case 5:
                    clienteControlador.muestraClientePorId();
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    menuClienteVista.muestraMensaje("Opción incorrecta, inténtelo de nuevo");
                    break;
            }
        } while (!salir);
        salir = false;
    }

    // Metodo que muestra el menu de modificar cliente
    public void controladorMenuModificarCliente() {
        do {
            menuClienteVista.muestraMenuModificarCliente();
            int opcion = teclado.pideInt("Elige una opción: ");
            switch (opcion) {
                // Opciones del menu modificar cliente
                // Modificar nombre
                case 1:
                    clienteControlador.modificaNombre();
                    break;
                // Modificar apellidos
                case 2:
                    clienteControlador.modificaApellidos();
                    break;
                // Modificar dni
                case 3:
                    clienteControlador.modificaDni();
                    break;
                // Modificar direccion
                case 4:
                    clienteControlador.modificaDireccion();
                    break;
                // Modificar edad
                case 5:
                    clienteControlador.modificaEdad();
                    break;
                // Modificar cliente completo
                case 6:
                    clienteControlador.modificaCliente();
                    break;
                // Volver al menu anterior
                case 7:
                    salir = true;
                default:
                    menuClienteVista.muestraMensaje("Opción incorrecta, inténtelo de nuevo");
                    break;
            }
        } while (!salir);
        salir = false;
    }

}
