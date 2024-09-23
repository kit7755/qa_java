import com.example.Animal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class AnimalParameterizedTest {

    private final String animalKind;
    private final List<String> listOfFood;

    public AnimalParameterizedTest(String animalKind, List<String> listOfFood) {
        this.animalKind = animalKind;
        this.listOfFood = listOfFood;
    }

    @Parameterized.Parameters
    public static Object[][] animalParameterizedTestData() {
        return new Object[][]{
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Травоядное", List.of("Трава", "Различные растения")},
        };
    }

    // Тест проверяет метод getFood для разных типов животных

    @Test
    public void checkAnimalParameterizedTest() throws Exception {
        Animal animal = new Animal();
        assertEquals(listOfFood, animal.getFood(animalKind));
    }
}
