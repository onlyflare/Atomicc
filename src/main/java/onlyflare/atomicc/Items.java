package onlyflare.atomicc;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Items {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Atomicc.MOD_ID);

    public static final DeferredItem<Item> ATOMICC_SHARD = ITEMS.registerSimpleItem(
            "atomicc_shard",
            new Item.Properties()
    );

    public static final DeferredItem<BlockItem> ATOMICC_ORE_ITEM = ITEMS.registerSimpleBlockItem(
            "atomicc_ore",
            Blocks.ATOMICC_ORE,
            new Item.Properties()

    );
}
