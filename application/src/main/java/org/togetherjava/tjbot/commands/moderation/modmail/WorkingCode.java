package org.togetherjava.tjbot.commands.moderation.modmail;

import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;

public class WorkingCode {


    /*
     * UNUSED CODE
     */

    /*
     * public static MessageEmbed messageEmbed(@NotNull String user, @NotNull String message) {
     * return new
     * EmbedBuilder().setAuthor("Modmail Command invoked").setColor(Color.BLACK).setTitle(
     * "Message from user '%s' who used /modmail command".formatted(user)).addField("Message",
     * message, false) .build(); }
     */

    /*
     * USEFUL LINKS
     */

    /*
     * different ways of getting the channel
     * https://github.com/DV8FromTheWorld/JDA/issues/787#issuecomment-424705383 getting list of all
     * channels https://stackoverflow.com/questions/67608375/jda-getting-all-channels private
     * channel
     * https://ci.dv8tion.net/job/JDA/javadoc/net/dv8tion/jda/api/entities/PrivateChannel.html
     * https://github.com/DV8FromTheWorld/JDA/wiki/7%29-Using-RestAction#example-sending-a-private-
     * message
     */
}


/*
 * 
 * package org.togetherjava.tjbot.commands.moderation.modmail;
 * 
 * import net.dv8tion.jda.api.EmbedBuilder; import net.dv8tion.jda.api.entities.TextChannel; import
 * net.dv8tion.jda.api.entities.User; import
 * net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent; import
 * net.dv8tion.jda.api.interactions.commands.OptionType; import
 * net.dv8tion.jda.api.requests.restaction.MessageAction; import org.jetbrains.annotations.NotNull;
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.togetherjava.tjbot.commands.SlashCommandAdapter; import
 * org.togetherjava.tjbot.commands.SlashCommandVisibility; import
 * org.togetherjava.tjbot.config.Config;
 * 
 * import java.awt.*; import java.nio.charset.StandardCharsets; import java.util.ArrayList; import
 * java.util.List; import java.util.Optional; import java.util.function.Predicate; import
 * java.util.regex.Pattern;
 * 
 * public class ModMailCommand extends SlashCommandAdapter {
 * 
 * private static final Logger logger = LoggerFactory.getLogger(ModMailCommand.class);
 * 
 * 
 * private static final String COMMAND_NAME = "modmail";
 * 
 * private static final String MESSAGE = "message";
 * 
 * private static final String TITLE = "title";
 * 
 * private static final Color EMBED_COLOR = Color.decode("#3788AC");
 * 
 * private static Predicate<String> auditLogChannelNamePredicate;
 * 
 * 
 * @Override public void onSlashCommand(@NotNull SlashCommandInteractionEvent event) {
 * List<Attachment> attachments = new ArrayList<>(); String title =
 * event.getOption(TITLE).getAsString(); String content = event.getOption(MESSAGE).getAsString();
 * Optional<TextChannel> name =
 * event.getPrivateChannel().getJDA().getGuildById(1004371840245964851L)
 * .getTextChannelCache().stream().filter(channel ->
 * auditLogChannelNamePredicate.test(channel.getName())) .findAny(); if ( name.isEmpty() ) { return;
 * } User author = event.getUser();
 * 
 * attachments.add(new Attachment("content.md", content));
 * 
 * 
 * MessageAction message = name.orElseThrow().sendMessageEmbeds(new
 * EmbedBuilder().setTitle(title).setDescription( "description").setAuthor(author.getAsTag(), null,
 * author.getAvatarUrl()).setTimestamp( event.getTimeCreated()).setColor(EMBED_COLOR).build());
 * 
 * for ( Attachment attachment: attachments ) { message =
 * message.addFile(attachment.getContentRaw(), attachment.name()); } message.queue();
 * 
 * event.reply("Thank you for contacting the moderators about the issue").queue();
 * 
 * }
 * 
 * public ModMailCommand(@NotNull Config config) { super(COMMAND_NAME,
 * "Sends a message to the moderators", SlashCommandVisibility.GLOBAL);
 * 
 * getData().addOption(OptionType.STRING, MESSAGE, "The message to be send to the moderators", true)
 * .addOption(OptionType.STRING,TITLE,"What is the message about?",true);
 * 
 * /* getData().addOption(OptionType.STRING, ID_OPTION, "The id of the tag to display", true)
 * .addOption(OptionType.USER, REPLY_TO_USER_OPTION,
 * "Optionally, the user who you want to reply to", false);
 */

/*
 * auditLogChannelNamePredicate =
 * Pattern.compile(config.getModAuditLogChannelPattern()).asMatchPredicate(); }
 */


/*
 * public record Attachment(@NotNull String name, @NotNull String content) {
 * 
 * public byte @NotNull [] getContentRaw() { return content.getBytes(StandardCharsets.UTF_8); } }
 * 
 * }
 * 
 * 
 * 
 */

