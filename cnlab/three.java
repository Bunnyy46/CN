from sklearn.feature_extraction.text import CountVectorizer
from sklearn.naive_bayes import MultinomialNB

# Training sentences
sentences = [
    "I love this product",
    "This movie was amazing",
    "I am very happy today",
    "The experience was great",
    "I enjoyed the service",
    "I hate this product",
    "This movie was terrible",
    "I am very unhappy today",
    "The experience was awful",
    "I did not enjoy the service"
]

labels = [
    "Positive","Positive","Positive","Positive","Positive",
    "Negative","Negative","Negative","Negative","Negative"
]

# Convert text to vectors
vectorizer = CountVectorizer()
X = vectorizer.fit_transform(sentences)

# Train Naive Bayes
model = MultinomialNB()
model.fit(X, labels)

# Test sentence
test_sentence = ["I really love this"]   # change anything here
X_test = vectorizer.transform(test_sentence)

# Prediction
print("Input :", test_sentence[0])
print("Class :", model.predict(X_test)[0])
