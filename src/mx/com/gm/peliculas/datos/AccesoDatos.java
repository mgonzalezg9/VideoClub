package mx.com.gm.peliculas.datos;

import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;

public interface AccesoDatos {
	public boolean existe(String nombreArchivo);
	
	public List<Pelicula> listar(String nombre);
	
	public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar);
	
	public boolean buscar(String nombreArchivo, String buscar);
	
	public void crear(String nombreArchivo);
	
	public void borrar(String nombreArchivo);
}
