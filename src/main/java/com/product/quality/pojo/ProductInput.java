package com.product.quality.pojo;

import java.util.Calendar;
import java.util.Date;

public class ProductInput {

	public String productName;
	public Integer sellIn;
	public Integer quality;
	public Date addedDate;
	public Date sellDate;

	public ProductInput() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductInput(String name, Integer sellIn, Integer quality) {
		super();
		this.productName = name;
		this.sellIn = sellIn;
		this.quality = quality;
		this.addedDate=new Date();
		this.sellDate = new Date();
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String name) {
		this.productName = name;
	}

	public Integer getSellIn() {
		return sellIn;
	}

	public void setSellIn(Integer sellIn) {
		this.sellIn = sellIn;
	}

	public Integer getQuality() {
		return quality;
	}

	public void setQuality(Integer quality) {
		this.quality = quality;
	}

	public Date getEntryDate() {
		return addedDate;
	}

	public void setEntryDate(Date entryDate) {
		this.addedDate = entryDate;
	}

	public Date getSellDate() {
		return sellDate;
	}

	public void setSellDate(Date entryDate) {
		this.sellDate = entryDate;
	}

}