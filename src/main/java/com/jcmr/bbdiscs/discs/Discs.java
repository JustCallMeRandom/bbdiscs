package com.jcmr.bbdiscs.discs;

import com.jcmr.bbdiscs.BBDiscs;
import net.minecraft.ChatFormatting;
import net.minecraft.client.sounds.SoundEngine;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = BBDiscs.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Discs {
    public static final Rarity LEGENDARY = Rarity.create("legendary", ChatFormatting.RED);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BBDiscs.MODID);
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, BBDiscs.MODID);

    public static final RegistryObject<SoundEvent> BCS_THEME_SOUND = registerSoundEvent("bcs_theme");
    public static final RegistryObject<SoundEvent> BCS_OUTRO_SOUND = registerSoundEvent("bcs_outro");
    public static final RegistryObject<SoundEvent> BB_THEME_SOUND = registerSoundEvent("bb_theme");
    public static final RegistryObject<SoundEvent> WALT_CONFESSION_SOUND = registerSoundEvent("walt_confession");

    public static final RegistryObject<RecordItem> BCS_THEME = registerRecord("bcs_theme_disc", BCS_THEME_SOUND);
    public static final RegistryObject<RecordItem> BCS_OUTRO = registerRecord("bcs_outro_disc", BCS_OUTRO_SOUND);
    public static final RegistryObject<RecordItem> BB_THEME = registerRecord("bb_theme_disc", BB_THEME_SOUND);
    public static final RegistryObject<RecordItem> WALT_CONFESSION = registerRecord("walt_confession_disc", WALT_CONFESSION_SOUND);

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUNDS.register(name, () -> new SoundEvent(new ResourceLocation(BBDiscs.MODID, name)));
    }
    private static RegistryObject<RecordItem> registerRecord(String name, RegistryObject<SoundEvent> sound) {
        return ITEMS.register(name, () -> new RecordItem(1, sound, new Item.Properties()
                .tab(CreativeModeTab.TAB_MISC)
                .stacksTo(1)
                .fireResistant()
                .rarity(LEGENDARY)));
    }

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
        SOUNDS.register(bus);
    }
}
