import java.util.Hashtable;

/** Factory de Var que se encargara de entregarle a cada una de las variables la misma Hashtable para poder
 * hace uso de ellas correctamente.
 */
public class VarFactory {
    private Hashtable<String, Operation> hashtable = new Hashtable<>();

    /** Retorna un Var con el input id de getVar() y la Hashtable de la Factory. */
    public Var getVar(String id){
        return new Var(hashtable, id);
    }

    /** Retorna un Var con el input id de getVar(), el valor asociado a la id y la Hashtable de la Factory. */
    public Var getVar(String id, Operation var){
        return new Var(hashtable, id, var);
    }
}