from sklearn.model_selection import train_test_split
from sklearn.neighbors import KNeighborsClassifier
from sklearn.model_selection import train_test_split
import matplotlib.pyplot as plt
import numpy as np
X=np.array([[1,19,19000],[1,35,20000],[0,26,43000],[0,27,5700]])
y=np.array([0,0,1,0])
X_train,X_test,y_train,y_test=train_test_split(X,y,test_size=0.3,random_state=42)
knn=KNeighborsClassifier(n_neighbors=2)
knn.fit(X_train,y_train)
y_pred=knn.predict(X_test)
print("Actual",y_train)
print("Pred",y_pred)
plt.scatter(X_train[:,0],X_train[:,2],c=y_train,s=150,label="actual")
plt.scatter(X_test[:,0],X_test[:,2],c=y_pred,s=200,marker="X",label="predicted")
plt.title("KNN")
plt.grid(True)
plt.legend()
