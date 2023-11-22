
package entidad;

public class Pelicula {
    private String titulo;
    private String categoria;
    private String nacionalidad;
    private short duracion;

    public Pelicula() {
    }

    public Pelicula(String titulo, String categoria, String nacionalidad, short duracion) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.nacionalidad = nacionalidad;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public short getDuracion() {
        return duracion;
    }

    public void setDuracion(short duracion) {
        this.duracion = duracion;
    }  
    
}
