/*
 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，
 然后把这个二进制数转变成
一个长整数。
举例：一个ip地址为10.0.3.193
每段数字             相对应的二进制数
10                   00001010
0                    00000000
3                    00000011
193                  11000001
组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，
即该IP地址转换后的数字就是它了。每段可以看成是一个0-255的整数，需要对IP地址进行校验

输入描述:
输入
1 输入IP地址
2 输入10进制型的IP地址

输出描述:
输出
1 输出转换成10进制的IP地址
2 输出转换后的IP地址

示例1
输入
10.0.3.193
167969729
输出
167773121
10.3.3.193
*/
package written_test0703;

import java.util.Scanner;
//整数与Ip地址间的转换
public class Test2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String ip=in.nextLine();
            String p=in.nextLine();
            System.out.println(ip(ip));
            ten(p);
        }
    }

    private static void ten(String p) {
        long temp=Long.parseLong(p);
        String ip=Long.toBinaryString(temp);
        StringBuilder sb=new StringBuilder();
        if(ip.length()<32){
            for(int i=0;i<(32-ip.length());i++){
                sb.append(0);
            }
            sb.append(ip);
        }else if(ip.length()==32){
            sb.append(ip);
        }
        for(int i=0;i<sb.length()-8;i=i+8){
            System.out.print(Integer.parseInt(sb.substring(i,i+8),2)+".");
        }
        System.out.println(Integer.parseInt(sb.substring(sb.length()-8,sb.length()),2));
    }

    private static long ip(String ip) {
        String[] arr=ip.split("\\.");
        long n=Long.parseLong(arr[0]);

        for(int i=1;i<arr.length;i++){
            n=n<<8;
            n=n+Long.parseLong(arr[i]);
        }
        return n;
    }
}
