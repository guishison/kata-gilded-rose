package edu.alenasoft.gildedrose;

public class StandardUpdateQualityStrategy implements UpdateQualityStrategyInterface {

    @Override
    public void Update(Item item) {

        if (item.quality > 0) {
            item.quality -= 1;
        }

        // Decrementa el SellIn en dicha fecha
        item.sellIn -= 1;

        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality -= 1;
            }
        }
    }
}