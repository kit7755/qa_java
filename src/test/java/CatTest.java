import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

   // Получает звук, издаваемый кошкой, проверяет, что звук соответствует ожидаемому

    @Test
    public void testAnimalSound() {
        String result = cat.getSound();
        assertEquals("Мяу", result);
    }

    //Тест проверяет, что метод getFood у объекта Cat возвращает ожидаемый список еды и корректно вызывает метод eatMeat

    @Test
    public void testFoodOutput() throws Exception {
        List<String> expectedListOfFood = List.of("Животные", "Птицы", "Рыбы");
        when(feline.eatMeat()).thenReturn(expectedListOfFood);
        List<String> food = cat.getFood();
        assertEquals(expectedListOfFood, food);

        Mockito.verify(feline).eatMeat();
    }
}

