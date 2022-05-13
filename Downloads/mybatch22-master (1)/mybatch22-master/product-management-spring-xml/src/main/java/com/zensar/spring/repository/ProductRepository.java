package com.zensar.spring.repository;

import com.zensar.spring.beans.Product;

public interface ProductRepository {

	public int insertProduct(Product product);
	
    public boolean deleteProduct(int productId);
	
	public int updateProduct(Product product);

	//public void updateProduct(int productCost);

	//public void deleteProduct(Product product);

	//public Object updateProduct(int id, String productName, int productCost);
}
