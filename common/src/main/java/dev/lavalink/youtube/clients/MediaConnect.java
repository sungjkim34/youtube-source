package dev.lavalink.youtube.clients;

import com.sedmelluq.discord.lavaplayer.tools.io.HttpInterface;
import dev.lavalink.youtube.clients.skeleton.StreamingNonMusicClient;
import org.jetbrains.annotations.NotNull;

public class MediaConnect extends StreamingNonMusicClient {
    public static ClientConfig BASE_CONFIG = new ClientConfig()
        .withClientName("MEDIA_CONNECT_FRONTEND")
        .withClientField("clientVersion", "0.1");

    @Override
    @NotNull
    protected ClientConfig getBaseClientConfig(@NotNull HttpInterface httpInterface) {
        return BASE_CONFIG.copy();
    }

    @Override
    @NotNull
    public String getPlayerParams() {
        return MOBILE_PLAYER_PARAMS;
    }

    @Override
    public boolean canHandleRequest(@NotNull String identifier) {
        // This client appears to be able to load livestreams and videos, but will
        // receive 400 bad request when loading playlists.
        return !identifier.contains("list=") && super.canHandleRequest(identifier);
    }

    @Override
    @NotNull
    public String getIdentifier() {
        return BASE_CONFIG.getName();
    }
}
