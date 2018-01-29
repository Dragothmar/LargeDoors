package dragothmar.largedoors;

import dragothmar.largedoors.common.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Dragothmar on 1/15/2018.
 */
@Mod(modid = LargeDoors.MODID, version = LargeDoors.VERSION, name = LargeDoors.MOD_NAME)
public class LargeDoors
{

    public static final String MODID = "largedoors";
    public static final String MOD_NAME = "Large Doors";
    public static final String VERSION = "0.0.0.1";

    @Mod.Instance(MODID)
    public static LargeDoors INSTANCE = new LargeDoors();

    @SidedProxy(serverSide = "dragothmar.largedoors.common.CommonProxy", clientSide = "dragothmar.largedoors.client.ClientProxy")
    public static CommonProxy proxy;

    //########################################################################################
    // Initialization methods

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {}


    @EventHandler
    public void init(FMLInitializationEvent event)
    {

        // some example code
        System.out.println("DRAGOTHMAR:DIRT BLOCK >> "+ Blocks.DIRT.getUnlocalizedName());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {}

    //########################################################################################
    // Creative Tab

    public static CreativeTabs creativeTab = new CreativeTabs(MODID)
    {
        @Override
        public ItemStack getTabIconItem() { return ItemStack.EMPTY; }
        @Override
        public ItemStack getIconItemStack() { return new ItemStack(Items.STICK);}
    };
}