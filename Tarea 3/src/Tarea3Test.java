import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class Tarea3Test {
    private IntFactory intFactory;
    private FloatFactory floatFactory;
    private StrFactory strFactory;
    private BoolFactory boolFactory;
    private BinaryFactory binaryFactory;
    private VarFactory varFactory;

    @BeforeEach
    void setUp(){
        intFactory = new IntFactory();
        floatFactory = new FloatFactory();
        binaryFactory = new BinaryFactory();
        strFactory = new StrFactory();
        boolFactory = new BoolFactory();
        varFactory = new VarFactory();
    }

    @Test
    public void CompareToTest(){
        var int1 = intFactory.getInt(4);
        var int2 = intFactory.getInt(3);
        var int3 = intFactory.getInt(4);
        var int4 = intFactory.getInt(5);
        assertEquals(int1.compareTo(int2),1);
        assertEquals(int1.compareTo(int3),0);
        assertEquals(int1.compareTo(int4),-1);

        var float1 = floatFactory.getFloat(2.2);
        var float2 = floatFactory.getFloat(2.2);
        var float3 = floatFactory.getFloat(2.5);
        var float4 = floatFactory.getFloat(1);
        assertEquals(float1.compareTo(float2),0);
        assertEquals(float1.compareTo(float3),-1);
        assertEquals(float1.compareTo(float4),1);

        var bin1 = binaryFactory.getBinary("101");
        var bin2 = binaryFactory.getBinary("101");
        var bin3 = binaryFactory.getBinary("100");
        var bin4 = binaryFactory.getBinary("00111111");
        assertEquals(bin1.compareTo(bin2),0);
        assertEquals(bin1.compareTo(bin3),1);
        assertEquals(bin1.compareTo(bin4),-1);

        var str1 = strFactory.getStr("hola");
        var str2 = strFactory.getStr("hola");
        var str3 = strFactory.getStr("holaa");
        var str4 = strFactory.getStr("hol");
        assertEquals(str1.compareTo(str2),0);
        assertEquals(str1.compareTo(str3),-1);
        assertEquals(str1.compareTo(str4),1);

        var bool1 = boolFactory.getBool(true);
        var bool2 = boolFactory.getBool(true);
        var bool3 = boolFactory.getBool(false);
        assertEquals(bool1.compareTo(bool2),0);
        assertEquals(bool1.compareTo(bool3),1);
        assertEquals(bool3.compareTo(bool1),-1);
    }

    @Test
    public void CompTest(){
        //Greater, Equals, NotEquals, Less
        var int1 = intFactory.getInt(4);
        var int2 = intFactory.getInt(3);
        var True = boolFactory.getBool(true);
        var False = boolFactory.getBool(false);
        var greater = new Greater(int1, int2);
        assertEquals(True, greater.eval());
        var greater2 = new Greater(int2, int1);
        assertEquals(False, greater2.eval());

        var float1 = floatFactory.getFloat(2.2);
        var float2 = floatFactory.getFloat(2.2);
        var float3 = floatFactory.getFloat(2.5);
        var equals = new Equals(float1, float2);
        var equals2 = new Equals(float1, float3);
        assertEquals(True, equals.eval());
        assertEquals(False, equals2.eval());

        var notEquals = new NotEquals(float1, float2);
        var notEquals2 = new NotEquals(float1, float3);
        assertEquals(False, notEquals.eval());
        assertEquals(True, notEquals2.eval());

        var less = new Less(int1, int2);
        var less2 = new Less(int2, int1);
        assertEquals(False, less.eval());
        assertEquals(True, less2.eval());
    }

    @Test
    public void IfTest(){
        var int1 = intFactory.getInt(24);
        var int2 = intFactory.getInt(6);
        var int3 = intFactory.getInt(18);
        var var1 = varFactory.getVar("A", int1);
        var var2 = varFactory.getVar("B", int2);
        var varA = varFactory.getVar("A");
        var varB = varFactory.getVar("B");
        var1.eval();
        var2.eval();
        assertEquals(var1.getValue(),int1);
        assertEquals(var2.getValue(),int2);
        var ast1 = varFactory.getVar("A",new Sub(varA, varB));
        var ast2 = varFactory.getVar("B",new Sub(varB, varA));
        var cond = new Greater(varA, varB);
        var if1 = new If(cond, ast1, ast2);
        if1.eval();
        assertEquals(varA.getValue(), int3);

    }

    @Test
    public void WhileTest(){
        var int1 = intFactory.getInt(24);
        var int2 = intFactory.getInt(6);
        var var1 = varFactory.getVar("A", int1);
        var var2 = varFactory.getVar("B", int2);
        var varA = varFactory.getVar("A");
        var varB = varFactory.getVar("B");
        var1.eval();
        var2.eval();
        assertEquals(var1.getValue(),int1);
        assertEquals(var2.getValue(),int2);
        var ast1 = varFactory.getVar("A",new Sub(varA, varB));
        var ast2 = varFactory.getVar("B",new Sub(varB, varA));
        var cond = new Greater(varA, varB);
        var if1 = new If(cond, ast1, ast2);

        var cond2 = new NotEquals(varB, varA);
        var while1 = new While(cond2, if1);
        while1.eval();
        assertEquals(varA.getValue(), int2);

    }
}
