class Solution {
public:
    int largestInteger(int num) {
    int cnt[10] = {}, p[2] = {0, 1}, res = 0;
    for (int n = num; n > 0; n /= 10)
        ++cnt[n % 10];
    for (long long n = num, mul = 1; n > 0; n /= 10, mul *= 10) {
        int par = n % 10 % 2 == 1;
        while (cnt[p[par]] == 0)
            p[par] += 2;
        res += mul * p[par];
        --cnt[p[par]];
    }
    return res;
}
};