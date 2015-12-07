import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;


public class ReferenceGen {
	
	
	public static void main(String[] args) throws IOException {
		for (int i=0; i<args.length; i++) {
			switch (args[i]) {
			case "-csv":
				printCSV();
				break;
			case "-raw":
				printRaw();
				break;
			case "-csvf":
				writeCSV(args[i+1]);
				i++;
				break;
			case "-rawf":
				writeRaw(args[i+1]);
				i++;
				break;
			case "-cc":
				printContracts();
				break;
			}
		}
	}
	
	private static void writeRaw(String filename) throws FileNotFoundException {
		PrintStream ps = System.out;
		FileOutputStream fos = new FileOutputStream(filename);
		System.setOut(new PrintStream(new BufferedOutputStream(fos), true));
		printRaw();
		System.setOut(ps);
	}
	
	private static void writeCSV(String filename) throws IOException {
		PrintStream ps = System.out;
		FileOutputStream fos = new FileOutputStream(filename);
		System.setOut(new PrintStream(new BufferedOutputStream(fos), true));
		printCSV();
		System.setOut(ps);
	}
	
	private static void printContracts() {
		for (ContractCard cc : Config.contractcards)
			System.out.println(cc.toString());
	}

	private static void printCSV() {
		System.out.println("1 Payload");
		System.out.print("Destination");
		for (Integer i : Config.tanksperstage) 
			System.out.print(",Fuel to orbit at " + i + " tank per stage (number of tanks),Turns to complete");
		for (Integer i : Config.tanksperstage) 
			System.out.print(",Fuel to land at " + i + " tank per stage (number of tanks),Turns to complete");
		for (Integer i : Config.tanksperstage) 
			System.out.print(",Fuel to land and return at " + i + " tank per stage (number of tanks),Turns to complete");
		System.out.println();
		for (Planet planet : Config.planets) {
			System.out.print(planet.getName());
			for (int i=1; i<=Config.tanksperstage.length; i++) {
				Cost occost = Config.planets[3].fuelToOrbit(planet, i, 1);
				Cost lccost = Config.planets[3].fuelToLand(planet, i, 1);
				Cost rccost = Config.planets[3].fuelRoundTrip(planet, i, 1);
				int otimetocomplete = (int) Math.ceil(((double) Config.planets[3].distanceTo(planet)+1)/Config.MPT);
				int ltimetocomplete = (int) Math.ceil(((double) Config.planets[3].distanceTo(planet)+2)/Config.MPT);
				int rtimetocomplete = (int) Math.ceil(((double) Config.planets[3].distanceTo(planet)*2+4)/Config.MPT);
				if (planet.equals(Config.planets[3])) {
					otimetocomplete = 1;
					ltimetocomplete = 1;
					rtimetocomplete = 2;
				}
				if (occost != null)
					System.out.print("," + occost.fuelCost() + " (" + occost.tankCost() + ")," + otimetocomplete); 
				else if (planet.equals(Config.planets[0]) || planet.equals(Config.planets[6]))
					System.out.print(",Impossible,Impossible");
				else
					System.out.print(",Requires refuel,variable");
				if (lccost != null)
					System.out.print("," + lccost.fuelCost() + " (" + lccost.tankCost() + ")," + ltimetocomplete); 
				else if (planet.equals(Config.planets[0]) || planet.equals(Config.planets[6]))
					System.out.print(",Impossible,Impossible");
				else
					System.out.print(",Requires refuel,variable");
				if (rccost != null)
					System.out.println("," + rccost.fuelCost() + " (" + rccost.tankCost() + ")," + rtimetocomplete);
				else if (planet.equals(Config.planets[0]) || planet.equals(Config.planets[6]))
					System.out.println(",Impossible,Impossible");
				else
					System.out.println(",Requires refuel,variable");
			}
		}
		for (Moon moon : Config.moons) {
			System.out.print(moon.getName());
			for (int i=1; i<=Config.tanksperstage.length; i++) {
				Cost occost = Config.planets[3].fuelToOrbit(moon, i, 1);
				Cost lccost = Config.planets[3].fuelToLand(moon, i, 1);
				Cost rccost = Config.planets[3].fuelRoundTrip(moon, i, 1);
				int otimetocomplete = (int) Math.ceil(((double) Config.planets[3].distanceTo(moon)+1)/Config.MPT);
				int ltimetocomplete = (int) Math.ceil(((double) Config.planets[3].distanceTo(moon)+2)/Config.MPT);
				int rtimetocomplete = (int) Math.ceil(((double) Config.planets[3].distanceTo(moon)*2+4)/Config.MPT);
				
				if (occost != null)
					System.out.print("," + occost.fuelCost() + " (" + occost.tankCost() + ")," + otimetocomplete);
				else
					System.out.println(",Requires refuel,variable");
				if (lccost != null)
					System.out.print("," + lccost.fuelCost() + " (" + lccost.tankCost() + ")," + ltimetocomplete); 
				else
					System.out.print(",Requires refuel,variable");
				if (rccost != null)
					System.out.println("," + rccost.fuelCost() + " (" + rccost.tankCost() + ")," + rtimetocomplete);
				else
					System.out.println(",Requires refuel,variable");
			}
		}
		System.out.println();
		System.out.println("2 Payload");
		System.out.print("Destination");
		for (Integer i : Config.tanksperstage) 
			System.out.print(",Fuel to orbit at " + i + " tank per stage (number of tanks),Turns to complete");
		for (Integer i : Config.tanksperstage) 
			System.out.print(",Fuel to land at " + i + " tank per stage (number of tanks),Turns to complete");
		for (Integer i : Config.tanksperstage) 
			System.out.print(",Fuel to land and return at " + i + " tank per stage (number of tanks),Turns to complete");
		System.out.println();
		for (Planet planet : Config.planets) {
			System.out.print(planet.getName());
			for (int i=1; i<=Config.tanksperstage.length; i++) {
				Cost occost = Config.planets[3].fuelToOrbit(planet, i, 2);
				Cost lccost = Config.planets[3].fuelToLand(planet, i, 2);
				Cost rccost = Config.planets[3].fuelRoundTrip(planet, i, 2);
				int otimetocomplete = (int) Math.ceil(((double) Config.planets[3].distanceTo(planet)+1)/Config.MPT);
				int ltimetocomplete = (int) Math.ceil(((double) Config.planets[3].distanceTo(planet)+2)/Config.MPT);
				int rtimetocomplete = (int) Math.ceil(((double) Config.planets[3].distanceTo(planet)*2+4)/Config.MPT);
				if (planet.equals(Config.planets[3])) {
					otimetocomplete = 1;
					ltimetocomplete = 1;
					rtimetocomplete = 2;
				}
				if (occost != null)
					System.out.print("," + occost.fuelCost() + " (" + occost.tankCost() + ")," + otimetocomplete); 
				else if (planet.equals(Config.planets[0]) || planet.equals(Config.planets[6]))
					System.out.print(",Impossible,Impossible");
				else
					System.out.print(",Requires refuel,variable");
				if (lccost != null)
					System.out.print("," + lccost.fuelCost() + " (" + lccost.tankCost() + ")," + ltimetocomplete); 
				else if (planet.equals(Config.planets[0]) || planet.equals(Config.planets[6]))
					System.out.print(",Impossible,Impossible");
				else
					System.out.print(",Requires refuel,variable");
				if (rccost != null)
					System.out.println("," + rccost.fuelCost() + " (" + rccost.tankCost() + ")," + rtimetocomplete);
				else if (planet.equals(Config.planets[0]) || planet.equals(Config.planets[6]))
					System.out.println(",Impossible,Impossible");
				else
					System.out.println(",Requires refuel,variable");
			}
		}
		for (Moon moon : Config.moons) {
			System.out.print(moon.getName());
			for (int i=1; i<=Config.tanksperstage.length; i++) {
				Cost occost = Config.planets[3].fuelToOrbit(moon, i, 2);
				Cost lccost = Config.planets[3].fuelToLand(moon, i, 2);
				Cost rccost = Config.planets[3].fuelRoundTrip(moon, i, 2);
				int otimetocomplete = (int) Math.ceil(((double) Config.planets[3].distanceTo(moon)+1)/Config.MPT);
				int ltimetocomplete = (int) Math.ceil(((double) Config.planets[3].distanceTo(moon)+2)/Config.MPT);
				int rtimetocomplete = (int) Math.ceil(((double) Config.planets[3].distanceTo(moon)*2+4)/Config.MPT);
				
				if (occost != null)
					System.out.print("," + occost.fuelCost() + " (" + occost.tankCost() + ")," + otimetocomplete);
				else
					System.out.println(",Requires refuel,variable");
				if (lccost != null)
					System.out.print("," + lccost.fuelCost() + " (" + lccost.tankCost() + ")," + ltimetocomplete); 
				else
					System.out.print(",Requires refuel,variable");
				if (rccost != null)
					System.out.println("," + rccost.fuelCost() + " (" + rccost.tankCost() + ")," + rtimetocomplete);
				else
					System.out.println(",Requires refuel,variable");
			}
		}
	}
	
