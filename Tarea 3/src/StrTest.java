import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class StrTest {
    private final static String string = "hola";
    private final static String string2 = "hola2";
    private Str str1;
    private Str str2;

    @BeforeEach
    void setUp(){
        str1 = new Str(string);
        str2 = new Str(string2);
    }

    @Test
    void constructorTest(){
        var expectedStr = new Str(string);
        assertEquals(expectedStr, str1, "no son iguales.");
        var otherStr = new Str(string2);
        assertEquals(otherStr, str2);
        assertNotEquals(otherStr, str1, "deberian ser distintos.");
        assertNotEquals(str1, str2);
    }

    @Test
    void getValueTest(){
        var newString = new Str(string);
        assertEquals(newString.getValue(), str1.getValue());
        assertNotEquals(newString.getValue(), str2.getValue());
    }

    @Test
    void sumaTest(){
        var newString = new Str(string);
        var newInt = new Int(123);
        var newFloat = new Float(12.4);
        var newBinary = new Binary("101010");
        var newBool = new Bool(false);
        assertEquals(newString.getValue()+"123", newString.suma(newInt).getValue());
        assertEquals(newString.getValue()+"12.4", newString.suma(newFloat).getValue());
        assertEquals(newString.getValue()+"101010", newString.suma(newBinary).getValue());
        assertEquals(newString.getValue()+"false", newString.suma(newBool).getValue());
        assertEquals(newString.suma(str1), newString.SSumaString(str1));
    }

    @Test
    void StringtoStringTest(){
        var newString = new Str(string);
        assertEquals(newString.StringToString(),newString);
    }

    @Test
    void SSumaStringTest(){
        var newString = new Str(string);
        assertEquals(newString.suma(str1), newString.SSumaString(str1));
    }
    @Test
    void ComparableTest(){
        var newString = new Str("hola");
        var newString2 = new Str("hola");
        assertEquals(0,newString.compareTo(newString2));
    }
}
