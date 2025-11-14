public class PriceCalculator {
    
    public double calculatePrice(double baseprice, double specialprice, double extraprice, int extras, double discount) {
        double addon_discount;
        
        // Berechnung des Zubehör-Rabatts
        if (extras >= 5) {
            addon_discount = 15;
        } else if (extras >= 3) {
            addon_discount = 10;
        } else {
            addon_discount = 0;
        }        
        
        // Es wird der höhere Rabatt verwendet (Händler- oder Zubehörrabatt)
        if (discount > addon_discount) {
            addon_discount = discount;
        }

        
        // Berechnung des Endpreises
        double result = baseprice * (1 - discount / 100.0) 
                        + specialprice 
                        + extraprice * (1 - addon_discount / 100.0);
        
        return result;
    }
}
