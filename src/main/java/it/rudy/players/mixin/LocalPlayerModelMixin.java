package it.rudy.players.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityRenderer.class)
public abstract class LocalPlayerModelMixin {
    // Solo trasformazione grafica: non modifica entità, collisioni o hitbox.
    private static final float PLAYERS_WIDTH_SCALE = 1.65F;
    private static final float PLAYERS_HEIGHT_SCALE = 0.88F;
    private static final float PLAYERS_DEPTH_SCALE = 1.35F;

    @Inject(method = "scale", at = @At("TAIL"))
    private void players$scaleLocalPlayerModel(AbstractClientPlayerEntity player, MatrixStack matrices, float tickDelta, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == player) {
            matrices.scale(PLAYERS_WIDTH_SCALE, PLAYERS_HEIGHT_SCALE, PLAYERS_DEPTH_SCALE);
        }
    }
}
