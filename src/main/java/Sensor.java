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
    }

}
