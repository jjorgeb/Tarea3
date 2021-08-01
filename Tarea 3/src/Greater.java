
public class Greater implements Operation{
    private final Operation Value1;
    private final Operation Value2;


    public Greater(Operation valor1, Operation valor2){
        this.Value1 = valor1;
        this.Value2 = valor2;
    }

    /** Entrega el Bool true si Value1 es mayor a Value2 y Bool false en caso contrario. */
    @Override
    public Leaf eval() {
        int comp = this.Value1.eval().compareTo(this.Value2.eval());
        if(comp > 0){
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
