public interface INumber extends Leaf {
    INumber SumaInt(Int x);
    Float SumaFloat(Float x);
    INumber RestaInt(Int x);
    Float RestaFloat(Float x);
    INumber MultiplicacionInt(Int x);
    Float MultiplicacionFloat(Float x);
    INumber DivisionInt(Int x);
    Float DivisionFloat(Float x);

    /*
    Leaf sumaL(Leaf l);
    Leaf restaL(Leaf l);
    Leaf divisionL(Leaf l);
    Leaf multiplicacionL(Leaf l);
    Leaf OrL(Leaf l);
    Leaf AndL(Leaf l);
    Leaf NegacionL();
    */
}
