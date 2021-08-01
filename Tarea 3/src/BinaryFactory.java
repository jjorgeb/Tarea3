import java.util.Hashtable;

/** Factory de Binary que se encargara de optimizar memoria usando el diseño flyweight. */
public class BinaryFactory {
    private Hashtable<String, Binary> hashtable = new Hashtable<>();


    /** Retorna un Binary ya creado en caso de que exista un Binary con valor value, o lo crea en caso de que no exista
     * y agrega ese valor en la hashtable.
     */
    public Binary getBinary(String value){
        String key = value;
        Binary Bin1 = hashtable.get(key);
        if(Bin1 != null){
            return Bin1;
        }
        else {
            Bin1 = new Binary(value);
            hashtable.put(key, Bin1);
        }
        return Bin1;
    }
}
