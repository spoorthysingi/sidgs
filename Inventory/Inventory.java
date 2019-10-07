package com.Inventory;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
	private Map<String, Product> inventory;
	private double deletedSum;
	private DecimalFormat dcF;
	private double profitLast;
	public Inventory() {
		inventory = new HashMap<String, Product>();
		deletedSum = 0;
		dcF = new DecimalFormat("#.00");
		this.profitLast = 0;
	}
	
	public void create(String id,float costPrice,float sellingPrice) {
		Product prod = new Product(id,costPrice,sellingPrice);
		inventory.put(id, prod);
	}
	public void delete(String id) {
		Product prod = inventory.get(id);
		this.deletedSum += prod.quantityAvailable * prod.getCostPrice();
		inventory.remove(id);
	}
	public void updateBuy(String id,int quantity) {
		Product prod = inventory.get(id);
		prod.setQuantityAvailable(quantity);
		inventory.put(id, prod);
	}
	public void updateSell(String id,int quantity) {
		Product prod = inventory.get(id);
		prod.setNoSold(quantity);
		inventory.put(id, prod);
	}
	public void updateSellingprice(String id,float sellingPrice) {
		Product prod = inventory.get(id);
		prod.setSellingPrice(sellingPrice);
		inventory.put(id, prod);
		
	}
	public void generateReport() {
		double profit = 0,totalProfit=0,totalValue = 0;
		System.out.println("\nItemname\tBought At\tSold At \t Available Qty\t Value");
		for(Map.Entry<String, Product> entry:inventory.entrySet()) {
			Product prod = entry.getValue();
			System.out.println(prod.toString());
			profit += prod.getProfit();
			totalValue += prod.calculateValue();
		}
		totalProfit = profit - deletedSum;
		this.profitLast = totalProfit - this.profitLast;
		System.out.println("\nTotal Value\t\t\t\t"+dcF.format(totalValue)+"\nProfit since previous report\t\t"+dcF.format(this.profitLast));
		
	}
	
}
