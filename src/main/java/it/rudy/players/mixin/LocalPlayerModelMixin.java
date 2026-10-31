package it.rudy.players.mixin;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Scales only the rendered player model to match the reference 9 x 15 cm outline.
 */
@Mixin(PlayerEntityRenderer.class)
public abstract class LocalPlayerModelMixin {
    // Calibrated from Rudy's 1360x768 reference screenshot on a 70x40 cm display.
    private static final float PLAYER_WIDTH_SCALE = 0.97F;
    private static final float PLAYER_HEIGHT_SCALE = 1.22F;
    private static final float PLAYER_DEPTH_SCALE = 0.97F;

    @Inject(method = "scale", at = @At("TAIL"))
    private void players$shapePlayerModel(AbstractClientPlayerEntity player, MatrixStack matrices,
                                           float tickDelta, CallbackInfo ci) {
        matrices.scale(PLAYER_WIDTH_SCALE, PLAYER_HEIGHT_SCALE, PLAYER_DEPTH_SCALE);
    }
}
