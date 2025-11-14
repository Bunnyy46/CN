
data = [
    ['Sunny', 'Warm',  'Normal', 'Strong', 'Warm', 'Same',   'Yes'],
    ['Sunny', 'Warm',  'High',   'Strong', 'Warm', 'Same',   'Yes'],
    ['Rainy', 'Cold',  'High',   'Strong', 'Warm', 'Change', 'No'],
    ['Sunny', 'Warm',  'High',   'Strong', 'Cool', 'Change', 'Yes']
]

S=['0']*6
G=[['?']*6]

for r in data:
    feats=r[:-1]
    label=r[-1]
    if label=='Yes':
        for j in range(6):
            if S[j]=='0' :
                S[j]=feats[j]
            elif S[j]!=feats[j]:
                S[j]='?'
    else:
        for j in range(6):
            if S[j]!=feats[j]:
                temp=S.copy()
                temp[j]='?'
                G.append(temp)

print(S)
print(G)
        
