package onlyflare.atomicc;

import net.minecraft.util.parsing.packrat.Atom;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(Atomicc.MOD_ID)
public class Atomicc {
    public static final String MOD_ID = "atomicc";

    public Atomicc(IEventBus modBus) {
        Blocks.BLOCKS.register(modBus);
        Items.ITEMS.register(modBus);
    }
}
