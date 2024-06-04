package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class GildedRose {
    Item[] items;
    Map<String, ItemBehavior> behaviors;

    public GildedRose(Item[] items) {
        this.items = items;
        behaviors = new HashMap<>();
        behaviors.put("Aged Brie", new AgedBrieBehavior());
        behaviors.put("Conjured Mana Cake", new ConjuredItemBehavior());
        behaviors.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassesBehavior());
        behaviors.put("Conjured", new ConjuredItemBehavior());
        behaviors.put("Normal Item", new NormalItemBehavior());
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemBehavior behavior = behaviors.getOrDefault(item.name, behaviors.get("Normal Item"));
            behavior.update(item);
        }
    }
}