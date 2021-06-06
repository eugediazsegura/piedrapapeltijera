/*Hacé un programa que te permita jugar a “Piedra, papel o tijera”.
  En primer lugar, la aplicación solicita el nombre de cada gamer,
  después empieza el juego. El juego consiste en pedir qué opción
  elige cada uno y sumar puntos al winner —si lo hay—. Definí y
  utilizá una función llamada cualGana con dos parámetros con las
  jugadas de cada uno, que devuelve 0 en caso de empate, 1 si gana
  el primero, 2 si gana el segundo. El juego termina cuando el
  primero elige “*” como indicador de final.*/

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner;
        scanner = new Scanner(System.in);
        String primerJugador;
        System.out.println("Ingrese primer jugador");
        primerJugador = scanner.nextLine();
        String segundoJugador;
        System.out.println("Ingrese segundo jugador");
        segundoJugador = scanner.nextLine();
        String jugada1;
        do{
            System.out.println("Ingrese piedra(1), papel(2) o tijera(3) o * para salir del juego");
            jugada1 = scanner.nextLine();
                if(jugada1.equals("*")){
                    System.out.println("jugada finalizada");
                    return;
                }else if(esValido(jugada1)){
                    String jugada2;
                    System.out.println("Ingrese piedra(1), papel(2) o tijera(3)");
                    jugada2 = scanner.nextLine();
                    if(esValido(jugada2)){
                        Integer resultado = cualGana(jugada1, jugada2);
                        if (resultado == 0){
                            System.out.println("Esto es un empate");
                        }else if(resultado == 1){
                            System.out.println("Ha ganado " + primerJugador);
                        }else{
                            System.out.println("Ha ganado " + segundoJugador);
                        }
                    }else{
                        System.out.println("Ingrese un valor correcto");
                        return;
                    }
                }else{
                    System.out.println("Ingrese un valor correcto");;
                }

        }while(!jugada1.equals("*"));
    }
    public static boolean esValido(String partida){
        return (partida.equals("1") || partida.equals("2") ||partida.equals("3"));
    }

    public static Integer cualGana(String partidaA, String partidaB){
        if(partidaA == partidaB){
            return 0;
        }else if(partidaA.equals("1") && partidaB.equals("3")|| partidaA.equals("2") && partidaB.equals("1")|| partidaA .equals("3") && partidaB.equals("2")) {
            return 1;
        }else{
            return 2;
        }
    }
}


