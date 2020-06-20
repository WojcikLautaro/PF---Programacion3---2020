package personajes.administradorUsuariosParaPersonajes.interfaces;

public class UsuarioOcupadoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1246064252820502365L;

	private String nombreDeUsuario;

	public UsuarioOcupadoException(String nombreDeUsuario) {
		super("Usuario ocupado.\n");

		this.nombreDeUsuario = nombreDeUsuario;
	}

	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}
}