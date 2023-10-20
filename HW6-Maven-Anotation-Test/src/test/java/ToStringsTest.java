import org.junit.Test;
import ru.otus.Cat;
import ru.otus.ToStrings;

public class ToStringsTest {

    @Test
    public void whenCallToStrings_thenWorks(){
        Cat cat=new Cat();
        cat.setName("Vasya");
        cat.setBreed("besporody");
        String result= ToStrings.toString(cat);
        System.out.println(result);
//        System.out.println(cat);
//        assertEquals(2,  result.split(",").length);
    }
}
