class Solution:
    def largestPathValue(self, colors: str, edges: List[List[int]]) -> int:
        n = len(colors)
        g = [[] for _ in range(n)]  # 图
        colorCount = [[0] * 26 for _ in range(n)]   
        maxColorNum = 0
        colorbase = ord('a') 
        for e in edges:
            g[e[0]].append(e[1])
        
        visted = [False] * n

        def dfs(i, pathNodes: set):
            nonlocal maxColorNum
            visted[i] = True
            pathNodes.add(i)
            for nexti in g[i]:
                if nexti in pathNodes:   
                    maxColorNum = -1
                    return
                if not visted[nexti]:
                    dfs(nexti, pathNodes)
                    if maxColorNum < 0:  
                        return
                for j in range(26):   
                    colorCount[i][j] = max(colorCount[i][j], colorCount[nexti][j])
            color = ord(colors[i]) - colorbase
            colorCount[i][color] += 1  
            maxColorNum = max(maxColorNum, colorCount[i][color])
            pathNodes.remove(i)

        for i in range(n):
            if not visted[i]:
                dfs(i, set())
            if maxColorNum < 0:
                break
        return maxColorNum