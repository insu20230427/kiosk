package menu;

import java.util.*;

// 주문 클래스
class Order {
    private List<Product> cart;
    // cart : List인터페이스를 구현한 클래스의 객체 중 Product타입의 객체를 직접참조
    private double totalSales;
    // totalSales  : 총 판매금액
    private int orderCount;
    // orderCount : 총 주문량

    public Order() {
    // Order클래스의 생성자

        cart = new ArrayList<>();
        // ArrayList객체 중 Product타입의 객체를 생성
        // cart에 ArrayList객체의 Product타입의 객체의 주소값 대입
        // 이제 cart는 ArrayList<>를 직접조회 할 수 있게 됨

        totalSales = 0.0;
        orderCount = 0;
        // totalSales, orderCount 초기화
    }

    public void addToCart(Product product) {
    // 해당 요소를 참조하는 요소를 받음
    // 즉 addToCart를 부르면 그 요소를 참조하는 참조변수를 받게됨
        cart.add(product);
        // cart가 참조조하는 객체 Product 객체에 넣음

        totalSales += product.price;
        // 총 판매 금액 증가

        orderCount++;
        // totalSales, orderCount 값 증가
    }

    public void viewCart() {
        // 장바구니 보기

        if (cart.isEmpty()) {
            System.out.println("장바구니가 비어있습니다.");
            // Product객체의 요소가 존재하지 않으면 장바구니 비었다고 말해쥼

        } else {
            // Product객체의 요소가 존재하면 실행

            System.out.println("[ Orders ]");
            for (Product product : cart) {
                //product가 cart를 순회함. 즉, cart의 주소값을 순회

                System.out.println(product.name + "    | W " + product.price);
                // 즉, cart가 참조하는 Product객체의 name, price를 출력하는 것
            }
            System.out.println("\n[ Total ]");
            System.out.println("W " + totalSales);
        }
    }

    public void maintainCart() {
        orderCount++;
    }
    // maintainCart를 호출하면 주문수 증가

    public int getOrderCount() {
        return orderCount;
        // 주문수 알려주기
        // getOrderCount를 호출하면 주문수를 알려줌

    }

    public double getTotalSales() {
        return totalSales;
        // 총판매금액 알려주기
        // getTotalSales를 호출하면 총 판매금액을 알려줌
    }
}