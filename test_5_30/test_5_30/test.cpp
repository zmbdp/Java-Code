#define _CRT_SECURE_NO_WARNINGS
// #include<bits/stdc++.h>
#include <iostream>
using namespace std;
const int MAXN = 5e6 + 5;
int a[MAXN], d[MAXN], presum[MAXN];
int main()
{
	int n = 0;
	int p = 0;
	cin >> n >> p;
	for (int i = 1; i <= n; ++i)
	{
		cin >> a[i];
	}
	for (int i = 1; i <= n; ++i)
	{
		d[i] = a[i] - a[i - 1];
	}
	while (p--) {
		int l, r, x;
		cin >> l >> r >> x;
		if (l >= 0) {
			d[l] += x;
		}
		if ((r + 1) < (n + 1)) {
			d[r + 1] -= x;
		}
	}
	for (int i = 1; i <= n; ++i)
	{
		presum[i] = presum[i - 1] + d[i];
	}
	int ans = presum[1];
	for (int i = 2; i <= n; ++i)
	{
		ans = ans < presum[i] ? ans : presum[i];
	}
	cout << ans;
	return 0;
}