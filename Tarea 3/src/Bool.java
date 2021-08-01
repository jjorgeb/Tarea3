public class Bool implements SumaString, IAndOr, Leaf{
    private boolean Value;

    public Bool(boolean valor){
        this.Value = valor;
    }


    public String toString(){
        return String.valueOf(this.Value);
    }

    public boolean getValue(){
        return this.Value;
    }

    private String Neg(String s){
        String s2 = "";
        for(int i = 0; i<s.length() ;i++){
            if(s.charAt(i)=='1'){
                s2 += '0';
            }
            else{
                s2 += '1';
            }
        }
        return s2;
    }
    private String unos(String s){
        String s3 = "";
        for(int i=0; i<s.length(); i++){
            s3 += '1';
        }
        return s3;
    }

    private String ceros(String s){
        String s3 = "";
        for(int i=0; i<s.length(); i++){
            s3 += '0';
        }
        return s3;
    }

    public Str BoolToString(){
        return new Str(this.toString());
    }

    public Bool BoolToBool(){
        return new Bool(this.Value);
    }

    public Str SSumaString(Str x){
        return new Str(x.getValue()+this.toString());
    }
    public IAndOr And(IAndOr x){
        return x.AndBool(this);
    }
    public IAndOr Or(IAndOr x){
        return x.OrBool(this);
    }

    public Bool AndBool(Bool x){
        if (x.getValue()){
            return new Bool(this.Value);
        }
        else{
            return new Bool(false);
        }
    }
    public Bool OrBool(Bool x){
        if(x.getValue()){
            return new Bool(true);
        }
        else{
            return new Bool(this.Value);
        }
    }
    public Binary AndBinary(Binary x){
        if(this.Value){
            return new Binary(x.getValue());
        }
        else{
            return new Binary(ceros(x.getValue()));
        }
    }
    public Binary OrBinary(Binary x){
        if(this.Value){
            return new Binary(unos(x.getValue()));
        }
        else{
            return new Binary(x.getValue());
        }
    }
    public Bool Negacion(){
        if(this.Value){
            return new Bool(false);
        }
        else{
            return new Bool(true);
        }
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Bool){
            var oooo = (Bool) obj;
            return (oooo.getValue()==this.Value);
        }
        return false;
    }


    @Override
    public Leaf sumaL(Leaf l) {
        return null;
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

    /** Retorna lo mismo que Or pero con un cast Leaf. */
    @Override
    public Leaf OrL(Leaf l) {
        return (Leaf) this.Or((IAndOr) l);
    }

    /** Retorna lo mismo que And pero con un cast Leaf. */
    @Override
    public Leaf AndL(Leaf l) {
        return (Leaf) this.And((IAndOr) l);
    }

    /** Retorna lo mismo que Negacion pero con un cast Leaf. */
    @Override
    public Leaf NegacionL() {
        return (Leaf) this.Negacion();
    }

    @Override
    public Leaf eval() {
        return this;
    }

    @Override
    public int compareTo(Operation o) {
        if(this.Value == ((Bool) o).getValue()){
            return 0;
        }
        else if((this.Value == true) && true != ((Bool) o).getValue()){
            return 1;
        }
        else{
            return -1;
        }
    }
}
