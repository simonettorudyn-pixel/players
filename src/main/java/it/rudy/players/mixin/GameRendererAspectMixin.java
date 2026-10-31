package it.rudy.players.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Cambia soltanto la componente orizzontale della matrice di proiezione
 * usata per il mondo. FOV e rendering della GUI restano intatti.
 */
@Mixin(GameRenderer.class)
public abstract class GameRendererAspectMixin {
    private static final float WORLD_ASPECT_RATIO = 1.50F;

    @Inject(method = "getBasicProjectionMatrix", at = @At("TAIL"), cancellable = true)
    private void players$setWorldAspectRatio(double fov, CallbackInfoReturnable<Matrix4f> cir) {
        MinecraftClient client = MinecraftClient.getInstance();
        int framebufferHeight = client.getWindow().getFramebufferHeight();
        if (framebufferHeight <= 0) {
            return;
        }

        float framebufferAspect = (float) client.getWindow().getFramebufferWidth() / framebufferHeight;
        Matrix4f projection = new Matrix4f(cir.getReturnValue());
        projection.m00(projection.m00() * framebufferAspect / WORLD_ASPECT_RATIO);
        cir.setReturnValue(projection);
    }
}
