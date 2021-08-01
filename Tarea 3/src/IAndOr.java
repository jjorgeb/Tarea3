public interface IAndOr {
    IAndOr Or(IAndOr x);
    IAndOr And(IAndOr x);
    IAndOr OrBool(Bool x);
    IAndOr AndBool(Bool x);
    Binary OrBinary(Binary x);
    Binary AndBinary(Binary x);
    IAndOr Negacion();
}
