package clases.interfaces;
/**
 * Interfaz espec�ficamente creada para crear m�todos que TODAS las clases vayan a tener 
 * en com�n. Abajo dejo unos ejemplos para que sea m�s f�cil entender la funci�n de esta 
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
