package onlyflare.atomicc.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import onlyflare.atomicc.Atomicc;
import onlyflare.atomicc.block.Blocks;
import onlyflare.atomicc.item.custom.AtomicShardItem;

import java.util.List;

public class Items {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Atomicc.MOD_ID);

    public static final DeferredItem<Item> ATOMIC_SHARD = ITEMS.register(
            "atomic_shard",
            registryName -> new AtomicShardItem(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, registryName))
                    .stacksTo(1))
    );

    public static final DeferredItem<Item> ATOMIC_CORE = ITEMS.registerSimpleItem(
            "atomic_core",
            new Item.Properties()
    );

    public static final DeferredItem<BlockItem> ATOMIC_ORE_ITEM = ITEMS.registerSimpleBlockItem(
            "atomic_ore",
            Blocks.ATOMIC_ORE,
            new Item.Properties()

    );
}
