
public class ContractCard {
	String name;
	String desc;
	Entity dest;
	Integer payload;
	int MTYPE;
	
	Integer fundreward;
	Integer fuelreward;
	Integer sciencereward;
	Integer vpreward;
	
	public ContractCard(String name, String desc, Entity dest, Integer payload, int MTYPE) {
		this.name = name;
		this.desc = desc;
		this.dest = dest;
		this.payload = payload;
		this.MTYPE = MTYPE;
		generate();
	}
	
	private void generate() {
		Integer ccscore = 0;
		switch (MTYPE) {
			case Constants.MTYPE_ORBIT: {
				Cost cost = Config.planets[3].fuelToOrbit(dest, 1, payload);
				DistData data = Config.planets[3].getDistanceData(dest);
				if (cost == null) {
					ccscore = (int) ((payload*(data.majorDist()+Config.planets[3].atmosphereThickness()) + 
							data.minorDist()/2) * Config.contract_refuel_mult);
				} else {
					ccscore = cost.fuelCost() + data.minorDist()/2;
					ccscore = (int) (ccscore * Config.contract_norefuel_mult);
				}
				break;
			} case Constants.MTYPE_LANDING: {
				Cost cost = Config.planets[3].fuelToLand(dest, 1, payload);
				DistData data = Config.planets[3].getDistanceData(dest);
				if (cost == null) {
					ccscore = (int) ((payload*(data.majorDist()+Config.planets[3].atmosphereThickness()) + 
							data.minorDist()/2) * Config.contract_refuel_mult);
					if (!dest.hasAtmosphere())
						ccscore += payload;
				} else {
					ccscore = cost.fuelCost() + data.minorDist()/2 + payload;
					ccscore = (int) (ccscore * Config.contract_norefuel_mult);
				}
				break;
			} case Constants.MTYPE_ROUNDTRIP: {
				Cost cost = Config.planets[3].fuelRoundTrip(dest, 1, payload);
				DistData data = Config.planets[3].getDistanceData(dest);
				if (cost == null) {
					ccscore = (int) ((payload*(data.majorDist()+Config.planets[3].atmosphereThickness()) + 
							data.minorDist()/2) * Config.contract_refuel_mult)*2;
				} else {
					ccscore = cost.fuelCost() + data.minorDist()/2 + 2*payload;
					ccscore = (int) (ccscore * Config.contract_norefuel_mult);
				}
				break;
			} case Constants.MTYPE_ORBITROUNDTRIP: {
				Cost cost = Config.planets[3].fuelToOrbit(dest, 1, payload);
				DistData data = Config.planets[3].getDistanceData(dest);
				if (cost == null) {
					ccscore = (int) ((payload*(data.majorDist()+Config.planets[3].atmosphereThickness()) + 
							data.minorDist()/2) * Config.contract_refuel_mult);
				} else {
					ccscore = cost.fuelCost()*2 + data.minorDist()/2;
					ccscore = (int) (ccscore * Config.contract_norefuel_mult);
				}
				break;
			}
		}
		
		fuelreward = (int) (ccscore * Config.contract_fuel_balance);
		sciencereward = (int) (ccscore * Config.contract_science_balance);
		fundreward = (int) Math.ceil(ccscore * Config.contract_funds_balance);
		vpreward = (int) (ccscore * Config.contract_vp_balance);
	}
	
	public String toString() {
		String ret = name + ":\n" + desc + "\nReward: ";
		if (!fundreward.equals(0))
			ret = ret + fundreward + " Funds";
		if (!sciencereward.equals(0))
			ret = ret + ", " + sciencereward + " Science";
		if (!fuelreward.equals(0))
			ret = ret + ", " + fuelreward + " Fuel";
		if (!vpreward.equals(0))
			ret = ret + ", " + vpreward + " VP";
		return ret + "\n";
	}
}
