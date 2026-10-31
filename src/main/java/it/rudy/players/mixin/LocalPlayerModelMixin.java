package it.rudy.players.mixin;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Ingrandisce solo il modello visualizzato. Non modifica le entità
 * nel mondo, quindi hitbox e collisioni restano invariate.
 */
@Mixin(PlayerEntityRenderer.class)
public abstract class LocalPlayerModelMixin {
    private static final float PLAYER_VISUAL_SCALE = 1.50F;

    @Inject(method = "scale", at = @At("TAIL"))
    private void players$enlargePlayerModel(AbstractClientPlayerEntity player, MatrixStack matrices,
                                             float tickDelta, CallbackInfo ci) {
        matrices.scale(PLAYER_VISUAL_SCALE, PLAYER_VISUAL_SCALE, PLAYER_VISUAL_SCALE);
    }
}
