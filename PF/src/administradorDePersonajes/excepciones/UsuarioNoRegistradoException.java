package administradorDePersonajes.excepciones;

public class UsuarioNoRegistradoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1246064252820502365L;

	private String nombreDeUsuario;
	
	public UsuarioNoRegistradoException(String nombreDeUsuario) {
		super("Usuario no inexistente");
		
		this.nombreDeUsuario = nombreDeUsuario;
	}
	
	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}
}
