package onlyflare.atomicc;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Atomicc.MOD_ID);

public static final Supplier<CreativeModeTab> ATOMICC_TAB = CREATIVE_MODE_TABS.register("main", () ->
        CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.atomicc.main"))
                .icon(() -> new ItemStack(Items.ATOMIC_SHARD.get()))
                .displayItems((params, output) -> {
                    output.accept(Items.ATOMIC_SHARD.get());
                    output.accept(Items.ATOMIC_ORE_ITEM.get());
                    output.accept(Items.ATOMIC_CORE.get());
                })
                .build()
);
}
