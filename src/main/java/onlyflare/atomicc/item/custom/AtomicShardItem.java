package onlyflare.atomicc.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class AtomicShardItem extends Item {

    public AtomicShardItem(Properties properties) {
        super(properties);
    }

    private static final Map<Block, Block> TRANSFORM_MAP = Map.ofEntries(
            //STONE
            Map.entry(Blocks.STONE, Blocks.GRANITE),
            Map.entry(Blocks.GRANITE, Blocks.DIORITE),
            Map.entry(Blocks.DIORITE, Blocks.ANDESITE),
            Map.entry(Blocks.ANDESITE, Blocks.DEEPSLATE),
            Map.entry(Blocks.DEEPSLATE, Blocks.TUFF),
            Map.entry(Blocks.TUFF, Blocks.STONE),

            //WOOD
            Map.entry(Blocks.OAK_LOG, Blocks.SPRUCE_LOG),
            Map.entry(Blocks.SPRUCE_LOG, Blocks.BIRCH_LOG),
            Map.entry(Blocks.BIRCH_LOG, Blocks.JUNGLE_LOG),
            Map.entry(Blocks.JUNGLE_LOG, Blocks.ACACIA_LOG),
            Map.entry(Blocks.ACACIA_LOG, Blocks.DARK_OAK_LOG),
            Map.entry(Blocks.DARK_OAK_LOG, Blocks.MANGROVE_LOG),
            Map.entry(Blocks.MANGROVE_LOG, Blocks.CHERRY_LOG),
            Map.entry(Blocks.CHERRY_LOG, Blocks.CRIMSON_STEM),
            Map.entry(Blocks.CRIMSON_STEM, Blocks.WARPED_STEM),
            Map.entry(Blocks.WARPED_STEM, Blocks.OAK_LOG)
    );

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);

        Block replacement = TRANSFORM_MAP.get(state.getBlock());
        if (replacement != null) {
            if (!level.isClientSide) {
                BlockState newState = replacement.defaultBlockState();
                level.setBlock(pos, newState, 3);

                level.playSound(null, context.getClickedPos(), SoundEvents.CHISELED_BOOKSHELF_INSERT_ENCHANTED, SoundSource.BLOCKS);

                ((ServerLevel)level).sendParticles(ParticleTypes.ENCHANT, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 20, 0.5, 1, 0.5, 0);

            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.atomicc.atomic_shard"));
            tooltipComponents.add(Component.translatable("tooltip.atomicc.atomic_shard.quote"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.atomicc.atomic_shard.shift"));
        }
    }
}
