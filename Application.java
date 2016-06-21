import java.util.Scanner;

import java.util.Random;

class Person {
	String name;

	void speakName() {
		System.out.println("I'm " + name + ". Let's create a character");
	}

	void sayHello() {
		System.out.println("Hello there!");
	}
}

class Character {
	String name;
	String role;
	String[][] Stats = new String[6][2];
}

public class Application {

	public static void main(String[] args) {
		Person person1 = new Person();
		person1.name = "The DM";
		person1.sayHello();
		person1.speakName();
		Character character1 = new Character();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your character's name: ");
		character1.name = input.nextLine();
		character1.Stats[0][0] = "Strength \t";
		character1.Stats[1][0] = "Dexterity \t";
		character1.Stats[2][0] = "Constitution \t";
		character1.Stats[3][0] = "Wisdom \t \t";
		character1.Stats[4][0] = "Intelligence \t";
		character1.Stats[5][0] = "Charisma \t";
		character1.Stats[0][1] = "null";
		character1.Stats[1][1] = "null";
		character1.Stats[2][1] = "null";
		character1.Stats[3][1] = "null";
		character1.Stats[4][1] = "null";
		character1.Stats[5][1] = "null";

		System.out.println("Building your character");
		System.out.println("...");
		System.out.println("...");
		System.out.println("...");
		System.out.println(character1.name);
		for (int rows = 0; rows < character1.Stats.length; rows++) {
			for (int col = 0; col < character1.Stats[rows].length; col++) {
				if (col == 1) {
					int stat = 0;
					for (int i = 0; i < 3; i++) {
						Random r = new Random();
						int Low = 1;
						int High = 6;
						int Result = r.nextInt(High - Low) + Low;
						stat = stat + Result;
					}
					character1.Stats[rows][col] = Integer.toString(stat);
				}
				System.out.print(character1.Stats[rows][col]);
			}
			System.out.println();
			int locale = 0;
			for (int i = 0; i < 6; i++) {
				int max = 0;
				if (Integer.parseInt(character1.Stats[i][1]) > max) {
					max = Integer.parseInt(character1.Stats[i][1]);
					locale = i;
				}
			}
			switch(locale){
			
			case 0:
				character1.role = "Fighter";
			
			case 1:
				character1.role = "Rogue";
			
			case 2:
				for (int i = 0; i < 6; i++) {
					int max = 0;
					if (i==2){
						continue;
					}
						else if (Integer.parseInt(character1.Stats[i][1]) > max) {
						max = Integer.parseInt(character1.Stats[i][1]);
						locale = i;
						}
					}
				switch(locale){
				case 0:
					character1.role = "Fighter";
				case 1:
					character1.role = "Rogue";
				case 3:
					character1.role = "Cleric";
				case 4:
					character1.role = "Mage";
				case 5:
					character1.role = "Bard";
				}
					
			case 3:
				character1.role = "Cleric";
			case 4:
				character1.role = "Mage";
			case 5:
				character1.role = "Bard";
				}
		}
		System.out.println("Reccommended class: " + character1.role);
	}
}
