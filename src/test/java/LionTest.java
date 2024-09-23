import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {

    @Mock
    private Feline mockFeline;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    //тест проверяет, что метод getKittens() класса Lion правильно получает и возвращает количество котят

    @Test
    public void testGetKittens() throws Exception {
        when(mockFeline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", mockFeline);
        int kittens = lion.getKittens();
        assertEquals(3, kittens);
    }

    //тест проверяет, что наличия гривы у льва работает корректно: самец имеет гриву, а самка — нет.

    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lionMale = new Lion("Самец", mockFeline);
        Lion lionFemale = new Lion("Самка", mockFeline);
        assertTrue(lionMale.doesHaveMane());
        assertFalse(lionFemale.doesHaveMane());
    }

    //тест проверяет, что возвращает правильный список пищи для льва.

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыбы");
        when(mockFeline.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", mockFeline);
        List<String> food = lion.getFood();
        assertNotNull(food);
        assertEquals(expectedFood, food);
    }

    // тест проверяет, что выводиться соответствующее исключение с правильным сообщением
    @Test
    public void testInvalidSex() {
        String invalidSex = "Исключение";
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion(invalidSex, mockFeline);
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}
