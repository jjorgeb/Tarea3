public class Less implements Operation{
    private final Operation Value1;
    private final Operation Value2;


    public Less(Operation valor1, Operation valor2){
        this.Value1 = valor1;
        this.Value2 = valor2;
    }

    /** Entrega el Bool true si Value1 es menor a Value2 y Bool false en caso contrario. */
    @Override
    public Leaf eval() {
        int comp = this.Value1.eval().compareTo(Value2.eval());
        if(comp == -1){
            return new Bool(true);
        }
        else {
            return new Bool(false);
        }
    }

    @Override
    public int compareTo(Operation o) {
        return this.eval().compareTo(o);
    }
}
