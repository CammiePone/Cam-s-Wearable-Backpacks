package dev.cammiescorner.camsbackpacks;

import dev.cammiescorner.camsbackpacks.common.network.PlaceBackpackPacket;
import dev.cammiescorner.camsbackpacks.common.screen.BackpackScreenHandler;
import dev.cammiescorner.camsbackpacks.core.registry.ModBlockEntities;
import dev.cammiescorner.camsbackpacks.core.registry.ModBlocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class CamsBackpacks implements ModInitializer
{
	public static final String MOD_ID = "camsbackpacks";
	public static final ScreenHandlerType<BackpackScreenHandler> BACKPACK_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(
			new Identifier(MOD_ID, "backpack_gui"), BackpackScreenHandler::new);

	@Override
	public void onInitialize()
	{
		ServerPlayNetworking.registerGlobalReceiver(PlaceBackpackPacket.ID, PlaceBackpackPacket::handle);

		ModBlocks.register();
		ModBlockEntities.register();
	}
}