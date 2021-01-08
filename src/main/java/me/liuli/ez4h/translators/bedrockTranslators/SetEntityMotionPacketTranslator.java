package me.liuli.ez4h.translators.bedrockTranslators;

import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityVelocityPacket;
import com.nukkitx.math.vector.Vector3f;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.SetEntityMotionPacket;
import me.liuli.ez4h.bedrock.Client;
import me.liuli.ez4h.translators.BedrockTranslator;

public class SetEntityMotionPacketTranslator implements BedrockTranslator {
    @Override
    public void translate(BedrockPacket inPacket, Client client) {
        SetEntityMotionPacket packet=(SetEntityMotionPacket)inPacket;
        Vector3f motion=packet.getMotion();
        client.sendPacket(new ServerEntityVelocityPacket((int) packet.getRuntimeEntityId(), motion.getX(), motion.getY(), motion.getZ()));
    }
}