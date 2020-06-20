package personajes.administradorUsuariosParaPersonajes.interfaces;

public class UsuarioNoRegistradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1246064252820502365L;

	private String nombreDeUsuario;

	public UsuarioNoRegistradoException(String nombreDeUsuario) {
		super("Usuario inexistente.\n");

		this.nombreDeUsuario = nombreDeUsuario;
	}

	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}
}
