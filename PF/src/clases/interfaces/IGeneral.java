package clases.interfaces;
/**
 * Interfaz específicamente creada para crear métodos que TODAS las clases vayan a tener 
 * en común. Abajo dejo unos ejemplos para que sea más fácil entender la función de esta 
 * interfaz, agregar o quitar los que gusten.
 */
public interface IGeneral {
	public String recibirAtaque();
	public String recibirHechizo();
	public String revivir();
	public String morir();
	public String subirNivel();
	public String usarPocionVida();
}
