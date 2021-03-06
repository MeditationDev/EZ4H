package me.liuli.ez4h.translators.bedrock.entity;

import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityCollectItemPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityDestroyPacket;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.TakeItemEntityPacket;
import me.liuli.ez4h.minecraft.Client;
import me.liuli.ez4h.translators.BedrockTranslator;

public class TakeItemEntityPacketTranslator implements BedrockTranslator {
    @Override
    public void translate(BedrockPacket inPacket, Client client) {
        TakeItemEntityPacket packet = (TakeItemEntityPacket) inPacket;
        int[] entityIds = new int[1];
        entityIds[0] = (int) packet.getItemRuntimeEntityId();
        client.getData().removeEntity((int) packet.getItemRuntimeEntityId());
        client.sendPacket(new ServerEntityDestroyPacket(entityIds));
        client.sendPacket(new ServerEntityCollectItemPacket((int) packet.getItemRuntimeEntityId(), (int) packet.getRuntimeEntityId(), 1));
    }

    @Override
    public Class<? extends BedrockPacket> getPacketClass() {
        return TakeItemEntityPacket.class;
    }
}
