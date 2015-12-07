
public class Entity {
	String name;
	int position;
	int atmosphere;
	public Entity(String name, int position, int atmosphere) {
		this.name = name;
		this.position = position;
		this.atmosphere = atmosphere;
	}
	
	public int getPosition() {return position;}
	public String getName() {return name;}
	public boolean hasAtmosphere() {return atmosphere > 0;}
	public int atmosphereThickness() {return atmosphere;}
}
