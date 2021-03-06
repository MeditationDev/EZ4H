package me.liuli.ez4h.translators.bedrock.play;

import com.github.steveice10.mc.protocol.data.game.entity.player.GameMode;
import com.github.steveice10.mc.protocol.data.game.world.notify.ClientNotification;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerNotifyClientPacket;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.data.GameType;
import com.nukkitx.protocol.bedrock.packet.SetPlayerGameTypePacket;
import me.liuli.ez4h.minecraft.Client;
import me.liuli.ez4h.translators.BedrockTranslator;
import me.liuli.ez4h.utils.BedrockUtil;

public class SetPlayerGameTypePacketTranslator implements BedrockTranslator {
    @Override
    public void translate(BedrockPacket inPacket, Client client) {
        SetPlayerGameTypePacket packet = (SetPlayerGameTypePacket) inPacket;

        GameMode gameMode = BedrockUtil.convertGameModeToJE(GameType.from(packet.getGamemode()));
        client.getPlayer().setGameMode(gameMode);
        client.sendPacket(new ServerNotifyClientPacket(ClientNotification.CHANGE_GAMEMODE, gameMode));
    }

    @Override
    public Class<? extends BedrockPacket> getPacketClass() {
        return SetPlayerGameTypePacket.class;
    }
}
