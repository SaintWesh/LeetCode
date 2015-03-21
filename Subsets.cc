// Author: Vincent
// LeetCode: Subsets
// using a recursive apporach

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<int> > subsets(vector<int> &S) {
    	std::sort(S.begin(), S.end());
			vector<vector<int> > ret;
			if (S.size() <= 0)
				return ret;
			collectElem(vector<int>(), 0, S.size(), S, ret);
			return ret; 
    }
private:
		void collectElem(vector<int> tmp, int pos, int sz,vector<int> &src, vector<vector<int> > &ret) {
			if (pos >= sz) {
				ret.push_back(std::move(tmp));
			}
			else {
				collectElem(tmp, pos + 1, sz, src, ret);
				tmp.push_back(src[pos]);
				collectElem(std::move(tmp), pos + 1, sz, src, ret);
			}
		}
};

int main() {
	Solution s;
	vector<int> set{4, 1, 0};
	auto ret = s.subsets(set);
	for (auto & v : ret) {
		cout << '[';
		for (auto elem : v) {
			cout << elem << ' ';
		}
		cout << ']' << '\n';
	}
	return 0;
}