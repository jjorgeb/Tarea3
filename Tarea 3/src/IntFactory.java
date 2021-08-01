import java.util.Hashtable;

/** Factory de Int que se encargara de optimizar memoria usando el diseño flyweight. */
public class IntFactory {
    private Hashtable<Integer, Int> hashtable = new Hashtable<>();

    /** Retorna un Int ya creado en caso de que exista un Int con valor value, o lo crea en caso de que no exista
     * y agrega ese valor en la hashtable.
     */
    public Int getInt(int value){
        Integer key = value;
        Int Int1 = hashtable.get(key);
        if(Int1 != null){
            return Int1;
        }
        else {
            Int1 = new Int(value);
            hashtable.put(key, Int1);
        }
        return Int1;
    }
}
