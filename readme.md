     Aplikace pro výpočet převodu peněžních částek pomocí kurzových převodů (úloha k příjímacímu řízení do Pojišťovny KB)

úloha počítá převody:
1. z cizí měny do CZK
2. z CZK do cizí měny 
3. převody mezi cizími měnami (v tomto případě se částka nejprve přepočítá do CZK a z CZK do cílové cizí měny)


Aplikace využívá in-memory databázi, která se inicializuje prostřednictvím demo iterace v metodě **onApplicationEvent** třídy **InitDatabase**, která implementuje AplicationLister.
Inicializují kuzové lístky zpětně 31 dnů pro měny USD, EUR, INR (indická rupie). Kurzy pro programaticky snižován o 0,1 měnové jednotky pro každý den (aby bylo docíleno různého kurz pro každý den)
V produkci by se použila buď každodenní inkrementační aktualizace kurzů např. z textového souboru nebo využila rest služba 3.strany.

Pro vizualizaci Api je možno využít **swagger ui** na url localhost:8080/swagger-ui.html (v případě spuštění na lokálím počítači).





 

