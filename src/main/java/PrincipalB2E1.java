import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PrincipalB2E1
{
    public static void main(String[] args)
    {

        // a. Crear los sensores sensor1, sensor2, sensor3 y sensor4 con los argumentos indicados en
        //el fichero Excel (B2E1_instancias.xls).
        float[] rango1 =  {-5f, 35f};
        Sensor sensor1 = new Sensor("100", "temperatura", rango1,54.4f);
        float[] rango2 =  {-5f, 40f};
        Sensor sensor2 = new Sensor("101", "temperatura", rango2, 48.5f);
        float[] rango3 =  {0f, 120f};
        Sensor sensor3 = new Sensor("200", "sonido", rango3, 30.5f);
        float[] rango4 =  {0f, 110f};
        Sensor sensor4 = new Sensor("201", "sonido", rango4, 28.3f);

        // b. Mostrar por pantalla los límites superiores e inferiores de los rangos de valores para todas las
        //instancias creadas en (a).
        System.out.println("APARTADO B) -----------------------------------------------------------------------------------------------------------");
        System.out.println("Sensor1:");
        System.out.println("\t Limite inferior: " + sensor1.limiteInferior());
        System.out.println("\t Limite superior: " + sensor1.limiteSuperior());
        System.out.println("Sensor2:");
        System.out.println("\t Limite inferior: " + sensor2.limiteInferior());
        System.out.println("\t Limite superior: " + sensor2.limiteSuperior());
        System.out.println("Sensor3:");
        System.out.println("\t Limite inferior: " + sensor3.limiteInferior());
        System.out.println("\t Limite superior: " + sensor3.limiteSuperior());
        System.out.println("Sensor4:");
        System.out.println("\t Limite inferior: " + sensor4.limiteInferior());
        System.out.println("\t Limite superior: " + sensor4.limiteSuperior());

        // c. Crear una estancia denominada estancia1 cuyo nombre es "Aula01" y la planta es 2.
        Estancia estancia1 = new Estancia("Aula01",2);

        //d. En la estancia estancia1, dar de alta a los sensores creados en (a), usando el método que tiene
        //como argumento la instancia de la clase Sensor e indicando si el sensor se ha dado de alta
        //correctamente o no.
        System.out.println("APARTADO D) -----------------------------------------------------------------------------------------------------------");
        Set <Sensor> sensores = new HashSet<>();
        estancia1.setSensores(sensores);
        System.out.println("Sensor1: " + estancia1.darAlta(sensor1));
        System.out.println("Sensor2: " + estancia1.darAlta(sensor2));
        System.out.println("Sensor3: " + estancia1.darAlta(sensor3));
        System.out.println("Sensor4: " + estancia1.darAlta(sensor4));

        //e. Introducir los valores de los sensores creados en (a), que están en el fichero Excel
        //(B2E1_instancias.xls), usando el método nuevoDato de la clase Estancia y mostrando por
        //pantalla si el dato ha sido introducido correctamente o no.
        System.out.println("APARTADO E) -----------------------------------------------------------------------------------------------------------");
        System.out.println("Sensor1:");
        System.out.println("- rango -> [" + sensor1.limiteInferior() + ", " + sensor1.limiteSuperior() + "]");
        ArrayList<Float> datosSensor1 = new ArrayList<>();
        sensor1.setDatos(datosSensor1);
        System.out.println("\t Dato 1: 23.4  -> " + estancia1.nuevoDato("100", 23.4f));
        System.out.println("\t Dato 2: 23.4  -> " + estancia1.nuevoDato("100", 23.4f));
        System.out.println("\t Dato 3: 23.5  -> " + estancia1.nuevoDato("100", 23.5f));
        System.out.println("\t Dato 4: 24.1  -> " + estancia1.nuevoDato("100", 24.1f));
        System.out.println("\t Dato 5: 23.2  -> " + estancia1.nuevoDato("100", 23.2f));
        System.out.println("\t Dato 6: -23.5 -> " + estancia1.nuevoDato("100", -23.5f));
        System.out.println("\t Dato 7: 24.6  -> " + estancia1.nuevoDato("100", 24.6f));
        System.out.println("\t Dato 8: 23.8  -> " + estancia1.nuevoDato("100", 23.8f));
        System.out.println("\t Dato 9: 23.9  -> " + estancia1.nuevoDato("100", 23.9f));
        System.out.println("\t Dato 10: 24.1 -> " + estancia1.nuevoDato("100", 24.1f));
        System.out.println("\t Dato 11: 24.3 -> " + estancia1.nuevoDato("100", 24.3f));
        System.out.println("\t Dato 12: 25.4 -> " + estancia1.nuevoDato("100", 25.4f));

        System.out.println("Sensor2:");
        System.out.println("- rango -> [" + sensor2.limiteInferior() + ", " + sensor2.limiteSuperior() + "]");
        ArrayList<Float> datosSensor2 = new ArrayList<>();
        sensor2.setDatos(datosSensor2);
        System.out.println("\t Dato 1: 22.1  -> " + estancia1.nuevoDato("101", 22.1f));
        System.out.println("\t Dato 2: -22.1 -> " + estancia1.nuevoDato("101", -22.1f));
        System.out.println("\t Dato 3: 22.5  -> " + estancia1.nuevoDato("101", 22.5f));
        System.out.println("\t Dato 4: 22.4  -> " + estancia1.nuevoDato("101", 22.4f));
        System.out.println("\t Dato 5: 22.9  -> " + estancia1.nuevoDato("101", 22.9f));
        System.out.println("\t Dato 6: 21.2  -> " + estancia1.nuevoDato("101", 21.2f));
        System.out.println("\t Dato 7: 21.5  -> " + estancia1.nuevoDato("101", 21.5f));
        System.out.println("\t Dato 8: 21.1  -> " + estancia1.nuevoDato("101", 21.1f));
        System.out.println("\t Dato 9: 20.9  -> " + estancia1.nuevoDato("101", 20.9f));
        System.out.println("\t Dato 10: -23.1-> " + estancia1.nuevoDato("101", -23.1f));
        System.out.println("\t Dato 11: 22.8 -> " + estancia1.nuevoDato("101", 22.8f));
        System.out.println("\t Dato 12: 23.2 -> " + estancia1.nuevoDato("101", 23.2f));

        System.out.println("Sensor3:");
        System.out.println("- rango -> [" + sensor3.limiteInferior() + ", " + sensor3.limiteSuperior() + "]");
        ArrayList<Float> datosSensor3 = new ArrayList<>();
        sensor3.setDatos(datosSensor3);
        System.out.println("\t Dato 1: 21.4   -> " + estancia1.nuevoDato("200", 21.4f));
        System.out.println("\t Dato 2: -21.3  -> " + estancia1.nuevoDato("200", -21.3f));
        System.out.println("\t Dato 3: 21.2   -> " + estancia1.nuevoDato("200", 21.2f));
        System.out.println("\t Dato 4: -21.2  -> " + estancia1.nuevoDato("200", -21.2f));
        System.out.println("\t Dato 5: 21.2   -> " + estancia1.nuevoDato("200", 21.2f));
        System.out.println("\t Dato 6: 21.5   -> " + estancia1.nuevoDato("200", 21.5f));
        System.out.println("\t Dato 7: 22.3   -> " + estancia1.nuevoDato("200", 22.3f));
        System.out.println("\t Dato 8: 21.8   -> " + estancia1.nuevoDato("200", 21.8f));
        System.out.println("\t Dato 9: 22.1   -> " + estancia1.nuevoDato("200", 22.1f));
        System.out.println("\t Dato 10: 21.7  -> " + estancia1.nuevoDato("200", 21.7f));
        System.out.println("\t Dato 11: -21.9 -> " + estancia1.nuevoDato("200", -21.9f));
        System.out.println("\t Dato 12: 22.5  -> " + estancia1.nuevoDato("200", 22.5f));

        System.out.println("Sensor4:");
        System.out.println("- rango -> [" + sensor4.limiteInferior() + ", " + sensor4.limiteSuperior() + "]");
        ArrayList<Float> datosSensor4 = new ArrayList<>();
        sensor4.setDatos(datosSensor4);
        System.out.println("\t Dato 1: 10.1  -> " + estancia1.nuevoDato("201", 10.1f));
        System.out.println("\t Dato 2: 10.1  -> " + estancia1.nuevoDato("201", 10.1f));
        System.out.println("\t Dato 3: -5.2  -> " + estancia1.nuevoDato("201", -5.2f));
        System.out.println("\t Dato 4: 30.6  -> " + estancia1.nuevoDato("201", 30.6f));
        System.out.println("\t Dato 5: 37.8  -> " + estancia1.nuevoDato("201", 37.8f));
        System.out.println("\t Dato 6: 45.8  -> " + estancia1.nuevoDato("201", 45.8f));
        System.out.println("\t Dato 7: 50.2  -> " + estancia1.nuevoDato("201", 50.2f));
        System.out.println("\t Dato 8: 52.1  -> " + estancia1.nuevoDato("201", 52.1f));
        System.out.println("\t Dato 9: 46.3  -> " + estancia1.nuevoDato("201", 46.3f));
        System.out.println("\t Dato 10: -10.3-> " + estancia1.nuevoDato("201", -10.3f));
        System.out.println("\t Dato 11: 89.2 -> " + estancia1.nuevoDato("201", 89.2f));
        System.out.println("\t Dato 12: 34.3 -> " + estancia1.nuevoDato("201", 34.3f));


        //f. Mostrar por pantalla la representación en texto de los sensores creados en (a).
        System.out.println("APARTADO F) -----------------------------------------------------------------------------------------------------------");
        System.out.println(sensor1.toString());
        System.out.println(sensor2.toString());
        System.out.println(sensor3.toString());
        System.out.println(sensor4.toString());

        //g. Mostrar por pantalla la representación en texto de estancia1.
        System.out.println("APARTADO G) -----------------------------------------------------------------------------------------------------------");
        float coste = estancia1.actualizarCoste();
        estancia1.setCoste(coste);
        System.out.println(estancia1.toString());

        //h. En la estancia1, dar de alta a los sensores sensor5, sensor6 y sensor7 con los
        //argumentos especificados en el fichero Excel, indicando si el sensor se ha dado de alta
        //correctamente o no. Se deberá utilizar el método de la clase Estancia cuyos argumentos son los
        //valores de los atributos de los sensores.
        System.out.println("APARTADO H) -----------------------------------------------------------------------------------------------------------");

        float[] rango5 =  {0f, 118f};
        Sensor sensor5 = new Sensor("202", "sonido", rango5,28.4f);
        float[] rango6 =  {0f, 100f};
        Sensor sensor6 = new Sensor("301", "humedad", rango6, 34.3f);
        float[] rango7 =  {0f, 100f};
        Sensor sensor7 = new Sensor("302", "humedad", rango7, 42.5f);

        System.out.println("Sensor1: " + estancia1.darAlta(sensor5));
        System.out.println("Sensor2: " + estancia1.darAlta(sensor6));
        System.out.println("Sensor3: " + estancia1.darAlta(sensor7));

        //i. Mostrar por pantalla los límites superiores e inferiores de los rangos de valores para todas las
        //instancias creadas en (h).


        //j. Mostrar por pantalla la representación en texto de los sensores creados en (h).


        //k. Mostrar por pantalla la representación en texto de estancia1.


        //l. Introducir los valores de los sensores creados en (h) que están indicados en el fichero Excel, usando
        //el método nuevoDato de la clase Estancia y mostrando por pantalla si cada dato ha sido
        //introducido correctamente o no.


        //m. Mostrar por pantalla la representación en texto de estancia1.


        //n. Mostrar por pantalla las características de los sensores de "temperatura" que hay en estancia1.


        //o. Mostrar por pantalla las características de los sensores de "sonido" que hay en estancia1.


        //p. Mostrar por pantalla las características del sensor de "humedad" que ha capturado el valor máximo
        //y el mínimo en la estancia1.


        //q. Para el sensor cuyo id es 301, mostrar por pantalla la lista de valores mayores de 33.


        //r. En estancia1, dar de alta al sensor sensor8 con los argumentos especificados en el fichero
        //Excel que se adjunta, indicando si el sensor se ha dado de alta correctamente o no. Se deberá
        //utilizar el método de la clase Estancia cuyos argumentos son los valores de los atributos del
        //sensor.


        //s. Mostrar por pantalla la representación en texto de estancia1.



    }

}
