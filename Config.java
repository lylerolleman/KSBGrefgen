
public class Config {
	public final static int MPT = 2;
	public final static double contract_refuel_mult = 2.0;
	public final static double contract_norefuel_mult = 1.0;
	public final static double contract_science_balance = 0.5;
	public final static double contract_fuel_balance = 0;
	public final static double contract_funds_balance = 0.67;
	public final static double contract_vp_balance = 0.33;
	
	public final static Integer[] tankcostperstage = {
		1,
		2,
		3
	};
	public final static Integer[] tanksperstage = {
		//2,
		3
		//4,
		//4
	};
	
	public final static Planet[] planets = {
		new Planet("Kerbol", 0, 0, false),
		new Planet("Moho", 1, 0, true),
		new Planet("Eve", 2, 2, true),
		new Planet("Kerbin", 3, 1, true),
		new Planet("Duna", 4, 1, true),
		new Planet("Dres", 5, 0, true),
		new Planet("Jool", 6, 0, false),
		new Planet("Eeloo", 7, 0, true)
	};
	
	public final static Moon[] moons = {
		new Moon("Gilly", planets[2], 1, 0),
		new Moon("Mun", planets[3], 1, 0),
		new Moon("Minmus", planets[3], 2, 0),
		new Moon("Ike", planets[4], 1, 0),
		new Moon("Laythe", planets[6], 1, 1),
		new Moon("Vall", planets[6], 2, 0),
		new Moon("Tylo", planets[6], 3, 0),
		new Moon("Bop", planets[6], 4, 0),
		new Moon("Pol", planets[6], 5, 0)
	};
	
