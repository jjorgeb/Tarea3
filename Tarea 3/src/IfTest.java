import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class IfTest {

    @Test
    void constructorTest(){
        var varFactory = new VarFactory();
        var int1 = new Int(24);
        var int2 = new Int(6);
        var var1 = varFactory.getVar("a", int1);
        var var2 = varFactory.getVar("b", int2);
        var var12 = varFactory.getVar("a");
        var var22 = varFactory.getVar("b");
        var1.eval();
        var2.eval();
        assertEquals(var1.getValue(),int1);
        assertEquals(var2.getValue(),int2);
        var ast1 = varFactory.getVar("a",new Sub(var12, var22));
        var ast2 = varFactory.getVar("b",new Sub(var22, var12));
        var cond = new Greater(var12, var22);
        var if1 = new If(cond, ast1, ast2);
        var cond2 = new NotEquals(var22, var12);
        var while1 = new While(cond2, if1);
        while1.eval();
        assertEquals(var1.getValue(),new Int(6));
        var int3 = new Int(10);
        var int4 = new Int(1);
        var var3 = varFactory.getVar("c", int3);
        var var4 = varFactory.getVar("d", int4);
        var3.eval();
        var4.eval();
        var var32 = varFactory.getVar("c");
        var var42 = varFactory.getVar("d");
        var cond3 = new Greater(var32, var42);
        var while2 = new While(cond3, varFactory.getVar("c", new Sub(var32, var42)));
        while2.eval();
        assertEquals(1,((Int) var4.getValue()).getValue());







    }
}
