package view;

public class MenuClienteVista {

    //Muestra el menu clientes
    public void muestraMenuClientes() {
        muestraMensaje("1. Nuevo cliente");
        muestraMensaje("2. Eliminar cliente");
        muestraMensaje("3. Modificar cliente");
        muestraMensaje("4. Mostrar clientes");
        muestraMensaje("5. Buscar cliente");
        muestraMensaje("6. Volver");
    }

    // Muestra el menu de modificar cliente
    public void muestraMenuModificarCliente() {
        muestraMensaje("1. Modificar nombre");
        muestraMensaje("2. Modificar apellido");
        muestraMensaje("3. Modificar DNI");
        muestraMensaje("4. Modificar direccion");
        muestraMensaje("5. Modificar edad");
        muestraMensaje("6. Modificar completo");
        muestraMensaje("7. Volver");
    }

    //Muestra un mensaje
    public void muestraMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
