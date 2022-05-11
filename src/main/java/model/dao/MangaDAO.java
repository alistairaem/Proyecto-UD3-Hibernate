package model.dao;

import model.entity.Manga;
import view.AlertaVista;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class MangaDAO implements InterfazDAO<Manga> {

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

    //Metodo para crear un manga
    @Override
    public void create(Manga manga) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            em.persist(manga);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Manga creado correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al crear el manga " + e.getMessage());
        }
    }

    //Metodo para listar todos los manga
    @Override
    public List<Manga> find() {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT m FROM Manga m");
            em.getTransaction().commit();
            List<Manga> mangas = query.getResultList();
            finalizaHibernate();
            return mangas;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para buscar un manga por id
    public Manga findById(int id) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT m FROM Manga m WHERE m.idLibro = :id");
            query.setParameter("id", id);
            em.getTransaction().commit();
            Manga manga = (Manga) query.getSingleResult();
            finalizaHibernate();
            return manga;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para buscar un manga por isbn
    public Manga findByIsbn(String isbn) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT m FROM Manga m WHERE m.isbn = :isbn");
            query.setParameter("isbn", isbn);
            int result = query.executeUpdate();
            em.getTransaction().commit();
            Manga manga = (Manga) query.getSingleResult();
            finalizaHibernate();
            return manga;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para buscar un manga por titulo
    public Manga findByTitulo(String titulo) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT m FROM Manga m WHERE m.titulo = :titulo");
            query.setParameter("titulo", titulo);
            int result = query.executeUpdate();
            em.getTransaction().commit();
            Manga manga = (Manga) query.getSingleResult();
            finalizaHibernate();
            return manga;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para buscar todos los manga de un autor
    public List<Manga> findByAutor(String autor) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT m FROM Manga m WHERE m.autor = :autor");
            query.setParameter("autor", autor);
            int result = query.executeUpdate();
            em.getTransaction().commit();
            List<Manga> mangas = query.getResultList();
            finalizaHibernate();
            return mangas;
        } catch (Exception e) {
            return null;
        }
    }


    //Metodo para buscar todos los manga de una editorial
    public List<Manga> findByEditorial(String editorial) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT m FROM Manga m WHERE m.editorial = :editorial");
            query.setParameter("editorial", editorial);
            int result = query.executeUpdate();
            em.getTransaction().commit();
            List<Manga> mangas = query.getResultList();
            finalizaHibernate();
            return mangas;
        } catch (Exception e) {
            return null;
        }
    }


    //Metodo para buscar todos los manga de un genero
    public List<Manga> findByGenero(String genero) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT m FROM Manga m WHERE m.genero = :genero");
            query.setParameter("genero", genero);
            int result = query.executeUpdate();
            em.getTransaction().commit();
            List<Manga> mangas = query.getResultList();
            finalizaHibernate();
            return mangas;
        } catch (Exception e) {
            return null;
        }
    }


    //Metodo para buscar todos los manga de una demografia
    public List<Manga> findByDemografia(String demografia) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT m FROM Manga m WHERE m.demografia = :demografia");
            query.setParameter("demografia", demografia);
            int result = query.executeUpdate();
            em.getTransaction().commit();
            List<Manga> mangas = query.getResultList();
            finalizaHibernate();
            return mangas;
        } catch (Exception e) {
            return null;
        }
    }


    //Metodo para buscar todos los manga a color
    public List<Manga> findAllColor() {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT m FROM Manga m WHERE m.color = :color");
            query.setParameter("color", true);
            List<Manga> mangas = query.getResultList();
            em.getTransaction().commit();
            finalizaHibernate();
            return mangas;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para buscar todos los manga en blanco y negro
    public List<Manga> findAllBlancoNegro() {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT m FROM Manga m WHERE m.color = :color");
            query.setParameter("color", false);
            List<Manga> mangas = query.getResultList();
            em.getTransaction().commit();
            finalizaHibernate();
            return mangas;
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo para buscar todos los manga de un año
    public List<Manga> findAllAño(int año) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT m FROM Manga m WHERE year(m.fechaPublicacion) = :año");
            query.setParameter("año", año);
            List<Manga> mangas = query.getResultList();
            em.getTransaction().commit();
            finalizaHibernate();
            return mangas;
        } catch (Exception e) {
            return null;
        }
    }


    //Metodo para actualizar un manga entero
    @Override
    public void update(Manga mangaNuevo) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            em.merge(mangaNuevo);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Manga actualizado correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar el manga " + e.getMessage());
        }
    }

    //Metodo para actualizar el isbn de un manga
    public void updateIsbn(Manga manga, String isbn) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            manga.setIsbn(isbn);
            em.merge(manga);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("ISBN actualizado correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar el ISBN " + e.getMessage());
        }
    }

    //Metodo para actualizar el titulo un manga
    public void updateTitulo(Manga manga, String titulo) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            manga.setTitulo(titulo);
            em.merge(manga);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Titulo actualizado correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar el titulo " + e.getMessage());
        }
    }

    //Metodo para actualizar el autor de un manga
    public void updateAutor(Manga manga, String autor) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            manga.setAutor(autor);
            em.merge(manga);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Autor actualizado correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar el autor " + e.getMessage());
        }
    }

    //Metodo para actualizar el genero de un manga
    public void updateGenero(Manga manga, String genero) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            manga.setGenero(genero);
            em.merge(manga);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Genero actualizado correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar el genero " + e.getMessage());
        }
    }

    //Metodo para actualizar la demografia de un manga
    public void updateDemografia(Manga manga, String demografia) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            manga.setDemografia(demografia);
            em.merge(manga);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Demografia actualizado correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar la demografia " + e.getMessage());
        }
    }

    //Metodo para actualizar la editorial de un manga
    public void updateEditorial(Manga manga, String editorial) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            manga.setEditorial(editorial);
            em.merge(manga);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Editorial actualizado correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar la editorial " + e.getMessage());
        }
    }

    //Metodo para actualizar el color de un manga
    public void updateColor(Manga manga, Boolean color) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            manga.setColor(color);
            em.merge(manga);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Color actualizado correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar el color " + e.getMessage());
        }
    }

    //Metodo para actuliazar las paginas de un manga
    public void updatePaginas(Manga manga, int paginas) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            manga.setLongitudImpresion(paginas);
            em.merge(manga);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Paginas actualizado correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar las paginas " + e.getMessage());
        }
    }

    //Metodo para actualizar la fecha de publicacion de un manga
    public void updateFecha(Manga manga, LocalDate fecha) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            manga.setFechaPublicacion(fecha);
            em.merge(manga);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Fecha actualizado correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al actualizar la fecha " + e.getMessage());
        }
    }


    //Metodo para eliminar un manga
    @Override
    public void delete(Manga manga) {
        try {
            iniciaHibernate();
            em.getTransaction().begin();
            em.remove(manga);
            em.getTransaction().commit();
            finalizaHibernate();
            alertaVista.muestraMensaje("Manga eliminado correctamente");
        } catch (Exception e) {
            alertaVista.muestraError("Error al eliminar el manga " + e.getMessage());
        }
    }

}
