package com.xworkz.Cosmetics.dao;

import java.util.List;

import com.xworkz.Cosmetics.Constants.CosmeticType;
import com.xworkz.Cosmetics.dto.CosmeticsDTO;

public interface CosmeticsDAO {

	public boolean save(CosmeticsDTO dto);

	CosmeticsDTO findByBrand(String brand);

	boolean updatePriceAndQuantityByBrand(int price, int quantity, String brand);

//	boolean updatePriceAndQuantityByBrand(double price,int quantity,String brand);

	CosmeticsDTO findByBrandAndType(String Brand, CosmeticType type);

	boolean updatePriceByBrandAndType(int price, String brand, CosmeticType type);

//	boolean updatePriceByBrandAndType(double price, String brand,CosmeticType type);
	
	boolean updateByBrand(String brand);
	
	void deleteAll();

	List<CosmeticsDTO> getAll();
	
	int totalSize();
}
