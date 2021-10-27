# Car Sales App

Ein Projekt um meine Kenntnisse in Java und MySQL zu refreshen und zu verbessern.

## Erster Meilenstein

 - [x] Verbinden mit der MySQL-Datenbank
 - [x] Ein neues Auto erfassen
 - [x] Alle Autos auslesen
 - [x] Ein Auto nach ID finden
 - [x] Ein Auto mit der ID entfernen


## Zweiter Meilenstein

 - [ ] Ein Auto mit der ID ändern
 - [ ] Alle Autos mit der Automarke auslesen
 - [ ] Alle Neuwagen (bzw. Occassion) auslesen
 - [ ] Mook-Up erstellen für GUI


## Dritter Meilenstein

 - [ ] GUI erstellen
 - [ ] Backend und Frontend zusammenführen
 - [ ] LOG-Files erstellen (Serialisierung)
 - [ ] Exceptions einsetzen

---
---

### How to connect with MySQL-Database 

```java
public Connection getAConnection() throws SQLException {

		// Namen der Datenbank und des Users und auch das Passwort eingeben!
		return DriverManager.getConnection(
                "jdbc:mysql://localhost/[DATABASE]?user=[USERNAME]&password=[PASSWORD]&useUnicode=true&characterEncoding=UTF-8");
	}
```