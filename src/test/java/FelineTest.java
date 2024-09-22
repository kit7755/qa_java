import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(Parameterized.class)
public class FelineTest {

    private final List<String> expectedFood;
    private final int inputKittens;
    private final int expectedKittens;
    private final String expectedFamily;
    private Feline feline;

    public FelineTest(List<String> expectedFood, int inputKittens, int expectedKittens, String expectedFamily) {
        this.expectedFood = expectedFood;
        this.inputKittens = inputKittens;
        this.expectedKittens = expectedKittens;
        this.expectedFamily = expectedFamily;
    }

    @Before
    public void setUp() {
        feline = Mockito.spy(new Feline());
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {FelineTestCases.getEatMeatTestData().get(0)[0], 1, 1, FelineTestCases.getFamilyTestData().get(0)[0]},
                {null, 3, 3, FelineTestCases.getFamilyTestData().get(0)[0]},
                {Arrays.asList("Мясо"), 0, 0, "Кошачьи"}
        });
    }

    // Проверяем метод eatMeat класса Feline

    @Test
    public void testEatMeat() throws Exception {
        if (expectedFood != null) {
            doReturn(expectedFood).when(feline).getFood("Хищник");
            List<String> result = feline.eatMeat();
            assertEquals(expectedFood, result);
            verify(feline).getFood("Хищник");
        }
    }

    // Проверяем метод getKittens класса Feline

    @Test
    public void testGetKittens() {
        int result = (inputKittens == 1) ? feline.getKittens() : feline.getKittens(inputKittens);
        assertEquals(expectedKittens, result);
    }

    // Проверяем метод getFamily класса Feline

    @Test
    public void testGetFamily() {
        String result = feline.getFamily();
        assertEquals(expectedFamily, result);
    }
}
