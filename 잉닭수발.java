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
        // scanner, order, Product타입의 List 인터페이스의 productList

        productList.add(new Product("숯불무뼈닭발(1인분)", 8.0, "함 잡숴봐"));
        productList.add(new Product("숯불뼈닭발(1인분)", 7.5, "귀찮지만 함 잡숴봐"));
        productList.add(new Product("국물무뼈닭발(1인분)", 9.0, "술떙김"));
        productList.add(new Product("국물뼈닭발(1인분)", 8.5, "귀찮지만 술떙김"));
        // ArrayList에 메뉴 추가

        while (true) {
            System.out.println("\n 잉닭수발에 오신것을 환영합니다!~!");
            System.out.println("1. 메뉴판 ");
            System.out.println("2. 결제하기 ");
            System.out.println("3. 결제 취소하기 ");
            System.out.println("0. 관리자 권한 ");
            System.out.print("선택: ");

            String input = scanner.nextLine();
            switch (input) {
                // case 1이면
                case "1":
                    // 메뉴판 보기
                    while (true) {
                        System.out.println("[ MENU ]");
                        for (int i = 0; i < productList.size(); i++) {

                            Product product = productList.get(i);
                            // 닭발 메뉴 4가지 불러오기

                            System.out.println((i + 1) + ". " + product.name + " | W " + product.price + " | " + product.description);
                        }
                        System.out.println("5. 돌아가기 ");
                        System.out.print("선택: ");
                        input = scanner.nextLine();

                        if (input.equals("5")) {
                            break;
                        } else {
                            int productIndex = Integer.parseInt(input) - 1;
                            // 정수로 반환해서 가져옴, -1 ㅡ> index 맞춰주기
                            // ex) Integer.parseInt(input) = 4라면 index = 4

                            Product product = getSelectedProduct(productIndex, productList);
                            // 해당 메서드로 받아온 값을 Product타입 product로 받음
                            // 어떤걸 받냐면 productList의 각 순번에 해당하는 요소값 받음
                            // 이 요소값들을 product에

                            if (product != null) {
                                System.out.println("\"" + product.name + "    | W " + product.price + " | " + product.description + "\"");
                                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                                System.out.println("1. 확인        2. 취소");
                                input = scanner.nextLine();
                                if (input.equals("1")) {
                                    order.addToCart(product);
                                    System.out.println("메뉴가 장바구니에 추가되었습니다.");
                                } else if (input.equals("2")) {
                                    System.out.println("메뉴 추가를 취소합니다.");
                                } else {
                                    System.out.println("잘못된 입력입니다. 메뉴 추가를 취소합니다.");
                                }
                            } else {
                                System.out.println("올바른 상품 번호를 입력해주세요.");
                            }
                        }
                    }
                    break;
                case "2":
                    // 주문 화면
                    while (true) {
                        System.out.println("아래와 같이 주문 하시겠습니까?\n");
                        order.viewCart();
                        System.out.println("\n1. 주문      2. 메뉴판");

                        input = scanner.nextLine();
                        if (input.equals("1")) {
                            // 주문완료 화면
                            System.out.println("주문이 완료되었습니다!");
                            System.out.println("대기번호는 [ " + order.getOrderCount() + " ] 번 입니다.");
                            order.clearCart();
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
                                default:
                                    System.out.println("올바른 메뉴 번호를 입력해주세요.");
                                    break;
                            }

                            if (input.equals("3")) {
                                break;
                            }
                        }
                    } else {
                        System.out.println("관리자 비밀번호가 올바르지 않습니다.");
                    }
                    break;
                default:
                    System.out.println("올바른 메뉴 번호를 입력해주세요.");
                    break;
            }
        }
    }

    private static Product getSelectedProduct(int index, List<Product> productList) {
        //
        if (index >= 0 && index < productList.size()) {
            // index : 0 ~ 3
            return productList.get(index);
            // 0 ~ 3순번 각각에 해당하는 요소 게또해서 반환하기
        }
        return null;
    }
}

