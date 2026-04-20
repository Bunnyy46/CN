def gap_tokenize(text):
    words = []
    word = ""
    
    for ch in text:
        if ch == " ":
            if word != "":
                words.append(word)
                word = ""
        else:
            word += ch
    
    if word != "":
        words.append(word)
    
    return words


sentence = input("Enter the sentence: ")
tokens = gap_tokenize(sentence)

print("Tokens are:")
for t in tokens:
    print(t)







        
def porter_stem(word):
    prefixes = ['un', 'miss', 'pre', 'non', 'uni']
    suffixes = ['ing', 'al', 'ed', 'ious', 'ive', 'ness']
    
    for prefix in prefixes:
        if word.startswith(prefix):
            word = word[len(prefix):]
    
    for suffix in suffixes:
        if word.endswith(suffix):
            word = word[:-len(suffix)]
    
    return word


words = ['playing', 'unimportant', 'happiness', 'national']

for word in words:
    print(word, "->", porter_stem(word))






import nltk
from nltk import CFG
from nltk.tree import Tree

grammar = CFG.fromstring("""
S  -> NP VP
NP -> DT NN
VP -> V NP
VP -> V NP PP
PP -> P NP

DT -> 'the'
NN -> 'bat' | 'ball' | 'boy'
V  -> 'hit'
P  -> 'with'
""")

parser = nltk.ChartParser(grammar)

sentence = "the boy hit the ball with the bat".split()

for tree in parser.parse(sentence):
    tree.pretty_print()





import nltk
from nltk import CFG
from nltk.parse import ShiftReduceParser

# Define grammar
g = CFG.fromstring("""
S  -> NP VP
NP -> DT NN
VP -> V NP
DT -> 'the'
NN -> 'boy' | 'ball'
V  -> 'hit'
""")

# Create parser with trace enabled
p = ShiftReduceParser(g, trace=2)

# Input sentence
s = "the boy hit the ball".split()

# Parse (this will print Shift-Reduce actions automatically)
for tree in p.parse(s):
    print("\nFinal Parse Tree:\n")
    tree.pretty_print()



import nltk
from nltk.grammar import DependencyGrammar
from nltk.parse import ProjectiveDependencyParser

# Define dependency grammar
grammar = DependencyGrammar.fromstring("""
'hit' -> 'boy' | 'ball'
'boy' -> 'the'
'ball' -> 'the'
""")

# Create parser
parser = ProjectiveDependencyParser(grammar)

# Input sentence
sentence = "the boy hit the ball".split()

# Parse
for tree in parser.parse(sentence):
    tree.pretty_print()




from sklearn.linear_model import LogisticRegression

# Train a dummy logistic regression model
m = LogisticRegression().fit([[0], [1]], [0, 1])

s = [
    "AI is powerful",
    "Machine learning improves AI",
    "Football is popular",
    "The match was exciting"
]

t = 1
print("TOPIC", t, ":")
print(s[0])

prev = 1

for i in range(1, len(s)):
    # Check if consecutive sentences share at least one common word
    o = len(set(s[i - 1].split()) & set(s[i].split())) > 0

    # Topic change condition
    if prev and not o and m.predict([[1]])[0]:
        t += 1
        print("\nTOPIC", t, ":")

    print(s[i])
    prev = o





from sklearn.linear_model import LogisticRegression

# Train a simple dummy model
m = LogisticRegression().fit([[1], [0]], [1, 0])

# Input text (tokenized by space)
t = "Wow! Is this working? Yes it is.".split()

# Output list
o = [t[0]]

for i in range(1, len(t)):
    
    if t[i - 1][-1] in ".!?" and m.predict([[t[i][0].isupper()]])[0]:
        o.append(t[i])
    else:
        o[-1] += " " + t[i]

print(o)






# Simple Lesk Algorithm for WSD
import nltk
nltk.download('wordnet')
nltk.download('omw-1.4')   # optional but recommended
from nltk.corpus import wordnet as wn

def lesk_algorithm(word, sentence):
    best_sense = None
    max_overlap = 0
    
    context = set(sentence.split())
    
    for sense in wn.synsets(word):
        definition = set(sense.definition().split())
        
        overlap = len(context.intersection(definition))
        
        if overlap > max_overlap:
            max_overlap = overlap
            best_sense = sense
    
    return best_sense

# Test
sentence = "I went to the bank to deposit money"
word = "bank"

sense = lesk_algorithm(word, sentence)
print("Word:", word)
print("Sense:", sense)










from sklearn.feature_extraction.text import CountVectorizer
from sklearn.naive_bayes import MultinomialNB

# Training data
sentences = [
    "I deposited money in the bank",
    "The river bank is beautiful"
]

labels = ["finance", "river"]  # meanings of "bank"

# Convert text to features nk
vectorizer = CountVectorizer()
X = vectorizer.fit_transform(sentences)

# Train model
model = MultinomialNB()
model.fit(X, labels)

# Test
test_sentence = ["bank is beautifull"]
test_X = vectorizer.transform(test_sentence)

prediction = model.predict(test_X)

print("Sentence:", test_sentence[0])
print("Predicted Sense:", prediction[0])







#11)Predicate Argument Structure
import nltk

# Sample sentence
sentence = "Ram eats mango"

# Step 1: Tokenization using split (safe)
words = sentence.split()

# Step 2: Use NLTK FreqDist (just to show NLTK usage)
freq = nltk.FreqDist(words)

# Step 3: Rule-based verb detection
verbs = ["eat", "eats", "run", "runs", "go", "goes"]

predicate = None
arguments = []

for word in words:
    if word.lower() in verbs and predicate is None:
        predicate = word
    else:
        arguments.append(word)

# Output
print("Sentence:", sentence)
print("Word Frequency (NLTK used):", freq)
print("Predicate:", predicate)
print("Arguments:", arguments)









# Dictionary Lookup
morph_dict = {
    "children": "child",
    "mice": "mouse",
    "cars": "car"
}

word = input("Enter word: ")

# 1. Dictionary Model
if word in morph_dict:
    root = morph_dict[word]
    feature = "irregular (dictionary)"

# 2. Finite State (Rule-Based)
elif word.endswith("ing"):
    root = word[:-3]
    feature = "continuous"
elif word.endswith("ed"):
    root = word[:-2]
    feature = "past tense"
elif word.endswith("s"):
    root = word[:-1]
    feature = "plural"

# 3. Unification (Feature tagging)
else:
    root = word
    feature = "base form"

# Output
print("Word   :", word)
print("Root   :", root)
print("Feature:", feature)









    
