package com.xworkz.Cosmetics.Service;

import com.xworkz.Cosmetics.Constants.CosmeticShades;
import com.xworkz.Cosmetics.Constants.CosmeticType;
import com.xworkz.Cosmetics.dao.CosmeticsDAO;
import com.xworkz.Cosmetics.dao.CosmeticsDAOImpl;
import com.xworkz.Cosmetics.dto.CosmeticsDTO;

public class CosmeticServiceImpl implements CosmeticService {

	private CosmeticsDAO cosmeticsDAO;
//	public CosmeticServiceImpl() {
//		System.out.println("Created CosmeticServiceImpl");
//		this.cosmeticsDAO=new CosmeticsDAOImpl();
//		
//	}
	
	public CosmeticServiceImpl(CosmeticsDAO cosmeticsDAO) {
		System.out.println("Created CosmeticServiceImpl");
		this.cosmeticsDAO=cosmeticsDAO;
		
	}

	@Override
	public boolean validateAndSave(CosmeticsDTO cosmeticDTO) {
		boolean validData = false;// it is used in all the properties which tells if it is valid then only check the data
		if (cosmeticDTO != null) {
			System.out.println("dto is not null, will validate fields");
			String brand = cosmeticDTO.getBrand();
			// we can write like null,""," ","V"

			if (brand != null && brand.length() >= 3 && !brand.isEmpty() && !brand.contains(" ")) {
				System.out.println("brand is invalid");
				validData = true;//
			} else {
				System.out.println("brand is invalid");
				validData = false;//
			}

			
			if (validData) {//
				CosmeticType type = cosmeticDTO.getType();
				if (type != null) {
					System.out.println("type is valid");
					validData = true;//
				} else {
					System.out.println("type is not valid");
					validData = false;//
				}
			}

			
			if (validData) {//
				CosmeticShades shades = cosmeticDTO.getShades();
				if (shades != null) {
					System.out.println("shade is valid");
					validData = true;//
				} else {
					System.out.println("shade is not valid");
					validData = false;//
				}
			}

			
			if (validData) {//
			int price = cosmeticDTO.getPrice();
			if (price > 0) {
				System.out.println("price is valid");
				validData=true;//
			} else {
				System.out.println("price is invalid");
				validData=false;//
			}
			}
			
			
			if (validData) {//
			int quantity = cosmeticDTO.getQuantity();
			if (quantity > 0 && quantity <= 100) {
				System.out.println("quantity is valid");
				validData=true;//
			} else {
				System.out.println("quantity is invalid");
				validData=false;//
			}
			}
			
			
			if (validData) {//
				System.out.println("data is valid, can invoke");
				//CosmeticsDAO cosmeticsDAO = new CosmeticsDAOImpl();//we should declare this variable above and we should create an object inside the constructor osf the class
				cosmeticsDAO.save(cosmeticDTO);
			}
		} 
		else
		{
			System.out.println("dto is null, invalid data");
		}

			return false;
	}

}
