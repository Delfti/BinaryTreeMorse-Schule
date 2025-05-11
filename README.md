## 📝 Projektbeschreibung

Dieses Java-Projekt implementiert einen Morsecode-Übersetzer mithilfe eines Binärbaums. Der Binärbaum dient zur effizienten Speicherung und Navigation der Morsecode-Zeichen. Das Programm bietet eine textbasierte Benutzerschnittstelle zur Codierung und Decodierung von Nachrichten sowie zur Ausgabe aller im Baum gespeicherten Zeichen samt Morsecode.

## 🔍 Funktionen

- **Codierung**: Umwandlung einer Klartext-Nachricht in Morsecode.
- **Decodierung**: Umwandlung von Morsecode zurück in lesbaren Text.
- **Baum anzeigen**: Ausgabe aller Buchstaben und deren Morsecode im Baum.

## ⚙️ Technische Details

- Der Morsecode wird als Binärbaum aufgebaut:
  - `.` führt nach links,
  - `-` führt nach rechts.
- Jeder Knoten im Baum enthält ein Objekt der Klasse `Buchstabe`, das den Buchstaben und seinen Morsecode speichert.
- Die Klassen im Projekt:
  - `BinaryTree`: Generische Binärbaumstruktur.
  - `Buchstabe`: Repräsentiert einen Buchstaben samt Morsecode.
  - `MorseCodeTranslator`: Verwaltet den Baum und bietet Funktionen zum Codieren und Decodieren.
  - `Main`: Stellt die textbasierte Benutzerschnittstelle bereit.

## 💡 Beispiel

- Eingabe: C
  - Nachricht: HELLO
  - Ausgabe: .... . .-.. .-.. ---

- Eingabe: D
  - Code: .... . .-.. .-.. ---
  - Ausgabe: HELLO

## ▶️ Ausführung

Das Projekt kann direkt in einer Java-IDE oder über die Konsole mit einem JDK ausgeführt werden:

```bash
📂 Struktur
├── Main.java                // Einstiegspunkt
├── MorseCodeTranslator.java // Codierung/Decodierung mit Baum
├── BinaryTree.java          // Generischer Binärbaum
├── Buchstabe.java           // Datenstruktur für Buchstaben + Code
