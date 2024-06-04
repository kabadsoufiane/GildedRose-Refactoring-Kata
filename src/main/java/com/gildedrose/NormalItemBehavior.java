package com.gildedrose;

class NormalItemBehavior implements ItemBehavior {
    private static final int QUALITY_DECREMENT = 1;
    private static final int MIN_QUALITY = 0;

    @Override
    public void update(Item item) {
        decreaseQuality(item, QUALITY_DECREMENT);
        item.sellIn--;
        if (item.sellIn < 0) {
            decreaseQuality(item, QUALITY_DECREMENT);
        }
    }

    protected void decreaseQuality(Item item, int amount) {
        item.quality = Math.max(MIN_QUALITY, item.quality - amount);
    }
}
