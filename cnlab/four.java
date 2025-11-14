#testhyp

from scipy import stats
    
import matplotlib.pyplot as plt



group1 = [12,14,15,10,13]
group2 = [8,9,12,11,7]

t_stat, p_val = stats.ttest_ind(group1, group2)
print("t-statistic:", t_stat)
print("p-value:", p_val)
plt.bar(['Group 1', 'Group 2'], [sum(group1)/len(group1), sum(group2)/len(group2)])
plt.ylabel('Mean Value')
plt.title('Mean Comparison (t-test)')
plt.show()

#mean
import numpy as np
from scipy import stats

# Step 1: Static dataset
data = np.array([10, 12, 23, 23, 16, 23, 21, 16])

# Step 2: Calculate central tendency and dispersion
mean = np.mean(data)
median = np.median(data)
mode = stats.mode(data, keepdims=True)[0][0]
variance = np.var(data)
std_dev = np.std(data)

# Step 3: Print results
print("Data:", data)
print("Mean:", mean)
print("Median:", median)
print("Mode:", mode)
print("Variance:", variance)
print("Standard Deviation:", std_dev)
