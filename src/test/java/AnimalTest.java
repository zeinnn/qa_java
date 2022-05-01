import com.example.Animal;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AnimalTest {

    @Mock
    Animal animal;


    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void animalReturnsCorrectTextException() throws Exception {
        String message = "В конструкторе Lion(Feline feline, String sex) некорректно отрабатывает исключение";
        String actual = "";
        String expected = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        Animal animal= new Animal();
        try {
            animal.getFood("Другое");
        } catch (Exception e) {
            actual = e.getMessage();
        }
        assertEquals(message, expected, actual);
    }

    @Test
    public void getFamilyReturnsCorrectText(){
        Animal animal = new Animal();
        String actual = animal.getFamily();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected,actual);

    }
}