	private static void printRaw() {
		for (Planet planet : Config.planets) {
			System.out.println("Fuel from Kerbin to " + planet.getName() + " orbit: ");
			for (int i=1; i<=Config.tanksperstage.length; i++) {
				Cost ccost1 = Config.planets[3].fuelToOrbit(planet, i, 1);
				Cost ccost2 = Config.planets[3].fuelToOrbit(planet, i, 2);
				
				System.out.format("\t%15s %d: ", "Tech Level", i);
				if (ccost1 != null) {
					Integer cost1 = ccost1.fuelCost();
					Integer tankcost = ccost1.tankCost();
					System.out.format("%15d(%d) ", cost1, tankcost);
				} else
					System.out.format("%15s ", "Impossible");
				if (ccost2 != null) {
					Integer cost2 = ccost2.fuelCost();
					Integer tankcost = ccost2.tankCost();
					System.out.format("%15d(%d)\n", cost2, tankcost);
				} else
					System.out.format("%15s\n", "Impossible");
			}
			int timetocomplete = (int) Math.ceil(((double) Config.planets[3].distanceTo(planet)+1)/Config.MPT);
			if (planet.equals(Config.planets[3]))
				timetocomplete = 1;
			System.out.format("\t%15s %14d\n\n", "Turns to complete: ", timetocomplete);
		}
		for (Moon moon : Config.moons) {
			System.out.println("Fuel from Kerbin to " + moon.getName() + " orbit: ");
			for (int i=1; i<=Config.tanksperstage.length; i++) {
				Cost ccost1 = Config.planets[3].fuelToOrbit(moon, i, 1);
				Cost ccost2 = Config.planets[3].fuelToOrbit(moon, i, 2);
				
				System.out.format("\t%15s %d: ", "Tech Level", i);
				if (ccost1 != null) {
					Integer cost1 = ccost1.fuelCost();
					Integer tankcost = ccost1.tankCost();
					System.out.format("%15d(%d) ", cost1, tankcost);
				} else
					System.out.format("%15s ", "Impossible");
				if (ccost2 != null) {
					Integer cost2 = ccost2.fuelCost();
					Integer tankcost = ccost2.tankCost();
					System.out.format("%15d(%d)\n", cost2, tankcost);
				} else
					System.out.format("%15s\n", "Impossible");
			}
			int timetocomplete = (int) Math.ceil(((double) Config.planets[3].distanceTo(moon)+1)/Config.MPT);
			System.out.format("\t%15s %14d\n\n", "Turns to complete: ", timetocomplete);
		}
		System.out.println();
		for (Planet planet : Config.planets) {
			if (planet.equals(Config.planets[3]))
				continue;
			System.out.println("Fuel from Kerbin to " + planet.getName() + " with landing: ");
			for (int i=1; i<=Config.tanksperstage.length; i++) {
				Cost ccost1 = Config.planets[3].fuelToLand(planet, i, 1);
				Cost ccost2 = Config.planets[3].fuelToLand(planet, i, 2);
				
				System.out.format("\t%15s %d: ", "Tech Level", i);
				if (ccost1 != null) {
					Integer cost1 = ccost1.fuelCost();
					Integer tankcost = ccost1.tankCost();
					System.out.format("%15d(%d) ", cost1, tankcost);
				} else
					System.out.format("%15s ", "Impossible");
				if (ccost2 != null) {
					Integer cost2 = ccost2.fuelCost();
					Integer tankcost = ccost2.tankCost();
					System.out.format("%15d(%d)\n", cost2, tankcost);
				} else
					System.out.format("%15s\n", "Impossible");
			}
			int timetocomplete = (int) Math.ceil(((double) Config.planets[3].distanceTo(planet)+2)/Config.MPT);
			System.out.format("\t%15s %14d\n\n", "Turns to complete: ", timetocomplete);
		}
		for (Moon moon : Config.moons) {
			System.out.println("Fuel from Kerbin to " + moon.getName() + " with landing: ");
			for (int i=1; i<=Config.tanksperstage.length; i++) {
				Cost ccost1 = Config.planets[3].fuelToLand(moon, i, 1);
				Cost ccost2 = Config.planets[3].fuelToLand(moon, i, 2);
				
				System.out.format("\t%15s %d: ", "Tech Level", i);
				if (ccost1 != null) {
					Integer cost1 = ccost1.fuelCost();
					Integer tankcost = ccost1.tankCost();
					System.out.format("%15d(%d) ", cost1, tankcost);
				} else
					System.out.format("%15s ", "Impossible");
				if (ccost2 != null) {
					Integer cost2 = ccost2.fuelCost();
					Integer tankcost = ccost2.tankCost();
					System.out.format("%15d(%d)\n", cost2, tankcost);
				} else
					System.out.format("%15s\n", "Impossible");
			}
			int timetocomplete = (int) Math.ceil(((double) Config.planets[3].distanceTo(moon)+2)/Config.MPT);
			System.out.format("\t%15s %14d\n\n", "Turns to complete: ", timetocomplete);
		}
		System.out.println();
		for (Planet planet : Config.planets) {
			if (planet.equals(Config.planets[3]))
				continue;
			System.out.println("Fuel from Kerbin to " + planet.getName() + " and return: ");
			for (int i=1; i<=Config.tanksperstage.length; i++) {
				Cost ccost1 = Config.planets[3].fuelRoundTrip(planet, i, 1);
				Cost ccost2 = Config.planets[3].fuelRoundTrip(planet, i, 2);
				
				System.out.format("\t%15s %d: ", "Tech Level", i);
				if (ccost1 != null) {
					Integer cost1 = ccost1.fuelCost();
					Integer tankcost = ccost1.tankCost();
					System.out.format("%15d(%d) ", cost1, tankcost);
				} else
					System.out.format("%15s ", "Impossible");
				if (ccost2 != null) {
					Integer cost2 = ccost2.fuelCost();
					Integer tankcost = ccost2.tankCost();
					System.out.format("%15d(%d)\n", cost2, tankcost);
				} else
					System.out.format("%15s\n", "Impossible");
			}
			int timetocomplete = (int) Math.ceil(((double) Config.planets[3].distanceTo(planet)*2+4)/Config.MPT);
			System.out.format("\t%15s %14d\n\n", "Turns to complete: ", timetocomplete);
		}
		for (Moon moon : Config.moons) {
			System.out.println("Fuel from Kerbin to " + moon.getName() + " and return: ");
			for (int i=1; i<=Config.tanksperstage.length; i++) {
				Cost ccost1 = Config.planets[3].fuelRoundTrip(moon, i, 1);
				Cost ccost2 = Config.planets[3].fuelRoundTrip(moon, i, 2);
				
				System.out.format("\t%15s %d: ", "Tech Level", i);
				if (ccost1 != null) {
					Integer cost1 = ccost1.fuelCost();
					Integer tankcost = ccost1.tankCost();
					System.out.format("%15d(%d) ", cost1, tankcost);
				} else
					System.out.format("%15s ", "Impossible");
				if (ccost2 != null) {
					Integer cost2 = ccost2.fuelCost();
					Integer tankcost = ccost2.tankCost();
					System.out.format("%15d(%d)\n", cost2, tankcost);
				} else
					System.out.format("%15s\n", "Impossible");
			}
			int timetocomplete = (int) Math.ceil(((double) Config.planets[3].distanceTo(moon)*2+4)/Config.MPT);
			System.out.format("\t%15s %14d\n\n", "Turns to complete: ", timetocomplete);
		}
	}
}
