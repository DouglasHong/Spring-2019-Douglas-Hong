import java.util.ArrayList;
/* This is the client code for Traveler, Hobbit, Dwarf, and Wizard. This calls the subclasses and makes an array of Travelers.
 * 
 * @author Douglas Hong
 * @version 2/11/2019
 */
public class ThereAndBackAgain {
	public static void main(String[] args) {
		Hobbit frodo = new Hobbit("Frodo");
		Hobbit sam = new Hobbit("Sam");
		Dwarf gimli = new Dwarf("Gimli");
		// Create a traveling party called party1 by creating an array of Travelers 
		// and filling it with frodo, sam, and gimli
		// Then, use a loop to make all travelers go a distance of 50 miles  
		// Then, for each Traveler in the travelingParty, print their name and how far they've
		//    traveled in miles.  (In the next piece, you'll do this in methods, but 
		//    for a first pass, just do it in main and print to the console.)
		// Expected output:  Frodo has traveled 50 miles.
		//                   Sam has traveled 50 miles.
		//                   Gimli has traveled 50 miles.
		Traveler[] party1 = {frodo, sam, gimli};
		for(Traveler currentTraveler : party1) {
			currentTraveler.travel(50);
			System.out.println(currentTraveler.getName() + " has traveled " + currentTraveler.getDistanceTraveled() + " miles.");
		}
		System.out.println("\n\n\nPART 2: \n");
		String[] dwarfNames = {"Fili", "Kili", "Dori", "Ori", "Nori", "Balin", "Dwalin", 
		"Oin", "Gloin", "Bifur", "Bofur", "Bombur", "Thorin" };  
		// Make a new ArrayList to hold a 2nd party of Travelers called party2:
		// Make a new Hobbit called "Bilbo" and add him to party2

		// <Make a new Wizard called "Gandalf" and add him to party2.
		//write createParty
		// Call the createParty method and pass it party2 and the dwarfNames array.
		// create party should add all the new dwarves to party2,
				
		//Write allTravel
		// Finally, call the allTravel method passing it party2 and 100 (representing
		// the 100 miles that party2 has traveled together.

		//Make sure your code prints out the name and distances party2 has traveled.
		ArrayList<Traveler> party2 = new ArrayList<Traveler>();
		Hobbit bilbo = new Hobbit("Bilbo");
		party2.add(bilbo);
		Wizard gandalf = new Wizard("Gandalf", "Grey");
		party2.add(gandalf);
		createParty(party2, dwarfNames);
		allTravel(party2, 100);
		for(Traveler currentTraveler : party2) {
			System.out.println(currentTraveler.getName() + " has traveled " + currentTraveler.getDistanceTraveled() + " miles.");
		}
	}
	public static void createParty(ArrayList<Traveler> party, String[] dwarfNames) {
		for(String name : dwarfNames) {
			Dwarf currentDwarf = new Dwarf(name);
			party.add(currentDwarf);
		}
	}
	public static void allTravel(ArrayList<Traveler> party, int miles) {
		for(Traveler currentTraveler : party) {
			currentTraveler.travel(miles);
		}
	}
}
