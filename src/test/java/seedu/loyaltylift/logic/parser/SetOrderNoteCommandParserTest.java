package seedu.loyaltylift.logic.parser;

import static seedu.loyaltylift.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.loyaltylift.logic.parser.CliSyntax.PREFIX_NOTE;
import static seedu.loyaltylift.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.loyaltylift.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.loyaltylift.testutil.TypicalIndexes.INDEX_FIRST;

import org.junit.jupiter.api.Test;

import seedu.loyaltylift.commons.core.index.Index;
import seedu.loyaltylift.logic.commands.SetOrderNoteCommand;
import seedu.loyaltylift.model.attribute.Note;

public class SetOrderNoteCommandParserTest {
    private SetOrderNoteCommandParser parser = new SetOrderNoteCommandParser();
    private final String nonEmptyNote = "Test Note";

    @Test
    public void parse_emptyNote_success() {
        Index targetIndex = INDEX_FIRST;
        String userInput = targetIndex.getOneBased() + " " + PREFIX_NOTE;
        SetOrderNoteCommand expectedCommand = new SetOrderNoteCommand(
                INDEX_FIRST, new Note(""));
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_nonEmptyNote_success() {
        Index targetIndex = INDEX_FIRST;
        String userInput = targetIndex.getOneBased() + " " + PREFIX_NOTE + nonEmptyNote;
        SetOrderNoteCommand expectedCommand = new SetOrderNoteCommand(
                INDEX_FIRST, new Note(nonEmptyNote));
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_missingCompulsoryField_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, SetOrderNoteCommand.MESSAGE_USAGE);

        // no parameters
        assertParseFailure(parser, SetOrderNoteCommand.COMMAND_WORD, expectedMessage);

        // no note
        assertParseFailure(parser, SetOrderNoteCommand.COMMAND_WORD + " 1" + nonEmptyNote, expectedMessage);
    }
}
