public interface Leaf extends Operation{
    Leaf sumaL(Leaf l);
    Leaf restaL(Leaf l);
    Leaf divisionL(Leaf l);
    Leaf multiplicacionL(Leaf l);
    Leaf OrL(Leaf l);
    Leaf AndL(Leaf l);
    Leaf NegacionL();
}
