package com.jcmr.bbdiscs;

import com.jcmr.bbdiscs.discs.Discs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.lwjgl.system.CallbackI;

@Mod.EventBusSubscriber(modid = BBDiscs.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MiscItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BBDiscs.MODID);

    public static final RegistryObject<Item> WALTIUM = makeIum("waltium");
    public static final RegistryObject<Item> JESSIUM = makeIum("jessium");
    public static final RegistryObject<Item> JIMMIUM = makeIum("jimmium");
    public static final RegistryObject<Item> SAULIUM = makeIum("saulium");
    public static final RegistryObject<Item> GENEIUM = makeIum("geneium");


    private static RegistryObject<Item> makeIum(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()
                .tab(CreativeModeTab.TAB_MISC)
                .rarity(Discs.LEGENDARY)
                .stacksTo(1)
                .fireResistant()));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
