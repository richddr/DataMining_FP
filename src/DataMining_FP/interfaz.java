/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataMining_FP;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
/**
 *
 * @author Richard Garcia
 *         Ricardo Batista
 */
public class interfaz extends javax.swing.JFrame {
    //Para el arbol/weka library    
    static BufferedReader reader;
    static Instances data ;
    static J48 tree;
    
    //Para el juego
    static int puntos_acumulados = 0;
    static boolean ult_prediccion = false;//para fines de bonos
    static String actividad_anterior = null;
    public static String[] actividades = {"Walking", "Jogging", "Sitting", "Standing"};
    /*
    Walking
    Jogging
    Upstairs
    Downstairs
    Sitting
    Standing
    */
    //Para la captura de datos
    static int puerto = 1085;
    static int size = 111;
    static final int numero_de_instancias = 200;
    
    static float[] accelerometer_x_array = new float[numero_de_instancias];
    static float[] accelerometer_y_array = new float[numero_de_instancias];
    static float[] accelerometer_z_array = new float[numero_de_instancias];
    static long[] tiempo_de_lecturas = new long[numero_de_instancias];
            
    /**
     * Creates new form interface GUI
     */
    public interfaz() {
        initComponents();
        inicializando_weka();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        actividad_actual = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        prediccion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_puntaje = new javax.swing.JTextField();
        lbl_tiempo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel9.setFont(new java.awt.Font("Segoe WP", 3, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 255));
        jLabel9.setText("SIMON DICE!");
        jLabel9.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("SIMON DICE QUE:");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 255, 0));
        jButton1.setText("INICIO!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setText("PARAR!");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        actividad_actual.setEditable(false);
        actividad_actual.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        actividad_actual.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("PREDICCION:");

        prediccion.setEditable(false);
        prediccion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        prediccion.setFocusable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("PUNTAJE:");

        tf_puntaje.setEditable(false);
        tf_puntaje.setFocusable(false);
        tf_puntaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_puntajeActionPerformed(evt);
            }
        });

        lbl_tiempo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_tiempo.setForeground(new java.awt.Color(0, 0, 255));
        lbl_tiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_tiempo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_puntaje, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(prediccion, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 129, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(actividad_actual, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbl_tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(actividad_actual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(prediccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(64, 64, 64))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tf_puntaje, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        final String act_curr = SimonDice();//Se elije la actividad aleatoria
        actividad_anterior = act_curr;
        prediccion.setText("");//borramos lo que dice el txtbx prediccion, si tenia algo
        switch (act_curr) {
            case "Walking":
                actividad_actual.setText("Camines!");
                break;
            case "Jogging":
                actividad_actual.setText("Trotes!");
                break;
            case "Sitting":
                actividad_actual.setText("te quedes sentado!");
                break;
            case "Standing":
                actividad_actual.setText("te quedes parado!");
                break;
        }
        new Thread(new Runnable() {
            public void run() {
                //Se llama la funcion que capturara los datos del smartphone
                CapturaDatos();
                //Se evalua a ver si se predijo bien
                Evaluacion_Actividad(act_curr);
            }
        }).start();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void displayTime(int tiempo){
        tiempo /= 20;
        lbl_tiempo.setText(String.valueOf(tiempo));
        lbl_tiempo.setForeground(Color.GREEN);
    }
    
    public void CapturaDatos(){
        int time_simulator = 200;
        try{
            // La IP es la local, el puerto es en el que el servidor esté escuchando.
            DatagramSocket socket = new DatagramSocket(puerto);
            
            // Un DatagramPacket para recibir los mensajes
            DatagramPacket dato = new DatagramPacket(new byte[size], size);
            
            displayTime(time_simulator);//Para simular un countdown
            time_simulator -= 20;
            
            for (int i = 0; i < numero_de_instancias; i++) {
                socket.receive(dato);
                //System.out.print("Recibido dato de "+ dato.getAddress().getHostName() + " : ");
                byte[] arreglo = dato.getData();
                tiempo_de_lecturas[i] = System.currentTimeMillis();//lectura ne milisegundos

                byte[] accelerometer_x_bytes = Arrays.copyOfRange(arreglo, 4, 8);//4, 8
                byte[] accelerometer_y_bytes = Arrays.copyOfRange(arreglo, 8, 12);
                byte[] accelerometer_z_bytes = Arrays.copyOfRange(arreglo, 12, 16);

                accelerometer_x_array[i] = ByteBuffer.wrap(accelerometer_x_bytes).order(ByteOrder.LITTLE_ENDIAN).getFloat()*10f;
                accelerometer_y_array[i] = ByteBuffer.wrap(accelerometer_y_bytes).order(ByteOrder.LITTLE_ENDIAN).getFloat()*10f;
                accelerometer_z_array[i] = ByteBuffer.wrap(accelerometer_z_bytes).order(ByteOrder.LITTLE_ENDIAN).getFloat()*10f;

                //Imprimiendo cada una de las lecturas
                System.out.println(i + 1 + " [X=" + accelerometer_x_array[i] + "]   \t\t\t" + "[Y=" + accelerometer_y_array[i] + "]   \t\t\t" + "[Z=" + accelerometer_z_array[i] + "]");
                
                if(time_simulator == (numero_de_instancias - i))
                {
                    displayTime(time_simulator);
                    time_simulator -= 20;
                }
            }
            socket.close();//CERRAMOS EL SOCKET
        }
        catch(Exception e){
            System.out.println("Error capturando los datos del smartphone");
        }
    }
        
    public static void inicializando_weka() {
        //Inicializando los objetos de weka
        try {
            reader = new BufferedReader(new FileReader("WISDM_ar_v1.1_transformed.arff"));
            data = new Instances(reader);
            reader.close();
            
            // especificando el atributo de clase
            data.setClassIndex(data.numAttributes() - 1);

            String[] options = new String[1];
            options[0] = "-U";            // unpruned tree
            tree = new J48();         // new instance of tree
            tree.setOptions(options);     // set the options
            tree.buildClassifier(data);   // build classifier
        } catch (Exception e) {
            System.out.println("Error inicializando los objetos de weka");
        }
        System.out.println("Weka inicio bien");
    }
    
    public static float[] maxmin(float[] arreglo){
       
       float[] resultados = new float[2];
       
       for(int i=0;i<arreglo.length;i++){
           if(i==0){
               resultados[0] = arreglo[i];
               resultados[1] = arreglo[i];
           }
           else{
               if(arreglo[i] > resultados[0]) resultados[0] = arreglo[i];//Mayor
               if(arreglo[i] < resultados[1]) resultados[1] = arreglo[i];//Menor
           }
       }
       return resultados;
   }
       
   public static float[] bins(float[] rango_maxmin, float[] lecturas_del_eje){
       
       float[] bins = new float[10];
       for(int i=0; i<10 ;i++) bins[i]=0;//inicializarlos en 0
       
       float rango = (rango_maxmin[0]-(rango_maxmin[1]))/10;
       
       
       for(int i=0;i<lecturas_del_eje.length;i++){
           for(int j=0;j<10;j++){
               
               //preguntar por los extremos primero
               if(lecturas_del_eje[i] == rango_maxmin[1]){
                   bins[0]++;
                   break;
               }
               else if(lecturas_del_eje[i] == rango_maxmin[0]){
                   bins[9]++;
                   break;
               }
               else if(lecturas_del_eje[i] > (rango_maxmin[1]+(j*rango)) && lecturas_del_eje[i] < (rango_maxmin[1]+((j+1)*rango))){
                   bins[j] += 1;
                   break;
               }
           }
       }
       
       for(int i=0;i<10;i++) bins[i]/= 200;
       return bins; 
   }
   
   public static float tiempo_entre_picos(float[] lecturas_del_eje,long[] tiempos){
       long resultado = 0;
       List indices_de_picos_dentro_del_umbral = new LinkedList();
       
       float[] extremos = maxmin(lecturas_del_eje);
       float factor = 0.10f;//threshold
       
       float variacion_de_umbral = extremos[0]*factor;
       if(variacion_de_umbral<0) variacion_de_umbral *= -1;//hace que siempre sea positivo
       
       //System.out.println("[Mayor = "+extremos[0]+", Variacion umbral"+variacion_de_umbral+"]\n\n");
       for(float umbral =(extremos[0]-variacion_de_umbral) ; umbral >= extremos[1] ;  ){
           //System.out.println("--->valor de l umbra = "+umbral+"]");
           for(int j=0;j<lecturas_del_eje.length;j++){ // j indice de los valores de los tiempos 
               if(lecturas_del_eje[j] >= umbral )
                   indices_de_picos_dentro_del_umbral.add(j);//Se encontró un valor mayor al umbra, añadie el indice a la lista
            }
           if(indices_de_picos_dentro_del_umbral.size() >= 3)//si la lista contiene por lo menos 3 valores mayores al umbral, pasar al siguiente paso
               break;
           else
               indices_de_picos_dentro_del_umbral.clear();//borrar los valores, para que entre de izquierda a derecha
           
           factor += 0.01f;//Se incrementa el threshold
           variacion_de_umbral = extremos[0]*factor;
           
           //Tomando en cuenta valores maximos positivos/negativos
           if(extremos[0]>=0)
               umbral = (extremos[0]-variacion_de_umbral);
           else
               umbral = (extremos[0]+variacion_de_umbral);
       }
       
       /*Si en la primera instancia, el threshold de 10% resulta ser menor
         que el "menor" el for nunca se ejecutara,por lo tanto se retorna
         cero.
       */
       if(indices_de_picos_dentro_del_umbral.isEmpty())
           return 0.0f;
       
       int[] indices = new int[indices_de_picos_dentro_del_umbral.size()];
       System.out.println("----------------------");
       //sacando los indices de la lista y convirtiendolos en un arrelgo de enteros
       for (int i = 0; i <indices_de_picos_dentro_del_umbral.size() ; i++) {
           indices[i] = Integer.parseInt(indices_de_picos_dentro_del_umbral.get(i).toString());
           System.out.println(indices[i]);
       }
       System.out.println("----------------------");
       for(int i=0;i<indices.length-1;i++)
           resultado += (tiempos[indices[i+1]]-tiempos[indices[i]]);//siguiente - actual
       
       resultado /= indices.length;   
       return resultado;
   }

   public static float get_avg(float[] lecturas_del_eje)
   {
       float avg = 0;

       //foreach en java
       for(float i : lecturas_del_eje)
           avg += i;
       avg /= lecturas_del_eje.length;
       
       avg = avg<0 ? 0: avg; //si es negativo ponerlo en 0, de lo contrario dejarlo igual.
       
       return avg;
   }

   public static float get_std_deviation(float[] lecturas_del_eje)
   {
       //primero calculamos el average
       float avg = get_avg(lecturas_del_eje);

       //luego calculamos la diferencia de cada valor con el avg y se eleva al cuadrado
       float std_dev = 0;
       for(float i : lecturas_del_eje)
           std_dev += Math.pow((i - avg), 2);

       //luego se le saca el average nuevamente y se le saca la raiz cuadrada.
       std_dev = (float)Math.sqrt((std_dev/lecturas_del_eje.length));
       return std_dev;
   }

   public static float get_avg_absolute_difference(float[] lecturas_del_eje)
   {
       //se calcula el average de las 200 medidas del eje a analizar
       float avg = get_avg(lecturas_del_eje);
       float abs_avg_diff = 0;
       for(float i : lecturas_del_eje)
           abs_avg_diff += Math.abs((i - avg));
       abs_avg_diff/=lecturas_del_eje.length;
       return abs_avg_diff;
   }

   public static float get_avg_resultant_acceleration(float[] eje_x, float[] eje_y, float[] eje_z)
   {
       float avg_resultant_acceleration = 0;
       for (int i = 0; i < eje_x.length; i++)
           avg_resultant_acceleration += Math.sqrt( (Math.pow(eje_x[i],2) + Math.pow(eje_y[i],2) + Math.pow(eje_z[i],2)));
       avg_resultant_acceleration /= eje_x.length;
       return avg_resultant_acceleration;
   }
    
    private String SimonDice(){
        //Esta funcion retorna un random de las actividad a realizar.
      
        Random rand = new Random();
        String act_curr; 
        
        //Si es la primera vez que se inicia el juego
        if(actividad_anterior == null)
            return actividades[rand.nextInt(actividades.length)];
        do{
           act_curr = actividades[rand.nextInt(actividades.length)];
        }while(actividad_anterior.equals(act_curr));
        return act_curr;
    }
    
    private void Evaluacion_Actividad(String SimonDijo){
        //Esta funcion recibe la actividad aleatoria de que genero SimonDice()
        //Luego se evalua con el arbol para ver si se predice correctamente y en base
        //a esto se le atriburan puntos al jugador.
        String resultado_prediccion = null;
        try {
            int num = 1150;//Un numero cualquiera
            Instance nueva_entrada = data.instance(num);//Crear una copia

            //Modificando los valores
            //Agregar los valores de los bins
            float[] bins_result_x = bins(maxmin(accelerometer_x_array), accelerometer_x_array);
            float[] bins_result_y = bins(maxmin(accelerometer_y_array), accelerometer_y_array);
            float[] bins_result_z = bins(maxmin(accelerometer_z_array), accelerometer_z_array);
            
            for (int i = 0; i < 10; i++) {
                nueva_entrada.setValue(i, bins_result_x[i]);//bins_x
                nueva_entrada.setValue(i + 10, bins_result_y[i]);//bins_y
                nueva_entrada.setValue(i + 20, bins_result_z[i]);//bins_z
            }

            //AVG
            nueva_entrada.setValue(30,get_avg(accelerometer_x_array));
            nueva_entrada.setValue(31,get_avg(accelerometer_y_array));
            nueva_entrada.setValue(32,get_avg(accelerometer_z_array));

            //PEAK
            nueva_entrada.setValue(33,tiempo_entre_picos(accelerometer_x_array,tiempo_de_lecturas));
            nueva_entrada.setValue(34,tiempo_entre_picos(accelerometer_y_array,tiempo_de_lecturas));
            nueva_entrada.setValue(35,tiempo_entre_picos(accelerometer_z_array,tiempo_de_lecturas));

            //ABSOLDEV
            nueva_entrada.setValue(36,get_avg_absolute_difference(accelerometer_x_array));
            nueva_entrada.setValue(37,get_avg_absolute_difference(accelerometer_y_array));
            nueva_entrada.setValue(38,get_avg_absolute_difference(accelerometer_z_array));

            //STANDDEV
            nueva_entrada.setValue(39,get_std_deviation(accelerometer_x_array));
            nueva_entrada.setValue(40,get_std_deviation(accelerometer_y_array));
            nueva_entrada.setValue(41,get_std_deviation(accelerometer_z_array));

            //RESULTANT
            nueva_entrada.setValue(42,get_avg_resultant_acceleration(accelerometer_x_array,accelerometer_y_array,accelerometer_z_array));
            double clsLabel = tree.classifyInstance(nueva_entrada); // Clasificando una nueva instancia
            resultado_prediccion = data.classAttribute().value((int) clsLabel);
            
            //Se actualiza lo que predijo en el textfield
            prediccion.setText(resultado_prediccion);
            //System.out.println("\n\n\n[resultado = "+resultado_prediccion+"]");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al predecir la instancia capturada");
        }
        
        //verificamos si el algoritmo logro predecir la actividad correctamente
        if(SimonDijo.equals(resultado_prediccion)){//Predijo correctamente!
            if(!ult_prediccion)//Si en la ultima vez que jugo no se predijo correctamente solo sumamos un punto.
                puntos_acumulados+=15;
            else//se ha predecido bien >= 2 veces
                puntos_acumulados+=30;
        }
        else{//No se predijo bien
            if((puntos_acumulados-4) > 0)//si no tiene puntos acumulados, no se le resta nada, de lo contrario se le quita un punto
                puntos_acumulados-=4;
            else
                puntos_acumulados = 0;
        }
        tf_puntaje.setText(String.valueOf(puntos_acumulados));
        
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Reiniciamos los valores como si se empezara de nuevo todo
        puntos_acumulados = 0;
        tf_puntaje.setText(String.valueOf(puntos_acumulados));
        ult_prediccion = false;
        actividad_anterior = null;
        lbl_tiempo.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tf_puntajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_puntajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_puntajeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actividad_actual;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbl_tiempo;
    public static javax.swing.JTextField prediccion;
    public static javax.swing.JTextField tf_puntaje;
    // End of variables declaration//GEN-END:variables
}
