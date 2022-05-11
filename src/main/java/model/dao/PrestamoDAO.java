package model.dao;


import model.entity.Prestamo;
import view.AlertaVista;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class PrestamoDAO implements InterfazDAO<Prestamo> {
    private EntityManagerFactory emf;
    private EntityManager em;

    private final AlertaVista alertaVista = new AlertaVista();

    private void iniciaHibernate() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }

    private void finalizaHibernate() {
        em.close();
        emf.close();
    }

    //Metodo para crear un prestamo
    @Override
    public void create(Prestamo prestamo) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            em.persist(prestamo);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Prestamo creado");
        } catch (Exception e) {
            alertaVista.muestraError("Error al crear el prestamo " + e.getMessage());
        }
    }

    //Metodo para buscar todos los prestamos
    @Override
    public List<Prestamo> find() {
        try {
            iniciaHibernate();
            List<Prestamo> prestamos = em.createQuery("SELECT p FROM Prestamo p").getResultList();
            finalizaHibernate();
            return prestamos;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para actualizar un prestamo completo
    @Override
    public void update(Prestamo prestamo) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            em.merge(prestamo);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Prestamo actualizado");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar el prestamo " + e.getMessage());

        }
    }

    //Metodo para eliminar un prestamo
    @Override
    public void delete(Prestamo prestamo) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            em.remove(prestamo);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Prestamo eliminado");
        } catch (Exception e) {
            alertaVista.muestraError("Error al eliminar el prestamo " + e.getMessage());
        }
    }


    //Metodo para buscar un prestamo por su id
    public Prestamo findById(int id) {
        try {
            iniciaHibernate();
            Query query = em.createQuery("SELECT p FROM Prestamo p WHERE p.idPrestamo = :id");
            query.setParameter("id", id);
            Prestamo prestamo = (Prestamo) query.getSingleResult();
            finalizaHibernate();
            return prestamo;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para obtener los prestamos de un cliente
    public List<Prestamo> findByCliente(int id) {
        try {
            iniciaHibernate();
            Query query = em.createQuery("SELECT p FROM Prestamo p WHERE p.cliente.idCliente = :cliente");
            query.setParameter("cliente", id);
            List<Prestamo> prestamos = query.getResultList();
            finalizaHibernate();
            return prestamos;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para obtener los prestamos de un cliente sin devolver
    public List<Prestamo> findByClienteSinDevolver(int id) {
        try {
            iniciaHibernate();
            Query query = em.createQuery("SELECT p FROM Prestamo p WHERE p.cliente.idCliente = :cliente AND p.devuelto = :devuelto");
            query.setParameter("cliente", id);
            query.setParameter("devuelto", false);
            List<Prestamo> prestamos = query.getResultList();
            finalizaHibernate();
            return prestamos;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para obtener los prestamos sin devolver
    public List<Prestamo> findPrestamosSinDevolver() {
        try {
            iniciaHibernate();
            Query query = em.createQuery("SELECT p FROM Prestamo p WHERE p.devuelto = false");
            List<Prestamo> prestamos = query.getResultList();
            finalizaHibernate();
            return prestamos;
        } catch (Exception e) {
            return null;
        }
    }


    //Metodo para obtener los prestamos que finalizan hoy
    public List<Prestamo> findPrestamosDevolverHoy() {
        try {
            iniciaHibernate();
            Query query = em.createQuery("SELECT p FROM Prestamo p WHERE p.devuelto = false AND p.fechaFin = :fecha");
            query.setParameter("fecha", LocalDate.now());
            List<Prestamo> prestamos = query.getResultList();
            finalizaHibernate();
            return prestamos;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para devolver un libro a dia de hoy
    public void finalizarPrestamo(Prestamo prestamo) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            em.merge(prestamo);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Prestamo finalizado");
        } catch (Exception e) {
            alertaVista.muestraError("Error al finalizar el prestamo " + e.getMessage());
        }
    }

    //Metodo para modificar la fecha de devolucion
    public void modificarFechaDevolucion(Prestamo prestamo) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            em.merge(prestamo);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Fecha de devolucion modificada");
        } catch (Exception e) {
            alertaVista.muestraError("Error al modificar la fecha de devolucion " + e.getMessage());
        }
    }

    //Metodo para buscar los prestamos que finalizan esta semana
    public List<Prestamo> findPrestamosDevolverSemana() {
        try {
            iniciaHibernate();
            Query query = em.createQuery("SELECT p FROM Prestamo p WHERE p.devuelto = false AND p.fechaFin BETWEEN :fecha1 AND :fecha2");
            query.setParameter("fecha1", LocalDate.now());
            query.setParameter("fecha2", LocalDate.now().plusDays(7));
            List<Prestamo> prestamos = query.getResultList();
            finalizaHibernate();
            return prestamos;
        } catch (Exception e) {
            return null;
        }
    }
}
