package model;

import java.util.ArrayList;

public class List{
	private String owner;
	ArrayList <Child> goodList;
	ArrayList <Child> naugthyList;
	/**
	 * Constructor for the class list
	 * @param owner, String
	 * */
	public List(String owner){
		this.owner=owner;
		goodList=new ArrayList <Child>();
		naugthyList=new ArrayList <Child>();
	}
	/**
	 * Adds a new object Child to the arraylist goodList or naugthy list
	 * @param nameK, String 
	 * @param lastNK, String
	 * @param ageK, int
	 * @param addressK, String
	 * @param cityK, String
	 * @param countryK, String
	 * @param wishK, String 
	 * @param atitudK, int
	 * */
	public void addKid(String nameK, String lastNK, int ageK, String addressK, String cityK, String countryK, String wishK, int atitudK){
		Attitude attitudeC=Attitude.GOOD;
		switch(atitudK){
			case 1:
				if(goodList.isEmpty()){
					attitudeC=Attitude.GOOD;
					Child newKid=new Child(nameK,lastNK,ageK,addressK,cityK,countryK,wishK,attitudeC);
					goodList.add(newKid);
				}

				else{	
					attitudeC=Attitude.GOOD;
					Child newKid=new Child(nameK,lastNK,ageK,addressK,cityK,countryK,wishK,attitudeC);
					compareAges(newKid);					
				}
		
			break;

			case 2:
				if(naugthyList.isEmpty()){
					attitudeC=Attitude.NAUGTHY;
					Child newKid=new Child(nameK,lastNK,ageK,addressK,cityK,countryK,wishK,attitudeC);
					naugthyList.add(newKid);
				}
				
				else{
					attitudeC=Attitude.GOOD;
					Child newKid=new Child(nameK,lastNK,ageK,addressK,cityK,countryK,wishK,attitudeC);
					compareAges(newKid);
				}
			break;
		}		
	}
	/**
	 * The method pass a object Child to the method compareTo from the class Child
	 * @param newKid, Child, its the object Child passed to th method compareTo
	 * */
	public void compareAges(Child newKid){

		boolean flag=false;

		for(int i=0; i<goodList.size() && !flag; i++){

			if(goodList.get(i).compareTo(newKid)<0){
				goodList.add(newKid);
				flag=true;
			}

			else{
				goodList.add(i,newKid);
				flag=true;
			}
		}
	}
	/**
	 * Search a kid by their name and lastname
	 * @param nameSearch, String, its the name that its going to be search
	 * @param lastNameS, String, its the lastname that its going to be search
	 * @return found, boolean, the method returns if the child was found or wasn't
	 * */
	public boolean searchKid(String nameSearch, String lastNameS){

		boolean found=false;

		if(goodList.isEmpty() && naugthyList.isEmpty()){
			found=false;
		}

		else{
			for(int i=0; i<goodList.size() && !found ;i++){
				if(goodList.get(i).getName().equals(nameSearch) && goodList.get(i).getLastName().equals(lastNameS)){
					found=true;
				}
				else{
					found=false;
				}
			}

			for(int i=0; i<naugthyList.size() && !found; i++){
				if(naugthyList.get(i).getName().equals(nameSearch) && naugthyList.get(i).getLastName().equals(lastNameS)){
					found=true;
				}
				else{
					found=false;
				}
			}
		}
		return found;
	}
	/**
	 * Method to move a child to one list to the other
	 * @param nameChange, String, name of the child who the user wants to move form list
	 * @param lastNameChange, String, lastname of the child who the user wants to move form list
	 * @param listIndex, int, number of the list where the selected child is going to be moved
	 * @return out, String, a message that says if the child was changed succesfully or it doesn't exists
	 * */
	public String moveKid(String nameChange, String lastNameChange, int listIndex){
		String out="";
		boolean flag=false;
		Attitude attitudeCh=Attitude.GOOD;
		switch(listIndex){
			case 1:
				attitudeCh=Attitude.GOOD;
				for(int i=0;i<naugthyList.size() && !flag; i++){
					if(naugthyList.get(i).getName().equals(nameChange) && naugthyList.get(i).getLastName().equals(lastNameChange)){
						naugthyList.get(i).setAttitude(attitudeCh);
						if(goodList.isEmpty()){
							goodList.add(naugthyList.get(i));
							naugthyList.remove(i);
							flag=true;
							out="The kid has been changed from the list succesfully";
						}
						else{
							if(goodList.get(i).compareTo(naugthyList.get(i))<0){
								goodList.add(naugthyList.get(i));
								naugthyList.remove(i);
								flag=true;
								out="The kid has been changed from the list succesfully";
							}
							else{
								goodList.add(i,naugthyList.get(i));
								naugthyList.remove(i);
								flag=true;
								out="The kid has been changed from the list succesfully";
							}
						}
						
					}
				}	
			break;

			case 2:
				attitudeCh=Attitude.NAUGTHY;
				for(int i=0;i<naugthyList.size() && !flag; i++){
					if(goodList.get(i).getName().equals(nameChange) && goodList.get(i).getLastName().equals(lastNameChange)){
						goodList.get(i).setAttitude(attitudeCh);
						if(naugthyList.isEmpty()){
							naugthyList.add(goodList.get(i));
							goodList.remove(i);
							flag=true;
							out="The kid has been changed from the list succesfully";
						}
						else{
							if(naugthyList.get(i).compareTo(goodList.get(i))<0){
								naugthyList.add(goodList.get(i));
								goodList.remove(i);
								flag=true;
								out="The kid has been changed from the list succesfully";
							}
							else{
								naugthyList.add(i,goodList.get(i));
								goodList.remove(i);
								flag=true;
								out="The kid has been changed from the list succesfully";
							}
						}
						
					}
				}	
			break;
		}
		return out;
	}
	/**
	 * Method that shows the objects that are in the arraylists
	 * @param idList, int, number of the list that wants its info
	 * @return out, String, message from the method toString from class Child
	 * */
	public String showList(int idList){
		String out="";
		switch(idList){
			case 1:
				for(int i=0; i<goodList.size(); i++){
					out+=goodList.get(i).toString();
				}
			break;

			case 2:
				for(int i=0; i<naugthyList.size(); i++){
					out+=naugthyList.get(i).toString();
				}
			break;
		}
		return out;
	}
}