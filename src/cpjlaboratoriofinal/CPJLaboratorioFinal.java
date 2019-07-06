package cpjlaboratoriofinal;

import java.util.Scanner;
import mx.com.gm.peliculas.negocio.CatalogoPeliculas;
import mx.com.gm.peliculas.negocio.CatalogoPeliculasImpl;

/**
 * Contiene el menú que permite al usuario seleccionar la acción a ejecutar
 * sobre el catálogo de películas
 * 
 * @author Manuel González
 */
public class CPJLaboratorioFinal {

	public static void main(String[] args) {
		String nombreArchivo = "C:\\archivos\\peliculas.txt";
		CatalogoPeliculas catalogoPeliculas = new CatalogoPeliculasImpl();
		
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Elige opción:");
			System.out.println("1.- Iniciar catalogo películas");
			System.out.println("2.- Agregar película");
			System.out.println("3.- Listar películas");
			System.out.println("4.- Buscar película");
			System.out.println("0.- Salir");
			
			opcion = sc.nextInt();

			switch (opcion) {
			case 0:
				break;

			case 1:
				catalogoPeliculas.iniciarArchivo(nombreArchivo);
				break;

			case 2:
				System.out.print("Introduce el nombre de una película a agregar: ");
				String nombrePelicula = sc.next();
				catalogoPeliculas.agregarPelicula(nombrePelicula, nombreArchivo);
				break;

			case 3:
				catalogoPeliculas.listarPeliculas(nombreArchivo);
				break;

			case 4:
				System.out.print("Introduce el nombre de la película a buscar: ");
				String buscar = sc.next();
				catalogoPeliculas.buscarPelicula(nombreArchivo, buscar);
			}

		} while (opcion != 0);
		
		sc.close();
	}

}
