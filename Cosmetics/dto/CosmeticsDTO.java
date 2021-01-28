package com.xworkz.Cosmetics.dto;

import com.xworkz.Cosmetics.Constants.CosmeticShades;
import com.xworkz.Cosmetics.Constants.CosmeticType;

public class CosmeticsDTO {
	private String brand;
	private int price;
	private int quantity;
	private CosmeticShades shades;
	private CosmeticType type;

	public CosmeticsDTO() {

	}

	public CosmeticsDTO(String brand, int price, int quantity, CosmeticShades shades, CosmeticType type) {
		super();
		this.brand = brand;
		this.price = price;
		this.quantity = quantity;
		this.shades = shades;
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public CosmeticShades getShades() {
		return shades;
	}

	public void setShades(CosmeticShades shades) {
		this.shades = shades;
	}

	public CosmeticType getType() {
		return type;
	}

	public void setType(CosmeticType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "CosmeticsDTO [brand=" + brand + ", price=" + price + ", quantity=" + quantity + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			System.out.println("Object is null");
		if (obj instanceof CosmeticsDTO) {
			CosmeticsDTO casted = (CosmeticsDTO) obj;
			if (this.brand != null && this.type != null) {
				if (this.brand.equals(casted.getBrand())) 
						if(this.type.equals(casted.getType()))
					System.out.println("CosmeticDTO is equal");
			}
			return true;
		}
		return false;
	}
}
