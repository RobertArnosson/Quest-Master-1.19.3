package net.robert.questmaster.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.animal.ShoulderRidingEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.robert.questmaster.QuestMaster;
import net.robert.questmaster.block.custom.JumpyBlock;
import net.robert.questmaster.item.ModCreativeModeTab;
import net.robert.questmaster.item.ModItems;
import org.antlr.v4.codegen.model.SrcOp;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, QuestMaster.MOD_ID);

    public static final RegistryObject<Block> ZIRCON_BLOCK = registryObject("zircon_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(0.5f).requiresCorrectToolForDrops()), ModCreativeModeTab.QUESTMASTER_TAB);

    public static final RegistryObject<Block> ZIRCON_ORE = registryObject("zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(0.4f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), ModCreativeModeTab.QUESTMASTER_TAB);
    public static final RegistryObject<Block> DEEPSLATE_ZIRCON_ORE = registryObject("deepslate_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(0.5f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), ModCreativeModeTab.QUESTMASTER_TAB);
    public static final RegistryObject<Block> NETHERRACK_ZIRCON_ORE = registryObject("netherrack_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(0.2f).requiresCorrectToolForDrops(), UniformInt.of(10, 15)), ModCreativeModeTab.QUESTMASTER_TAB);
    public static final RegistryObject<Block> ENDSTONE_ZIRCON_ORE = registryObject("endstone_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(0.6f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), ModCreativeModeTab.QUESTMASTER_TAB);

    public static final RegistryObject<Block> JUMPY_BLOCK = registryObject("jumpy_block",
            () -> new JumpyBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(0.5f).requiresCorrectToolForDrops()), ModCreativeModeTab.QUESTMASTER_TAB);

    private static <T extends Block>RegistryObject<T> registryObject(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registryBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registryBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
