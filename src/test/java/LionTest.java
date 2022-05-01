import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void lionReturnsCorrectTextException(){
        String message = "В конструкторе Lion(Feline feline, String sex) некорректно отрабатывает исключение";
        String actual = "";
        String expected = "Используйте допустимые значения пола животного - самец или самка";
        try {
            new Lion(feline, "mane");
        } catch (Exception e) {
            actual = e.getMessage();
        }
        assertEquals(message, expected, actual);
    }

    @Test
    public void getKittensLineReturnsCorrectValue() throws Exception{
        Lion lion = new Lion(feline,"Самка");
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        int expected = 1;
        assertEquals(expected,actual);

    }

    @Test
    public void getFoodReturnsCorrectList() throws Exception {
        Lion lion = new Lion(feline,"Самка");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = lion.getFood();
        assertEquals("Method getFood return incorrect value.", expected, actual);

    }

    @Test
    public void getMaleSex() throws Exception{
        Lion lion = new Lion(feline, "Самец");
        Assert.assertTrue(lion.doesHaveMane());
    }

    @Test
    public void getFemaleSex() throws Exception{
        Lion lion = new Lion(feline, "Самка");
        Assert.assertFalse(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeReturnCorrectBooleanFemale() throws Exception{
        Lion lion = new Lion(feline,"Самка");
        boolean actual = lion.doesHaveMane();
        boolean expected = false;
        assertEquals(expected,actual);
    }

    @Test
    public void doesHaveManeReturnCorrectBooleanMale() throws Exception{
        Lion lion = new Lion(feline,"Самец");
        boolean actual = lion.doesHaveMane();
        boolean expected = true;
        assertEquals(expected,actual);
    }

}
