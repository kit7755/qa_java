import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {

    // Тестирует метод getFamily
    @Test
    public void testFamily() {
        String expectedMessage = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        Animal animal = new Animal();
        assertEquals("Ошибка в перечесление семейств",
                animal.getFamily(),
                expectedMessage
        );
    }

    // Тестирует метод getFood для неизвестного типа животного.

    @Test
    public void testCheckErrorMessage() {
        String expectedMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";

        Animal animal = new Animal();
        Exception exception = Assert.assertThrows(Exception.class, () ->
                animal.getFood(""));

        assertEquals(expectedMessage, exception.getMessage());
    }
}
