#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int n;
    cin >> n;
    int mountains[n];
    for (int i = 0; i < n; i++) {
        cin >> mountains[i];
    }

    int asy_values[n];
    for (int i = 0; i < n; i++) {
        vector<int> tmp;
        for (int j = 0; j < n - i; j++) {
            int substring[i+1];
            for (int k = 0; k <= i; k++) {
                substring[k] = mountains[j+k];
            }

            int sum1 = 0;
            for (int k = 0; k <= i/2; k++) {
                sum1 += abs(substring[k] - substring[i-k]);
            }
            tmp.push_back(sum1);
        }
        try {
            asy_values[i] = *min_element(tmp.begin(), tmp.end());
        } catch (const std::out_of_range& e) {
            asy_values[i] = 0;
        }
    }

    for (int i = 0; i < n; i++) {
        cout << asy_values[i] << " ";
    }
    cout << endl;

    return 0;
}
