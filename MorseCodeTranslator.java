import com.sun.net.httpserver.BasicAuthenticator;

public class MorseCodeTranslator {

  private BinaryTree<Buchstabe> root;
  
  public MorseCodeTranslator() {
    root = new BinaryTree<>(new Buchstabe("Root", ""), new BinaryTree<>(new Buchstabe("E", "."), new BinaryTree<>(new Buchstabe("I", ".."), new BinaryTree<>(new Buchstabe("S", "..."), new BinaryTree<>(new Buchstabe("H", "...."), null, null), new BinaryTree<>(new Buchstabe("V", "...-"), null, null)), new BinaryTree<>(new Buchstabe("U", "..-"), new BinaryTree<>(new Buchstabe("F", "..-."), null, null), null)), new BinaryTree<>(new Buchstabe("A", ".-"), new BinaryTree<>(new Buchstabe("R", ".-."), new BinaryTree<>(new Buchstabe("L", ".-.."), null, null), null), new BinaryTree<>(new Buchstabe("W", ".--"), new BinaryTree<>(new Buchstabe("P", ".--."), null, null), new BinaryTree<>(new Buchstabe("J", ".---"), null, null)))), new BinaryTree<>(new Buchstabe("T", "-"), new BinaryTree<>(new Buchstabe("N", "-."), new BinaryTree<>(new Buchstabe("D", "-.."), new BinaryTree<>(new Buchstabe("B", "-..."), null, null), new BinaryTree<>(new Buchstabe("X", "-..-"), null, null)), new BinaryTree<>(new Buchstabe("K", "-.-"), new BinaryTree<>(new Buchstabe("C", "-.-."), null, null), new BinaryTree<>(new Buchstabe("Y", "-.--"), null, null))), new BinaryTree<>(new Buchstabe("M", "--"), new BinaryTree<>(new Buchstabe("G", "--."), new BinaryTree<>(new Buchstabe("Z", "--.."), null, null), new BinaryTree<>(new Buchstabe("Q", "--.-"), null, null)), new BinaryTree<>(new Buchstabe("O", "---"), null, null))));
  }
  
  public BinaryTree<Buchstabe> getRoot() {
    return this.root;
  }
  
  // Von Morsecode zu Buchstaben
  public String decode(BinaryTree<Buchstabe> aktuell, String gesucht) {
    if (aktuell.getContent() != null) {
      if (aktuell.getContent().getCode().equals(gesucht)) {
        return aktuell.getContent().getBuchstabe();
      }
    }
    
    if (aktuell.getLeftTree() != null) {
      String erg = decode(aktuell.getLeftTree(), gesucht);
      if (erg != null) {
        return erg;
      }
    }
    
    if (aktuell.getRightTree() != null) {
      String erg = decode(aktuell.getRightTree(), gesucht);
      if (erg != null) {
        return erg;
      }
    }
    return null;
  }

  // Von Buchstaben zu Morsecode
  public String encode(BinaryTree<Buchstabe> aktuell, String gesucht) {
    if (aktuell.getContent() != null) {
      if (aktuell.getContent().getBuchstabe().equals(gesucht)) {
        return aktuell.getContent().getCode();
      }
    }
    
    if (aktuell.getLeftTree() != null) {
      String erg = encode(aktuell.getLeftTree(), gesucht);
      if (erg != null) {
        return erg;
      }
    }
    
    if (aktuell.getRightTree() != null) {
      String erg = encode(aktuell.getRightTree(), gesucht);
      if (erg != null) {
        return erg;
      }
    }
    return null;
  }
  
  public void traverse(BinaryTree<Buchstabe> pAktuell) {
    if (pAktuell != null) {
      if (pAktuell.getContent() != null && !pAktuell.getContent().getBuchstabe().equals("")) {
        System.out.println(String.format("Buchstabe: %s | Code: %s", pAktuell.getContent().getBuchstabe(), pAktuell.getContent().getCode()));
      }
      traverse(pAktuell.getLeftTree());
      traverse(pAktuell.getRightTree());
    }
  }
  
  public void add(String pBuchstabe, String pCode) {
    String path[] = pCode.trim().split("");
    BinaryTree<Buchstabe> aktuell = this.root;
    
    for (int i = 0; i < path.length; i++) {
      boolean istEnde = (i == path.length - 1);
      
      if (path[i].equals(".")) {
        if (aktuell.getLeftTree() == null) {
          aktuell.setLeftTree(new BinaryTree<Buchstabe>(istEnde ? new Buchstabe(pBuchstabe, pCode) : new Buchstabe("", "")));
        }
        aktuell = aktuell.getLeftTree();
      } else if (path[i].equals("-")) {
        if (aktuell.getRightTree() == null) {
          aktuell.setRightTree(new BinaryTree<Buchstabe>(istEnde ? new Buchstabe(pBuchstabe, pCode) : new Buchstabe("", "")));
        }
        aktuell = aktuell.getRightTree();  
      } else {
        System.out.println(String.format("Ungueltiges Zeichen: %s im angegebenen Code", path[i]));  
      }
    }
  }
}