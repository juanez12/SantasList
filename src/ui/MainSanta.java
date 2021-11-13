package ui;

import java.util.Scanner;
import model.List;

public class MainSanta{
	
	private List santasList;
	private Scanner sc;

	/**
	 * Creates the object Scanner and List
	 * */
	public MainSanta(){
		sc=new Scanner (System.in);

		System.out.println("Starting the app \n" +
			"Please write your name, Santa"
			);
		String santaName=sc.nextLine();
		santasList=new List(santaName);
	}

	public static void main(String args){
		MainSanta ms=new MainSanta();

		System.out.println("Starting the app");

		int option=0;

		do{

			ms.showMenu();
			ms.selectionMenu(option);

		}while(option!=0);
		
	}
	/**
	 * Shows the menu of the app
	 * @return option, int, it's the option selected from the menu
	 * */
	public int showMenu(){
		int option=0;

		System.out.println("Select which option do you want? \n" +
			"(1) Add a new kid \n" + 
			"(2) Move a kid to the other list \n" +
			"(3) Show the lists \n" +
			"(0) Exit the app"
			);

		option=sc.nextInt();
		sc.nextLine();

		return option;
	}
	/**
	 * Enters to the different methods from the menu
	 * @param selection, int, it's the option selected from the menu
	 * */
	public void selectionMenu(int selection){
		switch(selection){

			case 0:
				System.out.println("Exiting from the app, Merry Christmas, Santa");
			break;

			case 1:
				addKid();
			break;

			case 2:
				moveKid();
			break;

			case 3:
				showList();
			break;

			default: System.out.println("Error option invalid");
		}
	}
	/**
	 * Ask for all the parameters to create a new object Child
	 * */
	public void addKid(){

		System.out.println("Enter the child's name");
		String nameCh=sc.nextLine();

		System.out.println("Enter their lastname");
		String lastN=sc.nextLine();

		System.out.println("Enter their age");
		int ageCh=sc.nextInt();
		sc.nextLine();

		System.out.println("Enter in which address they lives");
		String adress=sc.nextLine();

		System.out.println("Enter the city where they lives");
		String cityCh=sc.nextLine();

		System.out.println("Enter the country where they lives");
		String countryCh=sc.nextLine();

		System.out.println("Enter what they wished for Christmas");
		String wishC=sc.nextLine();

		System.out.println("Enter how the child behave during the year \n" +
			"(1) Good \n" +
			"(2) Naugthy \n" 
			);
		int atitud=sc.nextInt();
		sc.nextLine();

		santasList.addKid(nameCh,lastN,ageCh,adress,cityCh,countryCh, wishC, atitud);
	}
	/**
	 * Ask for the name and lastname from the child that wants to be moved from a list to the other, and to what list it's going to be moved
	 * */
	public void moveKid(){
		System.out.println("Enter the child's name and the lastname you want to move");
		String nameSrch=sc.nextLine();

		String lastNSrch=sc.nextLine();

		if(santasList.searchKid(nameSrch,lastNSrch)){
			System.out.println("Enter which list do you want to move them \n" + 
				"(1) The good list \n" +
				"(2) The naugthy list \n" 
				);

			int listSelect=sc.nextInt();
			sc.nextLine();

			System.out.println(santasList.moveKid(nameSrch,lastNSrch,listSelect));
		}
		
		else{
			System.out.println("The program didn't found any child called: " + nameSrch + lastNSrch);
		}		
	}
	/**
	 * Ask from what list the user wants to see the information and the shows a message with the information
	 * */
	public void showList(){
		System.out.println("Choose which list do you want to see \n" +
			"(1) Good list \n" + 
			"(2) Naugthy list"
			);

		int listId=sc.nextInt();
		sc.nextLine();

		System.out.println(santasList.showList(listId));
	}
}