package com.gildedrose;

class AgedBrieBehavior implements ItemBehavior {
    private static final int QUALITY_INCREMENT = 1;
    private static final int MAX_QUALITY = 50;
    @Override
    public void update(Item item) {
        increaseQuality(item, QUALITY_INCREMENT);
        item.sellIn--;
        if (item.sellIn < 0) {
            increaseQuality(item, QUALITY_INCREMENT);
        }
    }

    protected void increaseQuality(Item item, int amount) {
        if (item.quality < MAX_QUALITY) {
            item.quality += amount;
        }
    }
}
