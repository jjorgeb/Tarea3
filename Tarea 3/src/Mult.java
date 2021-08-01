public class Mult implements Operation{
    private final Operation Value1;
    private final Operation Value2;


    public Mult(Operation valor1, Operation valor2){
        this.Value1 = valor1;
        this.Value2 = valor2;
    }


    @Override
    public Leaf eval() {
        return this.Value1.eval().multiplicacionL(this.Value2.eval());
    }

    @Override
    public int compareTo(Operation o) {
        return this.eval().compareTo(o);
    }
}
