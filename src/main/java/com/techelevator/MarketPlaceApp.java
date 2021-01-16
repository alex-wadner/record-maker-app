package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MarketPlaceApp {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner userInput = new Scanner(System.in);
		
		
		System.out.println("**********************************************************************************************************************");
		System.out.println("*********************************      WELCOME TO THE SUN-TREADER RECORDS STORE      *********************************");
		System.out.println("**********************************************************************************************************************");
		System.out.println("");
		System.out.println("The mission of Sun-Treader Records is to discover, record, and produce local artists"
				+ "\nand release their music on vinyl while emphasizing the importance of good musicianship.");
		System.out.println("\nOur recording and cutting process is 100% analog, start to finish."
				+ "\nWe cut each copy of your record one at a time, by hand, on a refurbished record lathe from the 1950's."
				+ "\nYour music will be cut in beautiful MONO and the sound quality is comparable to that of the 1950's/60's.");
		System.out.println("");
		System.out.println("Each option below is for the desired end product. The price includes a minimum of 4 hours recording time at our studio.");
		System.out.println("If the artist chooses to record at a different venue, they are responsible for those additional charges.\n");
		System.out.println("Records can be cut in 33 1/3 or 45 RPM only.");
		System.out.println("");
		
		/// make a menu to create record quote or book a session in the studio?
		
		System.out.println("Purchase Options:");
		System.out.println("1) 7\" record (up to twelve minutes of music), $4.79/record");
		System.out.println("2) 10\" record (up to twenty-four minutes of music), $6.99/record");
		System.out.println("3) 12\" record (up to thirty-six minutes of music), $8.99/record");
		System.out.println("");
		Record record = new Record();
		BigDecimal pricePerUnit = new BigDecimal("0");
		BigDecimal fourHoursRecording = new BigDecimal("50");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmmss");  
	    Date date = new Date();  
	    PrintWriter invoice;
		int minutesOfMusic = 0;
		int upperLimit = 0;
		int choiceUpperLimit = 0;
		int choiceLowerLimit = 0;
		
		while (record.getSize() == null) {
			System.out.print("Please enter your selection >>> ");		
			String input = userInput.nextLine();

			if (input.equals("1")) {
				Record sevenInch = new Record();
				pricePerUnit = new BigDecimal("4.79");
				upperLimit = 12;
				choiceUpperLimit = 9;
				choiceLowerLimit = 6;
				sevenInch.setSize("7\"");
				record = sevenInch;
			}
			else if (input.equals("2")) {
				Record tenInch = new Record();
				pricePerUnit = new BigDecimal("6.25");
				upperLimit = 24;
				choiceUpperLimit = 18;
				choiceLowerLimit = 12;
				tenInch.setSize("10\"");
				record = tenInch;
			}
			else if (input.equals("3")){
				Record twelveInch = new Record();
				pricePerUnit = new BigDecimal("7.50");
				twelveInch.setSize("12\"");
				upperLimit = 36;
				choiceUpperLimit = 24;
				choiceLowerLimit = 15;
				record = twelveInch;
			} else {
				System.out.println("Invalid entry, please try again.\n");
			}
		}
		
		while (record.getSpeed() == null) {
			try {
			System.out.print("\nHow many minutes of music total? (enter nearest whole number) >>> ");
			minutesOfMusic = Integer.parseInt(userInput.nextLine());
			System.out.println();
			
			if (minutesOfMusic > upperLimit) {
				System.out.println("That's too much music for that format. Try again, or restart and select a bigger size");
			}
				
			else if (minutesOfMusic >= choiceUpperLimit) {
				System.out.println("Your " + record.getSize() + " will be cut at 33 1/3 RPM\n");
				record.setSpeed("33 1/3");
			}
			else if (minutesOfMusic > choiceLowerLimit && minutesOfMusic < choiceUpperLimit) {
				System.out.println("With this amount of material, you have a choice of playing speeds.");
				
				while (record.getSpeed() == null) {
					System.out.print("Would you prefer it to play at 33 1/3 or 45? >>> ");
					String speedPref = userInput.nextLine();
					
					if (speedPref.equals("33") || speedPref.equals("33.3") || speedPref.equals("33 1/3") || speedPref.equals("331/3")) {
						System.out.println("Your 7\" record will be cut at 33 1/3 RPM\n");
						record.setSpeed("33 1/3");
					}
					else if (speedPref.equals("45")) {
						System.out.println("Your record will be cut at 45 RPM\n");
						record.setSpeed("45");
					} else {
						System.out.println("Invalid entry, try again.\n");
					}
				}
			}
			else if (minutesOfMusic <= choiceLowerLimit){
				System.out.println("Your record will be cut at 45 RPM\n");
				record.setSpeed("45");
			}
			
			} catch (NumberFormatException e) {
				System.out.println("Invalid entry, try again.");
			}
		}
		
		
		System.out.print("What is the artist name? >>> ");
		String artistInput = userInput.nextLine();
		record.setArtist(artistInput);
		
		if (record.getSize().equals("7\"")) {
			while (record.getType() == null) {
			System.out.print("\nIs this release a (1) single or an (2) E.P.? >>> ");
			int answer = Integer.parseInt(userInput.nextLine());
			
			if (answer == 1) {
				record.setType("Single");
			}
			else if (answer == 2) {
				record.setType("E.P.");
			}
			else {
				System.out.println("Invalid entry, try again.\n");
			}
		}
		}
		else {
			while (record.getType() == null) {
			System.out.print("\nIs this release a (1) single, (2) E.P., or an (3) L.P.? >>> ");
			int answer = Integer.parseInt(userInput.nextLine());
			
			if (answer == 1) {
				record.setType("Single");
			}
			else if (answer == 2) {
				record.setType("E.P.");
			}
			else if (answer == 3) {
				record.setType("L.P.");
			}
			else {
				System.out.println("Invalid entry, try again.\n");
			}
		}
		}
		
		System.out.print("\nWhat is the name of this release? (leave blank if none) >>> ");
		String nameInput = userInput.nextLine();
			if (nameInput.equals("")) {
				nameInput = "(n/a)";
			} else {
				record.setDiscName(nameInput);
			}
		
		System.out.println("\nWhat song(s) will be on Side A? (This should be half of your total running time) ");
		System.out.println("Please separate ONLY with two forward slashes //");
		System.out.println("(Example: Song 1//Song 2//Song 3, etc.)");
		System.out.print(">>> ");
		String sideAInput = userInput.nextLine();
		String[] songsSideA = sideAInput.split("//");
		record.setSideA(songsSideA);
		
			
		System.out.println("\nWhat song(s) will be on Side B? ");
		System.out.println("Please separate ONLY with two forward slashes //");
		System.out.println("(Example: Song 1//Song 2//Song 3, etc.)");
		System.out.print(">>> ");
		String sideBInput = userInput.nextLine();
		String[] songsSideB = sideBInput.split("//");
		record.setSideB(songsSideB);
		//record.setNumberOfSongs(songsSideA.length + songsSideB.length); //added this instead to srecord.getNumberOfSongs()
		
		if (record.getNumberOfSongs() == 2) {
			nameInput = record.getSideA()[0] + "/" + record.getSideB()[0];
			record.setDiscName(nameInput);
		}		
			
		while (record.getColor() == null) {
			try {
			System.out.println("\nWhat color do you want the vinyl in? >>> ");
			System.out.print("Colors in stock: (1) Black, (2) Clear, (3) Baby Blue, (4) Aqua Green, (5) Neon Orange, (6) Other >>> ");
			int recordColor = Integer.parseInt(userInput.nextLine());
			if (recordColor == 1) {
				record.setColor("Black");
			}
			else if (recordColor == 2) {
				record.setColor("Clear");
			}
			else if (recordColor == 3) {
				record.setColor("Baby Blue");
			}
			else if (recordColor == 4) {
				record.setColor("Aqua Green");
			}
			else if (recordColor == 5) {
				record.setColor("Neon Orange");
			}
			else if (recordColor == 6) {
				System.out.print("We try and accomodate all requests! What color would you like? >>> ");
				String colorRequest = userInput.nextLine();
				record.setColor(colorRequest);
			}
			else {
				System.out.println("Invalid entry, try again.");
			}
			} catch (NumberFormatException e) {
				System.out.println("Invalid entry, try again.");
			}
		}
		int numberCopies = 0;
		while (numberCopies == 0) {
			try {
				System.out.print("\nHow many copies do you want? >>> ");
				numberCopies = Integer.parseInt(userInput.nextLine());
			} catch (NumberFormatException e){
				System.out.println("Invalid entry, try again.\n");
			}
		}
		
		String email = "";
		while (email.equals("")) {
		System.out.print("\nPlease enter an e-mail address to send your invoice to >>> ");
		email = userInput.nextLine();
			if (!email.contains("@") || !email.contains(".")) {
				System.out.println("Please enter a valid e-mail address");
			}
		}
		
		String invoiceArtist;
		if (record.getArtist().contains(" ")) {
			invoiceArtist = record.getArtist().replaceAll("\\s+","");
		}
		else {
			invoiceArtist = record.getArtist();
		}
		
		String invoiceNum = formatter.format(date) + "-" + invoiceArtist.toUpperCase();
		File invoiceFile = new File(invoiceNum + ".txt");
		BigDecimal copyPrice = pricePerUnit.multiply(BigDecimal.valueOf(numberCopies));
		BigDecimal price = copyPrice.add(fourHoursRecording);
		record.setPrice(price);
		if (invoiceFile.exists()) {
			invoice = new PrintWriter(new FileOutputStream(invoiceFile, true));
		}
		else {
			invoice = new PrintWriter(invoiceFile.getAbsolutePath());
		}
		invoice.println(invoiceNum);
		invoice.println(email);
		invoice.println(record.toString());
		invoice.println("\n\nTOTAL: " + record.getPrice() + " + shipping (" + numberCopies + " copies at $" + pricePerUnit + "/ea.)");
		invoice.flush();
		invoice.close();
	
		//set-up email capability
		
		System.out.println("Invoiced emailed to " + email);
		System.out.println("\nINVOICE NO. " + invoiceNum + record.toString() + "\n\nTOTAL: " + record.getPrice() + " + shipping (" + numberCopies + " copies at $" + pricePerUnit + "/ea.)");
			
		userInput.close();
	}
}
