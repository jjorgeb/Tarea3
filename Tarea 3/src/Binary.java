public class Binary implements INumber, INumberNoFloat, SumaString, IAndOr, Leaf{
    private String Value;

    public Binary(String valor){
        this.Value = valor;
    }

    public Binary eval(){
        return this;
    }


    public String getValue(){
        return this.Value;
    }
    public int getValueInt(){
        return toInt(this.Value);
    }

    private int toInt(String binary) {
        if(bitToInt(binary.charAt(0))==0) {
            return positiveBinToInt(binary);
        }
        else{
            return negativeBinaryToInt(binary);
        }
    }
    private int negativeBinaryToInt(String binary) {
        int n=binary.length()-1;
        int w=-bitToInt(binary.charAt(0))*(int) Math.pow(2, n);
        for(int i=n, j=0; i>0; i--, j++) {
            w+=(int) Math.pow(2, j)*(binary.charAt(i)=='1'?1:0);
        }
        return w;
    }
    private int positiveBinToInt(String binary) {
        int w=0;
        for(int i=binary.length()-1, j=0; i>0; i--, j++) {
            w += (int) Math.pow(2, j)*bitToInt(binary.charAt(i));
        }
        return w;
    }
    private int bitToInt(char bit) {
        return bit == '0' ? 0 : 1;
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

    public Int BinaryToInt(){
        return new Int(toInt(this.Value));
    }

    public Float BinaryToFloat(){
        return new Float(toInt(this.Value));
    }

    public Str BinaryToString(){
        return new Str(this.Value);
    }

    public Binary BinaryToBinary(){
        return new Binary(this.Value);
    }

    public Binary suma(INumberNoFloat x){
        return x.SumaBinary(this);
    }

    /** Retorna lo mismo que suma pero con un cast Leaf. */
    public Leaf sumaL(Leaf x){
        return (Leaf) this.suma((INumberNoFloat) x);
    }

    /** Retorna lo mismo que resta pero con un cast Leaf. */
    public Leaf restaL(Leaf x){
        return (Leaf) this.resta((INumberNoFloat) x);
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

    public Binary SumaBinary(Binary x){
        return new Binary(toBin2(x.getValueInt()+toInt(this.Value)));
    }
    public Int SumaInt(Int x){
        return new Int(toInt(this.Value)+x.getValue());
    }
    public Float SumaFloat(Float x){
        return new Float(toInt(this.Value)+x.getValue());
    }
    public Binary resta(INumberNoFloat x){
        return x.RestaBinary(this);
    }
    public Binary RestaBinary(Binary x){
        return new Binary(toBin2(x.getValueInt()-toInt(this.Value)));
    }
    public Int RestaInt(Int x){
        return new Int(x.getValue()-toInt(this.Value));
    }
    public Float RestaFloat(Float x){
        return new Float(x.getValue()-toInt(this.Value));
    }
    public Binary multiplicacion(INumberNoFloat x){
        return x.MultiplicacionBinary(this);
    }
    public Binary MultiplicacionBinary(Binary x){
        return new Binary(toBin2(x.getValueInt()*toInt(this.Value)));
    }
    public Int MultiplicacionInt(Int x){
        return new Int(x.getValue()*toInt(this.Value));
    }
    public Float MultiplicacionFloat(Float x){
        return new Float(x.getValue()*toInt(this.Value));
    }
    public Binary division(INumberNoFloat x){
        return x.DivisionBinary(this);
    }
    public Binary DivisionBinary(Binary x){
        return new Binary(toBin2(x.getValueInt()/toInt(this.Value)));
    }
    public Int DivisionInt(Int x){
        return new Int(x.getValue()/toInt(this.Value));
    }
    public Float DivisionFloat(Float x){
        return new Float(x.getValue()/toInt(this.Value));
    }
    public Str SSumaString(Str x){
        return new Str(x.getValue()+this.Value);
    }
    public Binary And(IAndOr x){
        return x.AndBinary(this);
    }
    public Binary Or(IAndOr x){
        return x.OrBinary(this);
    }
    public Binary AndBool(Bool x){
        if(x.getValue()){
            return new Binary(this.Value);
        }
        else{
            return new Binary(ceros(this.Value));
        }
    }
    public Binary OrBool(Bool x){
        if(x.getValue()){
            return new Binary(unos(this.Value));
        }
        else{
            return new Binary(this.Value);
        }
    }

    public Binary AndBinary(Binary x){
        String s1=x.getValue();
        String s2=this.getValue();
        String s3="";
        for(int i = Math.min(x.getValue().length(),this.Value.length());i<Math.max(x.getValue().length(),this.Value.length());i++){
            if(x.getValue().length()<this.Value.length()){
                s1 = ('1' + s1);
            }
            else{
                s2 = ('1' + s2);
            }
        }
        for(int j = 0; j<s2.length();j++){
            if(s1.charAt(j)=='0' | s2.charAt(j)=='0'){
                s3 += '0';
            }
            else{
                s3 += '1';
            }
        }
        return new Binary(s3);
    }

    public Binary OrBinary(Binary x){
        String s1=x.getValue();
        String s2=this.getValue();
        String s3="";
        for(int i = Math.min(x.getValue().length(),this.Value.length());i<Math.max(x.getValue().length(),this.Value.length());i++){
            if(x.getValue().length()<this.Value.length()){
                s1 = ('0' + s1);
            }
            else{
                s2 = ('0' + s2);
            }
        }
        for(int j = 0; j<s2.length();j++){
            if(s1.charAt(j)=='1' | s2.charAt(j)=='1'){
                s3 += '1';
            }
            else{
                s3 += '0';
            }
        }
        return new Binary(s3);
    }
    public Binary Negacion(){
        return new Binary(Neg(this.Value));
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Binary){
            var oo = (Binary) obj;
            return (oo.getValueInt()==this.getValueInt());
        }
        return false;
    }


    @Override
    public int compareTo(Operation o) {
        if(this.getValueInt() == ((Binary) o).getValueInt()){
            return 0;
        }
        else if(this.getValueInt() > ((Binary) o).getValueInt()){
            return 1;
        }
        else{
            return -1;
        }
    }

}
