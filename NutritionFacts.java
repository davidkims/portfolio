package effectivejava.chapter2.item2.javabeans;

// 코드 2-2 자바빈즈 패턴 - 일관성이 깨지고, 불변으로 만들 수 없다. (16쪽)
public class NutritionFacts {
    // 매개변수들은 (기본값이 있다면) 기본값으로 초기화된다.
    private int servingSize  = -1; // 필수; 기본값 없음
    private int servings     = -1; // 필수; 기본값 없음
    private int calories     = 0;
    private int fat          = 0;
    private int sodium       = 0;
    private int carbohydrate = 0;

    public NutritionFacts() { }
    // Setters
    public void setServingSize(int val)  { servingSize = val; }
    public void setServings(int val)     { servings = val; }
    public void setCalories(int val)     { calories = val; }
    public void setFat(int val)          { fat = val; }
    public void setSodium(int val)       { sodium = val; }
    public void setCarbohydrate(int val) { carbohydrate = val; }

    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts();
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);
        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);
    }
}

이 코드는 자바빈즈 패턴(JavaBeans Pattern)을 사용하여 영양 성분 정보를 표현하는 클래스인 NutritionFacts를 정의합니다. 이 패턴은 객체의 상태를 설정하기 위해 getter와 setter 메서드를 사용하는 디자인 패턴입니다.

여기서 NutritionFacts 클래스는 음료수의 영양 성분 정보를 나타내며, 각 성분에 대한 정보를 멤버 변수로 가지고 있습니다. 해당 멤버 변수들은 private으로 선언되어 외부에서 직접 접근이 불가능하며, setter 메서드를 통해 값을 설정할 수 있습니다.

주요 요소들에 대한 설명은 다음과 같습니다:

servingSize, servings, calories, fat, sodium, carbohydrate: 음료수의 영양 성분을 나타내는 변수들입니다.
NutritionFacts(): 기본 생성자로, 아무런 매개변수 없이 객체를 생성합니다.
Setter 메서드들: 각각의 setter 메서드를 통해 객체의 상태를 설정할 수 있습니다.
주어진 main 메서드에서는 NutritionFacts 클래스를 사용하여 콜라(cocaCola) 객체를 생성하고, setter 메서드를 이용하여 각각의 영양 성분을 설정하고 있습니다.

자바빈즈 패턴의 단점 중 하나는 일관성이 깨질 수 있다는 점입니다. 객체를 생성한 후에도 setter 메서드를 통해 값이 계속해서 변경될 수 있기 때문에, 객체의 불변성을 보장할 수 없습니다. 이는 예기치 못한 오류를 발생시킬 수 있는 가능성이 있습니다. 
또한, 객체를 스레드 안전하게 만들기 어려울 수 있습니다. 따라서 불변 객체를 사용하는 것이 더 안전하고 예측 가능한 코드를 작성하는 데 도움이 됩니다.
