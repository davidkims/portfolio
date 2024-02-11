package effectivejava.chapter2.item2.hierarchicalbuilder;

import java.util.ArrayList;
import java.util.List;

// Pizza 클래스를 추상 클래스로 정의
abstract class Pizza {
    // Topping 담을 리스트
    protected List<String> toppings;

    // 빌더 클래스 정의
    abstract static class Builder<T extends Builder<T>> {
        // Topping 리스트 초기화
        protected List<String> toppings = new ArrayList<>();

        // Topping 추가 메서드
        public T addTopping(String topping) {
            toppings.add(topping);
            return self();
        }

        // 빌드 메서드 - 추상 메서드로 남겨둠
        abstract Pizza build();

        // 자식 클래스가 자신의 타입을 반환하도록 self 메서드 정의
        protected abstract T self();
    }

    // Pizza 생성자
    protected Pizza(Builder<?> builder) {
        toppings = builder.toppings;
    }

    // 토핑 정보를 문자열로 반환하는 메서드
    @Override
    public String toString() {
        return "Pizza with toppings: " + toppings.toString();
    }
}

// Calzone 클래스는 Pizza 상속받는 하위 클래스
public class Calzone extends Pizza {
    private final boolean sauceInside;

    // 빌더 클래스 정의
    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false; // 기본값

        // 칼초네 안에 소스를 넣는 메서드
        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        // Calzone 객체 생성 메서드
        @Override
        public Calzone build() {
            return new Calzone(this);
        }

        // 자신의 타입을 반환하는 self 메서드 재정의
        @Override
        protected Builder self() {
            return this;
        }
    }

    // Calzone 생성자
    private Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

    // toString 메서드 재정의
    @Override
    public String toString() {
        return String.format("Calzone with toppings: %s, sauceInside: %s",
                toppings.toString(), sauceInside);
    }

    // main 메서드
    public static void main(String[] args) {
        // Calzone 객체 생성 예제
        Calzone calzone = new Calzone.Builder()
                .addTopping("HAM")
                .sauceInside()
                .build();

        System.out.println(calzone.toString());
    }
}