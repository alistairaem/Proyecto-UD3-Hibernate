package controller;

import model.dao.ClienteDAO;
import model.entity.Cliente;
import model.entity.Direccion;
import view.ClienteVista;
import view.DireccionVista;
import view.MenuClienteVista;
import view.Teclado;

import java.util.ArrayList;


public class ClienteControlador {
    private Teclado teclado = new Teclado();
    private ClienteVista clienteVista = new ClienteVista();
    private ClienteDAO clienteDAO = new ClienteDAO();
    private DireccionVista direccionVista = new DireccionVista();

    private MenuClienteVista menuClienteVista = new MenuClienteVista();

    public ClienteControlador() {

    }

    public void creaCliente() {
        Cliente cliente = clienteVista.datosCliente();
        cliente.setDireccion(direccionVista.datosDireccion());
        clienteDAO.create(cliente);
    }

    public Cliente nuevoCliente() {
        Cliente cliente = clienteVista.datosCliente();
        cliente.setDireccion(direccionVista.datosDireccion());
        clienteDAO.create(cliente);
        return cliente;
    }

    public void muestraClientePorId() {
        int id = teclado.pideInt("Ingrese el id del cliente ");
        Cliente cliente = clienteDAO.findById(id);
        if (cliente != null) {
            clienteVista.mostrarCliente(cliente);
        } else {
            menuClienteVista.muestraMensaje("No existe el cliente con el id ingresado");
        }
    }

    public Cliente buscaClientePorId() {
        int id = teclado.pideInt("Ingrese el id del cliente ");
        Cliente cliente = clienteDAO.findById(id);
        if (cliente != null) {
            return cliente;
        } else {
            menuClienteVista.muestraMensaje("No existe el cliente con el id ingresado");
            return null;
        }
    }

    public void listaClientes() {
        ArrayList<Cliente> lista = (ArrayList<Cliente>) clienteDAO.find();
        if (lista.size() > 0) {
            for (Cliente cliente : lista) {
                clienteVista.mostrarCliente(cliente);
            }
        } else {
            menuClienteVista.muestraMensaje("No hay clientes registrados");
        }
    }

    public void modificaCliente() {
        Cliente cliente = clienteDAO.findById(teclado.pideInt("Ingrese el id del cliente a modificar: "));
        if (cliente != null) {
            menuClienteVista.muestraMensaje("Introduce los datos del cliente a modificar: ");
            Cliente clienteNuevo = clienteVista.datosCliente();
            cliente.setNombre(clienteNuevo.getNombre());
            cliente.setApellido(clienteNuevo.getApellido());
            cliente.setDni(clienteNuevo.getDni());
            cliente.setEdad(clienteNuevo.getEdad());
            cliente.setDireccion(direccionVista.datosDireccion());
            clienteDAO.update(cliente);
        } else {
            menuClienteVista.muestraMensaje("No existe el cliente con el id ingresado");
        }
    }

    public void modificaNombre() {
        Cliente clienteViejo = clienteDAO.findById(teclado.pideInt("Ingrese el id del cliente a modificar: "));
        if (clienteViejo != null) {
            String nombreNuevo = clienteVista.nombreCliente();
            clienteDAO.updateNombre(clienteViejo, nombreNuevo);
        } else {
            menuClienteVista.muestraMensaje("No existe el cliente con el id ingresado");
        }
    }

    public void modificaApellidos() {
        Cliente clienteViejo = clienteDAO.findById(teclado.pideInt("Ingrese el id del cliente a modificar: "));
        if (clienteViejo != null) {
            String apellidoNuevo = clienteVista.apellidoCliente();
            clienteDAO.updateApellido(clienteViejo, apellidoNuevo);
        } else {
            menuClienteVista.muestraMensaje("No existe el cliente con el id ingresado");
        }
    }

    public void modificaDireccion() {
        Cliente clienteViejo = clienteDAO.findById(teclado.pideInt("Ingrese el id del cliente a modificar: "));
        if (clienteViejo != null) {
            Direccion direccionNueva = direccionVista.datosDireccion();
            clienteDAO.updateDireccion(clienteViejo, direccionNueva);
        } else {
            menuClienteVista.muestraMensaje("No existe el cliente con el id ingresado");
        }
    }

    public void modificaEdad() {
        Cliente clienteViejo = clienteDAO.findById(teclado.pideInt("Ingrese el id del cliente a modificar: "));
        if (clienteViejo != null) {
            int edadNueva = clienteVista.edadCliente();
            clienteDAO.updateEdad(clienteViejo, edadNueva);
        } else {
            menuClienteVista.muestraMensaje("No existe el cliente con el id ingresado");
        }
    }

    public void modificaDni() {
        Cliente clienteViejo = clienteDAO.findById(teclado.pideInt("Ingrese el id del cliente a modificar: "));
        if (clienteViejo != null) {
            String dniNuevo = clienteVista.dniCliente();
            clienteDAO.updateDni(clienteViejo, dniNuevo);
        } else {
            menuClienteVista.muestraMensaje("No existe el cliente con el id ingresado");
        }
    }

    public void eliminaCliente() {
        Cliente cliente = clienteDAO.findById(teclado.pideInt("Ingrese el id del cliente a eliminar: "));
        if (cliente != null) {
            clienteDAO.delete(cliente);
            menuClienteVista.muestraMensaje("Cliente eliminado");
        } else {
            menuClienteVista.muestraMensaje("No existe el cliente con el id ingresado");
        }
    }


}
