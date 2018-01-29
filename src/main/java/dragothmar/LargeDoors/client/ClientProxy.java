package dragothmar.largedoors.client;

import dragothmar.largedoors.common.CommonProxy;
import dragothmar.largedoors.common.Content;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by Dragothmar on 1/15/2018.
 *
 * Class delegated to registering and loading resources
 */

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
    /**
     * Register entities in preInit
     */
    @Override
    public void preInit() { }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event)
    {
        for(Block block : Content.registeredLDBlocks)
        {
            final ResourceLocation loc = Block.REGISTRY.getNameForObject(block);
            Item blockItem = Item.getItemFromBlock(block);
            if (blockItem == null)
                throw new RuntimeException("ITEMBLOCK FOR "+loc+" : " + block + " IS NULL");

            ModelLoader.setCustomModelResourceLocation(blockItem, 0, new ModelResourceLocation(loc, "inventory"));
        }

        for(Item item : Content.registeredLDItems)
        {
            if (item instanceof ItemBlock)
                continue;

            final ResourceLocation loc = Item.REGISTRY.getNameForObject(item);
            ModelBakery.registerItemVariants(item, loc);
            ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition() {
                @Override
                public ModelResourceLocation getModelLocation(ItemStack stack) {
                    return new ModelResourceLocation(loc, "inventory");
                }
            });
        }
    }

    /**
     * Load in block and item resources
     */
    @Override
    public void preInitEnd() { }

    @Override
    public void init() { }

    @Override
    public void postInit() { }
}