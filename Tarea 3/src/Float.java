public class Float implements INumber, SumaString, Leaf {
    private double Value;

    public Float(double valor){
        this.Value = valor;
    }

    public Float eval(){
        return this;
    }

    /** Entrega al double Value como un string de java. */
    public String toString(){
        return String.valueOf(this.Value);
    }

    public double getValue(){
        return this.Value;
    }

    /**  Retorna un Str inicializado con el valor Value en forma de String. */
    public Str FloatToString(){
        return new Str(this.toString());
    }

    /** Retorna un Float inicializado con el valor Value. */
    public Float FloatToFloat(){
        return new Float(this.Value);
    }

    /** Retorna el resultado de realizar la operacion SumaFloat en la clase de x, lo cual devolvera un Float,
     *  en el cual el valor sera la suma del valor Value con el valor de x.
     */
    public Float suma(INumber x){
        return x.SumaFloat(this);
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


    /** Retorna un Float inicializado con el valor Value sumado con el valor de x. */
    public Float SumaInt(Int x){
        return new Float(this.Value + x.getValue());
    }

    /** Retorna un Float inicializado con el valor Value sumado con el valor de x. */
    public Float SumaFloat(Float x){
        return new Float(x.getValue()+this.Value);
    }

    /** Retorna el resultado de realizar la operacion RestaFloat en la clase de x, lo cual devolvera un Float
     *  en el cual el valor sera la resta del valor Value con el valor de x.
     */
    public Float resta(INumber x){
        return x.RestaFloat(this);
    }

    /** Retorna un Float inicializado con el valor de x restado con el valor Value. */
    public Float RestaInt(Int x){
        return new Float(x.getValue() - this.Value);
    }

    /** Retorna un Float inicializado con el valor de x restado con el valor Value. */
    public Float RestaFloat(Float x){
        return new Float(x.getValue()-this.Value);
    }

    /** Retorna el resultado de realizar la operacion MultiplicacionFloat en la clase de x, lo cual devolvera un Float
     *  en el cual el valor sera la multiplicacion del valor de Value con el valor de x.
     */
    public Float multiplicacion(INumber x){
        return x.MultiplicacionFloat(this);
    }

    /** Retorna un Float inicializado con el valor de x multiplicado con el valor Value. */
    public Float MultiplicacionInt(Int x){
        return new Float((x.getValue() * this.Value));
    }

    /** Retorna un Int inicializado con el valor de x multiplicado con el valor Value. */
    public Float MultiplicacionFloat(Float x){
        return new Float(x.getValue()*this.Value);
    }

    /** Retorna el resultado de realizar la operacion DivisionFloat en la clase de x, lo cual devolvera un Float
     *  en el cual el valor sera la division del valor de Int con el valor de x.
     */
    public Float division(INumber x){
        return x.DivisionFloat(this);
    }

    /** Retorna un Float inicializado con el valor de x dividido con el valor Value. */
    public Float DivisionInt(Int x){
        return new Float(x.getValue() / this.Value);
    }

    /** Retorna un Float inicializado con el valor de x dividido con el valor Value. */
    public Float DivisionFloat(Float x){
        return new Float(x.getValue()/this.Value);
    }

    /** Retorna un String inicializado con el String de x concatenado con el valor Value en forma de String. */
    public Str SSumaString(Str x){
        return new Str(x.getValue()+this.toString());
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Float){
            var ooo = (Float) obj;
            return (ooo.getValue()==this.Value);
        }
        return false;
    }

    @Override
    public int compareTo(Operation o) {
        if(this.Value == ((Float) o).getValue()){
            return 0;
        }
        else if(this.Value > ((Float) o).getValue()){
            return 1;
        }
        else{
            return -1;
        }
    }
}
