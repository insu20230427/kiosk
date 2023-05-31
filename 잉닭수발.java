package menu;

import java.util.*;

public class 잉닭수발 {
    private static final String ADMIN_PASSWORD = "0821";



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Scanner클래스의 참조변수

        Order order = new Order();
        // order클래스의 참조변수

        List<Product> productList = new ArrayList<>();
        // ArrayList객체의 Product객체를 직접참조하는 변수 productList
        // 즉 Product객체를 직접참조하는 변수는 productList,cart가 존재함.

        productList.add(new Product("숯불무뼈닭발(1인분)", 8.0, "함 잡숴봐"));
        productList.add(new Product("숯불뼈닭발(1인분)", 7.5, "귀찮지만 함 잡숴봐"));
        productList.add(new Product("국물무뼈닭발(1인분)", 9.0, "술떙김"));
        productList.add(new Product("국물뼈닭발(1인분)", 8.5, "귀찮지만 술떙김"));
        productList.add(new Product("푸딩계란찜", 3.0, "푸딩보다 더 푸딩임"));
        productList.add(new Product("참치마요 주먹밥", 4.0, "참치마요랑 결혼할래.."));
        productList.add(new Product("케요네즈 샐러드", 3.0, "싱싱하다 싱싱해"));

        // ArrayList의 Product객체에 메뉴 추가

