package com.gildedrose;

class ConjuredItemBehavior implements ItemBehavior {
    @Override
    public void update(Item item) {
        decreaseQuality(item, 2);
        item.sellIn--;
        if (item.sellIn < 0) {
            decreaseQuality(item, 2);
        }
    }

    protected void decreaseQuality(Item item, int amount) {
        item.quality = Math.max(0, item.quality - amount);
    }
}

