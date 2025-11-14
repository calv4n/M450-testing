# Teststrategie

## Aufgabe 1: Rabbatregel-Testfälle

### 1.1 Abstrakte Testfälle

| Testfall-ID | Bedingung                                | Erwartetes Ergebnis   |
|-------------|------------------------------------------|-----------------------|
| TF1         | Kaufpreis `< 15'000`                     | Kein Rabatt           |
| TF2         | Kaufpreis `>= 15'000` und `<= 20'000`    | 5% Rabatt             |
| TF3         | Kaufpreis `> 20'000` und `< 25'000`      | 7% Rabatt             |
| TF4         | Kaufpreis `>= 25'000`                    | 8.5% Rabatt           |

### 1.2 Konkrete Testfälle

| Testfall-ID | Kaufpreis (CHF) | Erwartetes Ergebnis   |
|-------------|-----------------|-----------------------|
| TF1         | 14'999          | Kein Rabatt          |
| TF2         | 15'000          | 5% Rabatt            |
| TF3         | 20'000          | 5% Rabatt            |
| TF4         | 20'001          | 7% Rabatt            |
| TF5         | 24'999          | 7% Rabatt            |
| TF6         | 25'000          | 8.5% Rabatt          |

## Aufgabe 2: Black-Box Tests für eine Autovermietungs-Website

### 2.1 Funktionale Black-Box-Tests

| ID  | Beschreibung                                                    | Erwartetes Resultat                                        | Effektives Resultat         | Status    | Mögliche Ursache            |
|-----|------------------------------------------------------------------|------------------------------------------------------------|-----------------------------|-----------|-----------------------------|
| 1   | Login mit gültigen Benutzerdaten                                | Benutzer wird erfolgreich eingeloggt                       | Login erfolgreich          | Erfolgreich    | -     |
| 2   | Suche nach einem Fahrzeug mit gültigen Parametern               | Eine Liste von verfügbaren Fahrzeugen wird angezeigt       | Fahrzeuge werden angezeigt   | Erfolgreich    | -     |
| 3   | Reservierung eines Fahrzeuges mit gültigen Daten                | Fahrzeug wird erfolgreich reserviert                       | Reservierung erfolgreich    | Erfolgreich | -                          |
| 4   | Stornierung einer bestehenden Reservierung                      | Reservierung wird erfolgreich storniert                    | Stornierung schlägt fehl    | Fehler    | API-Aufruf nicht erfolgreich |
| 5   | Anzeige der Rechnung nach Abschluss einer Fahrzeugvermietung    | Eine korrekte Rechnung wird angezeigt                     | Fehlerhafte Rechnung        | Fehler    | Fehler in der Berechnungslogik |
         

## Aufgabe 3: Banksoftware-Tests

### 3.1 Mögliche **Black-Box** Testfälle

Diese basieren auf Benutzeraktionen und stellen sicher, dass das System wie erwartet funktioniert, ohne den Code direkt zu betrachten.

Bei der Eingabe ist es unübersichtlich, da nicht klar hervorgehoben wird, dass man auch eine Zahl eingeben kann. Dies könnte durch eine klarere Benutzerführung verbessert werden, beispielsweise durch eine explizite Information im Menü, die darauf hinweist, dass neben den Buchstabenoptionen auch Kontonummern eingegeben werden können.

**Kontenerstellung**
- Erstelle ein Konto mit einem gültigen Namen, einer Währung und einem Startguthaben.
- Teste ungültige Eingaben (z. B. leere Namen, unbekannte Währungen).

**Wechselkursabfrage**
- Abfrage des Wechselkurses zwischen zwei unterstützten Währungen.
- Teste ungültige oder nicht unterstützte Währungen.

**Benutzerinteraktion**
- Navigiere durch das Menü und prüfe die Reaktion auf jede Option.
- Teste ungültige Eingaben (z. B. Buchstaben, die nicht vorgesehen sind).

---

### 3.2 Mögliche **White-Box** Testfälle

**`Account`-Klasse**
- Teste `withdraw()` und `deposit()`-Methoden auf korrekte Berechnungen.
- Teste `pseudoDeleteAccount()`, um sicherzustellen, dass alle Felder korrekt zurückgesetzt werden.

**`Bank`-Klasse**
- Teste `createAccount()` und `deleteAccount()`, um sicherzustellen, dass Konten korrekt hinzugefügt und entfernt werden.
- Teste `getAccount(int nr)`, um sicherzustellen, dass Konten basierend auf der ID korrekt abgerufen werden.

**`Counter`-Klasse**
- Teste `chooseAccount()` und prüfe, ob Benutzeraktionen korrekt verarbeitet werden.
- Teste `transferAmount()` auf korrekte Berechnungen bei Wechselkursen.

**`ExchangeRateOkhttp`**
- Teste `getExchangeRate()`, um sicherzustellen, dass die API-Abfrage korrekt funktioniert.
- Simuliere Fehler wie ungültige Antworten oder Netzwerkfehler.

---

#### Code-Verbesserungen und Best Practices

**Fehlerbehandlung**
- Ersetze `System.out.println` durch ein konsistentes Logging-System.
- Füge robustere Fehlerbehandlungen hinzu, insbesondere bei der API-Abfrage in `ExchangeRateOkhttp`.

**Modularisierung**
- Zerlege die großen Methoden in kleinere, besser lesbare Methoden. Zum Beispiel in der `Counter`-Klasse.

**API-Key-Schutz**
- Der API-Key in `ExchangeRateOkhttp` sollte nicht im Code hinterlegt sein. Verwende Umgebungsvariablen oder eine sichere Konfiguration.
