package com.techelevator;

import java.math.BigDecimal;

public class Record {
	private String size;
	private String speed;
	private String color;
	private String type;
	private BigDecimal price;
	private String artist;
	private String discName;
	private int numberOfSongs;
	private String[] sideA;
	private String[] sideB;
	
	public Record() {
	}
	
	public Record(String size, String speed, String color, String type, String artist, String discName, String[] sideA, String[] sideB) {
		this.size = size;
		this.speed = speed;
		this.color = color;
		this.type = type;
		this.artist = artist;
		this.discName = discName;
		this.sideA = sideA;
		this.sideB = sideB;
	}
	
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}	
	public String getDiscName() {
		return discName;
	}
	public void setDiscName(String discName) {
		this.discName = discName;
	}
	public int getNumberOfSongs() {
		int numberOfSongs = sideA.length + sideB.length;
		return numberOfSongs;
	}
	public void setNumberOfSongs(int numberOfSongs) {
		this.numberOfSongs = numberOfSongs;
	}
	public String[] getSideA() {
		return sideA;
	}
	public void setSideA(String[] sideA) {
		this.sideA = sideA;
	}
	public String[] getSideB() {
		return sideB;
	}
	
	public void setSideB(String[] sideB) {
		this.sideB = sideB;
	}
	
	public String getSideAAsString() {
		String output = "";
		for (int i = 0; i < sideA.length; i++) {
			output += (i + 1) + ". " + sideA[i] + " ";
		}
		return output;
	}
	
	public String getSideBAsString() {
		String output = "";
		for (int i = 0; i < sideB.length; i++) {
			output += (i + 1) + ". " + sideB[i] + " ";
		}
		return output;
	}
	
	public String getSongsAsString() {
		String output = "";
		for (int i = 0; i < sideA.length; i++) {
			output += (i + 1) + ". " + sideA[i] + " ";
		}
		for (int i = 0; i < sideB.length; i++) {
			output += (i + 1) + ". " + sideB[i] + " ";
		}
		return output;
	}
	
	public String toString() {
		return  "\nARTIST: " + getArtist() + "\n" + getType().toUpperCase() + ": " + getDiscName() + 
				"\nSONGS: " + "(" + getNumberOfSongs() + " total) " + "[Side A] " + getSideAAsString() + " [Side B] " + getSideBAsString() + "\nSIZE: " + getSize() + 
				"\nSPEED: " + getSpeed() + " RPM" + "\nVINYL COLOR: " + getColor();
	}


	
	
}
