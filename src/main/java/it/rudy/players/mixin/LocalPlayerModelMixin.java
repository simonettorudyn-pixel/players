package it.rudy.players.mixin;

import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Allarga e abbassa solo il rendering del modello dei player.
 */
@Mixin(PlayerEntityRenderer.class)
public abstract class LocalPlayerModelMixin {
    private static final float PLAYER_WIDTH_SCALE = 1.65F;
    private static final float PLAYER_HEIGHT_SCALE = 0.88F;
    private static final float PLAYER_DEPTH_SCALE = 1.35F;

    @Inject(method = "scale", at = @At("TAIL"))
    private void players$shapePlayerModel(PlayerEntityRenderState state, MatrixStack matrices, CallbackInfo ci) {
        matrices.scale(PLAYER_WIDTH_SCALE, PLAYER_HEIGHT_SCALE, PLAYER_DEPTH_SCALE);
    }
}
