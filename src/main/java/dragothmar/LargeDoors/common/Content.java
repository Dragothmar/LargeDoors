package dragothmar.largedoors.common;

import dragothmar.largedoors.common.blocks.BlockTestDoor;
import dragothmar.largedoors.common.items.ItemTestDoor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;

/**
 * Created by Dragothmar on 1/15/2018.
 */
@Mod.EventBusSubscriber
public class Content
{
    public static ArrayList<Block> registeredLDBlocks = new ArrayList<Block>();
    public static ArrayList<Item> registeredLDItems = new ArrayList<Item>();


    public static BlockTestDoor blockTestDoor;
    public static ItemTestDoor itemTestDoor;

    static
    {
        blockTestDoor = (BlockTestDoor)(new BlockTestDoor("blockTestDoor", Material.WOOD)).setHardness(3.0F).setUnlocalizedName("doorTest");
        itemTestDoor = (ItemTestDoor)(new ItemTestDoor(blockTestDoor, "itemTestDoor").setUnlocalizedName("doorTest"));
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        System.out.println("LARGE_DOORS:Registering blocks");
        System.out.println("LARGE_DOORS:blockTestDoor unlocalized name " + blockTestDoor.getUnlocalizedName());
        event.getRegistry().register(blockTestDoor.setRegistryName(blockTestDoor.getResourceLocation()));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(itemTestDoor.setRegistryName(itemTestDoor.getResourceLocation()));
    }
}