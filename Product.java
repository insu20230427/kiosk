package menu;

class Product extends Menu {
    // 부모클래스 : Menu
    //
    protected double price;

    public Product(String name, double price, String description) {
        super(name, description);
        // 부모 생성자 호출

        this.price = price;
        // 자녀클래스 멤버변수 price 초기화
    }
}
