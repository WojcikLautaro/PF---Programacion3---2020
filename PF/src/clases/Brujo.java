package clases;

import java.util.ArrayList;

import atributes.AtributeMultipliers;
import clases.interfaces.IMage;
import habilidades.Habilidad;
import razas.ClasesNoConcretas.RazaBase.POSIBLES_CLASES;
import razas.InterfacesClasesConcretas.HerenciaDraenelana;
import razas.InterfacesClasesConcretas.HerenciaElfa;
import razas.InterfacesClasesConcretas.HerenciaGoblin;
import razas.InterfacesClasesConcretas.HerenciaNoMuerta;
import razas.InterfacesClasesConcretas.HerenciaTroll;
import recursos.MaximosRecursos;
import recursos.Recursos;

public class Brujo extends ClaseBase implements IMage,HerenciaTroll, HerenciaGoblin, HerenciaNoMuerta, HerenciaElfa, HerenciaDraenelana {
	@Override
	public POSIBLES_CLASES getEnumDeClase () {
		return POSIBLES_CLASES.BRUJO;
	}

	@Override
	public AtributeMultipliers getMultiplicadorDeAtributosDeClase() {
		return new AtributeMultipliers(1,1,1,1,1,1,1,1);
	}

	@Override
	public Recursos getClassResources() {
		return new Recursos(new MaximosRecursos(100, 100, 0, 0));
	}

	@Override
	public ArrayList<Habilidad> getClassAbilities()  {
		return new ArrayList <> ();
	}

	/**
	 *@author Anonymous(?
	 * Agregamos como testeo la interface para jugar con las habilidades.
	 * @return String
	 */
	 
	 
	
	@Override
	public String basicSpell() {
		float totalDamage = 100; // 100 es el daño que realiza el hechizo básico.
		float totalInteligence = this.getMultiplicadorDeAtributosDeClase().getInteligence(); 
		float totalCharisma = this.getMultiplicadorDeAtributosDeClase().getCarism();
		totalDamage+= totalDamage / (totalInteligence/100);
		totalDamage+= totalDamage / (totalCharisma/100);
		StringBuilder sb = new StringBuilder();
		sb.append("El ataque basico ha golpeado exitosamente realizando "+totalDamage+" daño.");
		return sb.toString();
	}

	/**
	 * La idea de estas funciones, es que evaluen según la suerte. Si el atributo suerte 
	 * por ejemplo es 15. Tenes un 15% de probabilidades de realizar ese hechizo. Ese
	 * será el factor que decida si esto se lleva a cabo o no.
	 */
	
	
	@Override
	public String freeze() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String teleport() {
		return null;
	}
}
