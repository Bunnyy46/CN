from sklearn.cluster import KMeans

import matplotlib.pyplot as plt
import numpy as np
X = np.array([[1,2],[1.5,1.8],[5,8],[8,8],[1,0.6],[9,11],[8,2],[10,2],[9,3]])


kmeans=KMeans(n_clusters=3,random_state=42).fit(X)

plt.scatter(X[:,0],X[:,1],c=kmeans.labels_)
plt.scatter(kmeans.cluster_centers_[:,0],kmeans.cluster_centers_[:,1],s=100,marker='X')
plt.title("KMeans")
plt.grid(True)


from sklearn.cluster import KMeans

import matplotlib.pyplot as plt
import numpy as np
X = np.array([[1],[1.5],[5],[8],[1],[9],[8],[10],[9]]).reshape(-1,1)


kmeans=KMeans(n_clusters=2,random_state=42).fit(X)
y=np.zeros(len(X))

plt.scatter(X[:,0],y,c=kmeans.labels_)
plt.scatter(kmeans.cluster_centers_[:,0],[0,1],s=100,marker='X')
plt.title("KMeans")
plt.grid(True)
