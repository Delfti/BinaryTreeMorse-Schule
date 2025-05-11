import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String eingabe = "";
    
    while (true) { 
      System.out.println();
      System.out.println("Geben Sie C ein fuer das codieren einer Nachricht, D fuer das decodieren und T fuer die ausgabe der Buchstaben mit Morsecode.");
      eingabe = sc.nextLine();
      
      if (eingabe.toLowerCase().equals("c")) {
        System.out.println();
        System.out.println("Geben Sie ihre Nachricht ein:");
        
        eingabe = sc.nextLine().toUpperCase();
        System.out.println();
        System.out.println(String.format("Codierte Nachricht: %s",getMorseCode(eingabe)));
      } else if (eingabe.toLowerCase().equals("d")) {
        System.out.println();
        System.out.println("Geben Sie den Morsecode an der decodiert werden soll:");
        
        eingabe = sc.nextLine().trim();
        System.out.println();
        System.out.println(String.format("Decodierte Nachricht: %s",getBuchstaben(eingabe)));
      } else if (eingabe.toLowerCase().equals("t")){
        System.out.println();
        System.out.println("Hier finden sie den vollstaendigen Baum:");
        System.out.println();
        traversieren();
      } else {
        System.out.println();
        System.out.println(String.format("Die eingabe: %s ist ungueltig bitte geben sie C oder D ein.", eingabe)); 
      }
    }
  }
  
  public static String getBuchstaben(String pCode) {
    String[] code = pCode.split(" ");
    String erg = "";
    MorseCodeTranslator translator = new MorseCodeTranslator();
    
    for (int i = 0; i < code.length; i++) {
      if (code[i].equals("/")) {
        erg += " ";
      } else {
        erg += translator.decode(translator.getRoot(), code[i]);
      }
    }
    return erg;
  }
  
  public static String getMorseCode(String pBuchstaben) {
    String current = "";
    String erg = "";
    MorseCodeTranslator translator = new MorseCodeTranslator();
    
    for (int i = 0; i < pBuchstaben.length(); i++) {
      current = Character.toString(pBuchstaben.charAt(i));
      
      if (current.equals(" ")) {
        erg += "/ ";
      } else {
        erg += translator.encode(translator.getRoot(), current) + " ";
      }
    }
    return erg;
  }
  
  public static void traversieren() {
    MorseCodeTranslator translator = new MorseCodeTranslator();
    
    translator.traverse(translator.getRoot());
  }
}