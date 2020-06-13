/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * https://www.pokerstars.com/espanol/poker/games/rules/hand-rankings/?no_redirect=1
 */
import java.security.SecureRandom;
/**
 *
 * @author eedua
 */
public class PaqueteDeCartas {
    /**
     * Arreglo de objetos Carta que formaran el juego total de baraja
     */
    private Carta[] paquete;
    /**
     * Posicion de la carta actual que esta por sacarse del mazo
     */
    private int cartaActual;
    /**
     * Cantidad de cartas que conforman el mazo
     */
    private static final int NUMERO_DE_CARTAS = 52;
    /**
     * Sirve para barajar las cartas
     */
    private static final SecureRandom numerosAleatorios = new SecureRandom();
    
    public PaqueteDeCartas(){
        String[] caras = {"As", "Dos", "Tres", "Cuatro", "Cinco", "Seis",
            "Siete", "Ocho", "Nueve", "Diez", "Joker", "Reina", "Rey"};
        String[] palos = {"Corazones", "Diamantes", "Treboles", "Espadas"};
        
        paquete = new Carta[NUMERO_DE_CARTAS];//crea 52 objetos Carta en el arreglo
        cartaActual = 0;
        
        for(int cuenta = 0; cuenta < paquete.length; cuenta++){//Recorre las 52 cartas
            paquete[cuenta] = new Carta(caras[cuenta % 13], palos[cuenta / 13]);//Asigna caras de As a Rey 4 veces y palos de Corazones a Espadas 13 veces
        }
    }
    /**
     * De un mazo ordenado de cartas, se revuelven todas de forma aleatoria
     */
    public void barajar(){
        cartaActual = 0;
        
        for(int primera = 0; primera < paquete.length; primera ++){//recorre las 52 cartas
            int segunda = numerosAleatorios.nextInt(NUMERO_DE_CARTAS);//numero aleatorio menor a 52
            Carta temp = paquete[primera];//asigna la primer carta a la carta temporal
            paquete[primera] = paquete[segunda];//intercambia la segunda carta (numero aleatorio) por la primera
            paquete[segunda] = temp;//asigna la primera al lugar de la segunda
        }
    }
    /**
     * Saca una carta del mazo y la regresa como valor de retorno del metodo,
     * si el mazo esta vacio retorna un null
     * @return una carta o una referencia a null si el mazo se ha quedado sin cartas
     */
    public Carta repartirCarta(){
        if(cartaActual < paquete.length)
            return paquete[cartaActual++];
        else
            return null;
    }
    /**
     * Saca 5 cartas del mazo de cartas
     * @return Carta[] Arreglo de 5 cartas
     */
    public Carta[] repartirMano(){
        int cantidad_de_cartas = 5;
        
        Carta[] mano = new Carta[cantidad_de_cartas];
        for(int carta_actual = 0; carta_actual < cantidad_de_cartas; carta_actual++){
            mano[carta_actual] = repartirCarta();
        }
        return mano;
    }
    /**
     * Muestra las cartas que contiene un arreglo Carta
     * @param cartas Carta[] arreglo de objetos Carta
     */
    public static void mostrarCartas(Carta[] cartas){
        for(Carta carta: cartas){
            System.out.printf("%s, ", carta);
        }
    }
    public static void compararManos(Carta[] manoA, Carta[] manoB){
        if(manoA.length != 5 || manoB.length != 5)
            throw new IllegalArgumentException("Ambas manos deben contener 5 cartas");
        
        int[] a = identificarMano(manoA);
//        for(int i: a){
//            System.out.printf("%d%n", i);
//        }
        int[] b = identificarMano(manoB);
//        for(int i: b){
//            System.out.printf("%d%n", i);
//        }
        
        int mayor = 0;//< el número que tiene el indice mayor
        int indice = 0;//< el indice que contien la jerarquia
        boolean ab = false;//false es a true es b
        for(int i = 0; i < a.length; i++){
            if(a[i] != 0 && indice <= i){
                mayor = a[i];
                indice = i;
                ab = false;
            }
            if(b[i] != 0 && indice <= i){
                mayor = b[i];
                indice = i;
                ab = true;
            }
        }
        System.out.printf("El indice mayor es %d y su valor es %d de la mano %s%n", indice, mayor, ab ? "B": "A");
    }
    /**
     * Dado una mano de cartas (5 cartas) identifica el tipo de juego que se tiene
     * @param cartas Carta[] Arreglo de 5 cartas
     */
    public static int[] identificarMano(Carta[] cartas){
        if(cartas.length != 5)
            throw new IllegalArgumentException("La cantidad de cartas debe ser 5");
        
        int[] palos = new int[]{0, 0, 0, 0};//< variables de identificación de palos
        
        int[] caras = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};//< variables de identificación de caras
        
