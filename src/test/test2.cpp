#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<int> mountains(n);
    for (int i = 0; i < n; i++) {
        cin >> mountains[i];
    }

    vector<int> asy_values(n);
    for (int i = 0; i < n; i++) {
        int min_asym = INT_MAX;
        for (int j = 0; j <= i; j++) {
            int k = i - j;
            int asym = 0;
            while (j < k) {
                asym += abs(mountains[j] - mountains[k]);
                j++;
                k--;
            }
            min_asym = min(min_asym, asym);
        }
        asy_values[i] = min_asym;
    }

    for (int value : asy_values) {
        cout << value << " ";
    }

    return 0;
}