	public final static ContractCard[] contractcards = {
		new ContractCard(
				"James Kerman Telescope",
				"Build a research station around Kerbol", 
				planets[0], 
				Constants.LOAD_HEAVY, 
				Constants.MTYPE_ORBIT),
		new ContractCard(
				"Kerbol EVA",
				"Perform an EVA around Kerbol and return safely", 
				planets[0], 
				Constants.LOAD_LIGHT, 
				Constants.MTYPE_ORBITROUNDTRIP),
		new ContractCard(
				"Moho Probe",
				"Send a rover to the surface of Moho", 
				planets[1], 
				Constants.LOAD_LIGHT, 
				Constants.MTYPE_LANDING),	
		new ContractCard(
				"Moho EVA",
				"Perform an EVA on or around Moho and return safely", 
				planets[1], 
				Constants.LOAD_LIGHT, 
				Constants.MTYPE_ORBITROUNDTRIP),
		new ContractCard(
				"Moho Outpost",
				"Put a base or station on or around Moho", 
				planets[1], 
				Constants.LOAD_HEAVY, 
				Constants.MTYPE_ORBIT),
		new ContractCard(
				"Eve Probe",
				"Send a rover to the surface of Eve", 
				planets[2], 
				Constants.LOAD_LIGHT, 
				Constants.MTYPE_LANDING),
		new ContractCard(
				"Eve EVA",
				"Perform an EVA on Eve and return safely", 
				planets[2], 
				Constants.LOAD_LIGHT, 
				Constants.MTYPE_ROUNDTRIP),
		new ContractCard(
				"Eve Station",
				"Put a station around Eve", 
				planets[2], 
				Constants.LOAD_HEAVY, 
				Constants.MTYPE_ORBIT),
		new ContractCard(
				"Eve Base",
				"Establish a base on Eve", 
				planets[2], 
				Constants.LOAD_HEAVY, 
				Constants.MTYPE_LANDING),
		new ContractCard(
				"Gilly/Ike Base",
				"Put a base on Gilly or Ike", 
				moons[0], 
				Constants.LOAD_HEAVY, 
				Constants.MTYPE_LANDING),
		new ContractCard(
				"Kerbstok I",
				"Perform and EVA around Kerbin or its moons and return safely", 
				planets[3], 
				Constants.LOAD_LIGHT, 
				Constants.MTYPE_ORBIT),
		new ContractCard(
				"Kerbollo Program",
				"Perform an EVA on Mun or Minmus and return safely", 
				planets[3], 
				Constants.LOAD_LIGHT, 
				Constants.MTYPE_ROUNDTRIP),
		new ContractCard(
				"Munex Project",
				"Establish a base on Mun or Minmus", 
				moons[1], 
				Constants.LOAD_HEAVY, 
				Constants.MTYPE_LANDING),
		new ContractCard(
				"Duna One",
				"Establish a base on Duna", 
				planets[4], 
				Constants.LOAD_HEAVY, 
				Constants.MTYPE_LANDING),
		new ContractCard(
				"Ike EVA",
				"Perform an EVA on Ike and return safely", 
				moons[3], 
				Constants.LOAD_LIGHT, 
				Constants.MTYPE_ROUNDTRIP),
		new ContractCard(
				"Duna 3",
				"Land a Rover on the surface of Duna", 
				planets[4], 
				Constants.LOAD_LIGHT, 
				Constants.MTYPE_LANDING),
		new ContractCard(
				"Dres Probe",
				"Land a Rover on the surface of Dres", 
				planets[5], 
				Constants.LOAD_LIGHT, 
				Constants.MTYPE_LANDING),
		new ContractCard(
				"Dres EVA",
				"Perform an EVA on or around Dres and return safely", 
				planets[5], 
				Constants.LOAD_LIGHT, 
				Constants.MTYPE_ORBITROUNDTRIP),
		new ContractCard(
				"Dres Outpost",
				"Put a base or station on or around Dres", 
				planets[5], 
				Constants.LOAD_HEAVY, 
				Constants.MTYPE_ORBIT),
		new ContractCard(
				"Kuropa Mission",
				"Land a rover on Laythe", 
				moons[4], 
				Constants.LOAD_LIGHT, 
				Constants.MTYPE_LANDING),
		new ContractCard(
				"Laythe EVA",
				"Perform an EVA on or around Laythe and return safely", 
				moons[4], 
				Constants.LOAD_LIGHT, 
				Constants.MTYPE_ORBITROUNDTRIP),
		new ContractCard(
				"Laythe Base",
				"Establish a Base on the surface of Laythe", 
				moons[4], 
				Constants.LOAD_HEAVY, 
				Constants.MTYPE_LANDING),
		new ContractCard(
				"Laythe Station",
				"Place a Station in orbit around Laythe", 
				moons[4], 
				Constants.LOAD_HEAVY, 
				Constants.MTYPE_ORBIT),
		new ContractCard(
				"Vall Base",
				"Establish a Base on the surface of Vall", 
				moons[5], 
				Constants.LOAD_HEAVY, 
				Constants.MTYPE_LANDING),
		new ContractCard(
				"Vall Station",
				"Place a Station in orbit around Vall", 
				moons[5], 
				Constants.LOAD_HEAVY, 
				Constants.MTYPE_ORBIT),
		new ContractCard(
				"Tylo Station",
				"Place a Station in orbit around Tylo", 
				moons[6], 
				Constants.LOAD_HEAVY, 
				Constants.MTYPE_ORBIT),
		new ContractCard(
				"Tylo EVA",
				"Perform an EVA on or around Tylo and return safely", 
				moons[6], 
				Constants.LOAD_LIGHT, 
				Constants.MTYPE_ORBITROUNDTRIP),
		new ContractCard(
				"Bop Rover",
				"Land a rover on Bop", 
				moons[7], 
				Constants.LOAD_LIGHT, 
				Constants.MTYPE_LANDING),
		new ContractCard(
				"Pol Rover",
				"Land a rover on Pol", 
				moons[8], 
				Constants.LOAD_LIGHT, 
				Constants.MTYPE_LANDING),
		new ContractCard(
				"Jool Station",
				"Place a Station in orbit around Jool", 
				planets[6], 
				Constants.LOAD_HEAVY, 
				Constants.MTYPE_ORBIT),
		new ContractCard(
				"Jool EVA",
				"Perform an EVA around Jool and return safely", 
				planets[6], 
				Constants.LOAD_LIGHT, 
				Constants.MTYPE_ORBITROUNDTRIP),
		new ContractCard(
				"New Kerbin",
				"Send a Rover to Eeloo", 
				planets[7], 
				Constants.LOAD_LIGHT, 
				Constants.MTYPE_LANDING),
		new ContractCard(
				"Eeloo EVA",
				"EVA on Eeloo and return safely", 
				planets[7], 
				Constants.LOAD_LIGHT, 
				Constants.MTYPE_ROUNDTRIP),
		new ContractCard(
				"Eeloo Base",
				"Establish a Base on the surface of Eeloo", 
				planets[7], 
				Constants.LOAD_HEAVY, 
				Constants.MTYPE_LANDING),
		new ContractCard(
				"Eeloo Station",
				"Establish a Station around Eeloo", 
				planets[7], 
				Constants.LOAD_HEAVY, 
				Constants.MTYPE_ORBIT)
	};
}
