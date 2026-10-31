package it.rudy.players.mixin;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexRendering;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.Color;

/**
 * Ridimensiona soltanto i riquadri disegnati da Combat Hitboxes.
 * L'Entity bounding box usata da collisioni e attacchi resta intatta.
 */
@Pseudo
@Mixin(value = EntityRenderDispatcher.class, priority = 500)
public abstract class CombatHitboxScaleMixin {
    @Unique
    private static Entity players$currentHitboxEntity;

    @Inject(
            method = "renderBox(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;Lnet/minecraft/entity/Entity;FLjava/awt/Color;Ljava/awt/Color;Ljava/awt/Color;Ljava/awt/Color;Ljava/awt/Color;ZZZZ)V",
            at = @At("HEAD"),
            require = 0
    )
    private static void players$captureEntity(MatrixStack matrices, VertexConsumer vertices, Entity entity,
                                              float tickDelta, Color eyeHeight, Color lookDirection,
                                              Color main, Color targeted, Color hurt,
                                              boolean targetColor, boolean hurtColor,
                                              boolean renderEyeHeight, boolean renderLookDirection,
                                              CallbackInfo ci) {
        players$currentHitboxEntity = entity;
    }

    @ModifyArg(
            method = "renderBox(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;Lnet/minecraft/entity/Entity;FLjava/awt/Color;Ljava/awt/Color;Ljava/awt/Color;Ljava/awt/Color;Ljava/awt/Color;ZZZZ)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/VertexRendering;drawBox(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;Lnet/minecraft/util/math/Box;FFFF)V"
            ),
            index = 2,
            require = 0
    )
    private static Box players$scaleHitboxOutline(Box box) {
        if (!(players$currentHitboxEntity instanceof PlayerEntity)) {
            return box;
        }

        double centerX = (box.minX + box.maxX) * 0.5;
        double centerZ = (box.minZ + box.maxZ) * 0.5;
        double halfWidth = (box.maxX - box.minX) * 0.5 * 1.65;
        double halfDepth = (box.maxZ - box.minZ) * 0.5 * 1.35;
        double height = (box.maxY - box.minY) * 0.88;

        return new Box(
                centerX - halfWidth, box.minY, centerZ - halfDepth,
                centerX + halfWidth, box.minY + height, centerZ + halfDepth
        );
    }
}
