package it.rudy.players.mixin;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Scales only F3+B's visual outline for player entities. The server-side and
 * client-side collision boxes used for movement and attacks are not changed.
 */
@Mixin(EntityRenderDispatcher.class)
public abstract class VanillaPlayerHitboxScaleMixin {
    // Approximate pixel scale from the original outline to a 9 x 15 cm display outline.
    private static final float PLAYER_WIDTH_SCALE = 2.18F;
    private static final float PLAYER_HEIGHT_SCALE = 1.98F;
    private static final float PLAYER_DEPTH_SCALE = 2.18F;

    @Inject(method = "renderHitbox", at = @At("HEAD"))
    private static void players$pushVisualHitboxScale(MatrixStack matrices, VertexConsumer vertices,
                                                       Entity entity, float tickDelta,
                                                       float red, float green, float blue,
                                                       CallbackInfo ci) {
        if (entity instanceof PlayerEntity) {
            matrices.push();
            matrices.scale(PLAYER_WIDTH_SCALE, PLAYER_HEIGHT_SCALE, PLAYER_DEPTH_SCALE);
        }
    }

    @Inject(method = "renderHitbox", at = @At("RETURN"))
    private static void players$popVisualHitboxScale(MatrixStack matrices, VertexConsumer vertices,
                                                      Entity entity, float tickDelta,
                                                      float red, float green, float blue,
                                                      CallbackInfo ci) {
        if (entity instanceof PlayerEntity) {
            matrices.pop();
        }
    }
}
