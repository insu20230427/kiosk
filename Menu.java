package menu;
import java.util.*;

class Menu {
    protected String name;
    protected String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    // 부모클래스 객체의 초기화 동시에 자녀클래스의 객체도 초기화 하는 과정
    }
}