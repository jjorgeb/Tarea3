public class While implements Operation{
    private final Operation cond;
    private final Operation ast1;



    public While(Operation cond, Operation ast1){
        this.cond = cond;
        this.ast1 = ast1;
    }

    /** Ejecuta el AST ast1 mientras la condicion cond sea true. */
    public Leaf eval(){
        while(((Bool) cond.eval()).getValue()){
            ast1.eval();
        }
        return new Int(1);
    }

    @Override
    public int compareTo(Operation i) {
        return 0;
    }
}
