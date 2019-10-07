package com.Inventory;

import java.text.DecimalFormat;

public class Product {
	private float costPrice;
	private float sellingPrice;
	private String key;
	public int quantityAvailable;
	public double totValue;
	public int noSold;
	public double profitMade;
	private DecimalFormat dcFormat;
	private double prevSellprofit;
	public Product(String key,float costPrice, float sellingPrice) {
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
		this.key = key;
		this.noSold =0;
		this.quantityAvailable = 0;
		this.profitMade = 0;
		this.prevSellprofit =0;
		this.totValue = 0;
		dcFormat = new DecimalFormat("#.00");
	}
	public float getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(float costPrice) {
		this.costPrice = costPrice;
	}
	public float getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(float sellingPrice) {
		double profit =calaculateProfit();
		this.prevSellprofit += profit;
		this.noSold = 0;
		this.sellingPrice = sellingPrice;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}

	public int getQuantityAvailable() {
		return quantityAvailable;
	}
	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable += quantityAvailable;
	}
	public int getNoSold() {
		return noSold;
	}
	public void setNoSold(int noSold) {
		this.quantityAvailable -= noSold;
		this.noSold += noSold;
		
	}
	public double getProfit() {
		if(this.prevSellprofit>0) {
			return calaculateProfit() + this.prevSellprofit;
		}
		this.profitMade = calaculateProfit();
		return this.profitMade;
	}
	private double calaculateProfit() {
		double profitMade = this.noSold * (this.sellingPrice - this.costPrice);
		return profitMade;
	}
	public double calculateValue() {
		totValue = this.costPrice*this.quantityAvailable;
		return totValue;
	}
	@Override
	public String toString() {
		return this.key+"\t\t"+this.costPrice+"\t\t"+this.sellingPrice+"\t\t"+this.quantityAvailable+"\t\t"+dcFormat.format(calculateValue());
	}
}
