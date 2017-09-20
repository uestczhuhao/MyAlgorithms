package Qunaer.Test0920;

import java.util.Scanner;

public class BigDataMod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long a = sc.nextLong();
            long b = sc.nextLong();
//            long b = sc.nextInt();
//            long n = sc.nextInt();
            long n = sc.nextLong();
            if (b == 0){
                System.out.println(1);
            } else {
                System.out.println(bigDataMod(a,b,n));
            }
        }
    }

    /**
     * 由于a^n的数太大，所以直接模除不行，因此我们引进二进制的思想，
     * 比如：a^13 % k=[ a^(2^3) * a^(2^2) * a^(2^1) ] % k =
     * [a^(2^3) %k] * [a^(2^2) %k] * [a^(2^1) %k]

     */
    public static long bigDataMod(long a, long n, long k)
    {
        long r = 1,b = a;

        while(n!=0)
        {
            //由于是b=a是由低位到高位递增，而n/=2是高位到低位递减，所以n%2==1是判断当前项的b是否已经满足分拆之后的某一项，例如8^24 = 8^16 * 8^8(最低项是8^8,这需要8^1运算3次)
            if(n % 2 == 1)
            {
                //对于每一项模除取余
                r = (r * b) % k;
            }
            //每运算一次迭代递增
            b = (b * b) % k;
            //每次规模减少一半
            n /= 2;
        }
        return r;
    }
}


/*
#include "stdafx.h"
#include <stdlib.h>
//由于输入的数可能比较大，所以定义无符号的长整型
unsigned long int Exponent_mod(const unsigned int a, unsigned int n,const unsigned int k)
{
    unsigned long int r = 1,b = a;
    //当输入指数为0时
    if(n == 0)
    {
        return r;
    }
    while(n)
    {
        //由于是b=a是由低位到高位递增，而n/=2是高位到低位递减，所以n%2==1是判断当前项的b是否已经满足分拆之后的某一项，例如8^24 = 8^16 * 8^8(最低项是8^8,这需要8^1运算3次)
        if(n % 2 == 1)
        {
            //对于每一项模除取余
            r = (r * b) % k;
        }
        //每运算一次迭代递增
        b = (b * b) % k;
        //每次规模减少一半
        n /= 2;
    }
    return r;
}
int _tmain(int argc, _TCHAR* argv[])
{
    unsigned long int a,n,k;
    printf("请输入底数,指数,和需要模除的数：");
    //由于涉及到大数，所以不能用%d，细节注意一下
    scanf("%lu,%lu,%lu",&a,&n,&k);
    printf("此次运算的余数是：%lu\n",Exponent_mod(a,n,k));
    system("Pause");
    return 0;
}
 */
