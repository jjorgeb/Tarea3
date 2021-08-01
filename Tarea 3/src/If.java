public class If implements Operation{
    private final Operation cond;
    private final Operation ast1;
    private final Operation ast2;



    public If(Operation cond, Operation ast1, Operation ast2){
        this.cond = cond;
        this.ast1 = ast1;
        this.ast2 = ast2;
    }

    /** Ejecuta el AST ast1 si la condicion cond es true, ejecuta ast2 en caso contrario. */
    public Leaf eval(){
        if(((Bool) cond.eval()).getValue() == true){
            ast1.eval();
        }
        else{
            ast2.eval();
        }
        return new Int(1);
    }

    @Override
    public int compareTo(Operation i) {
        return 0;
    }
}
