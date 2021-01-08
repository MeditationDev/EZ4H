package me.liuli.ez4h.translators.bedrockTranslators;

import com.github.steveice10.mc.protocol.data.game.entity.EquipmentSlot;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityEquipmentPacket;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.MobEquipmentPacket;
import me.liuli.ez4h.bedrock.Client;
import me.liuli.ez4h.translators.BedrockTranslator;
import me.liuli.ez4h.translators.converters.ItemConverter;

public class MobEquipmentPacketTranslator implements BedrockTranslator {
    @Override
    public void translate(BedrockPacket inPacket, Client client) {
        MobEquipmentPacket packet=(MobEquipmentPacket)inPacket;
        if(packet.getRuntimeEntityId()==client.clientStat.entityId){
            return;
        }
        switch (packet.getContainerId()){
            case 0:{
                client.sendPacket(new ServerEntityEquipmentPacket((int) packet.getRuntimeEntityId(), EquipmentSlot.MAIN_HAND, ItemConverter.convertToJE(packet.getItem())));
                break;
            }
            case 119:{
                client.sendPacket(new ServerEntityEquipmentPacket((int) packet.getRuntimeEntityId(), EquipmentSlot.OFF_HAND, ItemConverter.convertToJE(packet.getItem())));
                break;
            }
        }
    }
}