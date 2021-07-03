package net.permafrozen.permafrozen.client.entity.model;

import net.minecraft.util.Identifier;
import net.permafrozen.permafrozen.Permafrozen;
import net.permafrozen.permafrozen.entity.Nudifae;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class NudifaeModel extends AnimatedGeoModel<Nudifae> {

    @Override
    public Identifier getModelLocation(Nudifae nudifae) {

        return new Identifier(Permafrozen.MOD_ID, "geo/nudifae.geo.json");

    }

    @Override
    public Identifier getTextureLocation(Nudifae nudifae) {

        return new Identifier(Permafrozen.MOD_ID, String.format("textures/entity/nudifae/nudifae_%s.png", nudifae.getNudifaeType().id));

    }

    @Override
    public Identifier getAnimationFileLocation(Nudifae nudifae) {

        return new Identifier(Permafrozen.MOD_ID, "animations/nudifae.animation.json");

    }

    @Override
    public void setLivingAnimations(Nudifae entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX((extraData.headPitch + 30) * ((float) Math.PI / 360F));
        head.setRotationY((extraData.netHeadYaw) * ((float) Math.PI / 500F));
    }

}
