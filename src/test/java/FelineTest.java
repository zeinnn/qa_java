import com.example.Animal;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    Animal animal;

    @Test
    public void getKittensReturnsCorrectValueWithSpy(){
        Feline feline = spy(new Feline());
        int expectedKittens = 1;
        Mockito.when(feline.getKittens(expectedKittens)).thenReturn(expectedKittens);

        int actualKittens = feline.getKittens();

        Mockito.verify(feline, Mockito.times(1)).getKittens();
        Assert.assertEquals("Method getKittens return incorrect value.", expectedKittens, actualKittens );
    }

    @Test
    public void eatMeatReturnCorrectList() throws Exception{
        Feline feline = spy (new Feline());
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        assertEquals("Method getFood return incorrect value.", expected, actual);

    }

    @Test
    public void getFamilyReturnCorrectString(){
        Feline feline = new Feline();
        String actual = feline.getFamily();
        String expected = "Кошачьи";
        assertEquals("Method getFamily return incorrect String.",expected,actual);
    }

    @Test
    public void getKittensWithParameterReturnCorrectInt(){
        Feline feline = new Feline();
        int actual = feline.getKittens(5);
        int expected = 5;
        assertEquals(expected,actual);
    }
}
