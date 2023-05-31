package menu;

import java.util.*;

// 주문 클래스
class Order {
    private List<Product> cart;
    private double totalSales;
    private int orderCount;

    public Order() {
        cart = new ArrayList<>();
        totalSales = 0.0;
        orderCount = 0;
    }

    public void addToCart(Product product) {
        cart.add(product);
        totalSales += product.price;
        orderCount++;
    }

    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("장바구니가 비어있습니다.");
        } else {
            System.out.println("[ Orders ]");
            for (Product product : cart) {
                System.out.println(product.name + "    | W " + product.price);
            }
            System.out.println("\n[ Total ]");
            System.out.println("W " + totalSales);
        }
    }

    public void clearCart() {
        orderCount++;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public double getTotalSales() {
        return totalSales;
    }
}