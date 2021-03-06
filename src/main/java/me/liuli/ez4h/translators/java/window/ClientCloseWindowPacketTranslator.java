package me.liuli.ez4h.translators.java.window;

import com.github.steveice10.mc.protocol.packet.MinecraftPacket;
import com.github.steveice10.mc.protocol.packet.ingame.client.window.ClientCloseWindowPacket;
import com.github.steveice10.packetlib.packet.Packet;
import com.nukkitx.protocol.bedrock.packet.ContainerClosePacket;
import me.liuli.ez4h.minecraft.Client;
import me.liuli.ez4h.translators.JavaTranslator;

public class ClientCloseWindowPacketTranslator implements JavaTranslator {
    @Override
    public void translate(Packet inPacket, Client client) {
        ClientCloseWindowPacket packet = (ClientCloseWindowPacket) inPacket;

        if ((!client.getInventory().isOpen()) && packet.getWindowId() == 0)
            return;

        ContainerClosePacket containerClosePacket = new ContainerClosePacket();
        containerClosePacket.setUnknownBool0(false);
        containerClosePacket.setId((byte) packet.getWindowId());
        client.sendPacket(containerClosePacket);
    }

    @Override
    public Class<? extends MinecraftPacket> getPacketClass() {
        return ClientCloseWindowPacket.class;
    }
}
