import java.util.Hashtable;

/** Factory de Bool que se encargara de optimizar memoria usando el diseño flyweight. */
public class BoolFactory {
    private Hashtable<Boolean, Bool> hashtable = new Hashtable<>();

    /** Retorna un Bool ya creado en caso de que exista un Bool con valor value, o lo crea en caso de que no exista
     * y agrega ese valor en la hashtable.
     */
    public Bool getBool(boolean value){
        boolean key = value;
        Bool Bool1 = hashtable.get(key);
        if(Bool1 != null){
            return Bool1;
        }
        else {
            Bool1 = new Bool(value);
            hashtable.put(key, Bool1);
        }
        return Bool1;
    }
}
