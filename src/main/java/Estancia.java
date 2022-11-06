import java.util.*;

public class Estancia {
    // ATRIBUTOS
    private String nombre;  // nombre de la estancia, que también es su identificador único.
    private int planta; // planta en la que se encuentra la estancia
    private Set<Sensor> sensores; // conjunto de sensores que estan instalados en la estancia
    private float coste;    // coste de la estancia, entendida como la suma del precio de todos los sensores de la estancia

    // CONSTRUCTORES
    public Estancia(String nombre, int planta) {
        if (nombre != null) {
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
        if(nombre != null)
        {
            this.nombre = nombre;
        }
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
        if(sensores != null)
        {
            this.sensores = sensores;
        }
    }

    public float getCoste() {
        //actualizarCoste();
        return coste;
    }

    public void setCoste(float coste) {
        if(coste > 0f)
        {
            this.coste = coste;
        }
    }


    // METODOS FUNCIONALES

    public float actualizarCoste() {
        float res = 0f;
        if (this.sensores != null) {
            for (Sensor senso : sensores) {
                res += senso.getPrecio();
            }
        }
        return res;
    }

    //  dar de alta un sensor, teniendo en cuenta
    //el criterio de igualdad definido en la clase Sensor.
    public boolean darAlta(Sensor sensor) {
        //tenemos que ir recorriendo el array de sensores viendo que no haya ninguno
        //igual en la misma estancia
        if(sensor != null)
        {
            if (sensores == null) {
                Set<Sensor> sensores = new HashSet<Sensor>();
                this.sensores = sensores;
                sensores.add(sensor);
            } else {
                for (Sensor senso : sensores) {
                    if (senso != null) {
                        if (senso.equals(sensor)) {
                            return false;
                        }
                    }
                }
                sensores.add(sensor);
                this.coste = actualizarCoste();
            }
            return true;
        }
        return false;
    }

    //dar de alta un sensor a partir de su id, tipo, rango y precio, teniendo en cuenta el
    //criterio de igualdad
    public boolean darAlta(String id, String tipo, float[] rango, float precio)
    {
        if((id != null) && (tipo != null) && (rango != null) && (precio != 0))
        {
            if (sensores != null) {
                for (Sensor senso : sensores) {
                    if (senso.getId().equals(id)) {
                        return false;
                    }
                }
                Sensor nuevoSensor = new Sensor(id, tipo, rango, precio);
                this.sensores.add(nuevoSensor);
                this.coste = actualizarCoste();
                return true;
            } else {
                Set<Sensor> sensores = new HashSet<>();
                Sensor nuevoSensor = new Sensor(id, tipo, rango, precio);
                sensores.add(nuevoSensor);
                this.sensores = sensores;
                this.coste = actualizarCoste();
                return true;
            }
        }
        return false;
    }

    //introducir un nuevo dato
    //capturado por el sensor que tiene un determinado identificador id, devolviendo true si ha sido
    //introducido correctamente o false, en caso contrario
    public boolean nuevoDato(String id, float dato)
    {
        if((id != null))
        {
            if (sensores != null) {
                for (Sensor senso : sensores) {
                    // en el caso en el que exista el id...
                    if (senso.getId().equals(id)) {
                        if ((senso.limiteInferior() < dato) && (senso.limiteSuperior() > dato)) {
                            senso.nuevoDato(dato);
                            return true;
                        }
                    }
                }
            }
            //si no hay ningun sensor con ese id
            return false;
        }
        return false;
    }

    ////FUNCION PROPIA
    // funcion para poder atribuir los ids a un nombre y asi poder imprimir los datos de los sensores
    public Sensor sensorNombre(String id)
    {
        if(id!= null)
        {
            Sensor respuesta = null;
            if(sensores != null)
            {
                for (Sensor sensor : sensores)
                {
                    if (sensor.getId().equals(id)) {
                        respuesta = sensor;
                    }
                }
            }
            return respuesta;
        }
        return null;
    }

    // devuelve el conjunto de sensores
    //de un determinado tipo que hay en la estancia.
    public Set<Sensor> sensoresTipo(String tipo)
    {
        if(tipo != null) {
            Set<Sensor> respuesta = new HashSet<Sensor>();
            if (sensores != null) {
                for (Sensor senso : sensores) {
                    if (senso.getTipo().equals(tipo)) {
                        respuesta.add(senso);
                    }
                }
            }
            return respuesta;
        }
        return null;
    }

    // devuelve el sensor (o sensores) de
    //un determinado tipo que ha capturado el valor máximo.
    public Sensor[] sensorMaxValor(String tipo) {
        if(tipo != null) {
            Set<Sensor> aux = sensoresTipo(tipo);  // todos los sensores que sean de ese tipo
            Sensor[] respuesta = new Sensor[aux.size()];    // donde se va a almacenar la respuesta
            float maxValor = 0;
            int i = 0, j = 0;
            for (Sensor senso : aux) {
                if (i == 0) {
                    maxValor = senso.maximo();
                    i++;
                }
                if (maxValor <= senso.maximo()) {
                    maxValor = senso.maximo();
                    respuesta[j] = senso;
                    j++;
                }
            }
            return respuesta;
        }
        return null;
    }

    //  devuelve el sensor (o sensores) de
    //un determinado tipo que ha capturado el valor mínimo.
    public Sensor[] sensorMinValor(String tipo) {
        if(tipo != null) {
            Set<Sensor> aux = sensoresTipo(tipo);  // todos los sensores que sean de ese tipo
            Sensor[] respuesta = new Sensor[aux.size()];    // donde se va a almacenar la respuesta
            float minValor = 0;
            int i = 0, j = 0;
            for (Sensor senso : aux) {
                if (i == 0) {
                    minValor = senso.minimo();
                    i++;
                }
                if (minValor > senso.minimo()) {
                    minValor = senso.minimo();
                    respuesta[j] = senso;
                    j++;
                }
            }
            return respuesta;
        }
        return null;
    }

    // devuelve el conjunto de valores de un sensor con identificador id que superan un determinado
    //valor.
    public ArrayList<Float> valoresSuperiores(String id, float valor)
    {
        if(id != null) {
            ArrayList<Float> respuesta = new ArrayList<>();

            for (Sensor senso : sensores) {
                if (senso.getId().equals(id)) {
                    ArrayList<Float> sensorDatos = senso.getDatos();
                    for (Float d : sensorDatos) {
                        if (d > valor) {
                            respuesta.add(d);
                        }
                    }
                }

            }
            return respuesta;
        }
        return null;
    }


    // donde se considera que dos estancias son
    //iguales si sus nombres son iguales y si la planta en la que se encuentran es la misma
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        final Estancia other = (Estancia) object;
        if (!this.nombre.equals(other.nombre)) {
            return false;
        }
        if (this.planta != other.planta) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        String respuesta = null;
        if (nombre != null) {
            respuesta = "nombre: " + getNombre() + "\n";
        }
        respuesta += "planta: " + getPlanta() + "\n";
        if (sensores != null) {
            respuesta = respuesta + "sensores:  ";
            respuesta = respuesta + "[";
            int i = 0;
            for (Sensor sensor : sensores) {
                if (sensor.getId() != null) {
                    respuesta = respuesta + sensor.getId();
                    if (i != sensores.size() - 1) {
                        respuesta += ", ";
                    }
                }
                i++;
            }
            respuesta += "]" + "\n";
        }
        if (coste != 0f) {
            respuesta += "coste: " + getCoste() + "\n";

        }
        if (sensores != null) {
            respuesta = respuesta + "sensores_media:  ";
            respuesta = respuesta + "[";
            int i = 0;
            for (Sensor sensor : sensores) {
                if (sensor.getId() != null) {
                    respuesta += "{";
                    respuesta = respuesta + sensor.getId();
                    if (i != sensores.size()) {
                        respuesta += ", ";
                    }
                }
                if (sensor.media() != 0f) {
                    respuesta = respuesta + sensor.media();
                }
                respuesta += "} ";
                if (i != sensores.size() - 1) {
                    respuesta += ", ";
                }
                i++;
            }
            respuesta += "]" + "\n";
        }
        return respuesta;
    }

}
