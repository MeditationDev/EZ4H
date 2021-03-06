package me.liuli.ez4h.translators.java.play;

import com.github.steveice10.mc.protocol.packet.MinecraftPacket;
import com.github.steveice10.mc.protocol.packet.ingame.client.player.ClientPlayerSwingArmPacket;
import com.github.steveice10.packetlib.packet.Packet;
import com.nukkitx.protocol.bedrock.packet.AnimatePacket;
import me.liuli.ez4h.minecraft.Client;
import me.liuli.ez4h.translators.JavaTranslator;

public class ClientPlayerSwingArmPacketTranslator implements JavaTranslator {
    @Override
    public void translate(Packet inPacket, Client client) {
        ClientPlayerSwingArmPacket packet = (ClientPlayerSwingArmPacket) inPacket;
        AnimatePacket animatePacket = new AnimatePacket();
        animatePacket.setAction(AnimatePacket.Action.SWING_ARM);
        animatePacket.setRuntimeEntityId(client.getPlayer().getEntityId());
        client.sendPacket(animatePacket);
    }

    @Override
    public Class<? extends MinecraftPacket> getPacketClass() {
        return ClientPlayerSwingArmPacket.class;
    }
}
