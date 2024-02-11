package effectivejava.chapter2.item2.javabeans;

// 코드 2-2 자바빈즈 패턴 - 일관성이 깨지고, 불변으로 만들 수 없다. (16쪽)
public class NutritionFacts {

    public NutritionFacts(int ignoredVal) {
    }
    // Setters
    public void setServingSize(int ignoredVal)  { // 매개변수들은 (기본값이 있다면) 기본값으로 초기화된다.
        // 필수; 기본값 없음
    }
    public void setServings(int ignoredVal)     { // 필수; 기본값 없음
    }
    public void setCalories(int ignoredVal)     {
    }

    public void setSodium(int ignoredVal)       {
    }
    public void setCarbohydrate(int ignoredVal) {
    }

    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts(1);
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);
        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);
    }
}