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
 * Scala solo il contorno debug delle hitbox dei player.
 * Il bounding box usato dal gioco per collisioni e colpi non cambia.
 */
@Mixin(EntityRenderDispatcher.class)
public abstract class VanillaPlayerHitboxScaleMixin {
    private static final float PLAYER_WIDTH_SCALE = 2.00F;
    private static final float PLAYER_HEIGHT_SCALE = 1.15F;
    private static final float PLAYER_DEPTH_SCALE = 1.70F;

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
