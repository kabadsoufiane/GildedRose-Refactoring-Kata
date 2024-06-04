package com.gildedrose;

class BackstagePassesBehavior implements ItemBehavior {
    private static final int MAX_QUALITY = 50;
    private static final int SELL_IN_THRESHOLD_FOR_DOUBLE_INCREASE = 10;
    private static final int SELL_IN_THRESHOLD_FOR_TRIPLE_INCREASE = 5;

    @Override
    public void update(Item item) {
        if (item.sellIn < 1) {
            item.quality = 0;
        } else {
            increaseQuality(item, 1);
            if (item.sellIn <= SELL_IN_THRESHOLD_FOR_DOUBLE_INCREASE) {
                increaseQuality(item, 1);
            }
            if (item.sellIn <= SELL_IN_THRESHOLD_FOR_TRIPLE_INCREASE) {
                increaseQuality(item, 1);
            }
        }
        item.sellIn--;
    }

    protected void increaseQuality(Item item, int amount) {
        if (item.quality < MAX_QUALITY) {
            item.quality += amount;
        }
    }
}
