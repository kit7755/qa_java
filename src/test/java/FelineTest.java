import com.example.Feline;
import org.junit.Test;
import org.junit.Assert;

import java.util.List;


public class FelineTest {


    // Проверяем метод eatMeat класса Feline

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> felineEatMeat = feline.eatMeat();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), felineEatMeat);
    }

    // Тест проверяет, что метод getKittens() возвращает количество котят по умолчанию (1)

    @Test
    public void testKittensCount() {
        Feline feline = new Feline();
        int actualKittens = feline.getKittens();
        Assert.assertEquals(1, actualKittens);
    }

    // Проверяем метод getFamily класса Feline

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        String felineFamily = feline.getFamily();
        Assert.assertEquals("Кошачьи", felineFamily);
    }
}

