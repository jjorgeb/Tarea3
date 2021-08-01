import java.util.Hashtable;

public class Var implements Comparable<Operation>, Operation {
    private String id;
    private Operation value;
    private Hashtable<String, Operation> hashtable;

    public Var(Hashtable<String, Operation> hashtable ,String id, Operation value){
        this.id = id;
        this.value = value;
        this.hashtable = hashtable;
    }

    public Var(String id, Operation value){
        this.id = id;
        this.value = value;
    }

    public Var(String id){
        this.id = id;
    }

    public Var(Hashtable<String, Operation> hashtable, String id){
        this.id = id;
        this.hashtable = hashtable;
        this.value = null;
    }

    public Leaf getValue(){
        return (Leaf) hashtable.get(id);
    }

    public String getId(){
        return this.id;
    }

    public void changeValue(Operation newValue){
        value = newValue;
    }


    public Leaf eval(){
        if(this.value != null){
            hashtable.put(id, this.value.eval());
            return (Leaf) hashtable.get(id);
        }
        else{
            return (Leaf) hashtable.get(id);
        }
    }

    public int compareTo(Operation op) {
        return this.getValue().compareTo(op);
    }
}
