package org.togetherjava.tjbot.commands.moderation.temp;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.requests.RestAction;
import org.togetherjava.tjbot.commands.moderation.ModerationAction;
import org.togetherjava.tjbot.commands.moderation.ModerationUtils;
import org.togetherjava.tjbot.config.Config;

import javax.annotation.Nonnull;

/**
 * Action to revoke temporary quarantines, as applied by
 * {@link org.togetherjava.tjbot.commands.moderation.QuarantineCommand} and executed by
 * {@link TemporaryModerationRoutine}.
 */
final class TemporaryQuarantineAction extends RevocableRoleBasedAction {
    private final Config config;

    /**
     * Creates a new instance of a temporary quarantine action.
     *
     * @param config the config to use to identify the quarantined role
     */
    TemporaryQuarantineAction(Config config) {
        super("quarantine");

        this.config = config;
    }

    @Override
    @Nonnull
    public ModerationAction getApplyType() {
        return ModerationAction.QUARANTINE;
    }

    @Override
    @Nonnull
    public ModerationAction getRevokeType() {
        return ModerationAction.UNQUARANTINE;
    }

    @Override
    @Nonnull
    public RestAction<Void> revokeAction(Guild guild, User target, String reason) {
        return guild
            .removeRoleFromMember(target.getIdLong(),
                    ModerationUtils.getQuarantinedRole(guild, config).orElseThrow())
            .reason(reason);
    }
}
