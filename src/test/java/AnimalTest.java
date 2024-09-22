import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimalTest {

    // Константы для типов животных
    private static final String UNKNOWN = "Неизвестное животное";

    // Параметры для теста
    @Parameterized.Parameter
    public String animalType;

    @Parameterized.Parameter(1)
    public List<String> expectedFood;

    // Создание экземпляра класса Animal для тестирования
    private final Animal animal = new Animal();

    // Метод, который возвращает параметры для тестов
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Травоядное", List.of("Трава", "Различные растения") },
                { "Хищник", List.of("Животные", "Птицы", "Рыба") }
        });
    }

    // Тестирует метод getFood для травоядного животного.
    @Test
    public void testHerbivoreFood() throws Exception {
        List<String> actualFood = animal.getFood(animalType);
        assertEquals("Неправильный список еды для " + animalType, expectedFood, actualFood);
    }

    // Тестирует метод getFood для неизвестного типа животного.
    @Test
    public void testCheckErrorMessage() {
        Exception exception = assertThrows(Exception.class, () -> animal.getFood(UNKNOWN));

        String expectedMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        String actualMessage = exception.getMessage();

        assertTrue("Ожидаемое сообщение об ошибке", actualMessage.contains(expectedMessage));
    }

    // Тестирует метод getFamily.
    @Test
    public void testFamily() {
        String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actualFamily = animal.getFamily();
        assertEquals("Неверное семейство животных", expectedFamily, actualFamily);
    }
}

