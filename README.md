
Socket Math
====================================


## Introducción y descripción de la problemática

El proyecto presente consta en el diseño solución e implementación de una interfaz gráfica, sockets y el uso de una lista doblemente enlazada, la que al ser una estructura de datos, aydará a almacenar información necesaria que se utilizará para la realización del juego de mesa multijudor Socket Math, el cual se trata de un juego, que tendrá como principal objetivo, resolver operaciones matemáticas simples hasta llegar al final del tablero; el cual está desarrolado en el lenguaje de progrmacion Java (jdk 16.0).

Dicho juego tendrá su respectivo menú, en donde se encontrará una variedad de botones, con los cuales el usuario podrá interactuar con el programa.

Al ser un juego multijugador, habrán dos pantallas emergentes para los dos jugadores, a este punto los jugadores tendrán la posibilidad de elegir entre generar una pardita o unirse a una.

Una vez los dos jugadores estén en una misma partida se deplegará la pantalla de juego, la cual contará con un tablero y además de esto en pantalla se podrá ver el progreso de cada uno de los jugadores (Su respectiva posición en el tablero y en la casilla que se encuentra). Sin contar que está pantalla tambien cuenta con un dado, el cual genera números random en un rango de 1 a 3, dependiento de que numero salga en el dado, el jugador 1 o el jugador 2, dependiendo del turno se moverá n casillas hacía adelante o hacía atrás.

Cada casilla presentará un atributo de tres que ya están establecidos, correspondinetes a la casilla de reto, trampa y reto. 


* **Casilla de reto**

Esta casilla es una de las más comunes dentro del tablero, su proposito es ponerle un reto matemático al otro jugador. si este falla su respuesta se devolverá una casilla atrás, en caso de acierte, mantendrá su pocisión actual, pero independientemente si el jugador en cuestión falla o acierta la pregunta, el otro jugador avanzará una casilla.
Al caer en esta casilla, se desplegará una pantalla emergente con el problema en cuestión y con un txtbox que permitirá escribir la respuesta y un botón para poder enviarla.

* **Casilla tunel**

Al caer en esta casilla, esta permite que el jugador pueda avanzar entre una y tres casillas hacia adelante, el movimiento depederá del numero random que se genere en ese momento.

* **Casilla trampa**

Esta casilla funciona de la misma manera que la de tunel, pero en vez de avanzar, se retrocede en las casillas del tablero

## Diagrama de clases

