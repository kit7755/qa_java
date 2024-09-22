import com.example.Animal;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;


public class AnimalTest {

    private final Animal animal = new Animal();


    // Тестирует метод getFood для травоядного животного.
    @Test
    public void testHerbivoreFood() throws Exception {
        List<String> expectedFood = List.of("Трава", "Различные растения");
        List<String> actualFood = animal.getFood("Травоядное");
        assertEquals(expectedFood, actualFood);
    }

    // Тестирует метод getFood для хищника

    @Test
    public void testPredatorFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = animal.getFood("Хищник");
        assertEquals(expectedFood, actualFood);
    }

    // Тестирует метод getFood для неизвестного типа животного.
    @Test
    public void testCheckErrorMessage() {
        Exception exception = assertThrows(Exception.class, () -> animal.getFood("Неизвестное животное"));

        String expectedMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    // Тестирует метод getFamily.
    @Test
    public void testFamily() {
        String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actualFamily = animal.getFamily();
        assertEquals(expectedFamily, actualFamily);
    }
}

