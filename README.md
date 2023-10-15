# Wstęp

Program:
* Page Object Model - przypomnienie
* Komponenty UI
* Komponenty vs. Page Factory
* Komponenty vs. Page Factory + @FindBy

Materiały:
* Strona testowa: https://breathtaking.website/selenium_20231014/
* Prezentacja: https://breathtaking.website/selenium_20231014/files/prezentacja.pdf

# Zawartość (chronologicznie)

Kod utworzony podczas warsztatów znajduje się w lokalizacji `src/main/java/stacja`

## Część pierwsza

W tej części skupiliśmy się na wydzieleniu pojedynczego komponentu. Zaczęliśmy od rozwiązania bez Page Object Model,
a skończyliśmy na komponencie inicjalizowanym bezpośrednio poprzez adnotację `@FindBy`:
```java
@Getter
@FindBy(css = ".container")
private TableComponent table;
```

Zadanie do wykonania:
```
Wyświetl: tytul tabeli, kolumny, udzial Chrome na rynku
```

Rozwiązania:
* `tabelka.v1` - klasyczne rozwiązanie bez POM
* `tabelka.v2` - wydzielenie selektorów i getterów `WebElement`'ów do Page Object Model
* `tabelka.v3` - zastąpienie getterów `WebElement` getterami funkcjonalnymi (np. `open`, `getTitle`, ...)
* `tabelka.v4pageFactory` - wprowadzenie `PageFactory` wraz z adnotacją `@FindBy`
* `tabelka.v5pageFactoryWithComponent` - wydzielenie komponentu `TableComponent` w ramach osobnej klasy
* `tabelka.v6pageFactoryWithComponent` - wyrzucenie odniesień do `WebDriver` w komponencie
* `tabelka.v7pageFactoryWithComponent` - wprowadzenie `TableRowComponent`, przeniesienie wszystkich selektorów do adnotacji `@FindBy`
* `tabelka.v8pageFactoryWithComponent` - integracja komponentu `TableComponent` z adnotacją `@FindBy` poprzez implementację `CustomFieldDecorator`

## Część druga
W tej częsci skupiliśmy się na wydzieleniu listy komponentów:
```java
@Getter
@FindBy(css = ".card")
private List<ShopItemComponent> items;
```

Zadanie do wykonania:
```
Wyświetl detale dla każdej karty produktu w formacie:
nazwa | cena | url_obrazka

Dodaj każdy z produktów do koszyka. 
```

Rozwiązania:
* `shop.v1.notWorking` - próba wykorzystania finalnego rozwiązania z poprzedniej części do inicjalizacji Listy komponentów przez
  adnotację `@FindBy`
* `shop.v2` - dostosowanie `CustomFieldDecorator` do pracy z Listami komponentów przy inicjalizacji przez `@FindBy`

## Część trzecia
W tej części połączyliśmy rozwiązania z dwóch kolejnych części, oraz zrefaktorowaliśmy istniejący kod w taki sposób, aby
w maksymalnie prosty sposób móc definiować dowolną ilość komponentów bez zmian w naszym "`factory`".

Zadanie do wykonania: te same zadania co w części pierwszej i drugiej.

Rozwiązania:
`finalVersionNotWorking.finalVersion` - próba wykorzystania obu rozwiązań z poprzednich części. `...ListHandler` inicjalizujący
listy nie ma prawa działać ze względu na dynamiczne inicjalizowanie obiektu typu `TypeComponent`
`finalVersion` - finalne rozwiązanie dające możliwość definiowania dowolnych komponentów zarówno w postaci pojedynczych
elementów jak i list