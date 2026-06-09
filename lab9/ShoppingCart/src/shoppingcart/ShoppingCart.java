package shoppingcart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import products.Product;

public class ShoppingCart {
	private List<CartLine> cartLines = new ArrayList<CartLine>();

	public void addProduct(Product product) {
		for (CartLine cartLine : cartLines) {
			if (hasSameProductNumber(cartLine, product)) {
				cartLine.increaseQuantity();
				return;
			}
		}

		cartLines.add(new CartLine(product, 1));
	}

	public void removeProduct(Product product) {
		Iterator<CartLine> iterator = cartLines.iterator();

		while (iterator.hasNext()) {
			CartLine cartLine = iterator.next();

			if (hasSameProductNumber(cartLine, product)) {
				if (cartLine.getQuantity() > 1) {
					cartLine.decreaseQuantity();
				} else {
					iterator.remove();
				}
			}
		}
	}

	public void printContent() {
		System.out.println("Content of the shopping cart:");

		for (CartLine cartLine : cartLines) {
			Product product = cartLine.getProduct();
			System.out.println(cartLine.getQuantity() + " "
					+ product.getProductNumber() + " "
					+ product.getDescription() + " "
					+ product.getPrice());
		}

		System.out.println("Total price = " + getTotalPrice());
	}

	public double getTotalPrice() {
		double totalPrice = 0.0;

		for (CartLine cartLine : cartLines) {
			Product product = cartLine.getProduct();
			totalPrice += product.getPrice() * cartLine.getQuantity();
		}

		return totalPrice;
	}

	private boolean hasSameProductNumber(CartLine cartLine, Product product) {
		return cartLine.getProduct().getProductNumber().equals(product.getProductNumber());
	}

}
