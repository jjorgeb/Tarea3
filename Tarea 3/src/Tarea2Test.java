import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class Tarea2Test {
    private final static int num1 = 2;
    private final static int num2 = 3;
    private Int Int1;
    private Int Int2;
    private IntFactory intFactory;
    private FloatFactory floatFactory;
    private StrFactory strFactory;
    private BoolFactory boolFactory;
    private BinaryFactory binaryFactory;


    @BeforeEach
    void setUp(){
        Int1 = new Int(num1);
        Int2 = new Int(num2);
        intFactory = new IntFactory();
        floatFactory = new FloatFactory();
        binaryFactory = new BinaryFactory();
        strFactory = new StrFactory();
        boolFactory = new BoolFactory();
    }

    @Test
    void constructorTest1(){
        var expectedTree = new Int(5);
        var expectedTree2 = new Int(7);
        var tree = new Add(Int1, Int2);
        assertEquals(tree.eval(), expectedTree);
        var tree2 = new Add(expectedTree, Int1);
        assertEquals(tree2.eval(), expectedTree2);
        var expectedTree3 = new Int(1);
        var tree3 = new Sub(Int2, Int1);
        assertEquals(tree3.eval(), expectedTree3);
        var tree4 = new Add(tree3, Int1);
        assertEquals(tree4.eval(), Int2);
        var tree5 = new Add(new Float(5.5), new Int(1));
        assertEquals(tree5.eval(), new Float(6.5));
        var tree6 = new Add(Int1, new Binary("011"));
        assertEquals(tree6.eval(), new Int(5));
        var tree7 = new Sub(tree6, Int2);
        assertEquals(((Int) (tree7.eval())).IntToFloat(), new Add(new Int(5), new Sub(new Float(3) ,new Int(6)).eval()).eval());
        var tree8 = new Add(new Str("hola"), new Int(6));
        assertEquals(tree8.eval(), new Str("hola6"));
        var tree9 = new Or(new Binary("0101"), new Binary("1010"));
        assertEquals(new Add(new Str("hola"), tree9).eval(), new Str("hola1111"));
    }

    @Test
    public void FactoryTest(){
        var Int1 = intFactory.getInt(5);
        var Int2 = intFactory.getInt(5);
        var Binary1 = binaryFactory.getBinary("101");
        var Binary2 = binaryFactory.getBinary("101");
        var Float1 = floatFactory.getFloat(3.3);
        var Float2 = floatFactory.getFloat(3.3);
        var Str1 = strFactory.getStr("hola");
        var Str2 = strFactory.getStr("hola");
        var Bool1 = boolFactory.getBool(true);
        var Bool2 = boolFactory.getBool(true);
        assertEquals(Int1, Int2);
        assertTrue(Int1 == Int2);
        assertEquals(Binary1, Binary2);
        assertTrue(Binary1 == Binary2);
        assertEquals(Float1, Float2);
        assertTrue(Float1 == Float2);
        assertEquals(Str1, Str2);
        assertTrue(Str1 == Str2);
        assertEquals(Bool1, Bool2);
        assertTrue(Bool1 == Bool2);
    }

    @Test
    public void TreeTest(){
        var expectedTree1 = intFactory.getInt(10);
        var tree1 = new Add(intFactory.getInt(8),intFactory.getInt(2));
        assertEquals(tree1.eval(), expectedTree1);
        var expectedTree2 = floatFactory.getFloat(12.5);
        var tree2 = new Sub(floatFactory.getFloat(22.5), tree1);
        assertEquals(tree2.eval(), expectedTree2);
        var expectedTree3 = floatFactory.getFloat(125);
        var tree3 = new Mult(tree2, tree1);
        assertEquals(tree3.eval(), expectedTree3);
        var expectedTree4 = floatFactory.getFloat(1);
        var tree4 = new Div(tree3, intFactory.getInt(125));
        assertEquals(tree4.eval(), expectedTree4);
        var expectedTree5 = binaryFactory.getBinary("00111");
        var tree5 = new And(binaryFactory.getBinary("1111"), binaryFactory.getBinary("00111"));
        assertEquals(tree5.eval(), expectedTree5);
        var expectedTree6 = binaryFactory.getBinary("0010111");
        var tree6 = new Or(tree5, binaryFactory.getBinary("0010000"));
        assertEquals(tree6.eval(), expectedTree6);
        var expectedTree7 = binaryFactory.getBinary("1101000");
        var tree7 = new Neg(tree6);
        assertEquals(tree7.eval(), expectedTree7);
        var expectedTree8 = boolFactory.getBool(true);
        var tree8 = new Neg(boolFactory.getBool(false));
        assertEquals(tree8.eval(), expectedTree8);
    }

}
