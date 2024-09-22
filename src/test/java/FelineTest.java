import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    // Проверяем метод eatMeat класса Feline

    @Test
    public void testEatMeat() throws Exception {
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    // Тест проверяет, что метод getKittens() возвращает значение по умолчанию (1), если не передан аргумент, указывающий количество котят.

    @Test
    public void testGetKittensDefaultCount() {
        int kittens = feline.getKittens();
        assertEquals(1, kittens);
    }

    // Тест проверяет, что метод getKittens(int count) возвращает переданное количество котят, в данном случае — 3.

    @Test
    public void testGetKittensWithCount() {
        int kittens = feline.getKittens(3);
        assertEquals(3, kittens);
    }

    // Проверяем метод getFamily класса Feline

    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }
}