![UMLSocketMath ](https://user-images.githubusercontent.com/83249731/134855213-af958f90-f584-47f3-8d32-6893f596ee5c.png)

## Lista doblemente enlazada

Para la funcionalidad de las casillas se utilizó una lista doblemente enlazada. Esta consta de nodos, que para efectos de esta implementación contienen el nombre del tipo de casilla (sea reto, túnel o trampa) y la información que necesita cada tipo de casilla para su funcionamiento, como la operación de una casilla reto o la cantidad de espacios que avanza el jugador al caer en una casilla túnel o trampa. Además, cada nodo contiene los datos que indican dónde se encuentra en la memoria el nodo que le sigue y el nodo que le antecede. Esto se hace para que el jugador pueda moverse a las casillas que le siguen y devolverse cuando sea necesario.

Cada vez que se genera una lista al principio de un juego, el programa genera aleatoriamente cada nodo. Para que se mantenga la proporción de 50% reto y 50% trampa y túnel, la generación verifica cuántas casillas del tipo reto, túnel y trampa se han creado, si algún tipo ya creó el máximo posible, se genera otro tipo de casilla distinta que aún no tenga el máximo. El máximo posible en un tablero 4x4 son 8 casillas reto, 4 túnel y 4 trampa.

* **ListGeneration**

        public DoublyLinkedList random() {
            Random random = new Random();
            for (int i = 0; i < 16; i++) {
                int num = random.nextInt(3);
                System.out.println(num);
                if (num == 0 && this.casillas_reto < 8) {
                    int num_opt = random.nextInt(3);
                    String opt = null;
                    if (num_opt == 0) {
                        opt = "+";
                    } else if (num_opt == 1) {
                        opt = "-";
                    } else if (num_opt == 2) {
                        opt = "*";
                    } else if (num_opt == 3) {
                        opt = "/";
                    }
                    board.addFieldAtEnd("Reto", opt, random.nextInt(49)+1, random.nextInt(49)+1, 0);
                    this.casillas_reto++;
                } else if (num == 1 && casillas_trampa < 4) {
                    board.addFieldAtEnd("Trampa", null, 0, 0, random.nextInt(2)+1);
                    this.casillas_trampa++;
                } else if (num == 2 && casillas_tunel < 4) {
                    board.addFieldAtEnd("Tunel", null, 0, 0, random.nextInt(2)+1);
                    this.casillas_tunel++;
                } else {
                    if (this.casillas_reto < 8) {
                        int num_opt = random.nextInt(3);
                        String opt = null;
                        if (num_opt == 0) {
                            opt = "+";
                        } else if (num_opt == 1) {
                            opt = "-";
                        } else if (num_opt == 2) {
                            opt = "*";
                        } else if (num_opt == 3) {
                            opt = "/";
                        }
                        board.addFieldAtEnd("Reto", opt, random.nextInt(49)+1, random.nextInt(49)+1, 0);
                        this.casillas_reto++;
                    } else if (casillas_trampa < 4) {
                        board.addFieldAtEnd("Trampa", null, 0, 0, random.nextInt(2)+1);
                        this.casillas_trampa++;
                    } else if (casillas_tunel < 4) {
                        board.addFieldAtEnd("Tunel", null, 0, 0, random.nextInt(2)+1);
                        this.casillas_tunel++;
                    }
    

 * Cada vez que se genera una lista al principio de un juego, el programa genera aleatoriamente cada nodo. Esto se hace con un random del 0 al 2, si sale 0 se genera una casilla tipo reto, si sale 1 se genera una casilla trampa y si sale 2 se genera una casilla túnel. Para que se mantenga la proporción de 50% reto y 50% trampa y túnel, la generación verifica cuántas casillas del tipo reto, túnel y trampa se han creado, si algún tipo ya creó el máximo posible, se genera otro tipo de casilla distinta que aún no tenga el máximo. El máximo posible en un tablero 4x4 son 8 casillas reto, 4 túnel y 4 trampa. Para generar una operación de una casilla reto se utiliza un random entero del 1 a 50 que se guarda como “a” y se vuelve a hacer lo mismo para “b”. El operador se selecciona con un random del 0 al 3, si sale 0 el operador es “+”, si sale 1 se selecciona “-“, si sale 2 se selecciona “*” y si sale 3 se selecciona “/”, el operador se guarda como un string en el nodo. Finalmente, para generar la cantidad de espacios que se mueve un jugador cuando cae en una casilla trampa o túnel se utiliza un random entero del 1 al 3 que se guarda en el nodo.

 * **actionPerformedMenu**

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == BotonJugar) {
                ventanap.dispose();
                VentanaJuego ventanaJuego = new VentanaJuego();
            }
            if (e.getSource() == BotonCrear) {
                conexion = "servidor";
                Nombre = Usertxtbox.getText();
                Servidor servidor = new Servidor();
                new Thread(servidor).start();
            }
            if (e.getSource() == BotonUnirse) {
                conexion = "cliente";
                Nombre2 = Usertxtbox.getText();
                Cliente cliente = new Cliente();
                new Thread(cliente).start();
                }
        }

Este método permite que al clickear los botones presentes en la pantalla principal se pueda navegar por al rededor del juego.


* **actionPerformedJuego**

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == BotonMenu) {
                ventanaj.dispose();
                VentanaPrincipal.running = false;
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
            }

            int NumRandom = (int) (Math.random() * 3 + 1);
            if(e.getSource() == BLanzarDado & NumRandom == 1 & varNumDado <= 16){
                varNumDado = 1;
                if (Objects.equals(VentanaPrincipal.conexion, "servidor")) {
                    Servidor.varPos1 += 1;
                } else if (Objects.equals(VentanaPrincipal.conexion, "cliente")) {
                    Cliente.varPos2 += 1;
                }
                Espacio.setText(": 1");

            }

            else if(e.getSource() == BLanzarDado & NumRandom == 2 & varNumDado <= 16){
                varNumDado = 2;
                if (Objects.equals(VentanaPrincipal.conexion, "servidor")) {
                    Servidor.varPos1 += 2;
                } else if (Objects.equals(VentanaPrincipal.conexion, "cliente")) {
                    Cliente.varPos2 += 2;
                }
                Espacio.setText(": 2");

            }


            else if(e.getSource() == BLanzarDado & NumRandom == 3 & varNumDado <= 16){
                varNumDado = 3;
                if (Objects.equals(VentanaPrincipal.conexion, "servidor")) {
                    Servidor.varPos1 += 3;
                } else if (Objects.equals(VentanaPrincipal.conexion, "cliente")) {
                    Cliente.varPos2 += 3;
                }
                Espacio.setText(": 3");
                Posicion1.setText("Posicion: "+ Servidor.varPos1);
                Posicion2.setText("Posicion: "+ Servidor.varPos2);


            }

            if (Objects.equals(VentanaPrincipal.conexion, "servidor")) {
                if (Servidor.varPos1 >= 16 || Servidor.varPos2 >= 16){
                    if (Servidor.varPos1 >= 16) {
                        JOptionPane.showMessageDialog(null, "¡Ganaste!");
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Perdiste!");
                    }
                    ventanaj.dispose();
                    VentanaPrincipal.running = false;
                }
            } else if (Objects.equals(VentanaPrincipal.conexion, "cliente")) {
                if (Cliente.varPos1 >= 16 || Cliente.varPos2 >= 16){
                    if (Cliente.varPos2 >= 16) {
                        JOptionPane.showMessageDialog(null, "¡Ganaste!");
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Perdiste!");
                    }
                    ventanaj.dispose();
                    VentanaPrincipal.running = false;
                }
            }

            varNumDado = 0;

Este indiscutiblemente es uno de los algoritmos mas importantes en el código ya que por medio de este metodo se permite ver el progreso de los jugadores en pantalla, sin con contar que es el que acciona tanto los movimientos de los dados presentes en la pantalla del juego, permite visualizar en que casilla está el jugador y su posición en el tablero de juego. Además gracias a este método es posible ver cuándo el juegador gana o pierde.


* **Algoritmos referentes a Json**

         public static JsonNode parse(String jsonSource) throws JsonProcessingException{
            return objectMapper.readTree(jsonSource);
         }
        public static JsonNode toJson(Object o) throws JsonProcessingException {
            System.out.println(objectMapper.canSerialize(DoublyLinkedList.class));
                return objectMapper.valueToTree(o);
        }

            public static String generateString(JsonNode node, boolean pretty) throws JsonProcessingException{
                 ObjectWriter objectWriter = objectMapper.writer();
                     if(pretty){
                        objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
                     }
                return objectWriter.writeValueAsString(node);
            }

            public static String ReadJson(String file) {
                String json = new String();
                    try{
                    BufferedReader br = new BufferedReader(new FileReader(file));

                    try{
                     StringBuilder sb = new StringBuilder();
                     String line = br.readLine();

                     while (line != null){
                         sb.append(line);
                            sb.append(System.lineSeparator());
                            line = br.readLine();
                      }
                    json = sb.toString();

                    } finally {
                       br.close();
                 }

                 return json;

              }catch (Exception e){
               e.printStackTrace();
             }

            return json;
         }

La secuencia de algoritmos anteriores hacen referencia al movimiento de archivos, objetos y nodos por medio de Json, esto se realiza de manera secuencial a razón de que se puede convertir un objeto a un JsonNode, de este a un Json String para finalmente leerse como un string y así a viceversa.




## Problemas encontrados

Aunque la mayoría de los problemas presentes en el proyecto se dieron por parte del código y su resolución, tuvimos inconvenientes con github, dado que en ciertos casos habían conflictos prensentes en los merge quue se realizaban.

Una de las complicaciones mas grandes que se presentaron a la hora de realizar el proyecto fue el uso de diferentes IDE´S dado que unos se estaba trabajando en vscode y en Intellij a la vez, lo que generaba carpetas de archivos internos provenientes de dos ides diferentes y a la hora de mezclar  el .idea con el .vscode, no se podía compilar el proyecto.

Se tuvo que exportar todo el proyecto a un IDE con una extencion diferente, dado que cuando se empezó se guardó en un JAVA propocionado por IntelliJ, pero mas tarde el grupo de trabajo se dio cuenta de que para poder pasar objetos por Json, se necesitaban usar dependencias propias de un proyecto con extencion MAVEN, por lo que eso hizo que la elavoración del proyecto se atrasara considerablemente.
## Conclusiones

**1.** Al realizar la documentación interna utilizando la herramienta de JavaDocs, se reconoce la importancia de hacerla lo mas clara y lo más detallada posible, ya que es necesario para el entendimiento de las demás personas a la hora de leer el código realizado, teniendo una vista de los constructores, variables y metodos presentes en cada clase.

**2.** Se concluye el proyecto con la idea de que al crear algo grande a como lo es un videojuego, con cosas relativamente básicas y sin tener muchos recursos o mucho conocimiento de programación, se pueden lograr cosas muy provechosas e impresionantes como lo es un juego multijugador.

**3.** En la elaboración de un proyecto se da la oportunidad de adquirir nuevos conocimientos, nuevas formas de pensar y desarrollar la lógica computacional y de programación, con el fin de poder realizar a futuro, proyectos aún más avanzados y con más eficiencia mayor.

**4.** La mente de los estudiantes durante la confección de un código debe de permanecer siempre abierta, ser dinámica y adoptando una manera de mantener funcionales sus capacidades de pensamiento lógico y matemático, dentro del cual se reta a la inteligencia a al desarrollo en programación de los estudiantes.



