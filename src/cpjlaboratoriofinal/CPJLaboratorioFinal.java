package cpjlaboratoriofinal;

import java.util.Scanner;
import mx.com.gm.peliculas.negocio.CatalogoPeliculas;
import mx.com.gm.peliculas.negocio.CatalogoPeliculasImpl;

/**
 * Contiene el men� que permite al usuario seleccionar la acci�n a ejecutar
 * sobre el cat�logo de pel�culas
 * 
 * @author Manuel Gonz�lez
 */
public class CPJLaboratorioFinal {

	public static void main(String[] args) {
		String nombreArchivo = "C:\\archivos\\peliculas.txt";
		CatalogoPeliculas catalogoPeliculas = new CatalogoPeliculasImpl();
		
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Elige opci�n:");
			System.out.println("1.- Iniciar catalogo pel�culas");
			System.out.println("2.- Agregar pel�cula");
			System.out.println("3.- Listar pel�culas");
			System.out.println("4.- Buscar pel�cula");
			System.out.println("0.- Salir");
			
			opcion = sc.nextInt();

			switch (opcion) {
			case 0:
				break;

			case 1:
				catalogoPeliculas.iniciarArchivo(nombreArchivo);
				break;

			case 2:
				System.out.print("Introduce el nombre de una pel�cula a agregar: ");
				String nombrePelicula = sc.next();
				catalogoPeliculas.agregarPelicula(nombrePelicula, nombreArchivo);
				break;

			case 3:
				catalogoPeliculas.listarPeliculas(nombreArchivo);
				break;

			case 4:
				System.out.print("Introduce el nombre de la pel�cula a buscar: ");
				String buscar = sc.next();
				catalogoPeliculas.buscarPelicula(nombreArchivo, buscar);
			}

		} while (opcion != 0);
		
		sc.close();
	}

}
