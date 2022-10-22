import java.util.*;

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
        this.coste = 0f;
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

    public float getCoste()
    {
        actualizarCoste();
        return coste;
    }

    public float actualizarCoste()
    {
        float res = 0f;
        if (sensores != null)
        {
            for(Sensor senso: sensores)
            {
                res += senso.getPrecio();
            }
        }
        return res;
    }

    public void setCoste(float coste)
    {
        this.coste = coste;
    }


    // METODOS FUNCIONALES

    //  dar de alta un sensor, teniendo en cuenta
    //el criterio de igualdad definido en la clase Sensor.
    public boolean darAlta(Sensor sensor)
    {
        //tenemos que ir recorriendo el array de sensores viendo que no haya ninguno
        //igual en la misma estancia
        if(sensores == null)
        {
            Set <Sensor> sensores = new HashSet<>();
            sensores.add(sensor);
        }
        else
        {
            for(Sensor senso : sensores)
            {
                assert senso != null;
                if(senso.equals(sensor))
                {
                    return false;
                }
            }
            sensores.add(sensor);
        }

        return true;
    }

    //dar de alta un sensor a partir de su id, tipo, rango y precio, teniendo en cuenta el
    //criterio de igualdad
    public boolean darAlta(String id, String tipo, float[] rango, float precio)
    {
        for(Sensor senso : sensores)
        {
            if(senso.getId().equals(id))
            {
                return false;
            }
            else if(senso.getTipo().equals(tipo))
            {
                return false;
            }
            else if(senso.limiteInferior() == rango[0])
            {
                return false;
            }
            else if (senso.limiteSuperior() == rango[1])
            {
                return false;
            }
            else if(senso.getPrecio().equals(precio))
            {
                return false;
            }
        }
        return true;
    }

    //introducir un nuevo dato
    //capturado por el sensor que tiene un determinado identificador id, devolviendo true si ha sido
    //introducido correctamente o false, en caso contrario
    public boolean nuevoDato(String id, float dato)
    {
        if(sensores != null)
        {
            for (Sensor senso : sensores) {
                // en el caso en el que exista el id...
                if (senso.getId().equals(id))
                {
                    if((senso.limiteInferior() < dato) && (senso.limiteSuperior() > dato)) {
                        senso.nuevoDato(dato);
                        return true;
                    }
                }
            }
        }
        //si no hay ningun sensor con ese id
        return false;
    }

    // devuelve el conjunto de sensores
    //de un determinado tipo que hay en la estancia.
    public Set<Sensor> sensoresTipo(String tipo)
    {
        Set <Sensor> respuesta = new HashSet<>();
        for(Sensor senso : sensores)
        {
            if(senso.getTipo().equals(tipo))
            {
                respuesta.add(senso);
            }
        }
        return respuesta;
    }

    // devuelve el sensor (o sensores) de
    //un determinado tipo que ha capturado el valor máximo.
    /*public Sensor[] sensorMaxValor(String tipo)
    {
        Set <Sensor> aux = sensoresTipo(tipo);
        Collections.max(Arrays.asList(aux.toArray()), );
        Sensor[] respuesta = new Sensor[aux.size()];
        ArrayList<Float> maximo = new ArrayList<>(aux.size());
        for(Sensor senso : aux)
        {
             maximo.add(senso.maximo());
        }
        int cont = 0;
        for(int i=0; i < maximo.size(); i++)
        {
            if(Objects.equals(Collections.max(maximo), maximo.get(i)))
            {

            }
        }


        return null;
    }*/

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
        ArrayList<Float> respuesta = new ArrayList<>();

        for(Sensor senso: sensores)
        {
            if(senso.getId().equals(id))
            {
            }

        }
        return null;
    }


    // donde se considera que dos estancias son
    //iguales si sus nombres son iguales y si la planta en la que se encuentran es la misma
    @Override
    public boolean equals(Object object)
    {
        if(this == object)
        {
            return true;
        }
        if(object == null)
        {
            return false;
        }
        if(getClass() != object.getClass())
        {
            return false;
        }
        final Estancia other = (Estancia) object;
        if(!this.nombre.equals(other.nombre))
        {
            return false;
        }
        if(this.planta != other.planta)
        {
            return false;
        }
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
            respuesta = respuesta + "sensores:  ";
            respuesta = respuesta + "[";
            int i = 0;
            for (Sensor sensor: sensores)
            {
                if (sensor.getId() != null)
                {
                    respuesta = respuesta + sensor.getId();
                    if(i != sensores.size()-1)
                    {
                        respuesta += ", ";
                    }
                }
                i++;
            }
            respuesta +=  "]" + "\n";
        }
    if (coste != 0f)
    {
        respuesta += "coste: " + getCoste() + "\n";

    }
    if(sensores != null)
    {
        respuesta = respuesta + "sensores_media:  ";
        respuesta = respuesta + "[";
        int i = 0;
        for (Sensor sensor: sensores)
        {
            if (sensor.getId() != null)
            {
                respuesta += "{";
                respuesta = respuesta + sensor.getId();
                if(i != sensores.size())
                {
                    respuesta += ", ";
                }
            }
            if(sensor.media() != 0f)
            {
                respuesta = respuesta + sensor.media();
            }
            respuesta += "} ";
            if(i != sensores.size()-1)
            {
                respuesta += ", ";
            }
            i++;
        }
        respuesta +=  "]" + "\n";
    }
        return respuesta;
    }

}
