#include <iostream>
#include <vector>
#include <queue>
#include <unordered_set>
using namespace std;

void bfs(const vector<vector<int>>& graph, int start) {
    unordered_set<int> visited;
    queue<int> q;

    q.push(start);
    visited.insert(start);

    while (!q.empty()) {
        int node = q.front();
        q.pop();
        cout << node << " "; // Process the node

        for (int neighbor : graph[node]) {
            if (visited.find(neighbor) == visited.end()) {
                q.push(neighbor);
                visited.insert(neighbor);
            }
        }
    }
}

int main() {
    vector<vector<int>> graph = {
        {1, 2},    // Node 0
        {0, 3, 4}, // Node 1
        {0},       // Node 2
        {1},       // Node 3
        {1}        // Node 4
    };

    bfs(graph, 0);
    return 0;
}
