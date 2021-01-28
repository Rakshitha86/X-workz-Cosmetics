package com.xworkz.Cosmetics.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.xworkz.Cosmetics.Constants.CosmeticType;
import com.xworkz.Cosmetics.dto.CosmeticsDTO;

public class CosmeticsDAOImpl implements CosmeticsDAO {

	private List<CosmeticsDTO> cosmetics;

	// constructor is used for initializing the instance variable we can also use
	// setters method
	public CosmeticsDAOImpl() {
		this.cosmetics = new ArrayList<CosmeticsDTO>();
//		this.cosmetics = new LinkedList<CosmeticsDTO>();
	}

	@Override
	public boolean save(CosmeticsDTO dto) {
		boolean added = false;
		boolean contains = this.cosmetics.contains(dto);// Lakme
		if (!contains) {
			added = this.cosmetics.add(dto);
		}
		if (added)
			System.out.println("Cosmetics added" + dto);
		else
			System.out.println("Cosmetics not added");
		return added;
	}

	@Override
	public CosmeticsDTO findByBrand(String brand) {
		for (CosmeticsDTO cosmeticsDTO : cosmetics) {
			String cosmeticsFromBrand = cosmeticsDTO.getBrand();
			if (cosmeticsFromBrand.equals(cosmeticsDTO)) {
				System.out.println("Cosmetic found");
				return cosmeticsDTO;
			}
		}
		return null;
	}

	@Override
	public boolean updatePriceAndQuantityByBrand(int price, int quantity, String brand) {
		System.out.println("updatePriceAndQuantityByBrand");
		System.out.println("Price: " + price);
		System.out.println("Quantity: " + quantity);
		System.out.println("Brand: " + brand);
		CosmeticsDTO findByBrand = this.findByBrand("Dazler");
		if (findByBrand != null) {
			System.out.println("can update, cosmetic found");
			findByBrand.setPrice(price);
			findByBrand.setQuantity(quantity);
			return true;
		} else {
			System.out.println("cannot update");
		}
		return false;
	}

	public CosmeticsDTO findByBrandAndType(String Brand, CosmeticType type) {
		for (CosmeticsDTO cosmeticsDTO : cosmetics) {
			String cosmeticsFromBrand = cosmeticsDTO.getBrand();
			CosmeticType cosmeticsFromType = cosmeticsDTO.getType();
			if (cosmeticsFromType.equals(cosmeticsDTO)) {
				System.out.println("Cosmetic found");
				return cosmeticsDTO;
			}
		}
		return null;
	}

	@Override
	public boolean updatePriceByBrandAndType(int price, String brand, CosmeticType type) {
		System.out.println("updatePriceByBrandAndType");
		System.out.println("Price: " + price);
		System.out.println("Brand: " + brand);
		System.out.println("Type: " + type);
		CosmeticsDTO findByBrandAndType = this.findByBrandAndType("Dazler", CosmeticType.EYELINER);
		if (findByBrandAndType != null) {
			System.out.println("can update, cosmetic found");
			findByBrandAndType.setBrand(brand);
			findByBrandAndType.setType(type);
			return true;
		} else {
			System.out.println("cannot update");
		}
		return false;
	}

	@Override
	public boolean updateByBrand(String brand) {
		System.out.println("updateByBrand");
		System.out.println("Brand: " + brand);
		CosmeticsDTO findByBrand = this.findByBrand("Lakme");
		if (findByBrand != null) {
			System.out.println("can update, cosmetic found");
			return true;
		} else {
			System.out.println("cannot update");
		}
		return false;
	}

	@Override
	public void deleteAll() {
		cosmetics.clear();
	}

	@Override
	public List<CosmeticsDTO> getAll() {
	
		return null;
	}

	@Override
	public int totalSize() {
		
		return this.cosmetics.size();
	}

}
