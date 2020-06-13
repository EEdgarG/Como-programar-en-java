/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Bugs conocidos: esta desactivada la validación de dígitos que impide que un dígito pueda ser mayor a 9 y menor a 0
 * Las comparaciones predicado de esMayorOigualQue etc funcionan solo para EnteroEnorme sin signo, hace falta realizar
 * la comparación con números con signo
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 9/05/2020
 * @time 08:10:21 PM
 */
public class EnteroEnorme {
    /**
     * Almacena el entero de máximo 40 digitos
     */
    private int[] enteroEnorme;
    /**
     * Contiene el signo; true para positivo, false para negativo
     */
    private boolean signo;
    /**
     * Almacena el tamaño que tendra enteroEnorme
     */
    private static final short TAMANOENTEROENORME = 40;
    /**
     * Constructor predeterminado, crea el enteroEnorme a tamaño 40, inicializa los digitos a cero y asigna el signo a positvo
     */
    public EnteroEnorme(){
        signo = true;//<positivo
        enteroEnorme = new int[TAMANOENTEROENORME];
        
        for(int posicionActual = 0; posicionActual < TAMANOENTEROENORME; posicionActual++){
            enteroEnorme[posicionActual] = 0;
        }
    }
    /**
     * Convierte un número ingresado en un objeto String en un objeto EnteroEnorme
     * @param numeroS String que contiene el número
     */
    public EnteroEnorme(String numeroS){
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
    }
    /**
     * Convierte un número ingresado en un objeto String en un objeto EnteroEnorme con signo
     * @param numeroS String que contiene el número
     */
    public EnteroEnorme(String signo, String numeroS){
        this(numeroS);//< llama al constructor de dos argumentos
        if(!signo.equals("-") && !signo.equals("+"))
            throw new IllegalArgumentException("El signo se establece con '-' para negativo y '+' para positivo");
        
        if(signo.equals("-"))
            this.signo = false;
        
        if(EnteroEnorme.esCero(this))
            this.signo = true;
    }
//    /**
//     * Devuelve el signo del EnteroEnorme como un String
//     * @return String
//     */
//    public String obtenerSigno(){
//        if(signo)
//            return "+";
//        else
//            return "-";
//    }
    public boolean obtenerSigno(){
        return signo;
    }
    /**
     * Establece el signo con un valor boolean
     * @param signo boolean, true para positivo, false para negativo
     */
    public void establecerSigno(boolean signo){
            this.signo = signo;
    }
    /**
     * Convierte un número ingresado en un objeto String en digitos
     * que asigna en enteroEnorme[] (unicamente acepta números positivos)
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
//        if(valor < 0 || valor > 9)//< estorba con el algoritmo de resta
//            throw new IllegalArgumentException("Valor invalido");
        
        enteroEnorme[indice] = valor;
    }
    /**
     * Suma EnteroEnorme a con el EnteroEnorme que invoca este método y
     * devuelve esa suma como un nuevo EnteroEnorme
     * @param a EnteroEnorme
     * @return EnteroEnorme
     */
    public EnteroEnorme sumar(EnteroEnorme a){
        EnteroEnorme resultado = new EnteroEnorme();
        
        if(a.obtenerSigno() && obtenerSigno()){//< Si este objeto es positivo y a es positivo
            recorridoSuma(a, resultado);
        }
        else if(!a.obtenerSigno() && obtenerSigno()){//< Si a es negativo y este objeto es positivo
            a.establecerSigno(true);//< Se establece el signo a positivo
            resultado = resta(a);//< Se realiza una resta en lugar de suma
            resultado.establecerSigno(false);
            a.establecerSigno(false);//< Se establece el signo nuevamente a negativo
        }
        else if(a.obtenerSigno() && !obtenerSigno()){//< si a es positivo y este objeto es negativo
            establecerSigno(true);
            resultado = resta(a);
            resultado.establecerSigno(false);
            establecerSigno(false);
        }
        else{//< Ambos EnteroEnorme son negativos
            establecerSigno(true);
            a.establecerSigno(true);
            
            resultado = sumar(a);
            resultado.establecerSigno(false);
            
            establecerSigno(false);
            a.establecerSigno(false);
        }
        return resultado;
    }
    /**
     * MÉTODO DE APOYO
     * Algoritmo principal de suma. Realiza el recorrido de la suma del elemento EnteroEnorme a, al EnteroEnorme que 
     * invoca este método y deposita el resultado en el EnteroEnorme resultado.
     * @param a EnteroEnorme
     * @param resultado EnteroEnorme
     */
    private void recorridoSuma(EnteroEnorme a, EnteroEnorme resultado){
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
//    /**
//     * Para implementar correctamente este método se debe implementar el método restar de manera estatica
//     * Recibe dos objetos EnteroEnorme y devuelve la suma de ambos en un objeto EnteroEnorme
//     * @param a EnteroEnorme número a
//     * @param b EnteroEnorme número b
//     * @return EnteroEnorme c suma de a y b
//     */
//    public static EnteroEnorme sumar(EnteroEnorme a, EnteroEnorme b){
//        EnteroEnorme resultado = new EnteroEnorme();
//        
//        int suma = 0;//< variable de apoyo para sumar digito restante en la suma
//        
//        for(int posicionActual = TAMANOENTEROENORME - 1; posicionActual >= 0; posicionActual--){
//            int digitoC = a.obtenerDigito(posicionActual) + b.obtenerDigito(posicionActual) + suma;
//            suma = 0;
//            
//            if(digitoC > 9){
//                resultado.establecerDigito(posicionActual, digitoC % 10);
//                suma = digitoC / 10;
//            }
//            else if(digitoC < 10)
//                resultado.establecerDigito(posicionActual, digitoC);
//            
//            if(posicionActual == 0 && suma > 0)
//                throw new ArrayIndexOutOfBoundsException("Se excedio el tamaño maximo del objeto EnteroEnorme");
//        }
//        
//        return resultado;
//    }
    /**
     * Devuelve el EnteroEnorme que invoca este método menos la resta del EnteroEnorme a del argumento y lo asigna
     * a un nuevo EnteroEnorme
     * @param a EnteroEnorme
     * @return EnteroEnorme
     */
    public EnteroEnorme resta(EnteroEnorme a){
        EnteroEnorme r = new EnteroEnorme();
        // Si el número EnteroEnorme es mayor a "a" y ambos signos son positivos
        if(esMayorOIgualQue(a) && a.obtenerSigno() && obtenerSigno()){
            
            recorridoResta(a, r);
            
        }
        // Si el número EnteroEnorme es mayor a "a" y "a" es negativo
        else if(esMayorOIgualQue(a) && obtenerSigno() && !a.obtenerSigno()){
            a.establecerSigno(true);
            r = sumar(a);
            a.establecerSigno(false);
        }
        // Si el número EnteroEnorme es mayor a "a" y este número es negativo
        else if(esMayorOIgualQue(a) && !obtenerSigno() && a.obtenerSigno()){
            establecerSigno(true);
            a.establecerSigno(true);
            
            r = sumar(a);
            r.establecerSigno(false);
            
            establecerSigno(true);
            a.establecerSigno(true);
        }
        // Si el número EnteroEnorme es mayor a "a" y ambos números son negativos
        else if(esMayorOIgualQue(a) && !obtenerSigno() && !a.obtenerSigno()){
            a.establecerSigno(true);
            r = a.sumar(this);
            r.establecerSigno(false);
            a.establecerSigno(false);
        }
        else if(!esMayorOIgualQue(a)){
//            a.establecerSigno(true);
            r = a.resta(this);
            r.establecerSigno(true);
            a.establecerSigno(false);
        }
        return r;
    }
    /**
     * MÉTODO DE APOYO
     * Realiza el recorrido de la resta de un EnteroEnorme a, al EnteroEnorme que invoca este método y lo deposita en
     * el EnteroEnorme r
     * @param a EnteroEnorme
     * @param r EnteroEnorme
     */
    private void recorridoResta(EnteroEnorme a, EnteroEnorme r){
        for(int posicionActual = TAMANOENTEROENORME - 1; posicionActual >= 0; posicionActual--){
            int suma = r.obtenerDigito(posicionActual) + obtenerDigito(posicionActual);//< Suma de lo que se lleva

            if(suma < a.obtenerDigito(posicionActual)){//< El dígito es menor que el de a, ej 6 -8
                digitosPrestados(posicionActual, r);
                suma = r.obtenerDigito(posicionActual) + obtenerDigito(posicionActual);
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
    private void digitosPrestados(int posicionActual, EnteroEnorme r){
        int indicePrestamo = indiceDigitoPrestamo(posicionActual);
        
        r.establecerDigito(indicePrestamo, -1);//< digito prestado
        r.establecerDigito(posicionActual, 10);//< cantidad prestada
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
     * Devuelve true si el objeto que invoca este método es mayor a "a"
     * @param a EnteroEnorme
     * @return boolean
     */
    public boolean esMayorQue(EnteroEnorme a){
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
     * Devuelve true si el objeto que invoca este método es mayor o igual a EnteroEnorme a
     * @param a EnteroEnorme
     * @return boolean
     */
    public boolean esMayorOIgualQue(EnteroEnorme a){
        return esMayorQue(a) || esIgualA(a);
    }
    /**
     * Devuelve true si el objeto que invoca este método es mayor a "a"
     * @param a EnteroEnorme
     * @return boolean
     */
    public boolean esMenorQue(EnteroEnorme a){
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
    public boolean esMenorOIgualQue(EnteroEnorme a){
        return esMenorQue(a) || esIgualA(a);
    }
    /**
     * Devuelve true si el objeto que invoca este método es menor al objeto del argumento
     * @param a EnteroEnorme
     * @return boolean
     */
    private boolean menorCantidadDigitos(EnteroEnorme a){
        if(indiceMasSignificativo() > a.indiceMasSignificativo())
            return true;
        else
            return false;
    }
    /**
     * Devuelve el índice del dígito mas significativo
     * @return int
     */
    private int indiceMasSignificativo(){
        int posicionActual = 0;
        while(obtenerDigito(posicionActual) == 0 && (posicionActual < TAMANOENTEROENORME - 1)){
            posicionActual++;
        }
        return posicionActual;
    }
    /**
     * Devuelve true si el objeto EnteroEnorme a es igual al objeto que invoca este método
     * @param a EnteroEnorme
     * @return boolean
     */
    public boolean esIgualA(EnteroEnorme a){
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
     * Devuelve true si el objeto EnteroEnorme a no es igual al EnteroEnorme que invoca este método
     * @param a EneteroEnorme
     * @return boolean
     */
    public boolean noEsIgualA(EnteroEnorme a){
        return !esIgualA(a);
    }
    /**
     * Compara dos objetos EnteroEnorme y determina si son iguales o no
     * @param a EnteroEnorme a
     * @param b EnteroEnorme b
     * @return boolean true si son iguales, false si no lo son
     */
    public static boolean esIgualA(EnteroEnorme a, EnteroEnorme b){
        boolean igual = true;//< predeterminado son iguales
        for(int digito = 0; digito < a.enteroEnorme.length; digito++){
            if(a.enteroEnorme[digito] != b.enteroEnorme[digito])
                igual = false;
        }
        return igual;
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
    public static boolean esCero(EnteroEnorme a){
        boolean cero = true;//< predeterminado es cero
        for(int digito: a.enteroEnorme){
            if(digito != 0)
                cero = false;
        }
        return cero;
    }
    /**
     * Convierte a objeto String el número gigante
     * @return String representación en String del número
     */
    @Override
    public String toString(){
        String numero = new String(obtenerSigno() ? "+": "-");
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
