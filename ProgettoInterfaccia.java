package progettoInterfaccia;
import java.util.*;

public class ProgettoInterfaccia {

 public static class Punto {

public interface Poligono {

 public static class Triangolo implements Poligono {

 public static class Quadrilatero implements Poligono {

 //attributi
 private Punto punti[];

 // costruttore

 public Quadrilatero() {
 punti = new Punto[4];
 }

 public Quadrilatero(Punto p[]) {
 if (p.length != 4)
 System.out.println("Non è un quadrilatero");
 else
 punti = p;
 }

public Quadrilatero (double x1, double y1, double x2, doubley2, double x3, double y3, double x4, double y4) {
 this(); // crea l'array di 4 punti
 punti[0] = new Punto('A', x1, y1);
 punti[1] = new Punto('B', x2, y2);
 punti[2] = new Punto('C', x3, y3);
 punti[3] = new Punto('D', x4, y4);
 }

 public Quadrilatero(double p[]) {
 this();
 if (p.length != 8)
 System.out.println("Non è un quadrilatero");
 else {
 char nome = 'A';
 for(int i=0; i<p.length; i += 2) {
 punti[i/2]= new Punto(nome,p[i], p[i+1]);
 // Per Test
 //System.out.println("Ho appena creato l'angolo con nome "+nome+" e coordinata x "+p[i]+" e coordinata y"+p[i+1]);

ProgettoInterfaccia.java martedì 12 settembre 2023, 11:24275 nome += 1;
 }
 }
 }

 // altri metodi

 public double perimetro() {
 double perimetro = 0;
 for(int i = 0; i<punti.length -1; i++){
 perimetro += punti[i].calcolaDistanza(punti[i+1]);
 }
 perimetro += punti[punti.length-1].calcolaDistanza
(punti[0]);
 return perimetro;
 }

 public String toString() {
 String temp = "";
 for(int i = 0; i < punti.length; i++)
 temp += punti[i].getNome() + "(" + punti[i].getX
()+", "+punti[i].getY()+");\n";
 return temp;
 }
 }

 public static void main(String[] args) {
 Poligono figura;
 int lati;
 String tipoFigura;
 boolean isFigura = true;
 double p[];
 Scanner sc = new Scanner(System.in);

 System.out.println("Quanti lati ha la figura?");
 lati = sc.nextInt();

 p = new double[lati*2];

 for(int i = 0; i < p.length; i++) {
 if ((i%2)==0) {
 System.out.println("Inserire coordinata x #" + (int) (i/2));
 p[i] = sc.nextDouble();
 } else {
 System.out.println("Inserire coordinata y #" + (int) (i/2));
 p[i] = sc.nextDouble();
 }
 }

ProgettoInterfaccia.java martedì 12 settembre 2023, 11:24321 sc.close();

 switch(lati) {
 case(3): figura = new Triangolo(p);
 tipoFigura = "Triangolo";
 break;
 case(4): figura = new Quadrilatero(p);
 tipoFigura = "Quadrilatero";
 break;
 default: isFigura = false;
 tipoFigura = "";
 figura = new Triangolo();
 }
 if (isFigura)
 System.out.println("Il perimetro del "+tipoFigura+"
acquisito è: " + figura.perimetro());
 else
 System.out.println("Non gestiamo figure con "+lati+"
lati");
 //System.out.println(figura.toString());
