import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class IntTest {
    private final static int Entero1 = 123;
    private final static int Entero2 = 5;
    private Int int1;
    private Int int2;

    @BeforeEach
    void setUp(){
        int1 = new Int(Entero1);
        int2 = new Int(Entero2);
    }

    @Test
    void constructorTest(){
        var expectedInt = new Int(Entero1);
        assertEquals(int1, expectedInt);
        var otherInt = new Int(Entero2);
        assertEquals(int2, otherInt);
        assertNotEquals(otherInt, int1);
    }

    @Test
    void getValueTest(){
        var expectedInt = new Int(Entero1);
        assertEquals(expectedInt.getValue(),int1.getValue());
    }

    @Test
    void IntToIntTest(){
        var expectedInt = new Int(Entero1);
        assertEquals(expectedInt.IntToInt().getValue(), expectedInt.getValue());
    }

    @Test
    void IntToFloatTest(){
        var expectedFloat = new Float(Entero1);
        assertEquals(int1.IntToFloat().getValue(), expectedFloat.getValue());
    }

    @Test
    void IntToBinTest(){
        String expectedBin = "0101";
        assertEquals(int2.IntToBin().getValue(),expectedBin);
    }

    @Test
    void IntToStringTest(){
        String expectedString = "123";
        assertEquals(int1.IntToString().getValue(), expectedString);
    }

    @Test
    void sumaTest(){
        Int expectedInt = new Int(123+5);
        assertEquals(expectedInt, int1.suma(int2));
    }

    @Test
    void SumaIntTest(){
        Int expectedInt = new Int(123+5);
        assertEquals(expectedInt, int1.SumaInt(int2));
    }

    @Test
    void SumaFloatTest(){
        Float auxFloat = new Float(122.5);
        assertEquals(int1.SumaFloat(auxFloat).getValue(),245.5);
    }

    @Test
    void sumaBinaryTest(){
        Binary auxBinary = new Binary("0111");
        assertEquals(int1.SumaBinary(auxBinary).getValue(),"010000010");
        assertEquals(int1.SumaBinary(auxBinary).getValueInt(), 130);
    }

    @Test
    void restaTest(){
        Int expectedInt = new Int(123-5);
        assertEquals(expectedInt, int1.resta(int2));
    }

    @Test
    void RestaIntTest(){
        Int expectedInt = new Int(5-123);
        assertEquals(expectedInt, int1.RestaInt(int2));
    }

    @Test
    void RestaFloatTest(){
        Float expectedFloat = new Float(-200.5);
        Float restaFloat = new Float(-195.5);
        assertEquals(int2.RestaFloat(restaFloat).getValue(), expectedFloat.getValue());
    }


    @Test
    void RestaBinaryTest(){
        Binary expectedBinary = new Binary("110");
        Binary restaBinary = new Binary("0101");
        Int restaInt = new Int(7);
        assertEquals(restaInt.RestaBinary(restaBinary).getValue(),expectedBinary.getValue());
    }

    @Test
    void multiplicacionTest(){
        Int expectedInt = new Int(5*123);
        assertEquals(expectedInt, int1.multiplicacion(int2));
    }

    @Test
    void MultiplicacionIntTest(){
        Int expectedInt = new Int(5*123);
        assertEquals(expectedInt, int1.MultiplicacionInt(int2));
    }

    @Test
    void MultiplicacionFloatTest(){
        Float expectedFloat = new Float(5*5.1);
        Float multiplicacionFloat = new Float(5.1);
        assertEquals(expectedFloat.getValue(), int2.MultiplicacionFloat(multiplicacionFloat).getValue());
    }

    @Test
    void MultiplicacionBinaryTest(){
        Binary expectedBinary = new Binary("01010");
        Binary multiplicacionBinary = new Binary("010");
        assertEquals(expectedBinary.getValueInt(), int2.MultiplicacionBinary(multiplicacionBinary).getValueInt());
    }

    @Test
    void divisionTest(){
        Int expectedInt = new Int(2);
        Int divisionInt = new Int(10);
        assertEquals(divisionInt.division(int2), expectedInt);
    }

    @Test
    void DivisionIntTest(){
        Int expectedInt = new Int(2);
        Int divisionInt = new Int(10);
        assertEquals(int2.DivisionInt(divisionInt), expectedInt);
    }

    @Test
    void DivisionFloatTest(){
        Float expectedFloat = new Float(5.5);
        Float divisionFloat = new Float(27.5);
        assertEquals(int2.DivisionFloat(divisionFloat).getValue(), expectedFloat.getValue());
    }

    @Test
    void DivisionBinaryTest(){
        Binary expectedBinary = new Binary("0100");
        Binary divisionBinary = new Binary("010100");
        assertEquals(expectedBinary.getValueInt(), int2.DivisionBinary(divisionBinary).getValueInt());
    }

    @Test
    void SSumaStringTest(){
        Str expectedStr = new Str("hola5");
        Str sumaStr = new Str("hola");
        assertEquals(int2.SSumaString(sumaStr), expectedStr);
    }
}
