package model;

public class Child implements Comparable<Child>{

	private String name;
	private String lastName;
	private int age;
	private String address;
	private String city;
	private String country;
	private String wish;

	private Attitude attitude;
	/**
	*Constructor from class Child 
	* @param name, String
	* @param lastName, String
	* @param age, int
	* @param address, String
	* @param city, String
	* @param country, String
	* @param wish, String
	* @param attitude, Attitude
	 */
	public Child(String name, String lastName,int age, String address, String city, String country, String wish, Attitude attitude){
		this.name=name;
		this.lastName=lastName;
		this.age=age;
		this.address=address;
		this.city=city;
		this.country=country;
		this.wish=wish;
		this.attitude=attitude;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name=name;
	}

	public String getLastName(){
		return lastName;
	}

	public void setLastName(String lastName){
		this.lastName=lastName;
	}

	public int getAge(){
		return age;
	}

	public void setAge(int age){
		this.age=age;
	}

	public String getAddress(){
		return address;
	}

	public void setAddress(String address){
		this.address=address;
	}

	public String getCity(){
		return city;
	}

	public void setCity(String city){
		this.city=city;
	}

	public Attitude getAttitude(){
		return attitude;
	}

	public void setAttitude(Attitude attitude){
		this.attitude=attitude;
	}

	@Override
	/**
	@param other, Child
	@return out, int it's negative when this is less than other, it's 0 when this is equal to other, and is positve when this is greater than other
	*/
	public int compareTo(Child other){
		int out=-1;

		if(this.age<other.getAge()){
			out=-1;
		}else if (this.age==other.getAge()) {
			out=0;
		}else if (this.age>other.getAge()) {
			out=1;
		}

		return out;
	}
	/**
	 * Shows all the info from a object Child created
	 * @return out, String, message with all the information from the obejct
	 * */
	public String toString(){
		String out="";
		out+="Child's name: " + name + lastName + "\n";
		out+="Child's age: " + age + "\n";
		out+="Lives in: " + address + "on " + city + ", " + country + "\n";
		out+= "Wished a/an: " + wish + "\n";
		out+= "and is on the: " + attitude + "list \n";
		return out;
	}
}