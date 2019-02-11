/* Traveler is the superclass for Hobbit, Dwarf, and Wizard. It contains a name and the distance traveled.
 * 
 * @author Douglas Hong
 * @version 2/11/2019
 */
public class Traveler {
	//fields
	private int distanceTraveled;
	private String name;
	//constructor
	public Traveler(String name){
		this.distanceTraveled = 0;
		this.name = name;
	}
	//methods
	public int getDistanceTraveled(){
		return distanceTraveled;
	}
	public void travel(int miles){
		distanceTraveled += miles;
	}
	public String getName(){
		return name;
	}
}
