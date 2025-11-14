# Aufgabe 3: Junit Tests

## Aufgabe 1 Maven Simpler Rechner
In dieser Aufgabe erstellen Sie eine Calculator-Klasse mit grundlegenden mathematischen Funktionen wie Addition, Subtraktion, Multiplikation und Division. Anschließend schreiben Sie Unit-Tests mit JUnit 5, um die Methoden zu testen und führen diese sowohl in der Entwicklungsumgebung als auch über Maven auf der Kommandozeile aus.

## Aufgabe 2: JUnit Zusammenfassung

### 1. Assertions
- Überprüfen, ob Ergebnisse korrekt sind.
- Beispiel: `assertEquals(expected, actual)` prüft, ob das tatsächliche Ergebnis mit dem erwarteten übereinstimmt.

### 2. Annotations
- Steuern von Tests.
- Beispiele: 
  - `@Test` - Markiert eine Methode als Test.
  - `@BeforeEach` - Führt Code vor jedem Test aus, z. B. um Objekte vorzubereiten.

### 3. Beispiel: Test für die `add`-Methode des Rechners
```java
@Test
void testAdd() {
    Calculator calculator = new Calculator();
    assertEquals(5, calculator.add(2, 3));
}

```

## Aufgabe 3 Übersicht
Die Banken-Simulation ist eine Java-Anwendung, die verschiedene Bankkonten und Operationen verwaltet. Das Projekt ist als Maven-Projekt aufgebaut.

---

## Hauptbestandteile

### Bank
- Zentraler Einstiegspunkt.
- Verwaltet Konten und bietet Methoden wie:
  - `createPromoYouthSavingsAccount()`
  - `createSalaryAccount(double salary)`

### **Konten**
- **SavingsAccount:** Standard-Sparkonto.
- **SalaryAccount:** Konto für Gehaltszahlungen.
- **PromoYouthSavingsAccount:** Jugend-Sparkonto mit Sonderkonditionen.

### Comparatoren
- Sortieren Konten basierend auf dem Kontostand.

### Hilfsmethoden
- `BankUtils`: Unterstützt Berechnungen und Datenverarbeitung.

---

## Ablauf
1. Bank-Instanz erstellen.
2. Konten hinzufügen.
3. Operationen wie Einzahlungen und Abhebungen durchführen.
4. Konten sortieren oder Informationen abrufen.

---

## Fazit
Die Simulation ist modular und einfach erweiterbar. Sie bietet eine Basis für grundlegende Bankoperationen.
