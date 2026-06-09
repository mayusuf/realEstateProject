package shoppingcart;

import products.Product;

public class CartLine {
	private Product product;
	private int quantity;

	public CartLine(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void increaseQuantity() {
		quantity++;
	}

	public void decreaseQuantity() {
		quantity--;
	}

}
