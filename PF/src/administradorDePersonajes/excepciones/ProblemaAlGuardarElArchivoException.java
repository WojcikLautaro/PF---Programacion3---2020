package administradorDePersonajes.excepciones;

import java.io.IOException;

public class ProblemaAlGuardarElArchivoException extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IOException exepcion;

	public ProblemaAlGuardarElArchivoException(IOException exepcion) {
		super("Error al guardar el archivo");
		
		this.exepcion = exepcion;
	}
	
	public IOException getException () {
		return exepcion;
	}
}
