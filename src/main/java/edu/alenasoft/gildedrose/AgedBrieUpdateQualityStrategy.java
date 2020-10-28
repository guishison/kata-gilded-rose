package edu.alenasoft.gildedrose;

public class AgedBrieUpdateQualityStrategy implements UpdateQualityStrategyInterface {
    @Override
    public void Update(Item item) {
        if(item.quality < 50){
            item.quality++;
        }
        item.sellIn--;
    }
}
