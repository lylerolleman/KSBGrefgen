
public class DistData {
	int majororbit;
	int escape;
	int entry;
	
	public DistData(int majororbit, int escape, int entry) {
		this.majororbit = majororbit;
		this.escape = escape;
		this.entry = entry;
	}
	
	public int majorDist() {return majororbit;}
	public int minorDist() {return escape + entry;}
}
