# Grundlagen Testing und Testing im Vorgehensmodell

## Aufgabe 1 
In der IT gibt es eine riesen Anzahl von Testarten, um die Funktionalität von Software zu testen. Hier sind drei häufige Testarten die ich aus der Praxis kenne:

**1. Unit-Tests**

Man schreibt Unit-Tests, um sicherzustellen, dass jede Komponente oder Funktionen in Isolation wie erwartet funktioniert. Die Tests werden automatisiert und während der Entwicklung durchgeführt.

**2. Integrationstests**

Integrationstests sind wichtig, um zu sichern, dass unterschiedliche Teile der Software zusammenarbeiten und korrekt programmiert sind. Ein Beispiel ist das Testen der Verbindung zwischen dem Backend und der Datenbank.

**3. End-to-End-Tests**

Systemtests testen das gesamte Projekt. Es kann sicherstellen, dass eine Anwendung alle Anforderungen erfüllt und stabild geht, indem User-Szenarien simuliert werden.

## Aufgabe 2 

**- Softwarefehler (Bug)**

Eine App stürzt beim Öffnen eines bestimmten Punkts ab, weil eine Stelle im Code falsch verwendet oder Ausgeführt wird. Dieser Fehler hindert Nutzer daran, die App vollständig zu nutzen.

**- Softwaremangel**

Eine Online Bankiing app bietet keine Zwei Faktor Authentifizierung an. Dieser Mangel erhöht das Sicherheits Risiko und könnte eventuell zu einem ungewollten Zugang führen.

**- Beispiel für hohen Schaden bei Softwarefehler**

Ein Fehler in einem Event Ticket kauf App, dass Tickets doppelt berechnet werden. Dies könnte zu finanziellen Fehler und Beschwerden führen und den Ruf des Unternehmens senken.

## Aufgabe 3

Umsetzung der `calculatePrice` Methode und des Tests:

```java

public class PriceCalculator {
    
    public double calculatePrice(double baseprice, double specialprice, double extraprice, int extras, double discount) {
        double addon_discount;
        
        // Berechnung des Rabatts
        if (extras >= 5) {
            addon_discount = 15;
        } else if (extras >= 3) {
            addon_discount = 10;
        } else {
            addon_discount = 0;
        }
        
        // Es wird der höhere Rabatt verwendet 
        if (discount > addon_discount) {
            addon_discount = discount;
        }
        
        // Berechnung Endpreis
        double result = baseprice * (1 - discount / 100.0) 
                        + specialprice 
                        + extraprice * (1 - addon_discount / 100.0);
        
        return result;
    }
}

```

**Test:**

```java

public class PriceCalculatorTest {
    
    public static void main(String[] args) {
        boolean result = test_calculate_price();
        if (result) {
            System.out.println("Alle Tests bestanden.");
        } else {
            System.out.println("Ein oder mehrere Tests sind fehlgeschlagen.");
        }
    }
    
    public static boolean test_calculate_price() {
        PriceCalculator calculator = new PriceCalculator();
        boolean test_ok = true;
        
        double price1 = calculator.calculatePrice(1000, 200, 300, 4, 5); 
        double expectedPrice1 = 1000 * 0.95 + 200 + 300 * 0.9; // Berechnung vom erwarteten  Preis
        
        if (price1 != expectedPrice1) {
            System.out.println("Test 1 fehlgeschlagen. Erwarteter Preis: " + expectedPrice1 + ", Erhaltener Preis: " + price1);
            test_ok = false;
        }

        return test_ok;
    }
}

```

## Aufgabe 3 Bonus

Im Code ist ein logischer Fehler in der Berechnung des Rabatts vorhanden:

```java

if (extras >= 3) 
    addon_discount = 10;
else if (extras >= 5)
    addon_discount = 15;
else 
    addon_discount = 0;

```

Diese berechnung ist fehlerhaft, weil die Prüfung `extras >= 3` immer zuerst zutrifft, sobald mindestens 3 Zusatzausstattungen ausgewählt wurden. Dadurch wird der 15%-Rabatt für 5 oder mehr Zusatzausstattungen NIE angewendet.
