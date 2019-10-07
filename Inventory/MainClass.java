package com.Inventory;

import java.util.Scanner;

public class MainClass {
	private static Scanner sc ;
	
	public static void main(String[] args) {
		try {
			Inventory inv = new Inventory();
			sc= new Scanner(System.in);
			String str=null,transactions=null;
		
		do {
			str = sc.nextLine() ;
			transactions = transactions +"\n"+str;
		}while(str.charAt(0) !='#');
		
		String arr[] = transactions.split("\n");
		for(String s :arr) {
			String inTrans[] = s.split(" ");
			switch(inTrans[0]) {
				case "create":
					inv.create(inTrans[1], Float.parseFloat(inTrans[2]),Float.parseFloat(inTrans[3]));
					break;
				case "updateBuy":
					inv.updateBuy(inTrans[1], Integer.parseInt(inTrans[2]));
					break;
				case "updateSell":
					inv.updateSell(inTrans[1], Integer.parseInt(inTrans[2]));
					break;
				case "delete":
					inv.delete(inTrans[1]);
					break;
				case "report":
					inv.generateReport();
					break;
				case "updateSellPrice":
					inv.updateSellingprice(inTrans[1], Float.parseFloat(inTrans[2]));
					break;
				default:
					
			} 
		}
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
