#pragma warning(disable:4996)
#include<stdio.h>
////实现计算器
//void caidan()
//{
//	printf("****************************************\n");
//	printf("******    1.jiafa     2.jianfa    ******\n");
//	printf("******   3.chengfa     4.chufa    ******\n");
//	printf("******           0.exte           ******\n");
//	printf("****************************************\n");
//}
//int jia(int x, int y)
//{
//	return x + y;
//}
//int jian(int x, int y)
//{
//	return x - y;
//}
//int cheng(int x, int y)
//{
//	return x * y;
//}
//int chu(int x, int y)
//{
//	return x / y;
//}
//int main()
//{
//	int s = 0;
//	caidan();
//	do {
//		//jisuan[5]就是函数指针数组。
//		int(*jisuan[5])(int,int) = {NULL,jia,jian,cheng,chu};
//		printf("请输入你要选择的计算方式：");
//		scanf("%d", &s);
//		if (s > 5)
//		{
//			printf("输入错误，请重试：\n");
//			continue;
//		}
//		if (s == 0)
//		{
//			printf("退出成功!");
//			break;
//		}
//		int x = 0;
//		int y = 0;
//		printf("请输入两个需要计算的数：");
//		scanf("%d %d", &x, &y);
//		int z = (jisuan[s])(x, y);
//		printf("结果是：%d\n", z);
//	} while (s);
//	return 0;
//}



////回调函数
//void caidan()
//{
//	printf("****************************************\n");
//	printf("******    1.jiafa     2.jianfa    ******\n");
//	printf("******   3.chengfa     4.chufa    ******\n");
//	printf("******           0.exte           ******\n");
//	printf("****************************************\n");
//}
//
//int jia(int x, int y)
//{
//	return x + y;
//}
//int jian(int x, int y)
//{
//	return x - y;
//}
//int cheng(int x, int y)
//{
//	return x * y;
//}
//int chu(int x, int y)
//{
//	return x / y;
//}
//
//int quan(int(*pf)(int, int))
//{
//	int x = 0;
//	int y = 0;
//	printf("请输入需要计算的两个数：");
//	scanf("%d %d", &x, &y);
//	return pf(x, y);
//}
//int main()
//{
//	caidan();
//	int s = 0;
//	printf("请输入你选择的计算方式：");
//	scanf("%d", &s);
//	switch (s)
//	{
//	case 0:
//		printf("退出成功");
//		break;
//	case 1:
//		printf("结果是：%d\n", quan(jia));
//		main();//用递归主要是算完之后不用重新启动程序，还能接着算。
//		break;
//	case 2:
//		printf("结果是：%d\n", quan(jian));
//		main();
//		break;
//	case 3:
//		printf("结果是：%d\n", quan(cheng));
//		main();
//		break;
//	case 4:
//		printf("结果是：%d\n", quan(chu));
//		main();
//		break;
//	default:
//		printf("输入错误，请重新输入：\n");
//		main();
//	}
//	return 0;
//}



////冒泡排序
//int paixu(int arr[], int sz)
//{
//	int i = 0;
//	int j = 0;
//	int q = 1;
//	for (i = 0; i < sz - 1; i++)//进行几趟
//	{
//		for (j = 0; j < (sz - 1 - i); j++)//交换几次
//		{
//			if (arr[j] > arr[j + 1])
//			{
//				int n = arr[j];
//				arr[j] = arr[j + 1];
//				arr[j + 1] = n;
//				q--;
//			}
//		}
//		if (q == 1)
//		{
//			break;
//		}
//	}
//}
//
//void dayin(int arr[], int sz)
//{
//	int i = 0;
//	for (i = 0; i < sz; i++)
//	{
//		printf("%d ", arr[i]);
//	}
//}
//int main()
//{
//	int arr[] = { 1,2,3,4,5,6,7,8,9 };
//	int sz = sizeof(arr) / sizeof(arr[0]);
//	paixu(arr, sz);
//	dayin(arr, sz);
//	return 0;
//}



//