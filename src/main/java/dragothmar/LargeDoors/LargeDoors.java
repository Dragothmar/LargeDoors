package dragothmar.LargeDoors;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Created by Dragothmar on 1/15/2018.
 */
@Mod(modid = LargeDoors.MODID, version = LargeDoors.VERSION)
public class LargeDoors
{

    public static final String MODID = "largedoors";
    public static final String VERSION = "0.0.0.1";

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        System.out.println("DRAGOTHMAR:DIRT BLOCK >> "+ Blocks.DIRT.getUnlocalizedName());
    }
}