        for(Carta carta: cartas){
            switch(carta.obtenerPalo()){//< cuenta cantidad de palos
                case "Corazones":
                    palos[0]++;
                    break;
                case "Diamantes":
                    palos[1]++;
                    break;
                case "Treboles":
                    palos[2]++;
                    break;
                case "Espadas":
                    palos[3]++;
                    break;
            }
            
            switch(carta.obtenerCara()){//< identificacion caras
                case "As":
                    caras[0]++;
                    break;
                case "Dos":
                    caras[1]++;
                    break;
                case "Tres":
                    caras[2]++;
                    break;
                case "Cuatro":
                    caras[3]++;
                    break;
                case "Cinco":
                    caras[4]++;
                    break;
                case "Seis":
                    caras[5]++;
                    break;
                case "Siete":
                    caras[6]++;
                    break;
                case "Ocho":
                    caras[7]++;
                    break;
                case "Nueve":
                    caras[8]++;
                    break;
                case "Diez":
                    caras[9]++;
                    break;
                case "Joker":
                    caras[10]++;
                    break;
                case "Reina":
                    caras[11]++;
                    break;
                case "Rey":
                    caras[12]++;
                    break;
            }
        }
        
        int[] gana = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        
        gana[1] = unPar(caras);
        gana[2] = unPar(caras, gana[1]);
        if(gana[1] != 0 && gana[2] != 0)//< hay dos pares
            System.out.printf("Dos pares: el mayor de %d%n", gana[2]);
        
        gana[3] = tercia(caras);
        
        gana[4] = corridaOColor(cartas, palos);
        
        gana[5] = fullHouse(gana[1], gana[3]);
        
        gana[6] = poker(caras);
        
        gana[7] = escalera(cartas, palos);
        
        if(gana[1] == 0 && gana[2] == 0 && gana[3] == 0 && gana[4] == 0 && gana[5] == 0 && gana[6] == 0 && gana[7] == 0){
            gana[0] = cartaMayor(convertirCarasANumeros(cartas));
            System.out.printf("La carta mayor es %d%n", gana[0]);
        }
        
