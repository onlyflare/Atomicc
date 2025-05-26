package onlyflare.atomicc;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import onlyflare.atomicc.block.Blocks;
import onlyflare.atomicc.item.CreativeTab;
import onlyflare.atomicc.item.Items;

@Mod(Atomicc.MOD_ID)
public class Atomicc {
    public static final String MOD_ID = "atomicc";

    public Atomicc(IEventBus modBus) {
        Blocks.BLOCKS.register(modBus);
        Items.ITEMS.register(modBus);
        CreativeTab.CREATIVE_MODE_TABS.register(modBus);
    }
}