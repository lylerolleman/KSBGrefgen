
public class Moon extends Entity {
	Planet host;
	public Moon(String name, Planet host, int position, int atmo) {
		super(name, position, atmo);
		host.addMoon(this);
		this.host = host;
	}
	public void setHost(Planet host) {
		this.host = host;
	}
	public Planet getHost() {return host;}
	
	public int distanceTo(Entity entity) {
		int start = getHost().getPosition();
		int majororbitdist;
		int entrydist;
		int escapedist;
		if (entity instanceof Planet) {
			Planet planet = (Planet) entity;
			majororbitdist = Math.abs(start - planet.getPosition());
			if (majororbitdist != 0) {
				entrydist = planet.numMoons();
				escapedist = getHost().numMoons() - getPosition();
			} else {
				escapedist = getPosition();
				entrydist = 0;
			}
		} else {
			Moon moon = (Moon) entity;
			majororbitdist = Math.abs(start - moon.getHost().getPosition());
			if (majororbitdist != 0) {
				entrydist = moon.getHost().numMoons() - moon.getPosition();
				escapedist = getHost().numMoons() - getPosition();
			} else {
				escapedist = Math.abs(moon.getPosition() - getPosition());
				entrydist = 0;
			}
			
		}
		
		return majororbitdist + escapedist + entrydist;
	}
}
