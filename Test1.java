/*
输入一个数n，然后输入n个数值各不相同，再输入一个值x，输出这个值在
这个数组中的下标（从0开始，若不在数组中则输出-1）。

输入描述:
测试数据有多组，输入n(1<=n<=200)，接着输入n个数，然后输入x。

输出描述:
对于每组输入,请输出结果。
示例1
输入
2
1 3
0
输出
-1
 */
package written_test0703;

import java.util.Scanner;
//找x
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for(int i =0;i<n;i++){
                nums[i] = in.nextInt();
            }
            int x = in.nextInt();
            for(int i =0;i<n;i++){
                if(nums[i] == x){
                    System.out.println(i);
                    return ;
                }
            }
            System.out.println(-1);
        }
    }
}