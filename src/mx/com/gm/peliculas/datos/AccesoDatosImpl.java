package mx.com.gm.peliculas.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import mx.com.gm.peliculas.domain.Pelicula;

public class AccesoDatosImpl implements AccesoDatos {
	@Override
	public boolean existe(String nombreArchivo) {
		return (new File(nombreArchivo)).exists();
	}

	@Override
	public List<Pelicula> listar(String nombre) {
		BufferedReader bf = null;
		if (existe(nombre)) {
			try {
				bf = new BufferedReader(new FileReader(nombre));
			} catch (FileNotFoundException e1) {}
			
			// Lista contenedora
			List<Pelicula> lista = new LinkedList<>();

			try {
				while (bf.ready()) {
					lista.add(new Pelicula(bf.readLine()));
				}
			} catch (IOException e) {}
			
			try {
				bf.close();
			} catch (IOException e) {}
			return lista;
		} else {
			System.out.println("El archivo del catalogo no existe");
			return null;
		}
	}

	@Override
	public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) {
		PrintWriter bf = null;
		try {
			bf = new PrintWriter(new FileWriter(nombreArchivo, anexar));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		bf.println(pelicula.getNombre());
		
		bf.close();
	}

	@Override
	public boolean buscar(String nombreArchivo, String buscar) {
		List<Pelicula> lista = listar(nombreArchivo);
		List<String> nombres = new LinkedList<>();
		
		lista.stream()
				.forEach(p -> nombres.add(p.getNombre()));
		
		return nombres.contains(buscar);
	}

	@Override
	public void crear(String nombreArchivo) {
		PrintWriter bf = null;
		try {
			bf = new PrintWriter(new FileWriter(nombreArchivo));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		bf.close();
	}

	@Override
	public void borrar(String nombreArchivo) {
		escribir(new Pelicula(), nombreArchivo, false);
	}

}
