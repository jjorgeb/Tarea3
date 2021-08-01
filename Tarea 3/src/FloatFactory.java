import java.util.Hashtable;

/** Factory de Float que se encargara de optimizar memoria usando el diseño flyweight. */
public class FloatFactory {
    private Hashtable<Double, Float> hashtable = new Hashtable<>();


    /** Retorna un Float ya creado en caso de que exista un Float con valor value, o lo crea en caso de que no exista
     * y agrega ese valor en la hashtable.
     */
    public Float getFloat(double value){
        Double key = value;
        Float Float1 = hashtable.get(key);
        if(Float1 != null){
            return Float1;
        }
        else {
            Float1 = new Float(value);
            hashtable.put(key, Float1);
        }
        return Float1;
    }
}
