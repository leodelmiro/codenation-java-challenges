package br.com.codenation.service;

import java.util.*;
import java.util.stream.Collectors;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private final double EIGHTY_PERCENT = 0.8;
	private ProductRepository productRepository = new ProductRepositoryImpl();

	/**
	 * Calculate the sum of all OrderItems
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> items) {
		double sum = 0.0;
		Map<Product, Long> productsQuantity = items.stream().collect(Collectors.groupingBy(x -> productRepository.findById(x.getProductId()).get(), Collectors.summingLong(OrderItem::getQuantity)));

		for (Map.Entry<Product, Long> entry : productsQuantity.entrySet()) {
			Product product = entry.getKey();
			Long productQuantity = entry.getValue();
			if (product.getIsSale()){
				sum += product.getValue() * productQuantity * EIGHTY_PERCENT;
				continue;
			}
			sum += product.getValue() * productQuantity;
		}

		return sum;
	}

	/**
	 * Map from idProduct List to Product Set
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {
		return ids.stream()
				.map(x -> productRepository.findById(x).orElse(null))
				.filter(Objects::nonNull)
				.collect(Collectors.toSet());
	}

	/**
	 * Calculate the sum of all Orders(List<OrderIten>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		return orders.stream().mapToDouble(this::calculateOrderValue).sum();
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
		List<Product> products = new ArrayList<>(findProductsById(productIds));

		return products.stream()
				.collect(Collectors.groupingBy(Product::getIsSale));
	}

}