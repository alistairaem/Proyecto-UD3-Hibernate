package model.dao;

import model.entity.Revista;
import view.AlertaVista;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class RevistaDAO implements InterfazDAO<Revista> {

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

    //Metodo para crear una revista
    @Override
    public void create(Revista revista) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            em.persist(revista);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Revista creada correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al crear la revista " + e.getMessage());
        }
    }

    //Metodo para listar todas las revistas
    @Override
    public List<Revista> find() {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT r FROM Revista r");
            List<Revista> revistas = query.getResultList();
            em.getTransaction().commit();
            finalizaHibernate();
            return revistas;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para buscar una revista por id
    public Revista findById(int id) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT r FROM Revista r WHERE r.idLibro = :id");
            query.setParameter("id", id);
            Revista revista = (Revista) query.getSingleResult();
            em.getTransaction().commit();
            finalizaHibernate();
            return revista;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para buscar una revista por ISBN
    public Revista findByISBN(String isbn) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT r FROM Revista r WHERE r.isbn = :isbn");
            query.setParameter("isbn", isbn);
            Revista revista = (Revista) query.getSingleResult();
            em.getTransaction().commit();
            finalizaHibernate();
            return revista;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para buscar una revista por titulo
    public Revista findByTitulo(String titulo) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT r FROM Revista r WHERE r.titulo = :titulo");
            query.setParameter("titulo", titulo);
            Revista revista = (Revista) query.getSingleResult();
            em.getTransaction().commit();
            finalizaHibernate();
            return revista;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para buscar todas las revistas de una editorial
    public List<Revista> findByEditorial(String editorial) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT r FROM Revista r WHERE r.editorial = :editorial");
            query.setParameter("editorial", editorial);
            List<Revista> revistas = query.getResultList();
            em.getTransaction().commit();
            finalizaHibernate();
            return revistas;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para buscar todas las revistas de un tipo
    public List<Revista> findByTipo(String tipo) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT r FROM Revista r WHERE r.tipo = :tipo");
            query.setParameter("tipo", tipo);
            List<Revista> revistas = query.getResultList();
            em.getTransaction().commit();
            finalizaHibernate();
            return revistas;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para buscar todas las revistas de un año en concreto
    public List<Revista> findByAño(int año) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT r FROM Revista r WHERE year (r.fechaPublicacion) = :año");
            query.setParameter("año", año);
            List<Revista> revistas = query.getResultList();
            em.getTransaction().commit();
            finalizaHibernate();
            return revistas;
        } catch (Exception e) {
            return null;
        }
    }


    //Metodo para actualizar una revista
    @Override
    public void update(Revista revistaNueva) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            em.merge(revistaNueva);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Revista actualizada correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar la revista " + e.getMessage());
        }
    }

    //Metodo para actualizar el ISBN de una revista
    public void updateIsbn(Revista revista, String isbn) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            revista.setIsbn(isbn);
            em.merge(revista);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("ISBN actualizado correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar el ISBN " + e.getMessage());
        }
    }

    //Metodo para actualizar el titulo de una revista
    public void updateTitulo(Revista revista, String titulo) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            revista.setTitulo(titulo);
            em.merge(revista);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Titulo actualizado correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar el titulo " + e.getMessage());
        }
    }

    //Metodo para actualizar la editorial de una revista
    public void updateEditorial(Revista revista, String editorial) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            revista.setEditorial(editorial);
            em.merge(revista);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Editorial actualizada correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar la editorial " + e.getMessage());
        }
    }

    //Metodo para actualizar el tipo de una revista
    public void updateTipo(Revista revista, String tipo) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            revista.setTipo(tipo);
            em.merge(revista);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Tipo actualizado correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar el tipo " + e.getMessage());
        }
    }

    //Metodo para actualizar el numero de paginas de una revista
    public void updateNumPag(Revista revista, int numPag) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            revista.setLongitudImpresion(numPag);
            em.merge(revista);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Numero de paginas actualizado correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar el numero de paginas " + e.getMessage());
        }
    }

    //Metodo para actualizar la fecha de publicacion de una revista
    public void updateFechaPub(Revista revista, LocalDate fechaPub) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            revista.setFechaPublicacion(fechaPub);
            em.merge(revista);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Fecha de publicacion actualizada correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar la fecha de publicacion " + e.getMessage());
        }
    }


    //Metodo para eliminar una revista
    @Override
    public void delete(Revista revista) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("DELETE FROM Revista r WHERE r.idLibro = :id");
            query.setParameter("id", revista.getIdLibro());
            query.executeUpdate();
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Revista eliminada correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al eliminar la revista " + e.getMessage());
        }
    }
}
