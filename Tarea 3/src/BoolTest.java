import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class BoolTest {
    private Bool True;
    private Bool False;

    @BeforeEach
    void setUp(){
        True = new Bool(true);
        False = new Bool(false);
    }

    @Test
    void constructorTest(){
        var expectedBool = new Bool(true);
        assertEquals(True, expectedBool);
        var otherBool = new Bool(false);
        assertEquals(False, otherBool);
        assertNotEquals(otherBool, True);
    }

    @Test
    void getValueTest(){
        var expectedBool = new Bool(true);
        assertEquals(True.getValue(),expectedBool.getValue());
    }

    @Test
    void BoolToStringTest(){
        var expectedString = new Str("true");
        assertEquals(True.BoolToString(), expectedString);
    }

    @Test
    void BooltoBoolTest(){
        var expectedBool = new Bool(false);
        assertEquals(False.BoolToBool(), expectedBool);
    }

    @Test
    void SSumaStringTest(){
        var expectedString = new Str("holatrue");
        var sumaString = new Str("hola");
        assertEquals(True.SSumaString(sumaString), expectedString);
    }

    @Test
    void AndTest(){
        var expectedBool = new Bool(false);
        assertEquals(True.And(False), expectedBool);
    }

    @Test
    void OrTest(){
        var expectedBool = new Bool(true);
        assertEquals(True.Or(False), expectedBool);
    }

    @Test
    void AndBoolTest(){
        var expectedBool = new Bool(false);
        var expectedBool2 = new Bool(false);
        var expectedBool3 = new Bool(true);
        var andBool = new Bool(false);
        assertEquals(True.And(False), expectedBool);
        assertEquals(False.And(andBool), expectedBool2);
        assertEquals(True.And(True), expectedBool3);
    }

    @Test
    void OrBoolTest(){
        var expectedBool = new Bool(false);
        var expectedBool2 = new Bool(true);
        var expectedBool3 = new Bool(true);
        var orBool = new Bool(false);
        assertEquals(orBool.Or(False), expectedBool);
        assertEquals(False.Or(True), expectedBool2);
        assertEquals(True.Or(True), expectedBool3);
    }

    @Test
    void AndBinaryTest(){
        var expectedBinary = new Binary("101010");
        var expectedBinary2 = new Binary("000000");
        var andBinary = new Binary("101010");
        assertEquals(True.AndBinary(andBinary), expectedBinary);
        assertEquals(False.AndBinary(andBinary), expectedBinary2);
    }

    @Test
    void OrBinaryTest(){
        var expectedBinary = new Binary("111111");
        var expectedBinary2 = new Binary("101010");
        var orBinary = new Binary("101010");
        assertEquals(True.OrBinary(orBinary), expectedBinary);
        assertEquals(False.OrBinary(orBinary), expectedBinary2);
    }

    @Test
    void NegacionTest(){
        assertEquals(True.Negacion(),False);
        assertEquals(False.Negacion(), True);
        assertNotEquals(True.Negacion(), True);
    }

}
