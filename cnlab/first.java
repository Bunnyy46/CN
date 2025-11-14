from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeClassifier, plot_tree
from sklearn.metrics import accuracy_score
import matplotlib.pyplot as plt

# Features (X)
X = [
    [6, 148, 72, 35, 0, 33.6, 0.627, 50],
    [1, 85, 66, 29, 0, 26.6, 0.351, 31],
    [8, 183, 64, 0, 0, 23.3, 0.672, 32],
    [1, 89, 66, 23, 94, 28.1, 0.167, 21],
    [0, 137, 40, 35, 168, 43.1, 2.288, 33]
]

# Target variable (y)
y = [1, 0, 1, 0, 1]


X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=0)

model_gini = DecisionTreeClassifier(criterion='gini', max_depth=3)
model_gini.fit(X_train, y_train)
y_pred_gini = model_gini.predict(X_test)
print("Accuracy (Gini):", accuracy_score(y_test, y_pred_gini))
model_entropy = DecisionTreeClassifier(criterion='entropy', max_depth=3)
model_entropy.fit(X_train, y_train)
y_pred_entropy = model_entropy.predict(X_test)
print("Accuracy (Entropy):", accuracy_score(y_test, y_pred_entropy))

print("Info gain per feature:")
print(model_entropy.feature_importances_)

plt.subplot(1, 2, 1)
plot_tree(model_gini)
plt.title("Decision Tree (Gini)")

plt.subplot(1, 2, 2)
plot_tree(model_entropy)
plt.title("Decision Tree (Entropy)")

plt.tight_layout()
plt.show()
