package edu.alenasoft.gildedrose;

public class UpdateQualityStrategyFactory {
    public static UpdateQualityStrategyInterface Create(Item item)
    {
        if (item.name.contains("Sulfuras"))
        {
            return new SulfurasUpdateQualityStrategy();
        }
        else if (item.name.contains("Aged Brie"))
        {
            return new AgedBrieUpdateQualityStrategy();
        }
        else if (item.name.contains("Backstage pass"))
        {
            return new BackstagePassesUpdateQualityStrategy();
        }
        else if (item.name.contains("Conjured"))
        {
            return new ConjuredUpdateQualityStrategy();
        }
        else
        {
            return new StandardUpdateQualityStrategy();
        }
    }
}
