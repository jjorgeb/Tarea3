public class Int implements INumber, INumberNoFloat, SumaString, Leaf {
    private int Value;

    public Int(int valor){
        this.Value = valor;
    }

    public Int eval(){
        return this;
    }

    /** Entrega al entero Value como un string de java. */
    public String toString(){
        return String.valueOf(this.Value);
    }

    private String toBin1(int x){
        String s = "";
        int v = x;
        while(v>0){
            s = String.valueOf(v%2) + s;
            v = v/2;
        }
        return s;
    }
    private String toBin2(int x){
        if(x>0){
            return '0' + toBin1(x);
        }
        else if(x==0){
            return "0000";
        }
        else{
            return '1' + Add1(Neg(toBin1(Math.abs(x))));
        }
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
    private String Add1(String s){
        String s1 = "";
        int buf = 1;
        for(int i = s.length()-1; i>=0 ;i--){
            if(s.charAt(i)=='1' & buf == 1){
                s1 = '0' + s1;
            }
            else if(s.charAt(i)=='0' & buf==1){
                s1 = '1' + s1;
                buf=0;
            }
            else if(s.charAt(i)=='1' & buf==0){
                s1 = '1' + s1;
            }
            else{
                s1 = s.charAt(i) + s1;
            }
        }
        return s1;
    }

    public int getValue(){
        return this.Value;
    }

    /** Retorna un Float inicializado con el valor Value. */
    public Float IntToFloat(){
        return new Float(Value);
    }

    /**  Retorna un Str inicializado con el valor Value en forma de String. */
    public Str IntToString(){
        return new Str(String.valueOf(this.Value));
    }

    /** Retorna un Int inicializado con el valor Value. */
    public Int IntToInt(){
        return new Int(this.Value);
    }

    /** Retorna un Binary inicializado con el valor Value en forma binaria. */
    public Binary IntToBin(){
        return new Binary(toBin2(this.Value));
    }

    /** Retorna el resultado de realizar la operacion SumaInt en la clase de x, lo cual devolvera un Int a excepcion
     *  del caso en que x es un Float en el cual se retornara un Float, en el cual el valor sera la suma del valor
     *  de Int con el valor de x.
     */
    public INumber suma(INumber x) {
        return x.SumaInt(this);
    }

    /** Retorna lo mismo que suma pero con un cast Leaf. */
    public Leaf sumaL(Leaf x){
        return (Leaf) this.suma((INumber) x);
    }

    /** Retorna lo mismo que resta pero con un cast Leaf. */
    public Leaf restaL(Leaf x){
        return (Leaf) this.resta((INumber) x);
    }
    /** Retorna lo mismo que multiplicacion pero con un cast Leaf. */
    public Leaf multiplicacionL(Leaf x){
        return (Leaf) this.multiplicacion((INumber) x);
    }
    /** Retorna lo mismo que division pero con un cast Leaf. */
    public Leaf divisionL(Leaf x){
        return (Leaf) this.division((INumber) x);
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


    /** Retorna un Int inicializado con el valor Value sumado con el valor de x. */
    public Int SumaInt(Int x){
        return new Int(this.Value + x.getValue());
    }

    /** Retorna un Float inicializado con el valor Value sumado con el valor de x. */
    public Float SumaFloat(Float x){
        return new Float(x.getValue()+this.Value);
    }

    /** Retorna un Binary inicializado con el valor Value sumado con el valor de x. */
    public Binary SumaBinary(Binary x){
        return new Binary(toBin2(x.getValueInt()+this.Value));
    }

    /** Retorna el resultado de realizar la operacion RestaInt en la clase de x, lo cual devolvera un Int a excepcion
     *  del caso en que x es un Float en el cual se retornara un Float, en el cual el valor sera la resta del valor
     *  de Int con el valor de x.
     */
    public INumber resta(INumber x){
        return x.RestaInt(this);
    }

    /** Retorna un Int inicializado con el valor de x restado con el valor Value. */
    public Int RestaInt(Int x){
        return new Int(x.getValue() - this.Value);
    }

    /** Retorna un Float inicializado con el valor de x restado con el valor Value. */
    public Float RestaFloat(Float x){
        return new Float(x.getValue()-this.Value);
    }

    /** Retorna un Binary inicializado con el valor de x restado con el valor Value. */
    public Binary RestaBinary(Binary x){
        return new Binary(toBin2(x.getValueInt()-this.Value));
    }

    /** Retorna el resultado de realizar la operacion MultiplicacionInt en la clase de x, lo cual devolvera un Int a
     *  excepcion del caso en que x es un Float en el cual se retornara un Float, en el cual el valor sera la
     *  multiplicacion del valor de Int con el valor de x.
     */
    public INumber multiplicacion(INumber x){
        return x.MultiplicacionInt(this);
    }

    /** Retorna un Int inicializado con el valor de x multiplicado con el valor Value. */
    public Int MultiplicacionInt(Int x){
        return new Int(x.getValue() * this.Value);
    }

    /** Retorna un Float inicializado con el valor de x multiplicado con el valor Value. */
    public Float MultiplicacionFloat(Float x){
        return new Float(x.getValue()*this.Value);
    }

    /** Retorna un Binary inicializado con el valor de x multiplicado con el valor Value. */
    public Binary MultiplicacionBinary(Binary x){
        return new Binary(toBin2(x.getValueInt()*this.Value));
    }

    /** Retorna el resultado de realizar la operacion DivisionInt en la clase de x, lo cual devolvera un Int a
     *  excepcion del caso en que x es un Float en el cual se retornara un Float, en el cual el valor sera la
     *  division del valor de Int con el valor de x.
     */
    public INumber division(INumber x){
        return x.DivisionInt(this);
    }

    /** Retorna un Int inicializado con el valor de x dividido con el valor Value. */
    public Int DivisionInt(Int x){
        return new Int(x.getValue() / this.Value);
    }

    /** Retorna un Float inicializado con el valor de x dividido con el valor Value. */
    public Float DivisionFloat(Float x){
        return new Float(x.getValue()/this.Value);
    }

    /** Retorna un Binary inicializado con el valor de x dividido con el valor Value. */
    public Binary DivisionBinary(Binary x){
        return new Binary(toBin2(x.getValueInt()/this.Value));
    }

    /** Retorna un String inicializado con el String de x concatenado con el valor Value en forma de String. */
    public Str SSumaString(Str x){
        return new Str(x.getValue()+this.toString());
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Int){
            var o = (Int) obj;
            return (o.getValue()==this.Value);
        }
        return false;
    }


    /*
    @Override
    public int compareTo(Int i) {
        if(this.Value == i.getValue()){
            return 0;
        }
        else if(this.Value > i.getValue()){
            return 1;
        }
        else{
            return -1;
        }
    }

     */



    @Override
    public int compareTo(Operation o) {
        if(this.Value == ((Int) o.eval()).getValue()){
            return 0;
        }
        else if(this.Value > ((Int) o.eval()).getValue()){
            return 1;
        }
        else{
            return -1;
        }
    }
}
