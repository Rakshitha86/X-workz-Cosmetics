package com.xworkz.tester;

import com.xworkz.Cosmetics.Constants.CosmeticShades;
import com.xworkz.Cosmetics.Constants.CosmeticType;
import com.xworkz.Cosmetics.dao.CosmeticsDAO;
import com.xworkz.Cosmetics.dao.CosmeticsDAOImpl;
import com.xworkz.Cosmetics.dto.CosmeticsDTO;

public class CosmeticTester {

	public static void main(String[] args) {
		CosmeticsDTO cosmeticsDTO = new CosmeticsDTO();
		cosmeticsDTO.setBrand("Maybelline");
		cosmeticsDTO.setPrice(300);
		cosmeticsDTO.setQuantity(50);
		cosmeticsDTO.setShades(CosmeticShades.RED);
		cosmeticsDTO.setType(CosmeticType.TONER);

		CosmeticsDAO dao = new CosmeticsDAOImpl();
		System.out.println(dao.save(cosmeticsDTO));
		CosmeticsDTO cosmeticsDTO2 = new CosmeticsDTO("Lakme", 400, 20, CosmeticShades.BLUE, CosmeticType.LIPSTICK);
		System.out.println(dao.save(cosmeticsDTO2));
		CosmeticsDTO cosmeticsDTO3 = new CosmeticsDTO("Dazler", 600, 40, CosmeticShades.BLACK, CosmeticType.EYELINER);
		System.out.println(dao.save(cosmeticsDTO3));

		CosmeticsDTO findByBrand = dao.findByBrand("Maybelline");
		System.out.println(findByBrand);

		boolean updatePriceAndQuantityByBrand = dao.updatePriceAndQuantityByBrand(200, 10, "Dazler");
		System.out.println(updatePriceAndQuantityByBrand);

		boolean updatePriceByBrandAndType = dao.updatePriceByBrandAndType(400, "Dazler", CosmeticType.EYELINER);
		System.out.println(updatePriceByBrandAndType);
		
		boolean updateByBrand = dao.updateByBrand("Lakme");
		System.out.println(updateByBrand);
		
		 dao.deleteAll();
		 
		 int totalSize = dao.totalSize();
		 System.out.println(totalSize);
	}

}
