package com.aeroplane.Seating;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class SeatingService {

	private int totalPass = 0;
	private int[][] sArray = null;
	Integer asile     = 0;
	Integer window = 0;
	Integer middle  = 0;
	Integer var       = 0;
	Integer inc       = 0;
	
	public int[][] getPassengerArrangement(Aeroplane aero){
		List<ArrayList<Integer>> list = aero.getSeatAllignment();
		
		totalPass = aero.getTotPassengers();
		int[][] arr =  new int[list.size()][2];
		int len = 0;
		int brd = 0;
		
		int asilelen = 0;
		//to get asileseatslength
		for (int i = 0; i < list.size(); i++) {
			int col = list.get(i).get(0);
			int row = list.get(i).get(1);
			if (i == 0 || i == list.size() - 1) {
				asilelen = asilelen +(row * (col > 1 ? 1 : 0));
			} else   {
				asilelen = asilelen + (row * (col > 1 ? 2 : 1));
			}
			len = len + col;
			brd = Math.max(row, brd);
			arr[i][0] = col;
			arr[i][1] = row;
		}
		
		int windlen = arr[0][1]+arr[arr.length-1][1];

		 sArray = new int[brd][len];
		 asile     = 1;
		 window = 1+asilelen;
		 middle  = 1+windlen+asilelen;
		 var       = 0;
		 inc       = 0;
		 
		while(var<brd) {
			
			for (int j = 0; j < arr.length; j++) {
				
				if(var>arr[j][1]-1) {
					inc=inc+arr[j][0];
					continue;
				}
				
				if (j == 0||(arr[j][0]==1&&j == arr.length - 1)) {
					fillPassenger(window++);
				}else {
					fillPassenger(asile++);
				}
				int count = arr[j][0] - 2;
				
				fillMiddleSeat(count);
				
				if(count+1<=0) {
					continue;
				}
				
				if(j == arr.length - 1) {
					fillPassenger(window++);
				}else {
					fillPassenger(asile++);
				}
				
			}
			inc=0;
			var++;
		}
	
		return sArray;
		
	}

	private void fillPassenger(int value) {
		if(value<=totalPass) {
			sArray[var][inc] = value;
		}
		inc++;
	}
	
	private void fillMiddleSeat(int count) {
		if(count<=0) {
			return;
		}
		
		if(middle<=totalPass) {
			sArray[var][inc] = middle++;
		}
		inc++;
		
		fillMiddleSeat(--count);
	}
	
}
