package it.rudy.players.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Restituisce ai modelli dei player la loro larghezza visiva originale
 * dopo il cambio del rapporto orizzontale della proiezione del mondo.
 * La trasformazione interessa solo il rendering, mai entità o hitbox.
 */
@Mixin(PlayerEntityRenderer.class)
public abstract class LocalPlayerModelMixin {
    private static final float WORLD_ASPECT_RATIO = 1.50F;

    @Inject(method = "scale", at = @At("TAIL"))
    private void players$preservePlayerVisualSize(AbstractClientPlayerEntity player, MatrixStack matrices,
                                                   float tickDelta, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        int framebufferHeight = client.getWindow().getFramebufferHeight();
        if (framebufferHeight <= 0) {
            return;
        }

        float framebufferAspect = (float) client.getWindow().getFramebufferWidth() / framebufferHeight;
        float horizontalCompensation = WORLD_ASPECT_RATIO / framebufferAspect;
        matrices.scale(horizontalCompensation, 1.0F, horizontalCompensation);
    }
}
