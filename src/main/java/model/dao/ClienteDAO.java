package model.dao;

import model.entity.Cliente;
import model.entity.Direccion;
import view.AlertaVista;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ClienteDAO implements InterfazDAO<Cliente> {
    private final AlertaVista alertaVista = new AlertaVista();
    private EntityManagerFactory emf;
    private EntityManager em;

    private void iniciaHibernate() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }

    private void finalizaHibernate() {
        em.close();
        emf.close();
    }

    //Metodo para crear un cliente
    @Override
    public void create(Cliente cliente) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Cliente creado");
        } catch (Exception e) {
            alertaVista.muestraError("Error al crear cliente " + e.getMessage());
        }
    }

    //Metodo para buscar todos cliente
    @Override
    public List<Cliente> find() {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT c FROM Cliente c");
            em.getTransaction().commit();
            List<Cliente> clientes = query.getResultList();
            finalizaHibernate();
            return clientes;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para buscar un cliente por id
    public Cliente findById(int id) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.idCliente = :id");
            query.setParameter("id", id);
            em.getTransaction().commit();
            Cliente cliente = (Cliente) query.getSingleResult();
            finalizaHibernate();
            return cliente;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para actualizar un cliente completo
    @Override
    public void update(Cliente nuevo) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            em.merge(nuevo);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Cliente actualizado");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar cliente " + e.getMessage());
        }
    }

    // Metodo para modificar el nombre del cliente
    public void updateNombre(Cliente cliente, String nombre) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            cliente.setNombre(nombre);
            em.merge(cliente);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Nombre actualizado");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar nombre " + e.getMessage());
        }
    }

    // Metodo para modificar el apellido del cliente
    public void updateApellido(Cliente cliente, String apellido) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            cliente.setApellido(apellido);
            em.merge(cliente);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Apellido actualizado");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar apellido " + e.getMessage());
        }
    }

    // Metodo para modificar el dni del cliente
    public void updateDni(Cliente cliente, String dni) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            cliente.setDni(dni);
            em.merge(cliente);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Dni actualizado");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar dni " + e.getMessage());
        }
    }

    // Metodo para modificar la edad del cliente
    public void updateEdad(Cliente cliente, int edad) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            cliente.setEdad(edad);
            em.merge(cliente);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Edad actualizada");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar edad " + e.getMessage());
        }
    }

    // Metodo para modificar la direccion del cliente
    public void updateDireccion(Cliente cliente, Direccion direccion) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            cliente.setDireccion(direccion);
            em.merge(cliente);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Direccion actualizada");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar direccion " + e.getMessage());
        }
    }

    //Metodo para eliminar un cliente
    @Override
    public void delete(Cliente cliente) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("DELETE FROM Cliente c WHERE c.idCliente = :id");
            query.setParameter("id", cliente.getIdCliente());
            int result = query.executeUpdate();
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Cliente eliminado");
        } catch (Exception e) {
            alertaVista.muestraError("Error al eliminar cliente " + e.getMessage());
        }
    }
}
