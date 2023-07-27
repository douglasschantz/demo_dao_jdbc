package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {	
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("==== TEST 1 - findbyId ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n==== TEST 2 - Seller findbyDepartment ====");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TEST 3 - Seller findbyAll ====");
		list = sellerDao.findAll();
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TEST 4 - Seller insert ====");
		Seller newSeller = new Seller(null, "Greg", "greg@email.com", new Date(), 4000.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id = "+newSeller.getId());
		
		
		System.out.println("\n==== TEST 5 - Seller update ====");		
		seller = sellerDao.findById(1);
		seller.setName("Maria Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n==== TEST 5 - Seller delete ====");		
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("\ndelete completed");
		sc.close();
		

	}

}
