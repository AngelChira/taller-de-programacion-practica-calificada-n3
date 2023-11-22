package negocio;

import entidad.Pelicula;

public class PeliculaNegocio {
    Pelicula pelicula;
    Pelicula[] peliculas; 
    Pelicula[] peliculasEncontradas;
    
    public PeliculaNegocio() {
        peliculas = new Pelicula[10];
        peliculasEncontradas = new Pelicula[peliculas.length];
    }
    
    public boolean agregar(String titulo, String categoria, String nacionalidad, short duracion){
        pelicula = new Pelicula(titulo, categoria, nacionalidad, duracion);
        for(int i = 0; i < peliculas.length; i++){
            if(peliculas[i] == null){
                peliculas[i] = pelicula;
                return true;
            }
        }
        return false;
    }
    
    public boolean actualizar(String tituloId, String titulo, String categoria, String nacionalidad, short duracion){
        pelicula = new Pelicula(titulo, categoria, nacionalidad, duracion);
        for(int i = 0; i < peliculas.length; i++){
            if(peliculas[i] != null && peliculas[i].getTitulo()== tituloId){
                peliculas[i] = pelicula;
                return true;
            }
        }
        return false;        
    }
    
    public boolean eliminar(String tituloId){
        for(int i = 0; i < peliculas.length; i++){
            if(peliculas[i] != null && peliculas[i].getTitulo() == tituloId){
                peliculas[i] = null;
                return true;
            }
        }
        return false;
    }
    
    public Pelicula[] listar(){
        return peliculas;
    }
    
    public void limpiarFiltro(){
        for(int i = 0; i < peliculasEncontradas.length; i++){
            peliculasEncontradas[i] = null;
        }
    }
    
    public void filtrarPeliculas(String valorBuscado){
        limpiarFiltro();
        int count = 0;
        for(int i = 0; i < peliculas.length; i++){
            if(peliculas[i] != null && (peliculas[i].getCategoria().trim().equalsIgnoreCase(valorBuscado.trim()) || peliculas[i].getNacionalidad().trim().equalsIgnoreCase(valorBuscado.trim()))){
                peliculasEncontradas[count] = peliculas[i];
                count++;
            }
        }
    }
    
    public Pelicula[] listarPeliculasFiltro(){
        return peliculasEncontradas;
    }
    
    public int totalPeliculas(){
        int count = 0;
        for(int i = 0; i < peliculas.length; i++){
            if(peliculas[i] != null){
                count++;                
            }
        }
        return count;
    }
    
    public int totalPeliculasFiltro(){
        int count = 0;
        for(int i = 0; i < peliculasEncontradas.length; i++){
            if(peliculasEncontradas[i] != null){
                count++;                
            }
        }
        return count;
    }
}
