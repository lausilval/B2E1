import java.util.ArrayList;
import java.util.Set;

public class Estancia
{
    // ATRIBUTOS
    String nombre;  // nombre de la estancia, que también es su identificador único.
    int planta; // planta en la que se encuentra la estancia
    Set<Sensor> sensores; // conjunto de sensores que estan instalados en la estancia
    float coste;    // coste de la estancia, entendida como la suma del precio de todos los sensores de la estancia

    // CONSTRUCTORES
    public Estancia(String nombre, int planta)
    {
        if(nombre != null)
        {
            this.nombre = nombre;
        }
        this.planta = planta;

        this.sensores = null;
        this.coste = 0;
    }

    // GETTERS && SETTERS


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }
/*
    public Set<Sensor> getSensores() {
        return sensores;
    }
*/

    public void setSensores(Set<Sensor> sensores) {
        this.sensores = sensores;
    }

    public float getCoste() {
        return coste;
    }

    public void setCoste(float coste) {
        this.coste = coste;
    }

    // METODOS FUNCIONALES

    //  dar de alta un sensor, teniendo en cuenta
    //el criterio de igualdad definido en la clase Sensor.
    public boolean darAlta(Sensor sensor)
    {
        //tenemos que ir recorriendo el array de sensores viendo que no haya ninguno
        //igual en la misma estancia
        return true;
    }

    //dar de alta un sensor a partir de su id, tipo, rango y precio, teniendo en cuenta el
    //criterio de igualdad
    public boolean darAlta(String id, String tipo, float[] rango, float precio)
    {
        return true;
    }

    //introducir un nuevo dato
    //capturado por el sensor que tiene un determinado identificador id, devolviendo true si ha sido
    //introducido correctamente o false, en caso contrario
    public boolean nuevoDato(String id, float dato)
    {
        return true;
    }

    // devuelve el conjunto de sensores
    //de un determinado tipo que hay en la estancia.
    public Set<Sensor> sensoresTipo(String tipo)
    {
        return null;
    }

    // devuelve el sensor (o sensores) de
    //un determinado tipo que ha capturado el valor máximo.
    public Sensor[] sensorMaxValor(String tipo)
    {
        return null;
    }

    //  devuelve el sensor (o sensores) de
    //un determinado tipo que ha capturado el valor mínimo.
    public Sensor[] sensorMinValor(String tipo)
    {
        return null;
    }

    // devuelve el conjunto de valores de un sensor con identificador id que superan un determinado
    //valor.
    public ArrayList<Float> valoresSuperiores(String id, float valor)
    {
        return null;
    }


    // donde se considera que dos estancias son
    //iguales si sus nombres son iguales y si la planta en la que se encuentran es la misma
    @Override
    public boolean equals(Object object)
    {
        return true;
    }


    @Override
    public String toString()
    {
        String respuesta = null;
        if(nombre != null)
        {
            respuesta = "nombre: " + getNombre() + "\n";
        }
        respuesta += "planta: " + getPlanta() + "\n";
        if (sensores != null)
        {
            respuesta = respuesta + "sensores :  ";
            respuesta = respuesta + "[";
            for (Sensor sensor: sensores)
            {
                int i = 0;
                if (sensor.getId() != null)
                {
                    respuesta = respuesta + sensor.getId();
                    if(i != sensores.size()-1)
                    {
                        respuesta += ", ";
                    }
                }
                i++;
                respuesta +=  "]" + "\n";
            }
        }
    if (coste != 0)
    {
        respuesta += "coste: " + getCoste() + "\n";

    }
    /** NO SE HACERLO HAY QUE CORREGIRLO
    if( sensores != null)
    {
        respuesta += "sensores_media :" ;
        respuesta = respuesta + "[";
        for (Sensor sensor: sensores)
        {
            int i = 0;
            if (sensor.getId() != null)
            {
                respuesta = respuesta + sensor.getId();
                if(i != sensores.size()-1)
                {
                    respuesta += ", ";
                }
            }
            i++;
            respuesta +=  "]" + "\n";
        }

    }**/

        return respuesta;
    }

}
