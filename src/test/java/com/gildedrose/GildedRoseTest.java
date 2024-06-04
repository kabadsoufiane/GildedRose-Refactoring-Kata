package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    private static final String NORMAL_ITEM = "Normal Item";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";

    @Test
    void testNormalItemDegradation() {
        Item[] items = new Item[] { new Item(NORMAL_ITEM, 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(19, app.items[0].quality);
    }

    @Test
    void testNormalItemExpiredDegradation() {
        Item[] items = new Item[] { new Item(NORMAL_ITEM, 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(18, app.items[0].quality);
    }

    @Test
    void testAgedBrieQualityIncrease() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void testBackstagePassesIncrease() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 15, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void testBackstagePassesZeroAfterConcert() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testConjuredItemExpiredDegradation() {
        Item[] items = new Item[] { new Item(CONJURED_MANA_CAKE, 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(16, app.items[0].quality);
    }

    @Test
    void testConjuredItemDegradation() {
        Item[] items = new Item[] { new Item(CONJURED_MANA_CAKE, 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(18, app.items[0].quality);
    }
}