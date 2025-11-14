import numpy as np
from sklearn.linear_model import LinearRegression
import matplotlib.pyplot as plt
X = [
    [1,2],
    [2,3],
    [3,4],
    [4,4],
    [5,3],
    [6,4],
    [7,3],
    [8,2],
    [9,3],
    [10,2]
]

y = [5, 7, 9, 11, 13, 15, 17, 19, 21, 23]

X = np.array(X)
y = np.array(y)

model = LinearRegression()
model.fit(X, y)

y_pred = model.predict(X)

print("Coefficient:", model.coef_)
print("Intercept:", model.intercept_)

plt.scatter(X[:,0], y, label="Actual",color='red')
plt.plot(X, y_pred, label="Predicted", linewidth=0.2)
plt.xlabel("X")
plt.ylabel("y")
plt.title("MULTI Linear Regression")
plt.legend()
plt.show()
