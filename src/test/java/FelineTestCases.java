import java.util.Arrays;
import java.util.List;

// Метод, возвращающий тестовые данные для проверки метода eatMeat
public class FelineTestCases {
    public static List<Object[]> getEatMeatTestData() {
        return Arrays.asList(new Object[][] {
                {Arrays.asList("Животные", "Птицы", "Рыбы")}
        });
    }
    public static List<Object[]> getFamilyTestData() {
        return Arrays.asList(new Object[][] {
                {"Кошачьи"}
        });
    }
}

