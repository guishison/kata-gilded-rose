El primer Bug encontrado fue el siguiente:

en la linea 68
items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
nos dice que la calidad va a ser calidad - calidad, eso es un mal uso de operadores, por ejemplo lo siguiente:

int j = 5 / 5; //always 1
int k = 5 - 5; //always 0
c.equals(c); //always true

El valor siempre dara como resultado "0"





Las cadenas duplicadas hacen que el proceso de refactorización sea propenso a errores, ya que debe asegurarse de actualizar todas las ocurrencias.
Se tiene que referencia a constantes, que aunque se repitan, el cambio solo se realiza en un lugar.

"Backstage passes to a TAFKAL80ETC concert"





La combinación de declaraciones if colapsables aumenta la legibilidad del código. Ej:
if (file != null) {
  if (file.isFile() || file.isDirectory()) {
    /* ... */
  }
}

La solucion seria
if (file != null && isFileOrDirectory(file)) {
  /* ... */
}

private static boolean isFileOrDirectory(File file) {
  return file.isFile() || file.isDirectory();
}





La Complejidad Cognitiva o demaciados if else es una medida de qué tan difícil es comprender el flujo de control de un método. 
Los métodos con una alta complejidad cognitiva serán difíciles de mantener.


 1   for (int i = 0; i < items.size(); i++) {
  2    if ((!"Aged Brie".equals(items.get(i).getName()))
   3       && !"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) {
  4      if (items.get(i).getQuality() > 0) {
   5       if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
            items.get(i).setQuality(items.get(i).getQuality() - 1);
          }
        }
 6     } else {
  7      if (items.get(i).getQuality() < 50) {
          items.get(i).setQuality(items.get(i).getQuality() + 1);
  8        if ("Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) {
   9         if (items.get(i).getSellIn() < 11) {
  10            if (items.get(i).getQuality() < 50) {
                items.get(i).setQuality(items.get(i).getQuality() + 1);
              }
            }
  11          if (items.get(i).getSellIn() < 6) {
   12           if (items.get(i).getQuality() < 50) {
                items.get(i).setQuality(items.get(i).getQuality() + 1);
              }
            }
          }
        }
      }
 13     if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
        items.get(i).setSellIn(items.get(i).getSellIn() - 1);
      }
  14    if (items.get(i).getSellIn() < 0) {
   15     if (!"Aged Brie".equals(items.get(i).getName())) {
   16       if (!"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) {
  17          if (items.get(i).getQuality() > 0) {
  18            if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
                items.get(i).setQuality(items.get(i).getQuality() - 1);
              }
            }
   19       } else {
            items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
          }
   20     } else {
   21       if (items.get(i).getQuality() < 50) {
            items.get(i).setQuality(items.get(i).getQuality() + 1);
          }
        }
      }
    }
	
	
	
	
	
	
	Para la refactorizacion primero es crear la interfaz. Esta es una interfaz con un solo un método que toma un artículo. 
	Lo que hara es la actualización directamente del artículo en sí, asi que no necesita un return.
	
	public interface UpdateQualityStrategyInterface {
    void Update(Item item);
}

principios solid no cumplidos
open close se tenia que tocar siempre el update quality 
principio de responsabilidad simple no existe por ser una superclase que hace de todo

para el siguiente paso utilizare el patron Factory en donde defina una interfaz para crear un objeto, pero las subclases decidiran qué clase instanciar. 
El método Factory permite que una clase difiera la instanciación que utiliza a subclases.

Usaremos el patron Factory porque no interesa qué objeto recibe, solo le importa que implemente la interfaz que espera. 
