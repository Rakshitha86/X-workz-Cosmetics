package com.xworkz.tester;

import com.xworkz.Cosmetics.Constants.CosmeticShades;
import com.xworkz.Cosmetics.Constants.CosmeticType;
import com.xworkz.Cosmetics.Service.CosmeticService;
import com.xworkz.Cosmetics.Service.CosmeticServiceImpl;
import com.xworkz.Cosmetics.dao.CosmeticsDAO;
import com.xworkz.Cosmetics.dao.CosmeticsDAOImpl;
import com.xworkz.Cosmetics.dto.CosmeticsDTO;

public class ValidationTester {

	public static void main(String[] args) {
		// CosmeticsDAO cosmeticsDAO = new CosmeticsDAOImpl();

		CosmeticsDTO cosmeticsDTO = new CosmeticsDTO();
		//cosmeticsDTO.setBrand("");//it should print brand is invalid
		cosmeticsDTO.setBrand("MAC");//it should print brand is valid

		// cosmeticsDAO.save(null);
		// System.out.println(cosmeticsDAO.totalSize());

		cosmeticsDTO.setType(CosmeticType.LIPSTICK);// prints type is valid
		// cosmeticsDTO.setType(null);//prints type is not valid

		// cosmeticsDTO.setShades(null);//it prints shade is invalid
		cosmeticsDTO.setShades(CosmeticShades.PINK);// it prints shade is valid

		// cosmeticsDTO.setPrice(0);//it prints price is invalid
		cosmeticsDTO.setPrice(500);// it prints price is valid

		//cosmeticsDTO.setQuantity(0);//it prints quantity is invalid
		cosmeticsDTO.setQuantity(50);//it prints  is valid
		
		CosmeticsDAO  dao = new CosmeticsDAOImpl();
		CosmeticService cosmeticService = new CosmeticServiceImpl(dao);
		
//		CosmeticService cosmeticService = new CosmeticServiceImpl();
		cosmeticService.validateAndSave(cosmeticsDTO);
		
		
		CosmeticsDTO cosmeticsDTO2 = new CosmeticsDTO("Sugr",500,10, CosmeticShades.RED,CosmeticType.TONER);
		cosmeticService.validateAndSave(cosmeticsDTO2);
	}

}
