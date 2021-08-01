public interface Operation extends Comparable<Operation> {
    Leaf eval();
    int compareTo(Operation i);
}
