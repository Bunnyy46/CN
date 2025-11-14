from sklearn.linear_model import LogisticRegression
from sklearn.model_selection import train_test_split
import numpy as np
import matplotlib.pyplot as plt

# Data
X = np.array([
    [1, 2],
    [2, 3],
    [3, 4],
    [4, 5],
    [5, 6],
    [6, 7],
    [7, 8],
    [8, 9],
    [9, 10],
    [10, 11]
])
y = np.array([0, 0, 0, 0, 0, 1, 1, 1, 1, 1])

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.5, random_state=42)

model = LogisticRegression()
model.fit(X_train, y_train)
y_pred = model.predict(X_test)

print("Actual:   ", y_test)
print("Predicted:", y_pred)

plt.scatter(X_train[:, 0], y_train, color='blue', label='Actual')
plt.scatter(X_test[:, 0], y_pred, color='red', marker='x', s=100, label='Predicted')
plt.title('Simple Logistic Regression Visualization')
plt.xlabel('Feature 1')
plt.ylabel('Class')
plt.legend()
plt.grid(True)
plt.show()
