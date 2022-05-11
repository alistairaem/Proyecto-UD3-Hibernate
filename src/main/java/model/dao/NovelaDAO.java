package model.dao;


import model.entity.Novela;
import view.AlertaVista;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class NovelaDAO implements InterfazDAO<Novela> {

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

    //Metodo para crear novelas
    @Override
    public void create(Novela novela) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            em.persist(novela);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Novela creada correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al crear novela " + e.getMessage());
        }

    }


    //Metodo para mostrar todas las novelas
    @Override
    public List<Novela> find() {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT n FROM Novela n");
            em.getTransaction().commit();
            List<Novela> novelas = query.getResultList();
            finalizaHibernate();
            return novelas;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para mostrar una novela por id
    public Novela findById(int id) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT n FROM Novela n WHERE n.idLibro = :id");
            query.setParameter("id", id);
            em.getTransaction().commit();
            Novela novela = (Novela) query.getSingleResult();
            finalizaHibernate();
            return novela;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para mostrar novela por titulo
    public Novela findByTitulo(String titulo) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT n FROM Novela n WHERE n.titulo = :titulo");
            query.setParameter("titulo", titulo);
            em.getTransaction().commit();
            Novela novela = (Novela) query.getSingleResult();
            finalizaHibernate();
            return novela;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para mostrar novela por ISBN
    public Novela findByISBN(String isbn) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT n FROM Novela n WHERE n.isbn = :isbn");
            query.setParameter("isbn", isbn);
            em.getTransaction().commit();
            Novela novela = (Novela) query.getSingleResult();
            finalizaHibernate();
            return novela;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para mostrar las novelas de un autor
    public List<Novela> findByAutor(String autor) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT n FROM Novela n WHERE n.autor = :autor");
            query.setParameter("autor", autor);
            em.getTransaction().commit();
            List<Novela> novelas = query.getResultList();
            finalizaHibernate();
            return novelas;
        } catch (Exception e) {
            return null;
        }
    }


    //Metodo para mostrar las novelas de una editorial
    public List<Novela> findByEditorial(String editorial) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT n FROM Novela n WHERE n.editorial = :editorial");
            query.setParameter("editorial", editorial);
            em.getTransaction().commit();
            List<Novela> novelas = query.getResultList();
            finalizaHibernate();
            return novelas;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para mostrar las novelas de un tema
    public List<Novela> findByTema(String tema) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT n FROM Novela n WHERE n.tema = :tema");
            query.setParameter("tema", tema);
            em.getTransaction().commit();
            List<Novela> novelas = query.getResultList();
            finalizaHibernate();
            return novelas;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para mostrar las novelas de un subgenero
    public List<Novela> findBySubgenero(String subgenero) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT n FROM Novela n WHERE n.subgenero = :subgenero");
            query.setParameter("subgenero", subgenero);
            em.getTransaction().commit();
            List<Novela> novelas = query.getResultList();
            finalizaHibernate();
            return novelas;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para mostrar las novelas de un año
    public List<Novela> findByAño(int año) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT n FROM Novela n WHERE year(n.fechaPublicacion) = :año");
            query.setParameter("año", año);
            em.getTransaction().commit();
            List<Novela> novelas = query.getResultList();
            finalizaHibernate();
            return novelas;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para actualizar una novela completa
    public void update(Novela novelaNueva) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            em.merge(novelaNueva);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Novela actualizada correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar la novela " + e.getMessage());
        }
    }

    //Metodo para actualizar el ISBN de una novela
    public void updateISBN(Novela novela, String isbnNuevo) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            novela.setIsbn(isbnNuevo);
            em.merge(novela);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("ISBN actualizado correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar el ISBN " + e.getMessage());
        }
    }

    //Metodo para actualizar el titulo de una novela
    public void updateTitulo(Novela novela, String tituloNuevo) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            novela.setTitulo(tituloNuevo);
            em.merge(novela);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Titulo actualizado correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar el titulo " + e.getMessage());
        }
    }

    //Metodo para actualizar el autor de una novela
    public void updateAutor(Novela novela, String autorNuevo) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            novela.setAutor(autorNuevo);
            em.merge(novela);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Autor actualizado correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar el autor " + e.getMessage());
        }
    }

    //Metodo para actualizar el tema de una novela
    public void updateTema(Novela novela, String temaNuevo) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            novela.setTema(temaNuevo);
            em.merge(novela);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Tema actualizado correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar el tema " + e.getMessage());
        }
    }

    //Metodo para actualizar el subgenero de una novela
    public void updateSubgenero(Novela novela, String subgeneroNuevo) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            novela.setSubgenero(subgeneroNuevo);
            em.merge(novela);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Subgenero actualizado correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar el subgenero " + e.getMessage());
        }
    }

    //Metodo para actualizar la editorial de una novela
    public void updateEditorial(Novela novela, String editorialNueva) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            novela.setEditorial(editorialNueva);
            em.merge(novela);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Editorial actualizado correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar la editorial " + e.getMessage());
        }
    }

    //Metodo para actualizar el numero de paginas de una novela
    public void updatePaginas(Novela novela, int paginasNuevas) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            novela.setLongitudImpresion(paginasNuevas);
            em.merge(novela);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Numero de paginas actualizado correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar el numero de paginas " + e.getMessage());
        }
    }

    //Metodo para actualizar fecha de una novela
    public void updateFecha(Novela novela, LocalDate fechaNueva) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            novela.setFechaPublicacion(fechaNueva);
            em.merge(novela);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Fecha actualizada correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar la fecha " + e.getMessage());
        }
    }

    //Metodo para eliminar una novela
    @Override
    public void delete(Novela novela) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("DELETE FROM Novela n WHERE n.idLibro = :id");
            query.setParameter("id", novela.getIdLibro());
            int result = query.executeUpdate();
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Novela eliminada correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al eliminar la novela " + e.getMessage());
        }
    }
}
