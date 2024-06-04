package com.gildedrose;

class NormalItemBehavior implements ItemBehavior {
    @Override
    public void update(Item item) {
        decreaseQuality(item, 1);
        item.sellIn--;
        if (item.sellIn < 0) {
            decreaseQuality(item, 1);
        }
    }

    protected void decreaseQuality(Item item, int amount) {
        item.quality = Math.max(0, item.quality - amount);
    }
}
