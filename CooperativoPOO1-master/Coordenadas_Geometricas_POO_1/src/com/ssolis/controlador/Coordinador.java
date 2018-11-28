package com.ssolis.controlador;

import com.ssolis.modelo.Punto;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @Instituto Rumiñahui
 * @author SSolis
 */
public class Coordinador {

    ArrayList<Punto> puntos = new ArrayList<Punto>();

    public void menu() {
        int op = 0;

        do {
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog("Ingresa una opción:\n"
                        + "1.- Ingresar un punto\n"
                        + "2.- Calcular distancia entre dos puntos\n"
                        + "3.- Redefinir ubicación\n"
                        + "4.- Imprimir puntos\n"
                        + "5.- Calcular distancia a la torre de control\n"
                        + "6.- Salir"));
                switch (op) {
                    case 1:
                        System.out.println("caso 1");
                        ingresarPunto();
                        break;

                    case 2:
                        System.out.println("caso 2");
                        calcularDistancia();
                        break;
                    case 3:
                        System.out.println("caso 3");
                        break;
                    case 4:
                        System.out.println("caso 4");
                        JOptionPane.showMessageDialog(null, imprimirPuntos());
                        break;
                    case 5:
                        System.out.println("caso 5");
                        break;
                    case 6:
                        System.out.println("caso 6");
                        break;
                }
            } catch (Exception e) {
                System.out.println("error");
            }
        } while (op != 6);

    }

    public void ingresarPunto() {
        int x = Integer.parseInt(JOptionPane.showInputDialog("Ingresa x"));
        int y = Integer.parseInt(JOptionPane.showInputDialog("Ingresa y"));
        puntos.add(new Punto(x, y));
    }

    public String imprimirPuntos() {
        String datos = "";
        for (Punto punto : puntos) {
            datos += (1 + puntos.indexOf(punto)) + ".- " + punto.toString() + "\n";
        }
        return datos;
    }

    public void calcularDistancia() {

        int sel1=0,sel2 = 0;
        try {
            sel1 = Integer.parseInt(JOptionPane.showInputDialog(imprimirPuntos() + "\n"
                    + "Ingresa un punto"))-1;
            sel2 = Integer.parseInt(JOptionPane.showInputDialog(imprimirPuntos() + "\n"
                    + "Ingresa un punto"))-1;
            double v1=Math.pow(puntos.get(sel2).getX()-puntos.get(sel1).getX(),2);
            double v2=Math.pow(puntos.get(sel2).getY()-puntos.get(sel1).getY(),2);;
            double dis = Math.sqrt(v1+v2);
            JOptionPane.showMessageDialog(null, dis);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}




