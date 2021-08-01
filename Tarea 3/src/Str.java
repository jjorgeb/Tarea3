public class Str implements SumaString, Leaf {
    private String Value;

    public Str(String string){
        this.Value = string;
    }

    private String toString(String s){
        return s;
    }

    public String getValue(){
        return this.Value;
    }

    public Str StringToString(){
        return new Str(this.Value);
    }


    /** Retorna el resultado de realizar la operacion SSumaString en la clase de x, lo cual devolvera un Str,
     *  en el cual el valor sera la concatenacion del valor de this con el valor de x.
     */
    public Str suma(SumaString x){
        return x.SSumaString(this);
    }

    public Str SSumaString(Str x){
        return new Str(x.getValue()+this.Value);
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Str){
            var other = (Str) obj;
            return this.Value.equals(other.getValue());
        }
        return false;
    }

    /** Retorna lo mismo que suma pero con un cast Leaf. */
    @Override
    public Leaf sumaL(Leaf l) {
        return suma((SumaString) l);
    }


    @Override
    public Leaf restaL(Leaf l) {
        return null;
    }


    @Override
    public Leaf divisionL(Leaf l) {
        return null;
    }


    @Override
    public Leaf multiplicacionL(Leaf l) {
        return null;
    }

    @Override
    public Leaf OrL(Leaf l) {
        return null;
    }

    @Override
    public Leaf AndL(Leaf l) {
        return null;
    }

    @Override
    public Leaf NegacionL() {
        return null;
    }

    @Override
    public Leaf eval() {
        return this;
    }


    @Override
    public int compareTo(Operation o) {
        return this.Value.compareTo(((Str) o).getValue());
    }

}
