import java.util.ArrayList;

public class Sensor
{
    // ATRIBUTOS
    String id; //identificador del sensor
    String tipo; // tipo de sensor
    //Estancia estancia; //nombre de la estancia donde esta el sensor
    ArrayList<Float> datos; //conjunto de datos que ha capturado el sensor
    Float[] rango; //rango de valores que puede tomar el sensor
    Float precio; // precio del sensor


    // CONSTRUCTORES
    public Sensor(String id, String tipo, float[] rango, float precio)
    {
        if(id != null)
        {
            this.id = id;
        }
        if(tipo.equals("temperatura") || tipo.equals("sonido") || tipo.equals("luz") || tipo.equals("humedad"))
        {
            this.tipo = tipo;
        }
        //evitar aliasing en el rango
        //Float[] listaRango = new ArrayList<Float>;
        //listaRango = rango(Float);
       // this.rango = listaRango;

        if(precio != 0f)
        {
            this.precio = precio;
        }
    }


    //GETTERS Y SETTERS
    /** AÑADIR SETTER DE ESTANCIA !! **/

    /// id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /// tipo
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /// datos
    public void setDatos(ArrayList<Float> datos) {
        this.datos = datos;
    }

    /// rango
    public void setRango(Float[] rango) {
        this.rango = rango;
    }

    /// precio
    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    /// estancia

    // METODOS FUNCIONALES

    public float limiteInferior()  // devuelve el valor mínimo que puede tomar el sensor.
    {
        float limiteInf = 0f;
        limiteInf = rango[0];
        return limiteInf;
    }

    public float limiteSuperior()  // devuelve el valor maximo que puede tomar el sensor
    {
        float limiteSup = 0f;
        limiteSup = rango[1];
        return limiteSup;
    }

    public void nuevoDato(float dato)  //introduce un nuevo dato capturado por el sensor
    {
        datos.add(dato);
    }

    public float media()  // devuelve la media de los valores del sensor
    {
        float media = 0f, suma = 0f;
        for (Float dato : datos) {
            suma = suma + dato;
        }
        media = suma / datos.size();
        return media;
    }

    public float maximo() // devuelve el maximo de los valores del sensor
    {
        float maximo = 0f;
        for (int i =0; i< datos.size(); i++)
        {
            if(maximo < datos.get(i))
            {
                maximo = datos.get(i);
            }
        }
        return maximo;
    }

    public float minimo() // devuelve el minimo de los valores del sensor
    {
        float minimo = 0f;
        for (int i =0; i< datos.size(); i++)
        {
            if(minimo > datos.get(i))
            {
                minimo = datos.get(i);
            }
        }
        return minimo;
    }

   // @Override
   /* public boolean equals(Object object)
    {

    }*/

    @Override
    public String toString()
    {
        String respuesta = null;

        if(id != null)
        {
            respuesta = "id: " + getId() + "\n";
        }
        if(tipo != null)
        {
            respuesta += "tipo: " + getTipo() + "\n";
        }
       /* if(estancia != null)
        {
            respuesta += "estancia: " + getEstancia() + "\n";
        }*/
        if(rango != null)
        {
            respuesta = respuesta + "rango :  " ;
            respuesta = respuesta + "[";
            for (int i=0; i < rango.length; i++)
            {
                if (rango[i] != null)
                {
                    respuesta = respuesta + rango[i];
                    if(i != rango.length-1)
                    {
                        respuesta += ", ";
                    }
                }

            }
            respuesta +=  "]" + "\n";
        }
        if(datos != null)
        {
            respuesta = respuesta + "datos :  " ;
            respuesta = respuesta + "[";
            for (int i=datos.size()-1; i <= 10; i--)
            {
                if (datos.get(i) != null)
                {
                    respuesta = respuesta + datos.get(i);
                    if(i != datos.size()-1)
                    {
                        respuesta += ", ";
                    }
                }

            }
            respuesta +=  "]" + "\n";

        }
        if(precio != 0f)
        {
            respuesta += "precio: " + getPrecio() + "\n";
        }
        if(minimo() != 0f)
        {
            respuesta += "minimo: " + minimo() + "\n";
        }
        if(maximo() != 0f)
        {
            respuesta += "maximo: " + maximo() + "\n";
        }
        if(media() != 0f)
        {
            respuesta += "media: " + media() + "\n";
        }
        return respuesta;
    }


}
