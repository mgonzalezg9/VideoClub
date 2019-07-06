package mx.com.gm.peliculas.negocio;

import java.util.List;

import mx.com.gm.peliculas.datos.AccesoDatos;
import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.domain.Pelicula;

public class CatalogoPeliculasImpl implements CatalogoPeliculas {
	AccesoDatos datos;

	public CatalogoPeliculasImpl() {
		this.datos = (AccesoDatos) new AccesoDatosImpl();
	}

	@Override
	public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
		boolean anexar = false;
		if (datos.existe(nombreArchivo)) {
			anexar = true;
			datos.escribir(new Pelicula(nombrePelicula), nombreArchivo, anexar);
		} else {
			System.out.println("Error de acceso a datos");
		}
	}

	@Override
	public void listarPeliculas(String nombreArchivo) {
		List<Pelicula> peliculas = datos.listar(nombreArchivo);
		
		for (Pelicula pelicula : peliculas) {
			System.out.println(pelicula);
		}
	}

	@Override
	public void buscarPelicula(String nombreArchivo, String buscar) {
		if (datos.buscar(nombreArchivo, buscar)) {
			System.out.println("La película ha sido encontrada");
		} else {
			System.out.println("La película no se encuentra en el catálogo");
		}
	}

	@Override
	public void iniciarArchivo(String nombreArchivo) {
		datos.crear(nombreArchivo);
		System.out.println("El archivo que contiene al catálogo se ha creado con éxito");
	}
	
	
	
	
}
