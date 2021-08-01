import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class VarTest {

    @Test
    void test1(){
        var varFactory = new VarFactory();
        var int1 = new Int(5);
        var int2 = new Int(7);
        var var1 = varFactory.getVar("a", int1);
        var var2 = varFactory.getVar("b", int2);
        var1.eval();
        var2.eval();
        assertEquals(var1.getValue(),int1);
        assertEquals(var2.getValue(),int2);
        var ast1 = new Sub(var1, var2);
        var var3 = varFactory.getVar("a", ast1);
        var3.eval();
        assertEquals(var3.getValue(),new Int(-2));

    }
}
