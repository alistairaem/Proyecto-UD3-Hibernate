package controller;

import model.dao.RevistaDAO;
import model.entity.Revista;
import view.RevistaVista;
import view.Teclado;

import java.time.LocalDate;
import java.util.List;

public class RevistaControlador {

    private Teclado teclado = new Teclado();

    private RevistaDAO revistaDAO = new RevistaDAO();

    private RevistaVista revistaVista = new RevistaVista();

    //Metodo para crear una revista
    public void crearRevista() {
        Revista revista = revistaVista.datosRevista();
        revistaDAO.create(revista);
    }

    public Revista nuevaRevista() {
        Revista revista = revistaVista.datosRevista();
        revistaDAO.create(revista);
        return revista;
    }

    //Metodo para mostrar una revista por ID
    public void mostrarRevistaPorId() {
        int id = teclado.pideInt("Introduce el id de la revista: ");
        Revista revista = revistaDAO.findById(id);
        if (revista != null) {
            revistaVista.muestraRevista(revista);
        } else {
            revistaVista.mensaje("No existe la revista");
        }
    }

    //Metodo para buscar una revista por id
    public Revista buscarRevistaPorId(int id) {
        Revista revista = revistaDAO.findById(id);
        if (revista != null) {
            return revista;
        } else {
            revistaVista.mensaje("No existe la revista");
            return null;
        }
    }

    //Metodo para mostrar una revista por titulo
    public void mostrarRevistaPorTitulo() {
        String titulo = teclado.pideString("Introduce el titulo de la revista: ");
        Revista revista = revistaDAO.findByTitulo(titulo);
        if (revista != null) {
            revistaVista.muestraRevista(revista);
        } else {
            revistaVista.mensaje("No existe la revista");
        }
    }


    //Metodo para mostrar una revista por ISBN
    public void mostrarRevistaPorISBN() {
        String isbn = teclado.pideString("Introduce el ISBN de la revista: ");
        Revista revista = revistaDAO.findByISBN(isbn);
        if (revista != null) {
            revistaVista.muestraRevista(revista);
        } else {
            revistaVista.mensaje("No existe la revista");
        }
    }

    //Metodo para mostrar todas las revistas de una editorial
    public void mostrarRevistasPorEditorial() {
        String editorial = teclado.pideString("Introduce la editorial: ");
        List<Revista> revistas = revistaDAO.findByEditorial(editorial);
        for (Revista revista : revistas) {
            revistaVista.muestraRevista(revista);
        }
    }

    //Metodo para mostrar todas las revistas de un tipo
    public void mostrarRevistasPorTipo() {
        String tipo = teclado.pideString("Introduce el tipo: ");
        List<Revista> revistas = revistaDAO.findByTipo(tipo);
        for (Revista revista : revistas) {
            revistaVista.muestraRevista(revista);
        }
    }

    //Metodo para mostrar todas las revistas de un año
    public void mostrarRevistasPorAño() {
        int año = teclado.pideInt("Introduce el año: ");
        List<Revista> revistas = revistaDAO.findByAño(año);
        for (Revista revista : revistas) {
            revistaVista.muestraRevista(revista);
        }
    }

    //Metodo para mostrar todas las revistas
    public void mostrarRevistas() {
        List<Revista> revistas = revistaDAO.find();
        for (Revista revista : revistas) {
            revistaVista.muestraRevista(revista);
        }
    }

    //Metodo para actualizar una revista
    public void actualizarRevista() {
        int id = teclado.pideInt("Introduce el id de la revista: ");
        Revista revista = revistaDAO.findById(id);
        if (revista != null) {
            Revista revistaActualizada = revistaVista.datosRevista();
            revista.setLongitudImpresion(revistaActualizada.getLongitudImpresion());
            revista.setTitulo(revistaActualizada.getTitulo());
            revista.setEditorial(revistaActualizada.getEditorial());
            revista.setTipo(revistaActualizada.getTipo());
            revista.setFechaPublicacion(revistaActualizada.getFechaPublicacion());
            revista.setIsbn(revistaActualizada.getIsbn());
            revistaDAO.update(revista);
        } else {
            revistaVista.mensaje("No existe la revista");
        }
    }

    //Metodo para actualizar el ISBN de una revista
    public void actualizarISBN() {
        int id = teclado.pideInt("Introduce el id de la revista: ");
        Revista revista = revistaDAO.findById(id);
        if (revista != null) {
            String isbn = teclado.pideString("Introduce el nuevo ISBN: ");
            revistaDAO.updateIsbn(revista, isbn);
        } else {
            revistaVista.mensaje("No existe la revista");
        }
    }

    //Metodo para actualizar el titulo de una revista
    public void actualizarTitulo() {
        int id = teclado.pideInt("Introduce el id de la revista: ");
        Revista revista = revistaDAO.findById(id);
        if (revista != null) {
            String titulo = teclado.pideString("Introduce el nuevo titulo: ");
            revistaDAO.updateTitulo(revista, titulo);
        } else {
            revistaVista.mensaje("No existe la revista");
        }
    }

    //Metodo para actualizar la editorial de una revista
    public void actualizarEditorial() {
        int id = teclado.pideInt("Introduce el id de la revista: ");
        Revista revista = revistaDAO.findById(id);
        if (revista != null) {
            String editorial = teclado.pideString("Introduce la nueva editorial: ");
            revistaDAO.updateEditorial(revista, editorial);
        } else {
            revistaVista.mensaje("No existe la revista");
        }
    }

    //Metodo para actualizar el tipo de una revista
    public void actualizarTipo() {
        int id = teclado.pideInt("Introduce el id de la revista: ");
        Revista revista = revistaDAO.findById(id);
        if (revista != null) {
            String tipo = teclado.pideString("Introduce el nuevo tipo: ");
            revistaDAO.updateTipo(revista, tipo);
        } else {
            revistaVista.mensaje("No existe la revista");
        }
    }

    //Metodo para actualizar el numero de paginas de una revista
    public void actualizarNumeroPaginas() {
        int id = teclado.pideInt("Introduce el id de la revista: ");
        Revista revista = revistaDAO.findById(id);
        if (revista != null) {
            int numeroPaginas = teclado.pideInt("Introduce el nuevo numero de paginas: ");
            revistaDAO.updateNumPag(revista, numeroPaginas);
        } else {
            revistaVista.mensaje("No existe la revista");
        }
    }

    //Metodo para actualizar la fecha de publicacion de una revista
    public void actualizarFechaPublicacion() {
        int id = teclado.pideInt("Introduce el id de la revista: ");
        Revista revista = revistaDAO.findById(id);
        if (revista != null) {
            LocalDate fechaPublicacion = revistaVista.fechaPublicacion();
            revistaDAO.updateFechaPub(revista, fechaPublicacion);
        } else {
            revistaVista.mensaje("No existe la revista");
        }
    }

    //Metodo para eliminar una revista
    public void eliminarRevista() {
        int id = teclado.pideInt("Introduce el id de la revista: ");
        Revista revista = revistaDAO.findById(id);
        if (revista != null) {
            revistaDAO.delete(revista);
        } else {
            revistaVista.mensaje("No existe la revista");
        }
    }
}
