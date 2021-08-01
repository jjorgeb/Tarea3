import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTest {
    private final static String num1 = "0101";
    private final static String num2 = "1011";
    private Binary bin1;
    private Binary bin2;

    @BeforeEach
    void setUp(){
        bin1 = new Binary(num1);
        bin2 = new Binary(num2);
    }

    @Test
    void constructorTest(){
        var expectedBinary = new Binary(num1);
        assertEquals(bin1, expectedBinary);
        var otherBinary = new Binary(num2);
        assertEquals(bin2, otherBinary);
        assertNotEquals(otherBinary, bin1);
    }

    @Test
    void getValueTest(){
        assertEquals(bin1.getValue(), num1);
        assertEquals(bin2.getValue(), num2);
    }

    @Test
    void getValueIntTest(){
        assertEquals(bin1.getValueInt(), 5);
        assertEquals(bin2.getValueInt(), -5);
    }

    @Test
    void BinaryToIntTest(){
        Int expectedInt = new Int(5);
        Int expectedInt2 = new Int(-5);
        assertEquals(bin1.BinaryToInt(), expectedInt);
        assertEquals(bin2.BinaryToInt(), expectedInt2);
    }

    @Test
    void BinarytoFloatTest(){
        Float expectedFloat = new Float(5);
        Float expectedFloat2 = new Float(-5);
        assertEquals(bin1.BinaryToFloat(), expectedFloat);
        assertEquals(bin2.BinaryToFloat(), expectedFloat2);
    }

    @Test
    void BinaryToStringTest(){
        Str expectedStr = new Str(num1);
        Str expectedStr2 = new Str(num2);
        assertEquals(bin1.BinaryToString(),expectedStr);
        assertEquals(bin2.BinaryToString(),expectedStr2);
        assertNotEquals(bin1.BinaryToString(),expectedStr2);
    }

    @Test
    void BinarytoBinaryTest(){
        Binary expectedBinary = new Binary(num1);
        Binary expectedBinary2 = new Binary(num2);
        assertEquals(bin1.BinaryToBinary(), expectedBinary);
        assertEquals(bin2.BinaryToBinary(), expectedBinary2);
    }

    @Test
    void sumaTest(){
        Binary expectedBinary = new Binary("00");
        assertEquals(bin1.suma(bin2), expectedBinary);
    }

    @Test
    void SumaBinaryTest(){
        Binary expectedBinary = new Binary("00");
        assertEquals(bin1.SumaBinary(bin2), expectedBinary);
    }

    @Test
    void SumaIntTest(){
        Int expectedInt = new Int(15);
        Int expectedInt2 = new Int(-1);
        Int sumaInt = new Int(10);
        Int sumaInt2 = new Int(4);
        assertEquals(bin1.SumaInt(sumaInt), expectedInt);
        assertEquals(bin2.SumaInt(sumaInt2), expectedInt2);
    }

    @Test
    void SumaFloatTest(){
        Float expectedFloat = new Float(20);
        Float sumaFloat = new Float(15);
        assertEquals(bin1.SumaFloat(sumaFloat), expectedFloat);
    }

    @Test
    void restaTest(){
        Binary expectedBinary = new Binary("011");
        Binary restaBinary = new Binary("010");
        assertEquals(bin1.resta(restaBinary), expectedBinary);
    }

    @Test
    void RestaBinaryTest(){
        Binary expectedBinary = new Binary("011");
        Binary restaBinary = new Binary("010");
        assertEquals(restaBinary.RestaBinary(bin1), expectedBinary);
    }

    @Test
    void RestaIntTest(){
        Int expectedInt = new Int(-1);
        Int restaInt = new Int(4);
        assertEquals(bin1.RestaInt(restaInt), expectedInt);
    }

    @Test
    void RestaFloatTest(){
        Float expectedFloat = new Float(10.5);
        Float restaFloat = new Float(5.5);
        assertEquals(bin2.RestaFloat(restaFloat), expectedFloat);
    }

    @Test
    void multiplicacionTest(){
        Binary expectedBinary = new Binary("100111");
        assertEquals(bin1.multiplicacion(bin2), expectedBinary);
    }

    @Test
    void MultiplicacionBinaryTest(){
        Binary expectedBinary = new Binary("100111");
        assertEquals(bin1.MultiplicacionBinary(bin2), expectedBinary);
    }

    @Test
    void MultiplicacionIntTest(){
        Int expectedInt = new Int(10);
        Int multInt = new Int(2);
        assertEquals(bin1.MultiplicacionInt(multInt), expectedInt);
    }

    @Test
    void MultiplicacionFloatTest(){
        Float expectedFloat = new Float(10.5);
        Float multFloat = new Float(2.1);
        assertEquals(bin1.MultiplicacionFloat(multFloat), expectedFloat);
    }

    @Test
    void divisionTest(){
        Binary expectedBinary = new Binary("010");
        Binary divBinary = new Binary("01010");
        assertEquals(divBinary.division(bin1), expectedBinary);
    }

    @Test
    void DivisionBinaryTest(){
        Binary expectedBinary = new Binary("010");
        Binary divBinary = new Binary("01010");
        assertEquals(bin1.DivisionBinary(divBinary), expectedBinary);
    }

    @Test
    void DivisionIntTest(){
        Int expectedInt = new Int(-5);
        Int divInt = new Int(25);
        assertEquals(bin2.DivisionInt(divInt), expectedInt);
    }

    @Test
    void DivisionFloatTest(){
        Float expectedFloat = new Float(8.3/5);
        Float divFloat = new Float(8.3);
        assertEquals(bin1.DivisionFloat(divFloat), expectedFloat);
    }

    @Test
    void SSumaStringTest(){
        Str expectedStr = new Str("hola0101");
        Str sumaStr = new Str("hola");
        assertEquals(bin1.SSumaString(sumaStr), expectedStr);
    }

    @Test
    void AndTest(){
        Binary expectedBinary = new Binary("0000");
        Binary expectedBinary2 = new Binary("0001");
        Bool andBool = new Bool(false);
        assertEquals(bin1.And(andBool), expectedBinary);
        assertEquals(bin1.And(bin2), expectedBinary2);
    }

    @Test
    void OrTest(){
        Binary expectedBinary = new Binary("1111");
        Binary expectedBinary2 = new Binary("0101");
        Bool orBool = new Bool(false);
        assertEquals(bin1.Or(bin2), expectedBinary);
        assertEquals(bin1.Or(orBool),expectedBinary2);
    }

    @Test
    void AndBoolTest(){
        Binary expectedBinary = new Binary("0101");
        Binary expectedBinary2 = new Binary("0000");
        Bool andBool = new Bool(true);
        Bool andBool2 = new Bool(false);
        assertEquals(bin1.AndBool(andBool), expectedBinary);
        assertEquals(bin1.AndBool(andBool2), expectedBinary2);
    }

    @Test
    void OrBoolTest(){
        Binary expectedBinary = new Binary("1111");
        Binary expectedBinary2 = new Binary("0101");
        Bool orBool = new Bool(true);
        Bool orBool2 = new Bool(false);
        assertEquals(bin1.OrBool(orBool), expectedBinary);
        assertEquals(bin1.OrBool(orBool2), expectedBinary2);
    }

    @Test
    void AndBinaryTest(){
        Binary expectedBinary = new Binary("0001");
        Binary expectedBinary2 = new Binary("11110000");
        Binary andBinary = new Binary("1001");
        Binary andBinary2 = new Binary("11110000");
        assertEquals(bin1.AndBinary(andBinary), expectedBinary);
        assertEquals(bin1.AndBinary(andBinary2), expectedBinary2);
    }

    @Test
    void OrBinaryTest(){
        Binary expectedBinary = new Binary("0111");
        Binary expectedBinary2 = new Binary("11110101");
        Binary orBinary = new Binary("0011");
        Binary orBinary2 = new Binary("11110000");
        assertEquals(bin1.OrBinary(orBinary), expectedBinary);
        assertEquals(bin1.OrBinary(orBinary2), expectedBinary2);
    }

    @Test
    void NegacionTest(){
        Binary expectedBinary = new Binary("1010");
        Binary expectedBinary2 = new Binary("10101010");
        Binary expectedBinary3 = new Binary("1");
        Binary negBinary2 = new Binary("01010101");
        Binary negBinary3 = new Binary("0");
        assertEquals(bin1.Negacion(), expectedBinary);
        assertEquals(negBinary2.Negacion(), expectedBinary2);
        assertEquals(negBinary3.Negacion(), expectedBinary3);
    }

    @Test
    void ComparableTest(){
        Binary expectedBinary = new Binary("1010");
        Binary expectedBinary2 = new Binary("10101010");
        assertEquals(-1, expectedBinary2.compareTo(expectedBinary));
    }
}
