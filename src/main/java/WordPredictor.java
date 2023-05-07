
import com.swabunga.spell.engine.SpellDictionary;
import com.swabunga.spell.engine.SpellDictionaryHashMap;
import com.swabunga.spell.event.SpellCheckEvent;
import com.swabunga.spell.event.SpellCheckListener;
import com.swabunga.spell.event.SpellChecker;
import com.swabunga.spell.event.StringWordTokenizer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordPredictor implements SpellCheckListener {
    private SpellChecker spellChecker;
    private List<String> suggestions;

    public WordPredictor(String dictionaryPath) throws IOException {
        SpellDictionary dictionaryFile = new SpellDictionaryHashMap(new File(dictionaryPath));
        this.spellChecker = new SpellChecker(dictionaryFile);
        this.suggestions = new ArrayList<>();
    }

    public List<String> predictWords(String input) {
        this.suggestions.clear();
        String[] words = input.split("\\s+");
        for (String word : words) {
            this.spellChecker.addSpellCheckListener(this);
            this.spellChecker.checkSpelling(new StringWordTokenizer(word));
        }
        return this.suggestions;
    }

    @Override
    public void spellingError(SpellCheckEvent event) {
        String misspelledWord = event.getInvalidWord();
        List possibleSuggestions = this.spellChecker.getSuggestions(misspelledWord, 0);
        if (possibleSuggestions != null) {
            this.suggestions.addAll(possibleSuggestions);
        }
    }
    public List<String> getSuggestions() {
        return this.suggestions;
    }

}