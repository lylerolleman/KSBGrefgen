import java.util.ArrayList;


public class Planet extends Entity {
	ArrayList<Moon> moons;
	boolean canland;
	public Planet(String name, int position, int atmo, boolean canland) {
		super(name, position, atmo);
		this.moons = new ArrayList<Moon>();
		this.canland = canland;
	}
	public boolean canLand() {return canland;}
	public void addMoon(Moon moon) {
		moons.add(moon);
	}
	public boolean hasMoon(String name) {
		for (Moon moon : moons) {
			if (moon.getName().equals(name))
				return true;
		}
		return false;
	}
	public int numMoons() {return moons.size();}
	
	public Cost fuelToOrbit(Entity entity, int techlevel, int payload) {
		int majororbitdist;
		int atmocost = super.atmosphereThickness();
		if (super.hasAtmosphere() && techlevel == 4)
			atmocost--;
		if (entity instanceof Planet) {
			Planet planet = (Planet) entity;
			majororbitdist = Math.abs(getPosition() - planet.getPosition());
		} else {
			Moon moon = (Moon) entity;
			majororbitdist = Math.abs(getPosition() - moon.getHost().getPosition());
		}
		int totaltankcost = (atmocost + majororbitdist)*payload;
		int fuelcost = 0;
		int stagecount = 0;
		for (int i=0; i<totaltankcost; ) {
			for (int j=0; j<Config.tanksperstage[techlevel-1] && i<totaltankcost; j++, i++) {
				fuelcost += Config.tankcostperstage[stagecount];
			}
			stagecount++;
			if (stagecount == Config.tankcostperstage.length && i<totaltankcost)
				return null;
		}
		return new Cost(totaltankcost, fuelcost);
	}
	
	public Cost fuelToLand(Entity entity, int techlevel, int payload) {
		int majororbitdist;
		int atmocost = super.atmosphereThickness();
		if (super.hasAtmosphere() && techlevel == 4)
			atmocost--;
		if (!entity.hasAtmosphere())
			atmocost++;
		if (entity instanceof Planet) {
			Planet planet = (Planet) entity;
			if (!planet.canLand())
				return null;
			majororbitdist = Math.abs(getPosition() - planet.getPosition());
		} else {
			Moon moon = (Moon) entity;
			majororbitdist = Math.abs(getPosition() - moon.getHost().getPosition());
		}
		int totaltankcost = (atmocost + majororbitdist)*payload;
		int fuelcost = 0;
		int stagecount = 0;
		for (int i=0; i<totaltankcost; ) {
			for (int j=0; j<Config.tanksperstage[techlevel-1] && i<totaltankcost; j++, i++) {
				fuelcost += Config.tankcostperstage[stagecount];
			}
			stagecount++;
			if (stagecount == Config.tankcostperstage.length && i<totaltankcost)
				return null;
		}
		return new Cost(totaltankcost, fuelcost);
	}
	
	public Cost fuelRoundTrip(Entity entity, int techlevel, int payload) {
		int majororbitdist;
		int atmocost = super.atmosphereThickness() + entity.atmosphereThickness();
		if (super.hasAtmosphere() && techlevel == 4)
			atmocost--;
		if (entity.hasAtmosphere() && techlevel == 4)
			atmocost--;
		if (!entity.hasAtmosphere())
			atmocost++;
		if (!super.hasAtmosphere())
			atmocost++;
		if (entity instanceof Planet) {
			Planet planet = (Planet) entity;
			if (!planet.canLand())
				return null;
			majororbitdist = Math.abs(getPosition() - planet.getPosition())*2;
		} else {
			Moon moon = (Moon) entity;
			majororbitdist = Math.abs(getPosition() - moon.getHost().getPosition())*2;
		}
		int totaltankcost = (atmocost + majororbitdist)*payload;
		int fuelcost = 0;
		int stagecount = 0;
		for (int i=0; i<totaltankcost; ) {
			for (int j=0; j<Config.tanksperstage[techlevel-1] && i<totaltankcost; j++, i++) {
				fuelcost += Config.tankcostperstage[stagecount];
			}
			stagecount++;
			if (stagecount == Config.tankcostperstage.length && i<totaltankcost)
				return null;
		}
		return new Cost(totaltankcost, fuelcost);
	}
	
	public int distanceTo(Entity entity) {
		DistData data = getDistanceData(entity);
		return data.majorDist() + data.minorDist();
	}
	
	public DistData getDistanceData(Entity entity) {
		if (entity.equals(this))
			return new DistData(0, 0, 0);
		int start = super.getPosition();
		int majororbitdist;
		int entrydist;
		int escapedist;
		if (entity instanceof Planet) {
			Planet planet = (Planet) entity;
			majororbitdist = Math.abs(start - planet.getPosition());
			entrydist = planet.numMoons();
			escapedist = moons.size();
		} else {
			Moon moon = (Moon) entity;
			majororbitdist = Math.abs(start - moon.getHost().getPosition());
			
			if (majororbitdist != 0) {
				escapedist = moons.size();
				entrydist = moon.getHost().numMoons() - moon.getPosition();
			} else {
				escapedist = moon.getPosition();
				entrydist = 0;
			}
		}
	
		return new DistData(majororbitdist, escapedist, entrydist);
	}
}
