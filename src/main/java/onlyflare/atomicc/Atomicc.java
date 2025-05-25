package onlyflare.atomicc;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(Atomicc.MOD_ID)
public class Atomicc {
    public static final String MOD_ID = "atomicc";

    public Atomicc(IEventBus modBus) {
        Blocks.BLOCKS.register(modBus);
        Items.ITEMS.register(modBus);
        CreativeTab.CREATIVE_MODE_TABS.register(modBus);
    }
}