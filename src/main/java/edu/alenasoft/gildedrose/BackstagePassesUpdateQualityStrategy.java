package edu.alenasoft.gildedrose;

public class BackstagePassesUpdateQualityStrategy implements UpdateQualityStrategyInterface {
    @Override
    public void Update(Item item) {
        if(isAfterTheConcert(item)){
            item.quality = 0;
        }else if(item.quality < 50){
            Integer qualityIncrease = qualityIncreaseBy(item.sellIn);
            item.quality += qualityIncrease;
        }
        item.sellIn--;
    }

    // Depende de los parametros dados este va a aumentar el precio
    private Integer qualityIncreaseBy(Integer remainingDaysBeforeConcert) {
        if(remainingDaysBeforeConcert <= 5) {
            return 3;
        }
        else if (remainingDaysBeforeConcert <= 10) {
            return 2;
        }
        else {
            return 1;
        }
    }
    // Si la fecha es despues del vencimiento, el item se volvera 0
    private boolean isAfterTheConcert(Item item) {
        return item.sellIn <= 0;
    }
}
