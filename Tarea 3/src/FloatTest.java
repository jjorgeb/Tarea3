import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


public class FloatTest {
    private final static double Float1 = 27.5;
    private final static double Float2 = 5.5;
    private Float float1;
    private Float float2;

    @BeforeEach
    void setUp(){
        float1 = new Float(Float1);
        float2 = new Float(Float2);
    }

    @Test
    void constructorTest(){
        var expectedFloat = new Float(Float1);
        assertEquals(float1, expectedFloat);
        var otherFloat = new Float(Float2);
        assertEquals(float2, otherFloat);
        assertNotEquals(otherFloat, float1);
    }

    @Test
    void getValueTest(){
        var expectedFloat = new Float(Float1);
        assertEquals(float1.getValue(), expectedFloat.getValue());
    }

    @Test
    void FloatToStringTest(){
        var expectedStr = new Str("27.5");
        assertEquals(float1.FloatToString(), expectedStr);
    }

    @Test
    void FloatToFloatTest(){
        var expectedFloat = new Float(Float2);
        assertEquals(float2.FloatToFloat(), expectedFloat);
    }

    @Test
    void sumaTest(){
        var expectedFloat = new Float(Float1+Float2);
        var expectedFloat2 = new Float(Float2+4);
        var sumaInt = new Int(4);
        assertEquals(float1.suma(float2), expectedFloat);
        assertEquals(float2.suma(sumaInt), expectedFloat2);
    }

    @Test
    void SumaIntTest(){
        var expectedFloat = new Float(Float1+10);
        var sumaInt = new Int(10);
        assertEquals(float1.SumaInt(sumaInt), expectedFloat);
    }

    @Test
    void SumaFloatTest(){
        var expectedFloat = new Float(Float1+10.5);
        var sumaFloat = new Float(10.5);
        assertEquals(float1.SumaFloat(sumaFloat), expectedFloat);
    }

    @Test
    void restaTest(){
        var expectedFloat = new Float(Float2-4.5);
        var restaFloat = new Float(4.5);
        var expectedFloat2 = new Float(Float1-4);
        var restaBinary = new Binary("0100");
        assertEquals(float2.resta(restaFloat), expectedFloat);
        assertEquals(float1.resta(restaBinary), expectedFloat2);
    }

    @Test
    void RestaIntTest(){
        var expectedFloat = new Float(9-Float2);
        var expectedFloat2 = new Float(6-Float1);
        var restaInt1 = new Int(9);
        var restaInt2 = new Int(6);
        assertEquals(float2.RestaInt(restaInt1), expectedFloat);
        assertEquals(float1.RestaInt(restaInt2), expectedFloat2);
    }

    @Test
    void RestaFloatTest(){
        var expectedFloat = new Float(0-Float2);
        var expectedFloat2 = new Float(-6.1-Float1);
        var restaFloat1 = new Float(0);
        var restaFloat2 = new Float(-6.1);
        assertEquals(float2.RestaFloat(restaFloat1), expectedFloat);
        assertEquals(float1.RestaFloat(restaFloat2), expectedFloat2);
    }

    @Test
    void multiplicacionTest(){
        var expectedFloat = new Float(Float1*Float2);
        assertEquals(float1.multiplicacion(float2), expectedFloat);
    }

    @Test
    void MultiplicacionIntTest(){
        var expectedFloat = new Float(Float1*35);
        var multInt = new Int(35);
        assertEquals(float1.MultiplicacionInt(multInt), expectedFloat);
    }

    @Test
    void MultiplicacionFloatTest(){
        var expectedFloat = new Float(Float1*35.2);
        var multFloat = new Float(35.2);
        assertEquals(float1.MultiplicacionFloat(multFloat), expectedFloat);
    }

    @Test
    void divisionTest(){
        var expectedFloat = new Float(Float1/Float2);
        assertEquals(float1.division(float2), expectedFloat);
    }

    @Test
    void DivisionIntTest(){
        var expectedInt = new Float(7/Float1);
        var divInt = new Int(7);
        assertEquals(float1.DivisionInt(divInt), expectedInt);
    }

    @Test
    void DivisionFloatTest(){
        var expectedFloat = new Float(Float2/Float1);
        assertEquals(float1.DivisionFloat(float2), expectedFloat);
    }

    @Test
    void SSumaStringTest(){
        var expectedStr = new Str("hola5.5");
        var sumaStr = new Str("hola");
        assertEquals(float2.SSumaString(sumaStr), expectedStr);
    }



}