        while (true) {
            System.out.println("\n 잉닭수발에 오신것을 환영합니다!~!");
            System.out.println("1. 메뉴판 ");
            System.out.println("2. 결제하기 ");
            System.out.println("3. 결제 취소하기 ");
            System.out.println("0. 관리자 권한 ");
            System.out.print("선택: ");

            String input = scanner.nextLine();
            switch (input) {

                case "1":
                    // 메뉴판 보기
                    while (true) {
                        System.out.println("[ MENU ]");
                        for (int i = 0; i < productList.size(); i++) {

                            Product product = productList.get(i);
                            // get(i)를 이용하여 해당 요소들의 참조변수들을 대입, 각 참조변수의 주소값이 저장됨

                            System.out.println((i + 1) + ". " + product.name + " | W " + product.price + " | " + product.description);
                            // product가 참조하는 객체 = 각 요소들, 즉 각 요소들의 name, price, description 가져와 출력
                        }
                        System.out.println("0. 돌아가기 ");
                        System.out.print("선택: ");
                        input = scanner.nextLine();

                        if (input.equals("0")) {
                            // 0을 누르면 case1의 while문 종료
                            break;
                        } else {
                            int productIndex = Integer.parseInt(input) - 1;
                            // 정수로 반환해서 가져옴, 0이 아니면 input의 값에 대한 index값 반환
                            // 예를들어 input = 4가 입력되면 Integer.parseInt(input) - 1 = 3

                            Product product = getSelectedProduct(productIndex, productList);
                            // productInedx라는 인덱스값과, productList라는 객체를 던져줌
                            // input을 넣어 얻은 Index값과 productList객체를 전달
                            // product는 그 객체의 Index에 해당하는 요소의 주소값을 받았기 때문에 해당요소에 직접참조 가능


                            if (product != null) {
                            // product가 해당 인덱스의 요소값을 참조할 수 있을 때 실행
                            // 즉, 1 ~ 6의 번호가 아닌 값을 받으면 실행하지 x

                                System.out.println("\"" + product.name + "    | W " + product.price + " | " + product.description + "\"");
                                // product가 참조하는 객체의 요소가 존재할때 실행
                                // product가 참조하는 객체 = 해당 요소들 즉, 해당요소의 name, price, description 가져오기

                                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                                System.out.println("1. 확인        2. 취소");
                                input = scanner.nextLine();
                                if (input.equals("1")) {
                                    order.addToCart(product);
                                    // 해당 요소를 참조하는 변수를 addToCart에 보내줌

                                    System.out.println("메뉴가 장바구니에 추가되었습니다.");
                                } else if (input.equals("2")) {
                                    System.out.println("메뉴 추가를 취소합니다.");
                                } else {
                                    System.out.println("잘못된 입력입니다. 메뉴 추가를 취소합니다.");
                                }
                            } else {
                                System.out.println("올바른 상품 번호를 입력해주세요.");
                                //  1 ~ 6의 번호가 아닌 값을 받으면 올바른 상품 번호를 입력하라고 알려줌
                            }
                        }
                    }
                    break;
                case "2":
                    // 주문 화면
                    while (true) {
                        System.out.println("아래와 같이 주문 하시겠습니까?\n");
                        order.viewCart();
                        // Order객체의 viewCart(); 호출
                        // 장바구니가 비어있으면 장바구니가 비어있다고 호출해준다.
                        System.out.println("\n1. 주문      2. 메뉴판");

                        input = scanner.nextLine();
                        if (input.equals("1")) {
                            // 주문완료 화면
                            System.out.println("주문이 완료되었습니다!");
                            System.out.println("대기번호는 [ " + order.getOrderCount() + " ] 번 입니다.");
                            // orderCount 반환해줌
                            order.clearCart();
                            // orderCount가 증가됨

                            try {
                                Thread.sleep(3000);
                            // Thread.sleep(3000);을 써서 3초 지연시킴

                            } catch (InterruptedException e) {
                            // catch는 try에서 실행한 예외를 잡지만, Thread.sleep는 예외가 아니라 그냥 try실행됨
                            // 예외면 가두고 e.printStackTrac();를 실행하라고만 하는 것
                                e.printStackTrace();
                            }
                            break;
                        } else if (input.equals("2")) {
                            break;
                        }
                    }
                    break;
                case "3":
                    // 주문 취소 화면
                    System.out.println("결제를 취소하시겠습니까?");
                    System.out.println("1. 확인      2. 메뉴판");

                    input = scanner.nextLine();
                    if (input.equals("1")) {
                        order.clearCart();
                        System.out.println("결제가 취소되었습니다.");
                    } else if (input.equals("2")) {
                        continue;
                    }
                    break;
                case "0":
                    // 관리자 권한
                    System.out.print("관리자 비밀번호를 입력하십시오: ");
                    String password = scanner.nextLine();
                    if (password.equals(ADMIN_PASSWORD)) {
                        while (true) {
                            System.out.println("\n[ 관리자 권한 ]");
                            System.out.println("1. 총 판매상품 목록 현황");
                            System.out.println("2. 총 판매금액 현황");
                            System.out.println("3. 돌아가기");

                            System.out.print("선택: ");

                            input = scanner.nextLine();
                            switch (input) {
                                case "1":
                                    // 총 판매상품 목록 현황 조회
                                    System.out.println("\n[ 총 판매상품 목록 현황 ]");
                                    order.viewCart();
                                    break;
                                case "2":
                                    // 총 판매금액 현황 조회
                                    System.out.println("\n[총 판매금액 현황 ]");
                                    System.out.println("W " + order.getTotalSales());
                                    break;
                                case "3":
                                    break;
                                    // switch문에서 실행영역이 비어져있을때 break를쓰면 switch문 탈출ehfkahd0
                                default:
                                    System.out.println("올바른 메뉴 번호를 입력해주세요.");
                                    break;
                            }
                            if (input.equals("3")) {
                                break; // 돌아가기를 선택하면 while 루프를 탈출하여 메인 화면으로 돌아갑니다.
                            }
                        }
                    } else {
                        System.out.println("관리자 비밀번호가 올바르지 않습니다.");
                    }
                    break; // 관리자 권한 선택이 끝나면 switch 문에서 빠져나와 메인 메뉴로 돌아갑니다.

                default:
                    System.out.println("올바른 메뉴 번호를 입력해주세요.");
                    break;

            }
        }
    }

    private static Product getSelectedProduct(int index, List<Product> productList) {
        //
        if (index >= 0 && index < productList.size()) {
            // index : 0 ~ 5
            return productList.get(index);
            // 0 ~ 5순번에 해당하는 요소의 인덱스 반환
        }
        return null;
        // index : 0 ~ 5순번에 아니면 null을 보내기
    }
}

