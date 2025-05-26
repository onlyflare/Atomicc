package onlyflare.atomicc.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import onlyflare.atomicc.Atomicc;

public class Blocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Atomicc.MOD_ID);

    public static final DeferredBlock<Block> ATOMIC_ORE = BLOCKS.register(
            "atomic_ore",
            registryName -> new Block(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                    .strength(3f)
                    .requiresCorrectToolForDrops()
            )
    );
}
