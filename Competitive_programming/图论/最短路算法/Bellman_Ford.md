算法思路：

```cpp
for 1:n:
	for 所有边a,b,w (表示从a指向b的一条边，权重为w)
		dist[b] = min(dist[b], dist[a] + w)
```

循环完成以后，对于所有的边，都满足三角不等式：

$$dist[b] \leq dist[a]+w$$

更新的操作叫做“松弛”操作（relax）

但是注意，如果有负权回路的话，算法就会失效(也有特殊情况啦，就是负环不在路径上的时候。。)

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6184520d-df50-49e7-930d-8282dfe40409/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6184520d-df50-49e7-930d-8282dfe40409/Untitled.png)

同时也要注意到，Bellman-Ford算法是可以判断存不存在负环的。

循环n次是有实际含义的（for 1:n）。

如果迭代k次，说明最多不经过k条边

假如有路径：

$$1\rightarrow2\rightarrow……\rightarrow x$$

一共有n条边，那么就存在$n+1$个点。如果最后一次迭代依旧更新了某条路径，那么也就是说循环$n$次算法依旧没有结束，那么就说明有一条边被操作了2次，也就是存在负环。

因此，对于最短路存在的图，时间复杂度为$O(nm)$
