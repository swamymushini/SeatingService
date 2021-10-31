package com.aeroplane.Seating;

import java.util.ArrayList;
import java.util.List;

public class Aeroplane {
	
private int totPassengers;

private  List<ArrayList<Integer>> seatAllignment = new ArrayList<>(); ;

public int getTotPassengers() {
	return totPassengers;
}

public void setTotPassengers(int totPassengers) {
	this.totPassengers = totPassengers;
}

public List<ArrayList<Integer>> getSeatAllignment() {
	return seatAllignment;
}

public void setSeatAllignment(List<ArrayList<Integer>> seatAllignment) {
	this.seatAllignment = seatAllignment;
}


}
