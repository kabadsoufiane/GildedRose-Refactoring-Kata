package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!isLegendary(item)) {
                updateSellIn(item);
                updateQualityForItem(item);
                if (isExpired(item)) {
                    updateQualityForExpiredItem(item);
                }
            }
        }
    }

    private void updateQualityForItem(Item item) {
        switch (item.name) {
            case "Aged Brie":
                increaseQuality(item, 1);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                updateBackstagePassQuality(item);
                break;
            default:
                decreaseQuality(item, 1);
                break;
        }
    }

    private void updateQualityForExpiredItem(Item item) {
        switch (item.name) {
            case "Aged Brie":
                increaseQuality(item, 1);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                item.quality = 0;
                break;
            default:
                decreaseQuality(item, 1);
                break;
        }
    }

    private void updateBackstagePassQuality(Item item) {
        increaseQuality(item, 1);
        if (item.sellIn < 11) {
            increaseQuality(item, 1);
        }
        if (item.sellIn < 6) {
            increaseQuality(item, 1);
        }
    }

    private void increaseQuality(Item item, int amount) {
        if (item.quality < 50) {
            item.quality += amount;
        }
    }

    private void decreaseQuality(Item item, int amount) {
        if (item.quality > 0) {
            item.quality -= amount;
        }
    }

    private void updateSellIn(Item item) {
        item.sellIn -= 1;
    }

    private boolean isLegendary(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isExpired(Item item) {
        return item.sellIn < 0;
    }
}