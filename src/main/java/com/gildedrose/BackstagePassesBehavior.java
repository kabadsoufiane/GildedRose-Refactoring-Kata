package com.gildedrose;

class BackstagePassesBehavior implements ItemBehavior {
    @Override
    public void update(Item item) {
        if (item.sellIn < 1) {
            item.quality = 0;
        } else {
            increaseQuality(item, 1);
            if (item.sellIn <= 10) {
                increaseQuality(item, 1);
            }
            if (item.sellIn <= 5) {
                increaseQuality(item, 1);
            }
        }
        item.sellIn--;
    }

    protected void increaseQuality(Item item, int amount) {
        if (item.quality < 50) {
            item.quality += amount;
        }
    }
}

