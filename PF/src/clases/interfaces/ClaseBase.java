package clases.interfaces;

import java.util.ArrayList;

import atributosDeRazaYClase.AtributeMultipliers;
import clases.habilidades.Habilidad;
import clases.recursos.Recursos;
import razas.clasesNoConcretas.RazaBase.POSIBLES_CLASES;

/**
 * Una interfaz usada para describir los atributos relevantes a un personaje
 * segun su clase.
 * 
 * @author lautarowojcik
 */
public interface ClaseBase {
	/**
	 * Un metodo para obtener el conjunto de habilidades de una clase.
	 * 
	 * @return Devuelve un {@code ArrayList} de habilidades.
	 */
	public ArrayList<Habilidad> getClassAbilities();

	/**
	 * Un metodo para obtener el conjunto de recursos de una clase.
	 * 
	 * @return Devuelve {@code Recursos}.
	 */
	public Recursos getClassResources();

	/**
	 * Un metodo para obtener el enum de clase de una clase.
	 * 
	 * @return Devuelve {@code POSIBLES_CLASES}.
	 */
	public POSIBLES_CLASES getEnumDeClase();

	/**
	 * Un metodo para obtener los multiplicadores de atributos de una clase.
	 * 
	 * @return Devuelve {@code AtributeMultipliers}.
	 */
	public AtributeMultipliers getMultiplicadorDeAtributosDeClase();
}
