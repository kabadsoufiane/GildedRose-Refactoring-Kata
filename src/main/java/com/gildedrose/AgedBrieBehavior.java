package com.gildedrose;

class AgedBrieBehavior implements ItemBehavior {
    @Override
    public void update(Item item) {
        increaseQuality(item, 1);
        item.sellIn--;
        if (item.sellIn < 0) {
            increaseQuality(item, 1);
        }
    }

    protected void increaseQuality(Item item, int amount) {
        if (item.quality < 50) {
            item.quality += amount;
        }
    }
}