        return gana;
    }
    
    /**
     * Determina si existe exclusivamente un par (que no sea el que se le da como segundo parametro al metodo)
     * en el arreglo de enteros llamado caras
     * (ejemplo de caras: As, Dos, Tres, Cuatro, ..., Rey)
     * @param caras int[] Arreglo que contien las repeticiones de las caras
     * @param un_par int tipo de par que no se busca en ejemplo un_par = 2 significa que omite el par de 2 en caso de
     * encontrarlo
     * @return int 0 si no hay par, cualquier número entre 1 y 13 dependiendo del tipo de tercia encontrada, por ejemplo,
     * 6 significa par de seises
     */
    private static int unPar(int[] caras, int un_par){
        int jerarquia = 0;
        
        if(caras[0] == 2 && un_par != 1){
            jerarquia = 1;
            System.out.println("Par de Ases");
        }
        else if(caras[1] == 2 && un_par != 2){
            jerarquia = 2;
            System.out.println("Par de Dos");
        }
        else if(caras[2] == 2 && un_par != 3){
            jerarquia = 3;
            System.out.println("Par de Tres");
        }
        else if(caras[3] == 2 && un_par != 4){
            jerarquia = 4;
            System.out.println("Par de Cuatro");
        }
        else if(caras[4] == 2 && un_par != 5){
            jerarquia = 5;
            System.out.println("Par de Cinco");
        }
        else if(caras[5] == 2 && un_par != 6){
            jerarquia = 6;
            System.out.println("Par de Seis");
        }
        else if(caras[6] == 2 && un_par != 7){
            jerarquia = 7;
            System.out.println("Par de Siete");
        }
        else if(caras[7] == 2 && un_par != 8){
            jerarquia = 8;
            System.out.println("Par de Ocho");
        }
        else if(caras[8] == 2 && un_par != 9){
            jerarquia = 9;
            System.out.println("Par de Nueve");
        }
        else if(caras[9] == 2 && un_par != 10){
            jerarquia = 10;
            System.out.println("Par de Diez");
        }
        else if(caras[10] == 2 && un_par != 11){
            jerarquia = 11;
            System.out.println("Par de Joker");
        }
        else if(caras[11] == 2 && un_par != 12){
            jerarquia = 12;
            System.out.println("Par de Reina");
        }
        else if(caras[12] == 2 && un_par != 13){
            jerarquia = 13;
            System.out.println("Par de Rey");
        }
        
        return jerarquia;
    }
    /**
     * Determina si existe exclusivamente un par (el primer que encuentra) en el arreglo de enteros llamado caras
     * (ejemplo de caras: As, Dos, Tres, Cuatro, ..., Rey)
     * @param caras int[] Arreglo que contien las repeticiones de las caras
     * @return int 0 si no hay par, cualquier número entre 1 y 13 dependiendo del tipo de tercia encontrada, por ejemplo,
     * 6 significa par de seises
     */
    private static int unPar(int[] caras){
        int jerarquia = 0;
        
        if(caras[0] == 2){
            jerarquia = 1;
            System.out.println("Par de Ases");
        }
        else if(caras[1] == 2){
            jerarquia = 2;
            System.out.println("Par de Dos");
        }
        else if(caras[2] == 2){
            jerarquia = 3;
            System.out.println("Par de Tres");
        }
        else if(caras[3] == 2){
            jerarquia = 4;
            System.out.println("Par de Cuatro");
        }
        else if(caras[4] == 2){
            jerarquia = 5;
            System.out.println("Par de Cinco");
        }
        else if(caras[5] == 2){
            jerarquia = 6;
            System.out.println("Par de Seis");
        }
        else if(caras[6] == 2){
            jerarquia = 7;
            System.out.println("Par de Siete");
        }
        else if(caras[7] == 2){
            jerarquia = 8;
            System.out.println("Par de Ocho");
        }
        else if(caras[8] == 2){
            jerarquia = 9;
            System.out.println("Par de Nueve");
        }
        else if(caras[9] == 2){
            jerarquia = 10;
            System.out.println("Par de Diez");
        }
        else if(caras[10] == 2){
            jerarquia = 11;
            System.out.println("Par de Joker");
        }
        else if(caras[11] == 2){
            jerarquia = 12;
            System.out.println("Par de Reina");
        }
        else if(caras[12] == 2){
            jerarquia = 13;
            System.out.println("Par de Rey");
        }
        
        return jerarquia;
    }
    /**
     * Determina si existe una tercia en el arreglo de enteros llamado caras
     * (ejemplo de caras: As, Dos, Tres, Cuatro, ..., Rey)
     * @param caras int[] Arreglo que contien las repeticiones de las caras
     * @return int 0 si no hay tercia, cualquier número entre 1 y 13 dependiendo del tipo de tercia encontrada, por ejemplo,
     * 6 significa tercia de seises
     */
    private static int tercia(int[] caras){
        int tercias = 0;
        if(caras[0] == 3){
            tercias = 1;
            System.out.println("Tercia de Ases");
        }
        else if(caras[1]  == 3){
            tercias = 2;
            System.out.println("Tercia de Dos");
        }
        else if(caras[2]  == 3){
            tercias = 3;
            System.out.println("Tercia de Tres");
        }
        else if(caras[3]  == 3){
            tercias = 4;
            System.out.println("Tercia de Cuatro");
        }
        else if(caras[4]  == 3){
            tercias = 5;
            System.out.println("Tercia de Cinco");
        }
        else if(caras[5]  == 3){
            tercias = 6;
            System.out.println("Tercia de Seis");
        }
        else if(caras[6]  == 3){
            tercias = 7;
            System.out.println("Tercia de Siete");
        }
        else if(caras[7]  == 3){
            tercias = 8;
            System.out.println("Tercia de Ocho");
        }
        else if(caras[8]  == 3){
            tercias = 9;
            System.out.println("Tercia de Nueve");
        }
        else if(caras[9]  == 3){
            tercias = 10;
            System.out.println("Tercia de Diez");
        }
        else if(caras[10]  == 3){
            tercias = 11;
            System.out.println("Tercia de Joker");
        }
        else if(caras[11]  == 3){
            tercias = 12;
            System.out.println("Tercia de Reina");
        }
        else if(caras[12]  == 3){
            tercias = 13;
            System.out.println("Tercia de Rey");
        }
        
        return tercias;
    }
    /**
     * Determina si es una corrida/color (Cinco cartas no consecutivas del mismo palo, en caso de empate gana el
     * la carta mas grande)
     * @param cartas Carta[] Arreglo de objetos tipo Carta
     * @param palos int[] Arreglo de enteros
     * @return int 0 si no hay corrida, de 1 a 13 en caso de encontrarla donde el número define la carta mas grande
     */
    private static int corridaOColor(Carta[] cartas, int[] palos){
        int mayor = cartaMayor(convertirCarasANumeros(cartas));
        boolean corr = false;
        
        if(palos[0] == 5){
            corr = true;
            System.out.println("Corrida de corazones");
        }
        else if(palos[1] == 5){
            corr = true;
            System.out.println("Corrida de diamantes");
        }
        else if(palos[2] == 5){
            corr = true;
            System.out.println("Corrida de treboles");
        }
        else if(palos[3] == 5){
            corr = true;
            System.out.println("Corrida de espadas");
        }
        
        if(corr){
            System.out.printf("El valor mayor de la corrida o color es %d%n", mayor);
            return mayor;
        }
        else
            return 0;
    }
    /**
     * Determina si existe un fullhouse (una tercia mas un par, en caso de empate la tercia determina la jerarquia)
     * @param par int Identifica si existe un par
     * @param tercia int Identifica si existe una tercia
     * @return int valor de la tercia
     */
    private static int fullHouse(int par, int tercia){
        int tres = 0;
        if(par != 0 && tercia != 0){
            tres = tercia;
            System.out.println("Full house");
        }
        return tres;
    }
    /**
     * Determina si existe un poker (cuatro cartas del mismo valor, en caso de empate las 4 cartas definen la jerarquia del 
     * poker)
     * @param caras int[] Arreglo que contie las repeticiones de las caras
     * @return int Valor del poker, por ejemplo si las cuatro cartas tienen valor de 6, el metodo devolvera 6.
     * En caso de no encontrar un poker devolvera cero.
     */
    private static int poker(int[] caras){
        int cuarta = 0;
        if(caras[0] == 4){
            cuarta = 1;
            System.out.println("Poker de Ases");
        }
        else if(caras[1] == 4){
            cuarta = 2;
            System.out.println("Poker de Dos");
        }
        else if(caras[2] == 4){
            cuarta = 3;
            System.out.println("Poker de Tres");
        }
        else if(caras[3] == 4){
            cuarta = 4;
            System.out.println("Poker de Cuatro");
        }
        else if(caras[4] == 4){
            cuarta = 5;
            System.out.println("Poker de Cinco");
        }
        else if(caras[5] == 4){
            cuarta = 6;
            System.out.println("Poker de Seis");
        }
        else if(caras[6] == 4){
            cuarta = 7;
            System.out.println("Poker de Siete");
        }
        else if(caras[7] == 4){
            cuarta = 8;
            System.out.println("Poker de Ocho");
        }
        else if(caras[8] == 4){
            cuarta = 9;
            System.out.println("Poker de Nueve");
        }
        else if(caras[9] == 4){
            cuarta = 10;
            System.out.println("Poker de Diez");
        }
        else if(caras[10] == 4){
            cuarta = 11;
            System.out.println("Poker de Joker");
        }
        else if(caras[11] == 4){
            cuarta = 12;
            System.out.println("Poker de Reina");
        }
        else if(caras[12] == 4){
            cuarta = 13;
            System.out.println("Poker de Rey");
        }
        
        return cuarta;
    }
    
    private static int escalera(Carta[] cartas, int[] palos){
        int mayor = cartaMayor(convertirCarasANumeros(cartas));
        boolean corr = false;
        boolean[] valorCartas;
        
        if(palos[0] == 5){
            corr = true;
            valorCartas = convertirCarasANumeros(cartas);
            System.out.printf("%s%n", validarEscalera(valorCartas) ? "Escalera de corazones": "");
        }
        else if(palos[1] == 5){
            corr = true;
            valorCartas = convertirCarasANumeros(cartas);
            System.out.printf("%s%n", validarEscalera(valorCartas) ? "Escalera de diamantes": "");
        }
        else if(palos[2] == 5){
            corr = true;
            valorCartas = convertirCarasANumeros(cartas);
            System.out.printf("%s%n", validarEscalera(valorCartas) ? "Escalera de treboles": "");
        }
        else if(palos[3] == 5){
            corr = true;
            valorCartas = convertirCarasANumeros(cartas);
            System.out.printf("%s%n", validarEscalera(valorCartas) ? "Escalera de espadas": "");
        }
        
        if(corr){
            System.out.printf("El valor mayor de la corrida o color es %d%n", mayor);
            return mayor;
        }
        else
            return 0;
    }
    /**
     * Dado un arreglo booleano con los números que existen en true identifica cual es el mayor; por ejemplo,
     * si el ultimo elemento en true es el 6 ese número es devuelto por el metodo.
     * @param numeros boolean[] Arreglo booleano que contiene distintos números
     * @return int Número más grande
     */
    private static int cartaMayor(boolean[] numeros){
        int mayor = 0;
        for(int i = 0; i < numeros.length; i++){
            if(numeros[i])
                mayor = i;
        }
        
        return mayor + 1;
    }
    /**
     * Dado un arreglo de Cartas (Carta) se convierten sus caras a números enteros
     * @param cartas Carta[] arreglo de objetos tipo Carta
     * @return boolean[] Arreglo de elementos boolean con las caras de las cartas
     */
    private static boolean[] convertirCarasANumeros(Carta[] cartas){
        boolean[] valorCartas = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false};
        
        for(Carta carta: cartas){
            switch(carta.obtenerCara()){//< identificacion caras
                case "As":
                    valorCartas[0] = true;
                    break;
                case "Dos":
                    valorCartas[1] = true;
                    break;
                case "Tres":
                    valorCartas[2] = true;
                    break;
                case "Cuatro":
                    valorCartas[3] = true;
                    break;
                case "Cinco":
                    valorCartas[4] = true;
                    break;
                case "Seis":
                    valorCartas[5] = true;
                    break;
                case "Siete":
                    valorCartas[6] = true;
                    break;
                case "Ocho":
                    valorCartas[7] = true;
                    break;
                case "Nueve":
                    valorCartas[8] = true;
                    break;
                case "Diez":
                    valorCartas[9] = true;
                    break;
                case "Joker":
                    valorCartas[10] = true;
                    break;
                case "Reina":
                    valorCartas[11] = true;
                    break;
                case "Rey":
                    valorCartas[12] = true;
                    break;
            }
        }
        
        return valorCartas;
    }
    /**
     * Determina si un paquete de cartas tiene una escalera
     * @param valorCartas boolean[] Arreglo con los valores de las cartas en true
     * @return boolean, true si es escalera, false en caso contrario
     */
    private static boolean validarEscalera(boolean[] valorCartas){
        boolean esEscalera = false;//<Se almacena si es escalera o no
        int conteoConsecutivo = 0;//< Sirve para contar 5 numeros consecutivos
        int conteoTrue = 0;//< Sirve para contar hasta 5 numeros no consecutivos
        boolean inicioEscalera = false;//< Sirve para marcar cuando inicia el conteo
        
        for(boolean valor: valorCartas){
            if(valor && conteoConsecutivo != 5){//< cuando inicia la escalera
                conteoTrue++;//< cuenta todas las casillas en true
                inicioEscalera = true;
            }
            if(inicioEscalera && conteoConsecutivo != 5)//<si la escalera ya esta en proceso
                conteoConsecutivo++;
        }
        if(conteoConsecutivo == conteoTrue)
            esEscalera = true;
        
        return esEscalera;
    }
}
