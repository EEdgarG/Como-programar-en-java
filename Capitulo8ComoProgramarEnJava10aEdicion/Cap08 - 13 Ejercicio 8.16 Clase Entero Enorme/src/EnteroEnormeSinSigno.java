/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 6/06/2020
 * @time 02:21:24 PM
 */
public class EnteroEnormeSinSigno {
    /**
     * Almacena el entero de máximo 40 digitos
     */
    private int[] enteroEnorme;
    /**
     * Almacena el tamaño que tendra enteroEnorme
     */
    private static final short TAMANOENTEROENORME = 40;
    /**
     * Constructor predeterminado, crea el enteroEnorme a tamaño 40, inicializa los digitos a cero y asigna el signo a positvo
     */
    public EnteroEnormeSinSigno(){
        enteroEnorme = new int[TAMANOENTEROENORME];
        
        for(int posicionActual = 0; posicionActual < TAMANOENTEROENORME; posicionActual++){
            enteroEnorme[posicionActual] = 0;
        }
    }
    /**
     * Convierte un número ingresado en un objeto String en un objeto EnteroEnorme
     * @param numeroS String que contiene el número
     */
    public EnteroEnormeSinSigno(String numeroS){
        this();//< llama al constructor predeterminado para inicializar la variable de instancia
        
        int posicionNumeroS = 0;
        if(numeroS.length() > 40)
            throw new IllegalArgumentException("El número es mayor a 40 digitos");
        
        for(int posicionActual = TAMANOENTEROENORME - numeroS.length(); posicionActual < 40; posicionActual++){
            if(!Character.isDigit(numeroS.charAt(posicionNumeroS)))//< si la casilla actual es un caracter
                throw new IllegalArgumentException("La cadena contiene letras");
            
            enteroEnorme[posicionActual] = Character.getNumericValue(numeroS.charAt(posicionNumeroS));
            posicionNumeroS++;
        }
    }/**
     * Convierte un número ingresado en un objeto String en digitos
     * de EnteroEnorme
     * @param numeroS String que contiene el número
     */
    public void parse(String numeroS){
        int posicionNumeroS = 0;
        for(int posicionActual = TAMANOENTEROENORME - numeroS.length(); posicionActual < 40; posicionActual++){
            if(!Character.isDigit(numeroS.charAt(posicionNumeroS)))//< si la casilla actual es un caracter
                throw new IllegalArgumentException("La cadena contiene letras");
            
            enteroEnorme[posicionActual] = Character.getNumericValue(numeroS.charAt(posicionNumeroS));
            posicionNumeroS++;
        }
    }
    /**
     * Devuelve el digito que esta en la posición indicada por el índice
     * @param indice int >= 0 y <=40
     * @return int
     */
    private int obtenerDigito(int indice){
        if(indice < 0 || indice > 40)
            throw new IllegalArgumentException("Indice fuera de rango");
        
        return enteroEnorme[indice];
    }
    /**
     * Establece un elemento en la posición indice (dado como argumento del método)
     * con el valor 'valor' (dado como argumento del método)
     * @param indice int >= 0 y <=40
     * @param valor int  >= 0 y <= 9
     */
    private void establecerDigito(int indice, int valor){
        if(indice < 0 || indice > 40)
            throw new IllegalArgumentException("Indice fuera de rango");
        if(valor < -1 || valor > 9)//< -1 porque es el dígito prestado
            throw new IllegalArgumentException("Valor invalido");
        
        enteroEnorme[indice] = valor;
    }
    /**
     * Suma EnteroEnorme a con el EnteroEnorme que invoca este método y
     * devuelve esa suma como un nuevo EnteroEnorme
     * @param a EnteroEnorme
     * @return EnteroEnorme
     */
    public EnteroEnormeSinSigno suma(EnteroEnormeSinSigno a){
        EnteroEnormeSinSigno resultado = new EnteroEnormeSinSigno();
            algoritmoSuma(a, resultado);
        return resultado;
    }
    /**
     * MÉTODO DE APOYO
     * Algoritmo principal de suma. Realiza el recorrido de la suma del elemento EnteroEnorme a, al EnteroEnorme que 
     * invoca este método y deposita el resultado en el EnteroEnorme resultado.
     * @param a EnteroEnorme
     * @param resultado EnteroEnorme
     */
    private void algoritmoSuma(EnteroEnormeSinSigno a, EnteroEnormeSinSigno resultado){
        int suma = 0;//< variable de apoyo para sumar dígito restante en la suma
        for(int posicionActual = TAMANOENTEROENORME - 1; posicionActual >= 0; posicionActual--){
            int digito = obtenerDigito(posicionActual) + a.obtenerDigito(posicionActual) + suma;
            suma = 0;

            if(digito > 9){
                resultado.establecerDigito(posicionActual, digito % 10);
                suma = digito / 10;
            }
            else if(digito < 10)
                resultado.establecerDigito(posicionActual, digito);

            if(posicionActual == 0 && suma > 0)
                throw new ArrayIndexOutOfBoundsException("Se excedio el tamaño maximo del objeto EnteroEnorme");
        }
    }
     /**
     * Devuelve el EnteroEnorme que invoca este método menos la resta del EnteroEnorme a del argumento y lo asigna
     * a un nuevo EnteroEnorme
     * @param a EnteroEnorme
     * @return EnteroEnorme
     */
    public EnteroEnormeSinSigno resta(EnteroEnormeSinSigno a){
        EnteroEnormeSinSigno r = new EnteroEnormeSinSigno();
        if(!esMayorOIgualA(a))
            throw new ArithmeticException("El argumento es mayor que el método que lo invoca, imposible realizar la operación");
        else{
            algoritmoResta(a, r);  
        }
        return r;
    }
    /**
     * Devuelve true si el objeto que invoca este método es mayor o igual a EnteroEnorme a
     * @param a EnteroEnorme
     * @return boolean
     */
    public boolean esMayorOIgualA(EnteroEnormeSinSigno a){
        return esMayorQue(a) || esIgualA(a);
    }
    /**
     * Devuelve true si el objeto que invoca este método es mayor a "a"
     * @param a EnteroEnorme
     * @return boolean
     */
    public boolean esMayorQue(EnteroEnormeSinSigno a){
        if(esIgualA(a))//< Si son iguales
            return false;
        else{//< Si no lo son
            if(indiceMasSignificativo() < a.indiceMasSignificativo())//< Si tiene mas dígitos
                return true;
            else if(indiceMasSignificativo() > a.indiceMasSignificativo())//< Si tiene menos dígitos
                return false;
            else{//< Si tienen la misma cantidad de dígitos
                
                int posicionActual = indiceMasSignificativo();
                //Encuentra el índice donde ambos dígitos dejan de ser iguales
                while(obtenerDigito(posicionActual) == a.obtenerDigito(posicionActual)){
                    posicionActual++;
                }
                
                if(obtenerDigito(posicionActual) > a.obtenerDigito(posicionActual))//< Compara si a es menor
                    return true;
                else
                    return false;
            }
        }
    }
    /**
     * Devuelve true si el objeto EnteroEnorme a es igual al objeto que invoca este método
     * @param a EnteroEnorme
     * @return boolean
     */
    public boolean esIgualA(EnteroEnormeSinSigno a){
        if(indiceMasSignificativo() > a.indiceMasSignificativo() || indiceMasSignificativo() < a.indiceMasSignificativo())
            return false;
        else{//< son iguales en su índice mas significativo
            int posicionActual = indiceMasSignificativo();
            
            while((posicionActual < TAMANOENTEROENORME) && (obtenerDigito(posicionActual) == a.obtenerDigito(posicionActual))){
                posicionActual++;
            }
            return posicionActual == TAMANOENTEROENORME;
        }
    }
    /**
     * Devuelve el índice del dígito mas significativo, es decir, el índice donde comienza el número EnteroEnormeSinSigno
     * @return int >= 0 <=40
     */
    private int indiceMasSignificativo(){
        int posicionActual = 0;
        while(obtenerDigito(posicionActual) == 0 && (posicionActual < TAMANOENTEROENORME - 1)){
            posicionActual++;
        }
        return posicionActual;
    }
    /**
     * MÉTODO DE APOYO
     * Realiza el recorrido de la resta de un EnteroEnorme a, al EnteroEnorme que invoca este método y lo deposita en
     * el EnteroEnorme r
     * @param a EnteroEnorme
     * @param r EnteroEnorme
     */
    private void algoritmoResta(EnteroEnormeSinSigno a, EnteroEnormeSinSigno r){
        for(int posicionActual = TAMANOENTEROENORME - 1; posicionActual >= 0; posicionActual--){
            int suma = r.obtenerDigito(posicionActual) + obtenerDigito(posicionActual);//< Suma de lo que se lleva

            if(suma < a.obtenerDigito(posicionActual)){//< El dígito es menor que el de a, ej 6 -8
                digitosPrestados(posicionActual, r);
                suma = 10 + obtenerDigito(posicionActual);
            }
            if(suma >= a.obtenerDigito(posicionActual)){//< El dígito es mayor o igual que el de a: ejem 8 - 8
                //realiza la suma de "lo que se debe o se tiene" en r y se le resta lo que tiene a
                r.establecerDigito(posicionActual, suma - a.obtenerDigito(posicionActual));
            }
        }
    }
    /**
     * Realiza los prestamos necesarios de un digito, digamos que tenemos a = 2001000 -  b = 80, el segundo cero de a tiene
     * que pedir prestado al siguiente digito, si es cero tiene que pedir prestado al siguiente asi sucesivamente hasta el primer
     * dígito diferente de cero (en este ejemplo es 1); este método se encarga de realizar los correspondientes prestamos
     * que seran cobrados en el método que implemente a este, así los prestamos quedan en este ejemplo como -19"10
     * @param posicionActual int: índice actual de resta
     * @param r EnteroEnorme: resultado de la resta y ademas sirve como variable temporal
     */
    private void digitosPrestados(int posicionActual, EnteroEnormeSinSigno r){
        int indicePrestamo = indiceDigitoPrestamo(posicionActual);
        
        r.establecerDigito(indicePrestamo, -1);//< digito prestado
        //Se realiza el prestamo de todos los dígitos que estan entre el indicePrestamo y posicionActual
        for(int cuenta = indicePrestamo + 1; cuenta < posicionActual; cuenta++){
            r.establecerDigito(cuenta, 9);//< Todos los prestamos son 9
        }
    }
    /**
     * Devuelve el primer índice cuyo contenido es diferente de cero
     * @param posicionActual int
     * @return int
     */
    private int indiceDigitoPrestamo(int posicionActual){
        int indiceDigitoDistintoCero = posicionActual - 1;//< posicionActual
        while(indiceDigitoDistintoCero > indiceMasSignificativo() && obtenerDigito(indiceDigitoDistintoCero) == 0){
            indiceDigitoDistintoCero--;
        }
        return indiceDigitoDistintoCero;
    }
    /**
     * Devuelve true si el objeto EnteroEnorme a no es igual al EnteroEnorme que invoca este método
     * @param a EneteroEnorme
     * @return boolean
     */
    public boolean noEsIgualA(EnteroEnormeSinSigno a){
        return !esIgualA(a);
    }
    /**
     * Devuelve true si el objeto que invoca este método es mayor a "a"
     * @param a EnteroEnorme
     * @return boolean
     */
    public boolean esMenorQue(EnteroEnormeSinSigno a){
        if(esIgualA(a)){
            return false;
        }
        else{
            if(indiceMasSignificativo() > a.indiceMasSignificativo())//< Tiene menos dígitos, es decir, es menor
                return true;
            else if(indiceMasSignificativo() < a.indiceMasSignificativo())//< Tiene mas dígitos, es decir, es mayor
                return false;
            else{//< Tienen la misma cantidad de dígitos
                
                int posicionActual = indiceMasSignificativo();
                //Encuentra el índice donde ambos dígitos dejan de ser iguales
                while(obtenerDigito(posicionActual) == a.obtenerDigito(posicionActual)){
                    posicionActual++;
                }
                if(obtenerDigito(posicionActual) < a.obtenerDigito(posicionActual))//< Compara si a es mayor
                    return true;
                else
                    return false;
            }
        }
    }
    /**
     * Devuelve true si el EnteroEnorme que invoca este método es menor o igual que EnteroEnorme a
     * @param a EnteroEnorme
     * @return boolean
     */
    public boolean esMenorOIgualA(EnteroEnormeSinSigno a){
        return esMenorQue(a) || esIgualA(a);
    }
    /**
     * Devuelve true si el EnteroEnorme que invoca este método es cero, false en caso contrario
     * @return boolean
     */
    public boolean esCero(){
        return esCero(this);
    }
    /**
     * Indica si un objeto EnteroEnorme es cero
     * @param a EnteroEnorme objeto
     * @return boolean true si es cero, false si no lo es
     */
    public static boolean esCero(EnteroEnormeSinSigno a){
        boolean cero = true;//< predeterminado es cero
        for(int digito: a.enteroEnorme){
            if(digito != 0)
                cero = false;
        }
        return cero;
    }
    /**
     * Multiplica al EnteroEnormeSinSigno que invoca este método por el EnteroEnormeSinSigno del argumento del método
     * y el resultado lo devuelve como un nuevo EnteroEnormeSinSigno
     * @param a EnteroEnormeSinSigno
     * @return EnteroEnormeSinSigno
     */
    public EnteroEnormeSinSigno multiplicar(EnteroEnormeSinSigno a){
        EnteroEnormeSinSigno resultado = new EnteroEnormeSinSigno();
        
        for(int actualA = TAMANOENTEROENORME - 1; actualA >= 0; actualA--){//<Recorre todo a
            
            algoritmoMultiplicacion(a.obtenerDigito(actualA), actualA, resultado);
        }
        
        return resultado;
    }
    /**
     * MÉTODO DE APOYO
     * Algoritmo principal de multiplicación, recibe un dígito que multiplica al objeto que invoca este método y almacena los
     * resultados en el objeto EnteroEnorme r
     * @param numero int dígito actual
     * @param actualA int índice de número
     * @param r EnteroEnormeSinSigno
     */
    private void algoritmoMultiplicacion(int numero, int actualA, EnteroEnormeSinSigno r){
        int resultado = 0;
        int posicionFinal = 0;
        for(int posicionActual = TAMANOENTEROENORME - 1; posicionActual >= 0; posicionActual--){
            posicionFinal = - (TAMANOENTEROENORME - 1 - posicionActual - actualA);
            if(posicionFinal >= 0){
                resultado += (numero * obtenerDigito(posicionActual)) + r.obtenerDigito(posicionFinal);
                if(resultado > 9){
                    r.establecerDigito(posicionFinal, resultado % 10);
                    resultado /= 10;
                }
                else{
                    r.establecerDigito(posicionFinal, resultado);
                    resultado = 0;
                }
            }
        }
        if(resultado > 0)
                throw new ArithmeticException("El resultado es demasiado grande para el EnteroEnormeSinSigno");
    }
    /**
     * Devuelve un EnteroEnormeSinSigno resultado de dividir al objeto que invoca este método entre el argumento
     * EnteroEnormeSinSigno a
     * @param a EnteroEnormeSinSigno
     * @return EnteroEnormeSinSigno
     */
    public EnteroEnormeSinSigno dividir(EnteroEnormeSinSigno a){
        EnteroEnormeSinSigno resultado;
        
        if(a.esCero())
            throw new ArithmeticException("by zero");
        
        if(esIgualA(a)){
            resultado = new EnteroEnormeSinSigno("1");
        }
        else if(esMayorQue(a)){
            EnteroEnormeSinSigno temporal2 = new EnteroEnormeSinSigno("1");
            EnteroEnormeSinSigno temporal = new EnteroEnormeSinSigno(toString());//copia();
            resultado = new EnteroEnormeSinSigno("0");
            
            while(a.esMenorOIgualA(temporal)){
                temporal = temporal.resta(a);
                resultado = resultado.suma(temporal2);
            }
        }
        else
            resultado = new EnteroEnormeSinSigno("0");
        
        return resultado;
    }
    public EnteroEnormeSinSigno residuo(EnteroEnormeSinSigno a){
        EnteroEnormeSinSigno resultado;
        
        if(a.esCero())//< % 0
            throw new ArithmeticException("by zero");
        
        if(esIgualA(a)){//< % 
            resultado = new EnteroEnormeSinSigno("0");
        }
        else if(esMayorQue(a)){
            EnteroEnormeSinSigno temporal = new EnteroEnormeSinSigno(toString());
            
            while(a.esMenorOIgualA(temporal)){
                temporal = temporal.resta(a);
            }
            resultado = new EnteroEnormeSinSigno(temporal.toString());
        }
        else//< es menor
            resultado = new EnteroEnormeSinSigno("0");
        
        return resultado;
    }
    
    /**
     * Convierte a objeto String el número gigante
     * @return String representación en String del número
     */
    @Override
    public String toString(){
        String numero = new String();
        boolean iniciaNumero = false;//< variable de control para indicar cuando inicial el número
        
        for(int digito: enteroEnorme){
            if(digito != 0 || iniciaNumero == true){
                iniciaNumero = true;
                numero += digito;
            }
        }
        
        if(iniciaNumero == false)//< es un número con ceros unicamente
            numero += "0";
        
        return numero;
    }
}
