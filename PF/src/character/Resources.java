package character;

import java.util.HashMap;

public class Resources {
	public static enum POSIBLE_RESOURCES { 
		LIFE,
		MANA,
		FURY,
		STAMINA,
		EXPERIENCE;
	} 
	
	public static HashMap <POSIBLE_RESOURCES, Float> Resources;
}