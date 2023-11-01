package project_Product;

import java.util.*;

import com.careercamp.dto;
import com.careercamp.dao;
import com.careercamp.service;




public class Products {

	private static ArrayList<Product> data = new ArrayList<>();
	private static int id;

	private class Product {

		int prodID;
		String prodName;
		double price;
		int quantity;
		double discount;

		Product(String name, double price, int quantity, double discount) {
			this.prodID = ++id;
			this.prodName = name;
			this.price = price;
			this.quantity = quantity;
			this.discount = discount;
		}
	}

	// add
	public void addProduct(String name, double price, int quantity, double discount) {
		// TODO Auto-generated method stub
		Product p = new Product(name, price, quantity, discount);
		data.add(p);

	}

	// display
	public void display() {
		for (int i = 0; i < data.size(); i++) {

			Product p = data.get(i);
			System.out.println("productID = " + p.prodID + "|| Name = " + p.prodName + "|| Price = " + p.price
					+ "/-|| Quantity = " + p.quantity + "|| Discount = " + p.discount);

		}
	}

	// delete

	public void deleteProduct(int id) {
		try {
			delete(id);
		} catch (Exception e1) {
			System.err.println("ProductNotFound");
		}
	}

	private void delete(int id) throws ProductNotFoundException {

		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).prodID == id) {
				data.remove(i);
				return;
			}
		}

		throw new ProductNotFoundException();
	}

	// update
	public void update(int id, String name, double price, int quantity, double discount) {

		for (int i = 0; i < data.size(); i++) {

			if (data.get(i).prodID == id) {
				data.get(i).prodName = name;
				data.get(i).price = price;
				data.get(i).quantity = quantity;
				data.get(i).discount = discount;
				break;
			}
		}
		
		System.out.println();

	}

	// search
	private void search(int id) throws ProductNotFoundException {
		for (int i = 0; i < data.size(); i++) {

			if (data.get(i).prodID == id) {
				Product p = data.get(i);
				System.out.println("productID = " + p.prodID + "| Name = " + p.prodName + "| Price = " + p.price
						+ "/-| Quantity = " + p.quantity + "| Discount = " + p.discount);

				return;
			}
		}
		throw new ProductNotFoundException();

	}

	public void searchProduct(int id) {
		try {
			search(id);
		} catch (Exception e1) {
			System.err.println("ProductNotFound");
		}

	}

	// display price asc
	public void displayPrice(int q) {

		if (q == 1) {
			for (int i = 0; i < this.data.size(); i++) {

				for (int j = 0; j < this.data.size() - 1; j++) {
					if (data.get(j).price > data.get(j + 1).price) {
						Product temp = data.get(j);
						data.set(j, data.get(j + 1));
						data.set(j + 1, temp);
					}
				}
			}
		} else {
			for (int i = 0; i < this.data.size(); i++) {

				for (int j = 0; j < this.data.size() - 1; j++) {
					if (data.get(j).price < data.get(j + 1).price) {
						Product temp = data.get(j);
						data.set(j, data.get(j + 1));
						data.set(j + 1, temp);
					}
				}
			}

		}
		display();

	}
	
	
	public void displayDiscount(int q) {

		if (q == 1) {
			for (int i = 0; i < this.data.size(); i++) {

				for (int j = 0; j < this.data.size() - 1; j++) {
					if (data.get(j).discount > data.get(j + 1).discount) {
						Product temp = data.get(j);
						data.set(j, data.get(j + 1));
						data.set(j + 1, temp);
					}
				}
			}
		} else {
			for (int i = 0; i < this.data.size(); i++) {

				for (int j = 0; j < this.data.size() - 1; j++) {
					if (data.get(j).discount < data.get(j + 1).discount) {
						Product temp = data.get(j);
						data.set(j, data.get(j + 1));
						data.set(j + 1, temp);
					}
				}
			}

		}
		display();

	}
	

}
