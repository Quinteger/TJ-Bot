package org.togetherjava.tjbot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Adapter implementation of a {@link SlashCommand}. The minimal setup only requires implementation
 * of {@link #onSlashCommand(SlashCommandInteractionEvent)}. A new command can then be registered by
 * adding it to {@link Features}.
 * <p>
 * Further, {@link #onButtonClick(ButtonInteractionEvent, List)} and
 * {@link #onSelectionMenu(SelectMenuInteractionEvent, List)} can be overridden if desired. The
 * default implementation is empty, the adapter will not react to such events.
 * <p>
 * <p>
 * The adapter manages all command related data itself, which can be provided during construction
 * (see {@link #SlashCommandAdapter(String, String, CommandVisibility)}). In order to add
 * options, subcommands or similar command configurations, use {@link #getData()} and mutate the
 * returned data object (see {@link CommandData} for details on how to work with this class).
 * <p>
 * <p>
 * If implementations want to add buttons or selection menus, it is highly advised to use component
 * IDs generated by {@link #generateComponentId(String...)}, which will automatically create IDs
 * that are valid per {@link SlashCommand#onSlashCommand(SlashCommandInteractionEvent)}.
 * <p>
 * <p>
 * Some example commands are available in {@link org.togetherjava.tjbot.commands.basic}. A minimal
 * setup would consist of a class like
 *
 * <pre>
 * {
 *     &#64;code
 *     public class PingCommand extends SlashCommandAdapter {
 *         public PingCommand() {
 *             super("ping", "Responds with 'Pong!'", SlashCommandVisibility.GUILD);
 *         }
 *
 *         &#64;Override
 *         public void onSlashCommand(@NotNull SlashCommandInteractionEvent event) {
 *             event.reply("Pong!").queue();
 *         }
 *     }
 * }
 * </pre>
 * <p>
 * and registration of an instance of that class in {@link Features}.
 */
public abstract class SlashCommandAdapter extends BotCommandAdapter implements SlashCommand {
    private final String description;
    private final SlashCommandData data;

    /**
     * Creates a new adapter with the given data.
     *
     * @param name the name of this command, requirements for this are documented in
     *        {@link Commands#slash(String, String)}
     * @param description the description of this command, requirements for this are documented in
     *        {@link Commands#slash(String, String)}
     * @param visibility the visibility of the command
     */
    protected SlashCommandAdapter(@NotNull String name, @NotNull String description,
            CommandVisibility visibility) {
        super(Commands.slash(name, description), visibility);
        this.description = description;

        this.data = (SlashCommandData) super.getData();
    }

    @Override
    public final @NotNull String getDescription() {
        return description;
    }

    @NotNull
    @Override
    public final SlashCommandData getData() {
        return data;
    }
}