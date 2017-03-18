#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int> > combine(int n, int k) {
        vector<vector<int> > ret;
        if (n <= 0 || k <= 0) 
            return ret;
        collectNum(vector<int>(), n, k, 1, ret);
        return ret;
    }
private:
    void collectNum(vector<int> tmp, int n, int k, int pos, vector<vector<int> > &ret) {
        if (tmp.size() == k)
            ret.push_back(tmp);
        else {
            if (pos > n)
                return;
            else {
                collectNum(tmp, n, k, pos + 1, ret);
                tmp.push_back(pos);
                collectNum(std::move(tmp), n, k, pos + 1, ret);
            }
        }
    }
};



int main() {
    Solution s;
    auto ret = s.combine(1, 1);
    for (auto& v : ret) {
        cout << '[';
        for (auto i : v)
        cout << i << ' ';
        cout << ']' << '\n';
    }
}
