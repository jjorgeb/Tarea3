import java.util.Hashtable;

/** Factory de Str que se encargara de optimizar memoria usando el diseño flyweight. */
public class StrFactory {
    private Hashtable<String, Str> hashtable = new Hashtable<>();


    /** Retorna un Str ya creado en caso de que exista un Str con valor value, o lo crea en caso de que no exista
     * y agrega ese valor en la hashtable.
     */
    public Str getStr(String value){
        String key = value;
        Str Str1 = hashtable.get(key);
        if(Str1 != null){
            return Str1;
        }
        else {
            Str1 = new Str(value);
            hashtable.put(key, Str1);
        }
        return Str1;
    }
}
