package mx.com.gm.peliculas.excepciones;

public class AccesoDatosEx extends Exception {
	private static final long serialVersionUID = 1L;
	String message;
	
	public AccesoDatosEx(String message) {
		this.message = message;
	}
}
