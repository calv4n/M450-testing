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
        
        // Beispiel-Tests
        double price1 = calculator.calculatePrice(1000, 200, 300, 4, 5); // Erwarteter Preis basierend auf Eingabewerten
        double expectedPrice1 = 1000 * 0.95 + 200 + 300 * 0.9; // Berechnung des erwarteten Ergebnisses
        
        if (price1 != expectedPrice1) {
            System.out.println("Test 1 fehlgeschlagen. Erwarteter Preis: " + expectedPrice1 + ", Erhaltener Preis: " + price1);
            test_ok = false;
        }

        // Weitere Testfälle können hier hinzugefügt werden

        return test_ok;
    }
}
