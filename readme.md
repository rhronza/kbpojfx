     Aplikace pro výpočet převodu peněžních částek pomocí kurzových převodů (úloha k příjímacímu řízení do Pojišťovny KB)

aplikace je rozdělena do 4 modulů:
1. boot
2. business-logic
3. persistence
4. rest-api

počítá převody:
1. z cizí měny do CZK
2. z CZK do cizí měny 
3. převody mezi cizími měnami (v tomto případě se částka nejprve přepočítá do CZK a z CZK do cílové cizí měny)

Poznámka: aktuálně jsou v databázi 3 cizí měny: **EUR, USD, INR (indická rupie)**


Aplikace využívá in-memory databázi. Inicializuje se prostřednictvím demo iterace v metodě **onApplicationEvent** třídy **InitDatabase**, která implementuje AplicationLister.
Inicializují kurzové lístky zpětně 31 dnů pro měny USD, EUR, INR. Kurzy pro programaticky snižován o 0,1 měnové jednotky pro každý den (aby bylo docílen různý kurz pro každý den).
V produkci by se použila buď každodenní inkrementační aktualizace kurzů např. z textového souboru nebo využila rest služba 3.strany.

Pro vizualizaci Api je možno využít **swagger ui** na url localhost:8080/swagger-ui.html (v případě spuštění na lokálím počítači).





 

